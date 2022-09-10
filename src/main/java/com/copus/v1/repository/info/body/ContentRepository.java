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

    public List<Content> findLv4ContentByTitleId(String id) {
        return em.createQuery("select c from Content c " +
                        "where c.bodyInfo = (select l.bodyInfo from Lv4 l where l.id = :id)", Content.class)
                .setParameter("id", id)
                .getResultList();
    }
}


