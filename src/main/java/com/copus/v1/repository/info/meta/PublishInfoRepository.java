package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.PublishInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PublishInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<PublishInfo> findPublishInfoByLv1Id(String id) {
        return em.createQuery("select p from PublishInfo p " +
                        "where p.metaInfo = (select l.metaInfo from Lv1 l where l.id = :id)", PublishInfo.class)
                .setParameter("id", id)
                .getResultList();
    }


}


