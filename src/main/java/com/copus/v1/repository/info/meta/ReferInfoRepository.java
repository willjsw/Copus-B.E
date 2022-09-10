package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.ReferInfo;
import com.copus.v1.domain.info.meta.ReferTo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReferInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public ReferInfo findOne(Long id) {
        return em.find(ReferInfo.class, id);
    }

    public List<ReferInfo> findAll(Long id) {
        return em.createQuery("select r from ReferInfo r", ReferInfo.class)
                .getResultList();
    }

    public List<ReferInfo> findByReferToes(List<ReferTo> referToes) {
        return em.createQuery("select r from ReferInfo r where r.referToes = :referToes", ReferInfo.class)
                .setParameter("referToes", referToes)
                .getResultList();
    }

}



