package com.copus.v1.service;

import com.copus.v1.repository.level.Lv4Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class FinalInfoSearchServiceTest {

    @Autowired
    FinalInfoService finalInfoService;
    @Autowired
    Lv4Repository lv4Repository;


    @Test
    void TitleSearch(){
        ArrayList<ArrayList<String>> lv4 = finalInfoService.searchLv4ByLv3Id("ITKC_MO_1237A_0020_010");
        String content = finalInfoService.searchLv4ContentByLv4Id("ITKC_MO_1237A_0020_010_0010");

        System.out.println("결과:"+ lv4);
        System.out.println("본문:"+ content);

    }
}
