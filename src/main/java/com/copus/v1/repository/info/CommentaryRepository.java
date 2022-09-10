package com.copus.v1.repository.info;

import com.copus.v1.domain.info.AnnotationInfo;
import com.copus.v1.domain.info.Commentary;
import com.copus.v1.domain.info.ConnectionInfo;
import com.copus.v1.domain.info.body.BodyInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentaryRepository {
    @PersistenceContext
    private EntityManager em;

    public Commentary findOne(Long id) {
        return em.find(Commentary.class, id);
    }

    public List<Commentary> findAll(Long id) {
        return em.createQuery("select c from Commentary c", Commentary.class)
                .getResultList();
    }

    public List<Commentary> findByMetaInfo(MetaInfo metaInfo) {
        return em.createQuery("select c from Commentary c where c.metaInfo = :metaInfo", Commentary.class)
                .setParameter("metaInfo", metaInfo)
                .getResultList();
    }

    public List<Commentary> findByBodyInfo(BodyInfo bodyInfo) {
        return em.createQuery("select c from Commentary c where c.bodyInfo = :bodyInfo", Commentary.class)
                .setParameter("bodyInfo", bodyInfo)
                .getResultList();
    }

    public List<Commentary> findByAnnotationInfo(AnnotationInfo annotationInfo) {
        return em.createQuery("select c from Commentary c where c.annotationInfo = :annotationInfo", Commentary.class)
                .setParameter("annotationInfo", annotationInfo)
                .getResultList();
    }

    public List<Commentary> findByConnectionInfo(ConnectionInfo connectionInfo) {
        return em.createQuery("select c from Commentary c where c.connectionInfo = :connectionInfo", Commentary.class)
                .setParameter("connectionInfo", connectionInfo)
                .getResultList();
    }
}


