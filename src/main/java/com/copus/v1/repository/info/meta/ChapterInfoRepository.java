package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.body.BodyInfo;
import com.copus.v1.domain.info.meta.ChapterInfo;
import com.copus.v1.domain.info.meta.Title;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ChapterInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ChapterInfo> findChapterInfoByMetaInfoId(Long metaInfoId) {
        return em.createQuery("select c from ChapterInfo c where c.metaInfo.id = :metaInfoId ", ChapterInfo.class)
                .setParameter("metaInfoId", metaInfoId)
                .getResultList();
    }
}


