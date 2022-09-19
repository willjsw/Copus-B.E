package com.copus.v1.service.search;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.dto.search.SearchByAuthorNameDto;
import com.copus.v1.service.show.MainShow;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchByAuthorNameService implements ConsonantRangeSet {

    private final Lv1Repository lv1Repository;
    private final AuthorNameSearch authorNameSearch;


    public ArrayList<SearchByAuthorNameDto> searchByAuthorName(String authorName) {
        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(authorName);
        return authorNameSearch.lv4SearchByAuthorName(lv1List);
    }

}
