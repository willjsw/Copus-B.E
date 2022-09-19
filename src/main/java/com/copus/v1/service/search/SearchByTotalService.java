package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.search.SearchByTotalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchByTotalService {


    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;


    private final SearchByContentService searchByContentService;
    private final Lv1Search lv1Search;
    private final Lv2Search lv2Search;
    private final Lv3Search lv3Search;
    private final Lv4Search lv4Search;
    private final ContentSearch contentSearch;
    private final AuthorNameSearch authorNameSearch;

    public SearchByTotalDto searchByTotal(String keyword) {

        SearchByTotalDto searchByTotalDto = new SearchByTotalDto();

        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(keyword);
        if (lv1List.toArray().length != 0){
            searchByTotalDto.setSearchByLv1TitleDto(lv1Search.lv1SearchByLv1(lv1List));
        }

        List<Lv1> lv1ListByAuthorName = lv1Repository.findLv1ByAuthorName(keyword);
        if (lv1ListByAuthorName.toArray().length != 0){
            searchByTotalDto.setSearchByAuthorNameDto(authorNameSearch.lv4SearchByAuthorName(lv1List));
        }

        List<Lv2> lv2List = lv2Repository.findLv2ByLv2Title(keyword);
        if (lv2List.toArray().length != 0){
            searchByTotalDto.setSearchByLv2TitleDto(lv2Search.lv2SearchByLv2(lv2List));
        }

        List<Lv3> lv3List = lv3Repository.findLv3ByLv3Title(keyword);
        if (lv3List.toArray().length != 0){
            searchByTotalDto.setSearchByLv3TitleDto(lv3Search.lv3SearchByLv3(lv3List));
        }

        List<Lv4> lv4List = lv4Repository.findLv4ByLv4Title(keyword);
        if (lv4List.toArray().length != 0){
            searchByTotalDto.setSearchByLv4TitleDto(lv4Search.lv4SearchByLv4(lv4List));
        }

        List<Lv4> lv4ListByContent = lv4Repository.findLv4ByContent(keyword);
        if (lv4ListByContent.toArray().length != 0) {
            searchByTotalDto.setSearchByLv4ContentDto(contentSearch.contentSearchByContent(lv4ListByContent));
        }

        return searchByTotalDto;
        }


}
