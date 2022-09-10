package com.copus.v1.repository.level;

import com.copus.v1.domain.enums.Lv5Type;
import com.copus.v1.domain.info.AnnotationInfo;
import com.copus.v1.domain.info.ConnectionInfo;
import com.copus.v1.domain.info.body.BodyInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.domain.level.Lv5;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class Lv5Repository {
    @PersistenceContext
    private EntityManager em;

    public Lv5 findOne(Long id) {
        return em.find(Lv5.class, id);
    }

    public List<Lv5> findAll(Long id) {
        return em.createQuery("select l from Lv5 l", Lv5.class)
                .getResultList();
    }

    public List<Lv5> findByLv4(Lv4 lv4) {
        return em.createQuery("select l from Lv5 l where l.lv4 = :lv4", Lv5.class)
                .setParameter("lv4", lv4)
                .getResultList();
    }

    public List<Lv5> findByType(Lv5Type type) {
        return em.createQuery("select l from Lv5 l where l.type = :type", Lv5.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<Lv5> findByDCI(String DCI) {
        return em.createQuery("select l from Lv3 l where l.DCI = :DCI", Lv5.class)
                .setParameter("DCI", DCI)
                .getResultList();
    }

    public List<Lv5> findByCreateDate(LocalDate createDate) {
        return em.createQuery("select l from Lv3 l where l.createDate = :createDate", Lv5.class)
                .setParameter("createDate", createDate)
                .getResultList();
    }

    public List<Lv5> findByMetaInfo(MetaInfo metaInfo) {
        return em.createQuery("select l from Lv3 l where l.metaInfo = :metaInfo", Lv5.class)
                .setParameter("metaInfo", metaInfo)
                .getResultList();
    }

    public List<Lv5> findByBodyInfo(BodyInfo bodyInfo) {
        return em.createQuery("select l from Lv5 l where l.bodyInfo = :bodyInfo", Lv5.class)
                .setParameter("bodyInfo", bodyInfo)
                .getResultList();
    }

    public List<Lv5> findByAnnotationInfo(AnnotationInfo annotationInfo) {
        return em.createQuery("select l from Lv5 l where l.annotationInfo = :annotationInfo", Lv5.class)
                .setParameter("annotationInfo", annotationInfo)
                .getResultList();
    }

    public List<Lv5> findByConnectionInfo(ConnectionInfo connectionInfo) {
        return em.createQuery("select l from Lv5 l where l.connectionInfo = :connectionInfo", Lv5.class)
                .setParameter("connectionInfo", connectionInfo)
                .getResultList();
    }
}


