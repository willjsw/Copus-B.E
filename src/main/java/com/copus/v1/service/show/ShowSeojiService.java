package com.copus.v1.service.show;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

//Lv1 서지명 입력, Id 반환
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowSeojiService implements ConsonantRangeSet {

    public final Lv1Repository lv1Repository;
    public final MainShow mainShow;
    public ArrayList<ShowLv1Dto> searchLv1ByConsonant(String consonant) {
        List<String> lv1IdList = new ArrayList<>();
        String consonant1 = ConsonantRangeSet.consonantRange(consonant).get(0);
        String consonant2 = ConsonantRangeSet.consonantRange(consonant).get(1);

        List<Lv1> lv1List = lv1Repository.findLv1ByConsonant(consonant1, consonant2);
        return mainShow.mainSearchByLv1(lv1List);
    }

    public ArrayList<ShowLv1Dto> searchLv1ByAuthorName(String author){
        List<Lv1>lv1List=lv1Repository.findLv1ByAuthorName(author);
        return mainShow.mainSearchByLv1(lv1List);
                                                                                 }
}
