package com.copus.v1.repository;

import com.copus.v1.domain.enums.CommentType;
import com.copus.v1.domain.info.body.Content;
import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Repository

public class ContentRepositoryTest {

    @PersistenceContext
    private EntityManager em;


    public List<Content> findCommentaryByCommentaryInfoId(Long commentaryInfoId){
        return em.createQuery("""
                select c from Content c 
                inner join Commentary co 
                on co.commentaryInfo.id =: commentaryInfoId """, Content.class)
                .setParameter("commentaryInfoId", commentaryInfoId)
                .getResultList();
    }


    @Test
    void buga(){
        List<Content> buga = findCommentaryByCommentaryInfoId(1L);


        System.out.println("범례:" + buga.get(1).getContentText());
        System.out.println("해제:" + buga.get(0).getContentText());

    }

}
