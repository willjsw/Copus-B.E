package com.copus.v1.service.show;

import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.show.ShowLv4ContentDto;
import com.copus.v1.service.dto.show.ShowLv4Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowFinalInfoService {


    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final ContentRepository contentRepository;


    public ArrayList<ShowLv4Dto> searchLv4ByLv3Id(String level_3_id){

        ArrayList<ShowLv4Dto> showLv4DtoList = new ArrayList<>();

        List<Lv4> lv4List = lv4Repository.findLv4ByLv3Id(level_3_id);
        int searchNum=lv4List.toArray().length;

        if (searchNum != 0) {

            for (Lv4 lv4 : lv4List) {
                ShowLv4Dto showLv4Dto = new ShowLv4Dto();
                showLv4Dto.setLv4Id(lv4.getId());
                showLv4Dto.setLv4Title(titleRepository.findLv4TitleByLv4Id(lv4.getId()).get(0).getTitleText());
                showLv4DtoList.add(showLv4Dto);
            }

        }
        return showLv4DtoList;
    }

    @Transactional
    public ShowLv4ContentDto searchLv4ContentByLv4Id(String level_4_Id){
        ShowLv4ContentDto showLv4ContentDto = new ShowLv4ContentDto();
        showLv4ContentDto.setContent(contentRepository.findLv4ContentByLv4Id(level_4_Id).get(0).getContentText().substring(0,200));
        return showLv4ContentDto;
    }

}
