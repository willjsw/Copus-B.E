package com.copus.v1.repository.info.body;

import com.copus.v1.domain.info.body.Content;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Content> findLv4ContentByLv4Id(String level_4_Id) {
        return em.createQuery("select c from Content c join Lv4 l4  " +
                        "on l4.bodyInfo = c.bodyInfo and l4.id =:level_4_Id", Content.class)
                .setParameter("level_4_Id", level_4_Id)
                .getResultList();
    }

    public List<Content> findLv4ContentByContentText(String contentText) {
        return em.createQuery("select c from Content c where c.contentText like concat('%',:contentText,'%')", Content.class)
                .setParameter("contentText", contentText)
                .getResultList();
    }
}


