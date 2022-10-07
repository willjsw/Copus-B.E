package com.copus.v1.service.article;

import com.copus.v1.service.article.show.ShowFinalInfo;
import com.copus.v1.service.article.show.ShowGwonchaInfo;
import com.copus.v1.service.article.show.ShowMuncheInfo;
import com.copus.v1.service.article.show.ShowTotalGwonchaInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ShowLevelTest {

    @Autowired
    private ShowTotalGwonchaInfo showTotalGwonchaInfo;
    @Autowired
    private ShowGwonchaInfo showGwonchaInfo;
    @Autowired
    private ShowMuncheInfo showMuncheInfo;
    @Autowired
    private ShowFinalInfo showFinalInfo;

        @Test
        void showLevel(){
            System.out.println(showTotalGwonchaInfo.getTotalGwonchaInfo("ITKC_MO_1237A"));
            System.out.println(showGwonchaInfo.getGwonchaInfo("ITKC_MO_1237A_0020"));
            System.out.println(showMuncheInfo.getMuncheInfo("ITKC_MO_1237A_0020_010"));
            System.out.println(showFinalInfo.getFinalInfo("ITKC_MO_1237A_0020_010_0010"));;

        }

}