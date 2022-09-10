package com.copus.v1.repository.info.meta;



import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.info.meta.TitleInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TitleInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<TitleInfo> findById(Long id) {
        return em.createQuery("select t from TitleInfo t where t.id = :id", TitleInfo.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<TitleInfo> findAll(Long id) {
        return em.createQuery("select t from TitleInfo t", TitleInfo.class)
                .getResultList();
    }

    public List<TitleInfo> findByTitles(List<Title> titles) {
        return em.createQuery("select t from TitleInfo t where t.titles = :titles", TitleInfo.class)
                .setParameter("titles", titles)
                .getResultList();
    }
}


