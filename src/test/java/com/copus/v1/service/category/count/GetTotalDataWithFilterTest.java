package com.copus.v1.service.category.count;

import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.category.count.GetTotalDataWithFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class GetTotalDataWithFilterTest {

    @Autowired
    private GetTotalDataWithFilter getTotalDataWithFilter;

    private SearchFilter searchFilter;

        @Test
        void TotalDataCount(){
           System.out.println("bookTitle1" + getTotalDataWithFilter.getSearchCount(searchFilter.bookTitle, "月皐集"));
           System.out.println("bookTitle2"+ getTotalDataWithFilter.getSearchCount(searchFilter.bookTitle, "월고집"));
           System.out.println("authorName1"+ getTotalDataWithFilter.getSearchCount(searchFilter.authorName, "趙性家"));
           System.out.println("authorName2"+ getTotalDataWithFilter.getSearchCount(searchFilter.authorName, "조성가"));
           System.out.println("gwonchaTitle"+ getTotalDataWithFilter.getSearchCount(searchFilter.gwonchaTitle, "月"));
           System.out.println("muncheTitle"+ getTotalDataWithFilter.getSearchCount(searchFilter.muncheTitle, "詩"));
           System.out.println("content"+ getTotalDataWithFilter.getSearchCount(searchFilter.content, "詩"));
           System.out.println("dataId1"+ getTotalDataWithFilter.getSearchCount(searchFilter.dataId, "ITKC_MO_1237A"));
           System.out.println("dataId2"+ getTotalDataWithFilter.getSearchCount(searchFilter.dataId, "ITKC_MO_1237A_0040"));
           System.out.println("dataId3"+ getTotalDataWithFilter.getSearchCount(searchFilter.dataId, "ITKC_MO_1237A_0110_010"));
           System.out.println("dataId4"+ getTotalDataWithFilter.getSearchCount(searchFilter.dataId, "ITKC_MO_1237A_0010_010_0060"));
           System.out.println("total"+ getTotalDataWithFilter.getSearchCount(searchFilter.total, "月"));

        }

}