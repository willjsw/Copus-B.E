package com.copus.v1.service;

import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.dto.show.ShowLv1Dto;
import com.copus.v1.service.show.ShowSeojiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;


@SpringBootTest
@Transactional


class BookNameSearchServiceTest {
    @Autowired
    ShowSeojiService showSeojiService;
    @Autowired
    Lv1Repository lv1Repository;

    @Test
    void ItemSearch(){
        String han = "가";
        String testItem1 = "한국문집총간";
        String testItem2 = "조성가";
        String testItem3 = "趙性家";

        ArrayList<ShowLv1Dto> id1 = showSeojiService.searchLv1ByConsonant("가");
        ArrayList<ShowLv1Dto> id2 = showSeojiService.searchLv1ByConsonant("아");
        ArrayList<ShowLv1Dto> id3 = showSeojiService.searchLv1ByConsonant("자");
        ArrayList<ShowLv1Dto> id4 = showSeojiService.searchLv1ByConsonant("힣");
        ArrayList<ShowLv1Dto> id5 = showSeojiService.searchLv1ByConsonant("a");
        ArrayList<ShowLv1Dto> id6 = showSeojiService.searchLv1ByAuthorName(testItem2);
//        ArrayList<ArrayList<String>> id3 = bookNameSearchService.searchLv1ByAuthorName(testItem3);


        System.out.println("결과:"+ id1);
        System.out.println("결과2:"+ id2);
        System.out.println("결과3:"+ id3);
        System.out.println("결과4:"+ id4);
        System.out.println("결과5:"+ id5);
        System.out.println("결과6:"+ id6);

    }

}