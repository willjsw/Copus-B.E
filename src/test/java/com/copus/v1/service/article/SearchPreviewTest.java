package com.copus.v1.service.article;

import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.article.search.SearchPreview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SearchPreviewTest {

    @Autowired
    private SearchPreview searchPreview;

    private SearchFilter searchFilter;

        @Test
        void searchController(){
           System.out.println("bookTitle1:\n" + searchPreview.getPreview(searchFilter.bookTitle, "月皐集"));
           System.out.println("bookTitle2:\n"+ searchPreview.getPreview(searchFilter.bookTitle, "월고집"));
           System.out.println("authorName1:\n"+ searchPreview.getPreview(searchFilter.authorName, "趙性家"));
           System.out.println("authorName2:\n"+ searchPreview.getPreview(searchFilter.authorName, "조성가"));
           System.out.println("gwonchaTitle:\n"+ searchPreview.getPreview(searchFilter.gwonchaTitle, "月"));
           System.out.println("muncheTitle:\n"+ searchPreview.getPreview(searchFilter.muncheTitle, "詩"));
           System.out.println("content:\n"+ searchPreview.getPreview(searchFilter.content, "詩"));
           System.out.println("dataId1:\n"+ searchPreview.getPreview(searchFilter.dataId, "ITKC_MO_1237A"));
           System.out.println("dataId2:\n"+ searchPreview.getPreview(searchFilter.dataId, "ITKC_MO_1237A_0040"));
           System.out.println("dataId3:\n"+ searchPreview.getPreview(searchFilter.dataId, "ITKC_MO_1237A_0110_010"));
           System.out.println("dataId4:\n"+ searchPreview.getPreview(searchFilter.dataId, "ITKC_MO_1237A_0010_010_0060"));
           System.out.println("total:\n"+ searchPreview.getPreview(searchFilter.total, "月"));

        }

}