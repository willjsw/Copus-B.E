package com.copus.v1.service;

import com.copus.v1.service.dto.search.SearchByTotalDto;
import com.copus.v1.service.search.SearchByTotalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional

public class SearchByTotalServiceTest {

    @Autowired
    SearchByTotalService searchByTotalService;

    @Test
    void Category() {
        SearchByTotalDto result1_1 = searchByTotalService.searchByTotal("0");
        System.out.println("결과1_1:"+ result1_1);

        }
    }


