package com.copus.v1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;



@SpringBootTest
@Transactional

public class CategorySearchServiceTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookNameService bookNameService;
    @Autowired
    AuthorNameService authorNameService;

    @Test
    void Category() {
        ArrayList<ArrayList<String>>result1_1 = categoryService.searchByBookName("월고집");
        ArrayList<ArrayList<String>>result1_2 = categoryService.searchByBookName("매계집");
        ArrayList<ArrayList<String>>result2_1 = categoryService.searchByAuthorName("조성가");
        ArrayList<ArrayList<String>>result2_2 = categoryService.searchByAuthorName("趙性家");
        ArrayList<ArrayList<String>>result2_3 = categoryService.searchByAuthorName("정몽주");

        System.out.println("결과1_1:"+ result1_1);
        System.out.println("결과1_2:"+ result1_2);
        System.out.println("결과2_1:"+ result2_1);
        System.out.println("결과2_2:"+ result2_2);
        System.out.println("결과2_2:"+ result2_3);

        }
    }


