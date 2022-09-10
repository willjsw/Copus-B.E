package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.meta.TranslatorInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TranslatorInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public TranslatorInfo findOne(Long id) {
        return em.find(TranslatorInfo.class, id);
    }

    public List<TranslatorInfo> findAll(Long id) {
        return em.createQuery("select t from TranslatorInfo t", TranslatorInfo.class)
                .getResultList();
    }
}


