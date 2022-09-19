package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.dto.search.SearchByLv2TitleDto;
import com.copus.v1.service.dto.search.SearchByLv3TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Lv3Search {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;


    public ArrayList<SearchByLv3TitleDto> lv3SearchByLv3(List<Lv3> lv3List) {

        List<String> lv3IdList = new ArrayList<>();
        for (Lv3 lv3 : lv3List) {
            lv3IdList.add(lv3.getId());
        }

        ArrayList<SearchByLv3TitleDto> searchByLv3TitleDtoList = new ArrayList<>();
        SearchByLv3TitleDto searchByLv3TitleDto;

        int searchNum = lv3IdList.toArray().length;

        if (searchNum != 0) {


            for (String lv3Id : lv3IdList) {
                List<Lv3> lv3 = lv3Repository.findLv3ByLv3Id(lv3Id);
                String lv2Id = lv3.get(0).getLv2().getId();
                List<Lv2> lv2 = lv2Repository.findLv2ByLv2Id(lv2Id);
                String lv1Id = lv2.get(0).getLv1().getId();

                searchByLv3TitleDto = new SearchByLv3TitleDto();

                searchByLv3TitleDto.setLv1Id(lv1Id);

                String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                searchByLv3TitleDto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                searchByLv3TitleDto.setAuthor(authorKor+"("+authorChn+")");

                searchByLv3TitleDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());
                searchByLv3TitleDto.setLv2Id(lv2Id);
                searchByLv3TitleDto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText());
                searchByLv3TitleDto.setLv3Id(lv3Id);
                searchByLv3TitleDto.setLv3Title(titleRepository.findLv3TitleByLv3Id(lv3Id).get(0).getTitleText());


                searchByLv3TitleDtoList.add(searchByLv3TitleDto);
            }
        }
        return searchByLv3TitleDtoList;
    }
}
