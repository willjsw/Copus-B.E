package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.KingInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class KingInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public KingInfo findOne (Long id){
        return em.find(KingInfo.class, id);
    }

    public List<KingInfo> findAll(Long id){
        return em.createQuery("select k from KingInfo k", KingInfo.class)
                .getResultList();
    }

    public List<KingInfo> findByName(String name){
        return em.createQuery("select k from KingInfo k where k.name = :name", KingInfo.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<KingInfo> findByAscendDateAD(LocalDate ascendDateAD){
        return em.createQuery("select k from KingInfo k where k.ascendDateAD = :ascendDateAD", KingInfo.class)
                .setParameter("ascendDateAD",ascendDateAD)
                .getResultList();
    }

    public List<KingInfo> findByAscendDateAlias(String ascendDateAlias){
        return em.createQuery("select k from KingInfo k where k.ascendDateAlias = :ascendDateAlias", KingInfo.class)
                .setParameter("ascendDateAlias",ascendDateAlias)
                .getResultList();
    }

    public List<KingInfo> findByDescendDateAD(LocalDate descendDateAD){
        return em.createQuery("select k from KingInfo k where k.descendDateAD = :descendDateAD", KingInfo.class)
                .setParameter("descendDateAD",descendDateAD)
                .getResultList();
    }

    public List<KingInfo> findByDescendDateAlias(String descendDateAlias){
        return em.createQuery("select k from KingInfo k where k.descendDateAlias = :descendDateAlias", KingInfo.class)
                .setParameter("descendDateAlias",descendDateAlias)
                .getResultList();
    }


}


