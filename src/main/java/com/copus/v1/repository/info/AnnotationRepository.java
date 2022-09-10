package com.copus.v1.repository.info;

import com.copus.v1.domain.enums.AnnotationType;
import com.copus.v1.domain.info.Annotation;

import com.copus.v1.domain.info.AnnotationInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnnotationRepository {
    @PersistenceContext
    private EntityManager em;

    public Annotation findOne(Long id) {
        return em.find(Annotation.class, id);
    }

    public List<Annotation> findAll(Long id) {
        return em.createQuery("select a from Annotation a", Annotation.class)
                .getResultList();
    }

    public List<Annotation> findByAnnotationInfo(AnnotationInfo annotationInfo) {
        return em.createQuery("select a from Annotation a where a.annotationInfo = :annotationInfo", Annotation.class)
                .setParameter("annotationInfo", annotationInfo)
                .getResultList();
    }

    public List<Annotation> findByType(AnnotationType type) {
        return em.createQuery("select a from Annotation a where a.type = :type", Annotation.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<Annotation> findByAnnotationName(String annotationName) {
        return em.createQuery("select a from Annotation a where a.annotationName = :annotationName", Annotation.class)
                .setParameter("annotationName", annotationName)
                .getResultList();
    }

    public List<Annotation> findByAnnotationBody(String annotationBody) {
        return em.createQuery("select a from Annotation a where a.annotationBody = :annotationBody", Annotation.class)
                .setParameter("annotationBody", annotationBody)
                .getResultList();
    }
    //삽화 or 표 라는 항목인데 월고집에서는 확인 불가 일단은 String
    public List<Annotation> findByImageOrTable(String imageOrTable) {
        return em.createQuery("select a from Annotation a where a.imageOrTable = :imageOrTable", Annotation.class)
                .setParameter("imageOrTable", imageOrTable)
                .getResultList();
    }
}
