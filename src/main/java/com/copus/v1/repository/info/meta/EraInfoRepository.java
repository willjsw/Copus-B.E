package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.enums.LeapFlat;
import com.copus.v1.domain.enums.LeapFlat;
import com.copus.v1.domain.info.meta.EraInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EraInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public EraInfo findOne (Long id){

        return em.find(EraInfo.class, id);
    }

    public List<EraInfo> findAll(Long id){
        return em.createQuery("select e from EraInfo e", EraInfo.class)
                .getResultList();
    }

    public List<EraInfo> findByYear(String year){
        return em.createQuery("select e from EraInfo e where e.year = :year", EraInfo.class)
                .setParameter("year",year)
                .getResultList();
    }

    public List<EraInfo> findByZodiacYear(String zodiacYear){
        return em.createQuery("select e from EraInfo e where e.zodiacYear = :zodiacYear", EraInfo.class)
                .setParameter("zodiacYear",zodiacYear)
                .getResultList();
    }

    public List<EraInfo> findByAlias(String alias){
        return em.createQuery("select e from EraInfo e where e.alias = :alias", EraInfo.class)
                .setParameter("alias",alias)
                .getResultList();
    }

    public List<EraInfo> findByAliasYear(String aliasYear){
        return em.createQuery("select e from EraInfo e where e.aliasYear = :aliasYear", EraInfo.class)
                .setParameter("aliasYear",aliasYear)
                .getResultList();
    }

    public List<EraInfo> findByAliasYearCount(String aliasYearCount){
        return em.createQuery("select e from EraInfo e where e.aliasYearCount = :aliasYearCount", EraInfo.class)
                .setParameter("aliasYearCount",aliasYearCount)
                .getResultList();
    }

    public List<EraInfo> findByMonth(String month){
        return em.createQuery("select e from EraInfo e where e.month = :month", EraInfo.class)
                .setParameter("month",month)
                .getResultList();
    }

    public List<EraInfo> findByLeapFlat(LeapFlat leapFlat){
        return em.createQuery("select e from EraInfo e where e.leapFlat = :leapFlat", EraInfo.class)
                .setParameter("leapFlat",leapFlat)
                .getResultList();
    }

    public List<EraInfo> findByDay(String day){
        return em.createQuery("select e from EraInfo e where e.day = :day", EraInfo.class)
                .setParameter("day",day)
                .getResultList();
    }

    public List<EraInfo> findByZodiacDay(String zodiacDay){
        return em.createQuery("select e from EraInfo e where e.zodiacDay = :zodiacDay", EraInfo.class)
                .setParameter("zodiacDay",zodiacDay)
                .getResultList();
    }

}


