package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.StoreHouse;
import com.copus.v1.domain.info.meta.StoreInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StoreHouseRepository {
    @PersistenceContext
    private EntityManager em;

    public StoreHouse findOne(Long id) {
        return em.find(StoreHouse.class, id);
    }

    public List<StoreHouse> findAll(Long id) {
        return em.createQuery("select s from StoreHouse s", StoreHouse.class)
                .getResultList();
    }

    public List<StoreHouse> findByStoreInfo(StoreInfo storeInfo) {
        return em.createQuery("select s from StoreHouse s where s.storeInfo = :storeInfo", StoreHouse.class)
                .setParameter("storeInfo", storeInfo)
                .getResultList();
    }

    public List<StoreHouse> findByStoreHouseText(String storeHouseText) {
        return em.createQuery("select s from StoreHouse s where s.storeHouseText = :storeHouseText", StoreHouse.class)
                .setParameter("storeHouseText", storeHouseText)
                .getResultList();
    }
}


