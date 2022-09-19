package com.copus.v1.service;

import com.copus.v1.service.dto.search.SearchByLv4ContentDto;
import com.copus.v1.service.search.SearchByContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class ContentSearchServiceTest {

    @Autowired
    SearchByContentService searchByContentService;

    @Test
    void Content() {

        ArrayList<SearchByLv4ContentDto> result = searchByContentService.searchByContent("正");

       System.out.println("결과:"+ result);
    }




}
