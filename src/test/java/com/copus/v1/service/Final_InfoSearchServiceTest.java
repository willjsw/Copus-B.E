package com.copus.v1.service;

import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.show.ShowLv4ContentDto;
import com.copus.v1.service.dto.show.ShowLv4Dto;
import com.copus.v1.service.show.ShowFinalInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class Final_InfoSearchServiceTest {

    @Autowired
    ShowFinalInfoService showFinalInfoService;
    @Autowired
    Lv4Repository lv4Repository;


    @Test
    void TitleSearch(){
        ArrayList<ShowLv4Dto> lv4 = showFinalInfoService.searchLv4ByLv3Id("ITKC_MO_1237A_0020_010");
        ShowLv4ContentDto content = showFinalInfoService.searchLv4ContentByLv4Id("ITKC_MO_1237A_0010_010_0030");

        System.out.println("결과:"+ lv4);
        System.out.println("본문:"+ content);

    }
}
