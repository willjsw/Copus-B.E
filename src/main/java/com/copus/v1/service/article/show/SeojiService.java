package com.copus.v1.service.article.show;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.articleDto.showDto.SeojiInfoBugaDataDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.SeojiInfoDataDto;

import com.copus.v1.service.enums.SeojiKeyword;
import com.copus.v1.service.enums.SeojiOrdering;
import com.copus.v1.service.serviceDto.articleDto.showDto.SeojiInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeojiService {

    private final Lv1Repository lv1Repository;
    private final AuthorRepository authorRepository;
    private final GetMetaInfo getMetaInfo;
    private final ConsonantRangeSet consonantRangeSet;

    public SeojiInfoDto getSeojiInfo(SeojiKeyword seojiKeyword, SeojiOrdering seojiOrdering, String keyword){
        SeojiInfoDto seojiInfoDto = new SeojiInfoDto();
        List<SeojiInfoDataDto> seojiInfoDataDtos = new ArrayList<>();
        switch(seojiKeyword){
            case all -> getAllSeojiInfo(seojiInfoDto, seojiInfoDataDtos);
            case authorName -> getSeojiInfoByAuthorName(seojiInfoDto,seojiInfoDataDtos, keyword);
            case authorNameConsonant -> getSeojiInfoByAuthorNameConsonant(seojiInfoDto, seojiInfoDataDtos,keyword);
            case bookTitleConsonant -> getSeojiInfoByBookTitleConsonant(seojiInfoDto, seojiInfoDataDtos,keyword);

        }
        seojiInfoDto.setData(seojiInfoDataDtos);
        return seojiInfoDto;
    }

    private void getSeojiInfoByLv1Id(List<SeojiInfoDataDto> seojiInfoDataDtos, List<Lv1> seojies){
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String zipsu = getMetaInfo.getZipsu(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            //부가정보
            String beomrye =  getMetaInfo.getBeomrye(seoji.getCommentaryInfo().getId());
            String chapterInfo =  getMetaInfo.getChapterInfo(metaInfoId);
            String haejae = getMetaInfo.getHaejae(seoji.getCommentaryInfo().getId());
            ;

            seojiInfoDataDtos.add(
                    new SeojiInfoDataDto(seoji.getId(), seojiTitle, authorName,zipsu,publishYear,new SeojiInfoBugaDataDto(beomrye, chapterInfo, haejae)));
        }
    }

    //전체 서지명 가져오기(case 1)
    private void getAllSeojiInfo(SeojiInfoDto seojiInfoDto, List<SeojiInfoDataDto> seojiInfoDataDtos) {
        List<Lv1> seojies = lv1Repository.findAll();
        seojiInfoDto.setCount(seojies.size());
        getSeojiInfoByLv1Id(seojiInfoDataDtos, seojies);
    }

    //자음에 해당하는 모든 서지명 가져오기(case 2)
    private void getSeojiInfoByBookTitleConsonant(SeojiInfoDto seojiInfoDto,List<SeojiInfoDataDto> seojiInfoDataDtos, String consonantStart) {
        List<Lv1> seojies = lv1Repository.findLv1ByConsonant(consonantRangeSet.consonantRangeSet(consonantStart).get(0) , consonantRangeSet.consonantRangeSet(consonantStart).get(1));
        seojiInfoDto.setCount(seojies.size());
        getSeojiInfoByLv1Id(seojiInfoDataDtos, seojies);
    }

    //자음에 해당하는 모든 저자의 서지명 가져오기(case 3-1)
    private void getSeojiInfoByAuthorNameConsonant(SeojiInfoDto seojiInfoDto,List<SeojiInfoDataDto> seojiInfoDataDtos, String consonantStart) {
        List<Author> authors = getAuthorNameByConsonant(consonantStart);
        int count =0;
        for(Author author : authors){
            List<Lv1> seojies = lv1Repository.findLv1ByAuthorName(author.getNameKor());
            count= count + seojies.size();
            getSeojiInfoByLv1Id(seojiInfoDataDtos, seojies);
        }
        seojiInfoDto.setCount(count);
    }

    //자음에 해당하는 모든 저자명 가져오기(case 3-2-1)
    private List<Author>getAuthorNameByConsonant(String consonantStart) {
        return authorRepository.findAuthorNameByConsonant(consonantRangeSet.consonantRangeSet(consonantStart).get(0), consonantRangeSet.consonantRangeSet(consonantStart).get(1));
    }

    //저자명에 해당하는 모든 서지명 가져오기(case 3-2-2)
    private void getSeojiInfoByAuthorName(SeojiInfoDto seojiInfoDto,List<SeojiInfoDataDto> seojiInfoDataDtos, String author) {
        List<Lv1> seojies = lv1Repository.findLv1ByAuthorName(author);
        seojiInfoDto.setCount(seojies.size());
        getSeojiInfoByLv1Id(seojiInfoDataDtos, seojies);
    }
}