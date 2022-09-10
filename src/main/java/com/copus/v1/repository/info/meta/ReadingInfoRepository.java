package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.meta.Reading;
import com.copus.v1.domain.info.meta.ReadingInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReadingInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public ReadingInfo findOne (Long id){
        return em.find(ReadingInfo.class, id);
    }

    public List<ReadingInfo> findAll(Long id){
        return em.createQuery("select r from ReadingInfo r", ReadingInfo.class)
                .getResultList();
    }

    public List<ReadingInfo> findByReadings(List<Reading> readings){
        return em.createQuery("select r from ReadingInfo r where r.readings = :readings", ReadingInfo.class)
                .setParameter("readings",readings)
                .getResultList();
    }
}


