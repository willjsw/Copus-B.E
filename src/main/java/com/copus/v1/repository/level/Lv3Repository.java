package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv3;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv3Repository {
    @PersistenceContext
    private EntityManager em;
    public List<Lv3> findLv3ByLv3Id(String id){
        return em.createQuery("select l from Lv3 l where l.id =: id", Lv3.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv2Id(String lv2id) {
        return em.createQuery("select l from Lv3 l join l.lv2 lv " +
                        "where lv.id = :lv2id", Lv3.class)
                .setParameter("lv2id", lv2id)
                .getResultList();
    }
}
