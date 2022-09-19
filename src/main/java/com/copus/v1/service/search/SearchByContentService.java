package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.dto.search.SearchByLv4ContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchByContentService implements ConsonantRangeSet {
    public final Lv4Repository lv4Repository;
    public final ContentSearch contentSearch;


    public ArrayList<SearchByLv4ContentDto> searchByContent(String contentText){
        List<Lv4> lv4List = lv4Repository.findLv4ByContent(contentText);
        return contentSearch.contentSearchByContent(lv4List);
    }

}
