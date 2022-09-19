package com.copus.v1.service;

import com.copus.v1.service.category.AuthorNameCountService;
import com.copus.v1.service.category.BookNameCountService;
import com.copus.v1.service.category.ContentCountService;
import com.copus.v1.service.category.TotalCountService;
import com.copus.v1.service.dto.category.AuthorNameCountDto;
import com.copus.v1.service.dto.category.BookNameCountDto;
import com.copus.v1.service.dto.category.ContentCountDto;
import com.copus.v1.service.dto.category.TotalCountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;


@SpringBootTest
@Transactional
public class CategoryCountServiceTest {

    @Autowired
    TotalCountService totalCountService;
    @Autowired
    BookNameCountService bookNameCountService;
    @Autowired
    AuthorNameCountService authorNameCountService;
    @Autowired
    ContentCountService contentCountService;

    @Test
    void Count() {
        TotalCountDto result1=totalCountService.totalCount("月");
        BookNameCountDto result2=bookNameCountService.bookNameCount("월고집");
        AuthorNameCountDto result3=authorNameCountService.authorNameCount("조성가");
        ContentCountDto result4=contentCountService.contentCount("八");
        System.out.println("결과1:"+ result1);
        System.out.println("결과2:"+ result2);
        System.out.println("결과3:"+ result3);
        System.out.println("결과4:"+ result4);



        }
    }


