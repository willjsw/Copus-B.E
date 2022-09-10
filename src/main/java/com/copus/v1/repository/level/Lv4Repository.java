package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv4;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv4Repository {
    @PersistenceContext
    private EntityManager em;

    public List<Lv4> findLv4ByLv3Id(String lv3id) {
        return em.createQuery("select l from Lv4 l join l.lv3 lv " +
                        "where lv.id = :lv3id", Lv4.class)
                .setParameter("lv3id", lv3id)
                .getResultList();
    }

    public List<Lv4> findLv4ByContent(String contentText) {
        return em.createQuery("select l4 from Lv4 l4 join l4.lv3 l3 where l4.bodyInfo = " +
                        "any(select c.bodyInfo from Content c " +
                        "where c.contentText like concat('%',:contentText,'%')) ", Lv4.class)
                .setParameter("contentText", contentText)
                .getResultList();

    }
}