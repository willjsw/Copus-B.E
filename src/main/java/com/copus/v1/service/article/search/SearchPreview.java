package com.copus.v1.service.article.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDataDto;
import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDto;
import com.copus.v1.service.exception.NoFilterForSeojiPreviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchPreview {

    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final ContentRepository contentRepository;
    private final GetMetaInfo getMetaInfo;

    public SearchPreviewDto getPreview(SearchFilter searchFilter, String keyword) {
        List<SearchPreviewDataDto> searchPreviewDataDtos = new ArrayList<>();
        SearchPreviewDto searchPreviewDto = new SearchPreviewDto(0, null);
        //Filter & keyword -> Find Lv1 Id
        switch (searchFilter) {
            case dataId -> getPreviewByDataId(searchPreviewDataDtos, keyword, searchPreviewDto );
            case content -> getPreviewByContent(searchPreviewDataDtos, keyword, searchPreviewDto );
            case muncheTitle -> getPreviewByMuncheTitle(searchPreviewDataDtos, keyword, searchPreviewDto );
            case gwonchaTitle -> getPreviewByGwonchaTitle(searchPreviewDataDtos, keyword, searchPreviewDto );
            case authorName -> getPreviewByAuthorName(searchPreviewDataDtos, keyword, searchPreviewDto );
            case bookTitle -> getPreviewByBookTitle(searchPreviewDataDtos, keyword, searchPreviewDto );
            case total -> getPreviewByTotal(searchPreviewDataDtos, keyword, searchPreviewDto );
            default -> throw new NoFilterForSeojiPreviewException("서치 프리뷰를 위한 필터가 존재하지 않습니다");
        }

        searchPreviewDto.setData(searchPreviewDataDtos);
        return searchPreviewDto;
    }

    private Integer getLevelDepthByLevelId(String levelId) {
        return Math.toIntExact(levelId.chars()
                .filter(c -> c == '_')
                .count() - 1);
    }

    private void getPreviewByDataId(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        switch (getLevelDepthByLevelId(keyword)) {
            //서지 ID
            case 1 -> getPreviewByLv1Id(searchPreviewDataDtos, keyword, searchPreviewDto);
            //권차 ID
            case 2 -> getPreviewByLv2Id(searchPreviewDataDtos, keyword, searchPreviewDto);
            //문체 ID
            case 3 -> getPreviewByLv3Id(searchPreviewDataDtos, keyword, searchPreviewDto);
            //최종정보 ID
            case 4 -> getPreviewByLv4Id(searchPreviewDataDtos, keyword, searchPreviewDto);
            //default -> throw new InvalidLevelIdException("해당 레벨 깊이는 존재하지 않습니다");

        }
    }

    private void getPreviewByLv1Id(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findAllByLv1IdKeyword(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);

            String authorName = getMetaInfo.getAuthorName(metaInfoId);

            String publishYear = getMetaInfo.getPublishYear(metaInfoId);


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }

    }



    private void getPreviewByLv2Id(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findAllByLv2IdKeyword(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());
        Lv2 gwoncha = lv2Repository.findOne(keyword);
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = keyword;
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, null, null, null, null, null));
        }
    }




    private void getPreviewByLv3Id(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findAllByLv3IdKeyword(keyword);
        List<Lv2> gwonchas = lv2Repository.findAllByLv3IdKeyword(keyword);
        Lv3 munche = lv3Repository.findOne(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());

        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munche.getMetaInfo().getId());


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, null, null, null));
        }
    }


    private void getPreviewByLv4Id(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findAllByLv4IdKeyword(keyword);
        List<Lv2> gwonchas = lv2Repository.findAllByLv4IdKeyword(keyword);
        List<Lv3> munches = lv3Repository.findAllByLv4IdKeyword(keyword);
        Lv4 finalInfo = lv4Repository.findOne(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());

        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munches.get(0).getMetaInfo().getId());

            String finalId = keyword;
            String finalTitle = getMetaInfo.getTitleByMetaInfoId(finalInfo.getMetaInfo().getId());


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, finalId, finalTitle, null));
        }
    }


    private void getPreviewByContent(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {

        List<Lv4> finalInfos = lv4Repository.findAllByContentKeyword(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+finalInfos.size());

        for (Lv4 lv4 : finalInfos) {

            Long bodyInfoId = lv4.getBodyInfo().getId();

            List<Lv1> seojies = lv1Repository.findAllByLv4IdKeyword(lv4.getId());
            List<Lv2> gwonchas = lv2Repository.findAllByLv4IdKeyword(lv4.getId());
            List<Lv3> munches = lv3Repository.findAllByLv4IdKeyword(lv4.getId());
            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getMetaInfo.getTitleByMetaInfoId(munches.get(0).getMetaInfo().getId());

            String finalId = lv4.getId();
            String finalTitle = getMetaInfo.getTitleByMetaInfoId(lv4.getMetaInfo().getId());

            String content = contentRepository.findOneByBodyInfoId(bodyInfoId).get(0).getContentText();
            if(content.length()>200){
                content = content.substring(0,200);
            }


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, finalId, finalTitle, content));
        }
    }

    private void getPreviewByMuncheTitle(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv3> munches = lv3Repository.findLv3ByLv3Title(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+munches.size());

        for (Lv3 lv3 : munches) {

            List<Lv1> seojies = lv1Repository.findAllByLv3IdKeyword(lv3.getId());
            List<Lv2> gwonchas = lv2Repository.findAllByLv3IdKeyword(lv3.getId());

            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = lv3.getId();
            String muncheTitle = getMetaInfo.getTitleByMetaInfoId(lv3.getMetaInfo().getId());


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, null, null, null));
        }
    }

    private void getPreviewByGwonchaTitle(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv2> gwonchas = lv2Repository.findLv2ByLv2Title(keyword);
        System.out.println(gwonchas);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+gwonchas.size());

        for (Lv2 lv2 : gwonchas) {

            List<Lv1> seojies = lv1Repository.findAllByLv2IdKeyword(lv2.getId());

            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            String authorName = getMetaInfo.getAuthorName(metaInfoId);
            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            String gwonchaId = lv2.getId();
            String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(lv2.getMetaInfo().getId());


            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, null, null, null, null, null));
        }
    }

    private void getPreviewByAuthorName(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findLv1ByAuthorName(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);

            String authorName = getMetaInfo.getAuthorName(metaInfoId);

            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }
    }

    private void getPreviewByBookTitle(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        List<Lv1> seojies = lv1Repository.findLv1ByLv1Title(keyword);
        searchPreviewDto.setCount(searchPreviewDto.getCount()+seojies.size());
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);

            String authorName = getMetaInfo.getAuthorName(metaInfoId);

            String publishYear = getMetaInfo.getPublishYear(metaInfoId);

            searchPreviewDataDtos.add(
                    new SearchPreviewDataDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }
    }

    private void getPreviewByTotal(List<SearchPreviewDataDto> searchPreviewDataDtos, String keyword, SearchPreviewDto searchPreviewDto) {
        getPreviewByContent(searchPreviewDataDtos, keyword, searchPreviewDto);
        getPreviewByMuncheTitle(searchPreviewDataDtos, keyword, searchPreviewDto);
        getPreviewByGwonchaTitle(searchPreviewDataDtos, keyword, searchPreviewDto);
        getPreviewByAuthorName(searchPreviewDataDtos, keyword, searchPreviewDto);
        getPreviewByBookTitle(searchPreviewDataDtos, keyword, searchPreviewDto);
        getPreviewByDataId(searchPreviewDataDtos, keyword, searchPreviewDto);
    }


}
