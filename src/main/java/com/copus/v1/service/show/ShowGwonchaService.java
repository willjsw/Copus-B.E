package com.copus.v1.service.show;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.service.dto.show.ShowLv2Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowGwonchaService {

    private final Lv2Repository lv2Repository;
    private final TitleRepository titleRepository;


    public ArrayList<ShowLv2Dto> searchLv2ByLv1Id(String level_1_id) {

        ArrayList<ShowLv2Dto> showLv2DtoList = new ArrayList<>();

        List<Lv2> lv2List = lv2Repository.findLv2ByLv1Id(level_1_id);
        int searchNum=lv2List.toArray().length;

        if (searchNum != 0) {

            for (Lv2 lv2 : lv2List) {
                ShowLv2Dto showLv2Dto = new ShowLv2Dto();
                showLv2Dto.setLv2Id(lv2.getId());
                showLv2Dto.setLv2Title(titleRepository.findLv2TitleByLv2Id(lv2.getId()).get(0).getTitleText());
                showLv2DtoList.add(showLv2Dto);
            }


        }
        return showLv2DtoList;
    }
}
