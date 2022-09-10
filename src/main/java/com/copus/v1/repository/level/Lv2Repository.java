package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv2Repository {
    @PersistenceContext
    private EntityManager em;
    public List<Lv2> findLv2ByLv2Id(String id){
        return em.createQuery("select l from Lv2 l where l.id =: id", Lv2.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Lv2> findLv2ByLv1Id(String lv1id) {
        return em.createQuery("select l from Lv2 l join l.lv1 lv " +
                        "where lv.id = :lv1id", Lv2.class)
                .setParameter("lv1id", lv1id)
                .getResultList();
    }


}