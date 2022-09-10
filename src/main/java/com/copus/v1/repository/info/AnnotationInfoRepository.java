package com.copus.v1.repository.info;


import com.copus.v1.domain.info.Annotation;
import com.copus.v1.domain.info.AnnotationInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnnotationInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public AnnotationInfo findOne(Long id) {
        return em.find(AnnotationInfo.class, id);
    }

    public List<AnnotationInfo> findAll(Long id) {
        return em.createQuery("select a from AnnotationInfo a", AnnotationInfo.class)
                .getResultList();
    }

    public List<AnnotationInfo> findByAnnotations(List<Annotation> annotations) {
        return em.createQuery("select a from AnnotationInfo a where a.annotations = :annotations", AnnotationInfo.class)
                .setParameter("annotations", annotations)
                .getResultList();
    }
}
