package com.copus.v1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class ContentSearchServiceTest {

    @Autowired
    ContentService contentService;

    @Test
    void Content() {

        ArrayList<ArrayList<String>>result = contentService.searchByContent("正心除外騖");

       System.out.println("결과:"+ result);
    }




}
