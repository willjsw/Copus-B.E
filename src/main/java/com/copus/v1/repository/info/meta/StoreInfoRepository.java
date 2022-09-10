package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.StoreHouse;
import com.copus.v1.domain.info.meta.StoreInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StoreInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public StoreInfo findOne(Long id) {
        return em.find(StoreInfo.class, id);
    }

    public List<StoreInfo> findAll(Long id) {
        return em.createQuery("select s from StoreInfo s", StoreInfo.class)
                .getResultList();
    }

    public List<StoreInfo> findByStoreHouse(List<StoreHouse> storeHouse) {
        return em.createQuery("select s from StoreInfo s where s.storeHouse = :storeHouse", StoreInfo.class)
                .setParameter("storeHouse", storeHouse)
                .getResultList();
    }
}


