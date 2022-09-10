package com.copus.v1.service;

import com.copus.v1.domain.info.body.Content;
import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv4Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinalInfoService {


    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final ContentRepository contentRepository;


    public ArrayList<ArrayList<String>> searchLv4ByLv3Id(String id){
        ArrayList<String> searchNum = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        List<Lv4> lvList = lv4Repository.findLv4ByLv3Id(id);
        List<Title> TitleList = titleRepository.findLv4TitleByLv3Id(id);

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

    @Transactional
    public String searchLv4ContentByLv4Id(String id){
        List<Content>lv4ContentList=contentRepository.findLv4ContentByTitleId(id);
        return lv4ContentList.get(0).getContentText();
    }

}
