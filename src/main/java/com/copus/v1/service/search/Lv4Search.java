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
import com.copus.v1.service.dto.search.SearchByLv3TitleDto;
import com.copus.v1.service.dto.search.SearchByLv4ContentDto;
import com.copus.v1.service.dto.search.SearchByLv4TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Lv4Search {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;


    public ArrayList<SearchByLv4TitleDto> lv4SearchByLv4(List<Lv4> lv4List) {

        List<String> lv4IdList = new ArrayList<>();
        for (Lv4 lv4 : lv4List) {
            lv4IdList.add(lv4.getId());
        }

        ArrayList<SearchByLv4TitleDto> searchByLv4TitleDtoList = new ArrayList<>();
        SearchByLv4TitleDto searchByLv4TitleDto;

        int searchNum = lv4List.toArray().length;

        if (searchNum != 0) {

                for (Lv4 lv4 : lv4List) {
                    searchByLv4TitleDto = new SearchByLv4TitleDto();

                    String lv3Id = lv4.getLv3().getId();
                    List<Lv3> lv3 = lv3Repository.findLv3ByLv3Id(lv3Id);
                    String lv2Id = lv3.get(0).getLv2().getId();
                    List<Lv2> lv2 = lv2Repository.findLv2ByLv2Id(lv2Id);
                    String lv1Id = lv2.get(0).getLv1().getId();

                    searchByLv4TitleDto.setLv1Id(lv1Id);
                    String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                    String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                    searchByLv4TitleDto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                    String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                    String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                    searchByLv4TitleDto.setAuthor(authorKor+"("+authorChn+")");
                    searchByLv4TitleDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());

                    searchByLv4TitleDto.setLv2Id(lv2Id);
                    searchByLv4TitleDto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText());
                    searchByLv4TitleDto.setLv3Id(lv3Id);
                    searchByLv4TitleDto.setLv3Title(titleRepository.findLv3TitleByLv3Id(lv3Id).get(0).getTitleText());
                    searchByLv4TitleDto.setLv4Id(lv4.getId());
                    searchByLv4TitleDto.setLv4Title(titleRepository.findLv4TitleByLv4Id(lv4.getId()).get(0).getTitleText());

                    searchByLv4TitleDtoList.add(searchByLv4TitleDto);

                }
            }

        return searchByLv4TitleDtoList;
    }
}
