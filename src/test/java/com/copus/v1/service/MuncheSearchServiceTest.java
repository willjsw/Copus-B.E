package com.copus.v1.service;

import com.copus.v1.repository.level.Lv3Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;


@SpringBootTest
@Transactional
public class MuncheSearchServiceTest {

    @Autowired
    MuncheService muncheService;
    @Autowired
    Lv3Repository lv3Repository;

    @Test
    void MuncheSearch(){
        ArrayList<ArrayList<String>> lv3 = muncheService.searchLv3ByLv2Id("ITKC_MO_1237A_0120");

        System.out.println("결과:"+ lv3);
    }


}
