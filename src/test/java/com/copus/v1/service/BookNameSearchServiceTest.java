package com.copus.v1.service;

import com.copus.v1.repository.level.Lv1Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;


@SpringBootTest
@Transactional


class BookNameSearchServiceTest {
    @Autowired
    BookNameService bookNameService;
    @Autowired
    Lv1Repository lv1Repository;

    @Test
    void ItemSearch(){
        String han = "가";
        String testItem1 = "한국문집총간";
        String testItem2 = "조성가";
        String testItem3 = "趙性家";

        Lv1SearchDTO id1 = bookNameService.searchLv1ByConsonant("가");
        Lv1SearchDTO id2 = bookNameService.searchLv1ByConsonant("아");
        Lv1SearchDTO id3 = bookNameService.searchLv1ByConsonant("자");
        Lv1SearchDTO id4 = bookNameService.searchLv1ByConsonant("힣");
        Lv1SearchDTO id5 = bookNameService.searchLv1ByConsonant("a");
        Lv1SearchDTO id6 = bookNameService.searchLv1ByAuthorName(testItem2);
//        ArrayList<ArrayList<String>> id3 = bookNameSearchService.searchLv1ByAuthorName(testItem3);


        System.out.println("결과:"+ id1);
        System.out.println("결과2:"+ id2);
        System.out.println("결과3:"+ id3);
        System.out.println("결과4:"+ id4);
        System.out.println("결과5:"+ id5);
        System.out.println("결과6:"+ id6);

    }

}