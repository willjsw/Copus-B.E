package com.copus.v1.service.article;

import com.copus.v1.service.enums.SeojiKeyword;
import com.copus.v1.service.enums.SeojiOrdering;
import com.copus.v1.service.article.show.ShowSeojiInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ShowSeojiInfoTest {

    @Autowired
    private ShowSeojiInfo showSeojiInfo;

    private SeojiKeyword seojiKeyword;

        @Test
        void seaojiInfo(){
           System.out.println("all:\n" + showSeojiInfo.getSeojiInfo(seojiKeyword.all, SeojiOrdering.none,"none"));
           System.out.println("bookTitleConsonant:\n"+ showSeojiInfo.getSeojiInfo(seojiKeyword.bookTitleConsonant, SeojiOrdering.none, "아"));
           System.out.println("authorNameConsonant:\n"+ showSeojiInfo.getSeojiInfo(seojiKeyword.authorNameConsonant, SeojiOrdering.none,"자"));
           System.out.println("authorName:\n"+ showSeojiInfo.getSeojiInfo(seojiKeyword.authorName, SeojiOrdering.none, "조성가"));

        }

}