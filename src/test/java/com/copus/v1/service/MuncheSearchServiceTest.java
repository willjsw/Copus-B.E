package com.copus.v1.service;

import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.dto.show.ShowLv3Dto;
import com.copus.v1.service.show.ShowMuncheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;


@SpringBootTest
@Transactional
public class MuncheSearchServiceTest {

    @Autowired
    ShowMuncheService showMuncheService;

    @Test
    void showMunche(){
        ArrayList<ShowLv3Dto> lv3 = showMuncheService.searchLv3ByLv2Id("ITKC_MO_1237A_0010");

        System.out.println("결과:"+ lv3);
    }


}
