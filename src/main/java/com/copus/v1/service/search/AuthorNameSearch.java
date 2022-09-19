package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.search.SearchByAuthorNameDto;
import com.copus.v1.service.dto.search.SearchByLv4TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorNameSearch {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository ;


    public ArrayList<SearchByAuthorNameDto> lv4SearchByAuthorName(List<Lv1> lv1List) {

        List<String> lv1IdList = new ArrayList<>();
        for (Lv1 lv1 : lv1List) {
            lv1IdList.add(lv1.getId());
        }
        ArrayList<SearchByAuthorNameDto> searchByAuthorNameDtoList = new ArrayList<>();
        SearchByAuthorNameDto searchByAuthorNameDto;

        int searchNum = lv1List.toArray().length;

        if (searchNum != 0) {

                for (String lv1Id : lv1IdList) {
                    searchByAuthorNameDto = new SearchByAuthorNameDto();
                    String lv2Id = lv2Repository.findLv2ByLv1Id(lv1Id).get(0).getId();
                    String lv3Id = lv3Repository.findLv3ByLv2Id(lv2Id).get(0).getId();
                    String lv4Id = lv4Repository.findLv4ByLv3Id(lv3Id).get(0).getId();

                    searchByAuthorNameDto.setLv1Id(lv1Id);
                    String lv1TitleChn = titleRepository.findLv1TitleByLv1Id(lv1Id).get(0).getTitleText();
                    String lv1TitleKor = titleRepository.findLv1TitleByLv1Id(lv1Id).get(1).getTitleText();
                    searchByAuthorNameDto.setLv1Title(lv1TitleKor+"("+lv1TitleChn+")");
                    String authorChn=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameChn();
                    String authorKor=authorRepository.findAuthorNameByLv1Id(lv1Id).get(0).getNameKor();
                    searchByAuthorNameDto.setAuthor(authorKor+"("+authorChn+")");
                    searchByAuthorNameDto.setOriginalPublishYear(publishInfoRepository.findPublishInfoByLv1Id(lv1Id).get(0).getOriginalPublishYear());

                    searchByAuthorNameDto.setLv2Id(lv2Id);
                    searchByAuthorNameDto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2Id).get(0).getTitleText());
                    searchByAuthorNameDto.setLv3Id(lv3Id);
                    searchByAuthorNameDto.setLv3Title(titleRepository.findLv3TitleByLv3Id(lv3Id).get(0).getTitleText());
                    searchByAuthorNameDto.setLv4Id(lv4Id);
                    searchByAuthorNameDto.setLv4Title(titleRepository.findLv4TitleByLv4Id(lv4Id).get(0).getTitleText());

                    searchByAuthorNameDtoList.add(searchByAuthorNameDto);

                }
            }

        return searchByAuthorNameDtoList;
    }
}
