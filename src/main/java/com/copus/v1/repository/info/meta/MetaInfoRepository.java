package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.meta.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MetaInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<MetaInfo> findById (Long id){
        return em.createQuery("select m from MetaInfo m where m.id = :id", MetaInfo.class)
                .setParameter("id",id)
                .getResultList();
    }

    public List<MetaInfo> findAll(Long id){
        return em.createQuery("select m from MetaInfo m", MetaInfo.class)
                .getResultList();
    }

    public List<MetaInfo> findByTitleInfo(TitleInfo titleInfo){
        return em.createQuery("select m from MetaInfo m where m.titleInfo = :titleInfo", MetaInfo.class)
                .setParameter("titleInfo",titleInfo)
                .getResultList();
    }

    public List<MetaInfo> findByKingInfo(KingInfo kingInfo){
        return em.createQuery("select m from MetaInfo m where m.kingInfo = :kingInfo", MetaInfo.class)
                .setParameter("kingInfo",kingInfo)
                .getResultList();
    }

    public List<MetaInfo> findByEraInfo(EraInfo eraInfo){
        return em.createQuery("select m from MetaInfo m where m.eraInfo = :eraInfo", MetaInfo.class)
                .setParameter("eraInfo",eraInfo)
                .getResultList();
    }

    public List<MetaInfo> findByAuthorInfo(AuthorInfo authorInfo){
        return em.createQuery("select m from MetaInfo m where m.authorInfo = :authorInfo", MetaInfo.class)
                .setParameter("authorInfo",authorInfo)
                .getResultList();
    }

    public List<MetaInfo> findByTranslatorInfo(TranslatorInfo translatorInfo){
        return em.createQuery("select m from MetaInfo m where m.translatorInfo = :translatorInfo", MetaInfo.class)
                .setParameter("translatorInfo",translatorInfo)
                .getResultList();
    }

    public List<MetaInfo> findByPublishInfo(PublishInfo publishInfo){
        return em.createQuery("select m from MetaInfo m where m.publishInfo = :publishInfo", MetaInfo.class)
                .setParameter("publishInfo",publishInfo)
                .getResultList();
    }

    public List<MetaInfo> findByStoreInfo(StoreInfo storeInfo){
        return em.createQuery("select m from MetaInfo m where m.storeInfo = :storeInfo", MetaInfo.class)
                .setParameter("storeInfo",storeInfo)
                .getResultList();
    }

    public List<MetaInfo> findByReferInfo(ReferInfo referInfo){
        return em.createQuery("select m from MetaInfo m where m.referInfo = :referInfo", MetaInfo.class)
                .setParameter("referInfo",referInfo)
                .getResultList();
    }

    public List<MetaInfo> findByCategoryInfo(CategoryInfo categoryInfo){
        return em.createQuery("select m from MetaInfo m where m.categoryInfo = :categoryInfo", MetaInfo.class)
                .setParameter("categoryInfo",categoryInfo)
                .getResultList();
    }


}


