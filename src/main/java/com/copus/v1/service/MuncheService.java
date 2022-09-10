package com.copus.v1.service;

import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MuncheService {

    private final Lv3Repository lv3Repository;
    private final TitleRepository titleRepository;

    @Transactional
    public ArrayList<ArrayList<String>> searchLv3ByLv2Id(String id){
        ArrayList<String> searchNum = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        List<Lv3>lvList=lv3Repository.findLv3ByLv2Id(id);
        List<Title>TitleList=titleRepository.findLv3TitleByLv2Id(id);

        int lvListLength = lvList.toArray().length;
        int TitleListLength = TitleList.toArray().length;

        searchNum.add(String.valueOf(lvListLength));
        result.add(searchNum);

        if(lvListLength!=0){
            for(int i=0; i<lvListLength;i++){
                idList.add(lvList.get(i).getId());
            }

            for(int i=0; i<TitleListLength;i++){
                titleList.add(TitleList.get(i).getTitleText());
            }

            result.add(idList);
            result.add(titleList);
        }

        return result;
    }

}