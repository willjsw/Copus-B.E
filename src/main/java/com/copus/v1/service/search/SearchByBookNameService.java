package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.dto.search.SearchByLv1TitleDto;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchByBookNameService implements ConsonantRangeSet {

    private final Lv1Repository lv1Repository;
    private final Lv1Search lv1Search;



    public ArrayList<SearchByLv1TitleDto> searchByBookName(String bookName) {
        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(bookName);
        return lv1Search.lv1SearchByLv1(lv1List);
    }
}
