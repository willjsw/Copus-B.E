package com.copus.v1.service;

import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.service.dto.show.ShowLv2Dto;
import com.copus.v1.service.show.ShowGwonchaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class GwonchaSearchServiceTest {

    @Autowired
    ShowGwonchaService showGwonchaService;
    @Autowired
    Lv2Repository lv2Repository;

    @Test
    public void GwonchaSearch(){

        ArrayList<ShowLv2Dto> lv2 = showGwonchaService.searchLv2ByLv1Id("月皐集");

        System.out.println("결과:"+ lv2);
        System.out.println("결과:"+ lv2.get(0).getLv2Id());
    }
}
