package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.body.BodyInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    public BodyInfo finBodyInfoRepositorydOne(Long id){
        return em.find(BodyInfo.class, id);
    }

    public List<BodyInfo> findAll(Long id){
        return em.createQuery("select b from BodyInfo b", BodyInfo.class)
                .getResultList();
    }

    public List<BodyInfo> findByContent(String content){
        return em.createQuery("select b from BodyInfo b where b.content = :content", BodyInfo.class)
                .setParameter("content",content)
                .getResultList();
    }
}


