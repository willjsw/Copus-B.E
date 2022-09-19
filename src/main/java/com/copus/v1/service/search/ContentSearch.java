package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.dto.search.SearchByLv4ContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContentSearch {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;
    private final ContentRepository contentRepository;


    public ArrayList<SearchByLv4ContentDto> contentSearchByContent(List<Lv4> lv4List) {

        SearchByLv4ContentDto searchByLv4ContentDto;
        ArrayList<SearchByLv4ContentDto> searchByLv4ContentDtoList = new ArrayList<>();

        int searchNum = lv4List.toArray().length;

        if (searchNum != 0) {

                for (Lv4 lv4 : lv4List) {
                    searchByLv4ContentDto = new SearchByLv4ContentDto();

                    String lv3Id = lv4.getLv3().getId();
                    List<Lv3> lv3 = lv3Repository.findLv3ByLv3Id(lv3Id);
                    String lv2Id = lv3.get(0).getLv2().getId();
                    List<Lv2> lv2 = lv2Repository.findLv2ByLv2Id(lv2Id);
                    String lv1Id = lv2.get(0).getLv1().getId();

                    searchByLv4ContentDto.setLv1Id(lv1Id);
                    String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                    String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                    searchByLv4ContentDto.setLv1TitleChn(lv1TitleKor+"("+lv1TitleChn+")");
                    searchByLv4ContentDto.setAuthorChn(authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn());
                    searchByLv4ContentDto.setAuthorKor(authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor());
                    searchByLv4ContentDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());
                    searchByLv4ContentDto.setLv2Id(lv2Id);
                    searchByLv4ContentDto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText());
                    searchByLv4ContentDto.setLv3Id(lv3Id);
                    searchByLv4ContentDto.setLv3Title(titleRepository.findLv3TitleByLv3Id(lv3Id).get(0).getTitleText());
                    searchByLv4ContentDto.setLv4Id(lv4.getId());
                    searchByLv4ContentDto.setLv4Title(titleRepository.findLv4TitleByLv4Id(lv4.getId()).get(0).getTitleText());

                    String content = contentRepository.findLv4ContentByLv4Id(lv4.getId()).get(0).getContentText();
                    if(content.length() >= 200){
                        String contentSubstrd = content.substring(0,200);
                        searchByLv4ContentDto.setContent(contentSubstrd);
                    }else{
                        searchByLv4ContentDto.setContent(content);
                    }
                    searchByLv4ContentDtoList.add(searchByLv4ContentDto);

                }
            }

        return searchByLv4ContentDtoList;
    }
}
