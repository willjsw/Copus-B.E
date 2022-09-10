package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.enums.ReferToType;
import com.copus.v1.domain.info.meta.ReferBody;
import com.copus.v1.domain.info.meta.ReferInfo;
import com.copus.v1.domain.info.meta.ReferTo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReferToRepository {
    @PersistenceContext
    private EntityManager em;

    public ReferTo findOne(Long id) {
        return em.find(ReferTo.class, id);
    }

    public List<ReferTo> findAll(Long id) {
        return em.createQuery("select r from ReferTo r", ReferTo.class)
                .getResultList();
    }

    public List<ReferTo> findByType(ReferToType type) {
        return em.createQuery("select r from ReferTo r where r.type = :type", ReferTo.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<ReferTo> findByReferInfo(ReferInfo referInfo) {
        return em.createQuery("select r from ReferTo r where r.referInfo = :referInfo", ReferTo.class)
                .setParameter("referInfo", referInfo)
                .getResultList();
    }

    public List<ReferTo> findByReferInfo(List<ReferBody> referInfo) {
        return em.createQuery("select r from ReferTo r where r.referInfo = :referInfo", ReferTo.class)
                .setParameter("referInfo", referInfo)
                .getResultList();
    }
}


