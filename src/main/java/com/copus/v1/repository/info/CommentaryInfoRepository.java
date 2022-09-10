package com.copus.v1.repository.info;

import com.copus.v1.domain.enums.CommentType;
import com.copus.v1.domain.info.Commentary;
import com.copus.v1.domain.info.CommentaryInfo;
import com.copus.v1.domain.level.Lv1;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentaryInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public CommentaryInfo findOne(Long id) {
        return em.find(CommentaryInfo.class, id);
    }

    public List<CommentaryInfo> findAll(Long id) {
        return em.createQuery("select c from CommentaryInfo c", CommentaryInfo.class)
                .getResultList();
    }

    public List<CommentaryInfo> findByLv1(Lv1 lv1) {
        return em.createQuery("select c from CommentaryInfo c where c.lv1 = :lv1", CommentaryInfo.class)
                .setParameter("lv1", lv1)
                .getResultList();
    }

    public List<CommentaryInfo> findByType(CommentType type) {
        return em.createQuery("select c from CommentaryInfo c where c.type = :type", CommentaryInfo.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<CommentaryInfo> findByCommentary(Commentary commentary) {
        return em.createQuery("select c from CommentaryInfo c where c.commentary = :commentary", CommentaryInfo.class)
                .setParameter("commentary", commentary)
                .getResultList();
    }
}


