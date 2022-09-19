package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.dto.search.SearchByLv1TitleDto;
import com.copus.v1.service.dto.search.SearchByLv2TitleDto;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Lv1Search {

    public final Lv1Repository lv1Repository;
    public final TitleRepository titleRepository;
    public final AuthorRepository authorRepository;
    public final PublishInfoRepository publishInfoRepository ;


    public ArrayList<SearchByLv1TitleDto> lv1SearchByLv1(List<Lv1> lv1List) {

        List<String> lv1IdList = new ArrayList<>();
        for (Lv1 lv1 : lv1List) {
            lv1IdList.add(lv1.getId());
        }

        ArrayList<SearchByLv1TitleDto> searchByLv1TitleDtoList = new ArrayList<>();
        SearchByLv1TitleDto searchByLv1TitleDto;

        int searchNum = lv1IdList.toArray().length;

        if (searchNum != 0) {

            for (String lv1Id : lv1IdList) {
                searchByLv1TitleDto = new SearchByLv1TitleDto();
                searchByLv1TitleDto.setLv1Id(lv1Id);
                String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                searchByLv1TitleDto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                searchByLv1TitleDto.setAuthor(authorKor+"("+authorChn+")");
                searchByLv1TitleDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());

                searchByLv1TitleDtoList.add(searchByLv1TitleDto);
            }
        }
        return searchByLv1TitleDtoList;
    }
}
