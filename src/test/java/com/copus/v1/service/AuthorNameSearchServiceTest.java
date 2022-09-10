package com.copus.v1.service;

import com.copus.v1.repository.info.meta.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional


class AuthorNameSearchServiceTest {
    @Autowired
    AuthorNameService authorNameService;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void Author(){
        ArrayList<ArrayList<String>> author1 = authorNameService.searchAuthorNameByItemName("가");
        ArrayList<ArrayList<String>> author2 = authorNameService.searchAuthorNameByItemName("자");
        ArrayList<ArrayList<String>> author3 = authorNameService.searchAuthorNameByItemName("차");
        ArrayList<ArrayList<String>> author4 = authorNameService.searchAuthorNameByItemName("힣");
        ArrayList<ArrayList<String>> author5 = authorNameService.searchAuthorNameByItemName("a");


        System.out.println("결과1:"+ author1);
        System.out.println("결과2:"+ author2);
        System.out.println("결과3:"+ author3);
        System.out.println("결과4:"+ author4);
        System.out.println("결과5:"+ author5);


    }

}