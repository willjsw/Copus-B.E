package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.service.dto.search.SearchByLv2TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Lv2Search {

    private final Lv2Repository lv2Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;


    public ArrayList<SearchByLv2TitleDto> lv2SearchByLv2(List<Lv2> lv2List) {

        List<String> lv2IdList = new ArrayList<>();
        for (Lv2 lv2 : lv2List) {
            lv2IdList.add(lv2.getId());
        }

        ArrayList<SearchByLv2TitleDto> searchByLv2TitleDtoList = new ArrayList<>();
        SearchByLv2TitleDto searchByLv2TitleDto;

        int searchNum = lv2IdList.toArray().length;

        if (searchNum != 0) {


            for (String lv2Id : lv2IdList) {
                List<Lv2> lv2 = lv2Repository.findLv2ByLv2Id(lv2Id);
                String lv1Id = lv2.get(0).getLv1().getId();

                searchByLv2TitleDto = new SearchByLv2TitleDto();

                searchByLv2TitleDto.setLv1Id(lv1Id);

                String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                searchByLv2TitleDto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                searchByLv2TitleDto.setAuthor(authorKor+"("+authorChn+")");

                searchByLv2TitleDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());
                searchByLv2TitleDto.setLv2Id(lv2Id);
                searchByLv2TitleDto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText());

                searchByLv2TitleDtoList.add(searchByLv2TitleDto);
            }
        }
        return searchByLv2TitleDtoList;
    }
}
