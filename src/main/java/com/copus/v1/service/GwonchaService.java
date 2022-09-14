package com.copus.v1.service;

import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GwonchaService {

    private final Lv2Repository lv2Repository;
    private final TitleRepository titleRepository;

    @Transactional
    public ArrayList<ArrayList<String>> searchLv2ByLv1Id(String id) {
        ArrayList<String> searchNum = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        List<Lv2> lvList = lv2Repository.findLv2ByLv1Title(id);
        List<Title> TitleList = titleRepository.findLv2TitleByLv1Id(id);

        int lvListLength = lvList.toArray().length;
        int TitleListLength = TitleList.toArray().length;

        searchNum.add(String.valueOf(lvListLength));
        result.add(searchNum);

        if (lvListLength != 0) {
            for (int i = 0; i < lvListLength; i++) {
                idList.add(lvList.get(i).getId());
            }

            for (int i = 0; i < TitleListLength; i++) {
                titleList.add(TitleList.get(i).getTitleText());
            }

            result.add(idList);
            result.add(titleList);
        }
        return result;
    }
}
