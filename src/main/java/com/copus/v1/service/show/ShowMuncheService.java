package com.copus.v1.service.show;

import com.copus.v1.domain.level.Lv3;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.dto.show.ShowLv3Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowMuncheService {

    private final Lv3Repository lv3Repository;
    private final TitleRepository titleRepository;


    public ArrayList<ShowLv3Dto> searchLv3ByLv2Id(String level_2_id){


        ArrayList<ShowLv3Dto> showLv3DtoList = new ArrayList<>();

        List<Lv3> lv3List = lv3Repository.findLv3ByLv2Id(level_2_id);
        int searchNum=lv3List.toArray().length;

        if (searchNum != 0) {

            for (Lv3 lv3 : lv3List) {
                ShowLv3Dto showLv3Dto = new ShowLv3Dto();
                showLv3Dto.setLv3Id(lv3.getId());
                showLv3Dto.setLv3Title(titleRepository.findLv3TitleByLv3Id(lv3.getId()).get(0).getTitleText());
                showLv3DtoList.add(showLv3Dto);
            }

        }
        return showLv3DtoList;
    }

}