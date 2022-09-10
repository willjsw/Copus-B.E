package com.copus.v1.service;

import com.copus.v1.repository.level.Lv2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class GwonchaSearchServiceTest {

    @Autowired
    GwonchaService gwonchaService;
    @Autowired
    Lv2Repository lv2Repository;

    @Test
    public void GwonchaSearch(){

        ArrayList<ArrayList<String>> lv2 = gwonchaService.searchLv2ByLv1Id("ITKC_MO_1237A");

        System.out.println("결과:"+ lv2);
    }
}
