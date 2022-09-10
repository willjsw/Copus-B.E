package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.ReferBody;
import com.copus.v1.domain.info.meta.ReferTo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReferBodyRepository {
    @PersistenceContext
    private EntityManager em;

    public ReferBody findOne (Long id){
        return em.find(ReferBody.class, id);
    }

    public List<ReferBody> findAll(Long id){
        return em.createQuery("select r from ReferBody r", ReferBody.class)
                .getResultList();
    }

    public List<ReferBody> findByReferTo(ReferTo referTo){
        return em.createQuery("select r from ReferBody r where r.referTo = :referTo", ReferBody.class)
                .setParameter("referTo",referTo)
                .getResultList();
    }


    public List<ReferBody> findByReferBodyText(String referBodyText){
        return em.createQuery("select r from ReferBody r where r.referBodyText = :referBodyText", ReferBody.class)
                .setParameter("referBodyText",referBodyText)
                .getResultList();
    }
}


