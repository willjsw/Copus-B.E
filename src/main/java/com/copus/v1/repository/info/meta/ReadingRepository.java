package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.enums.ReadingType;
import com.copus.v1.domain.info.meta.Reading;
import com.copus.v1.domain.info.meta.ReadingInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReadingRepository {
    @PersistenceContext
    private EntityManager em;

    public Reading findOne (Long id){
        return em.find(Reading.class, id);
    }

    public List<Reading> findAll(Long id){
        return em.createQuery("select r from Reading r", Reading.class)
                .getResultList();
    }

    public List<Reading> findByReadingInfo(ReadingInfo readingInfo){
        return em.createQuery("select r from Reading r where r.readingInfo = :readingInfo", Reading.class)
                .setParameter("readingInfo",readingInfo)
                .getResultList();
    }

    public List<Reading> findByType(ReadingType type){
        return em.createQuery("select r from Reading r where r.type = :type", Reading.class)
                .setParameter("type",type)
                .getResultList();
    }

    public List<Reading> findByReadingText(String readingText){
        return em.createQuery("select r from Reading r where r.readingText = :readingText", Reading.class)
                .setParameter("readingText",readingText)
                .getResultList();
    }

}


