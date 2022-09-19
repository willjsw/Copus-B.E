package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.Title;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class TitleRepository {
    @PersistenceContext
    private EntityManager em;

    //동일레벨

    public List<Title> findLv1TitleByLv1Id(String id) {
        return em.createQuery("select t from Title t join t.titleInfo ti " +
                        "where ti.metaInfo = (select l.metaInfo from Lv1 l where l.id = :id)", Title.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Title> findLv2TitleByLv2Id(String id) {
        return em.createQuery("select t from Title t join t.titleInfo ti " +
                        "where ti.metaInfo = (select l.metaInfo from Lv2 l where l.id = :id)", Title.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Title> findLv3TitleByLv3Id(String id) {
        return em.createQuery("select t from Title t join t.titleInfo ti " +
                        "where ti.metaInfo = (select l.metaInfo from Lv3 l where l.id = :id)", Title.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Title> findLv4TitleByLv4Id(String id) {
        return em.createQuery("select t from Title t join t.titleInfo ti " +
                        "where ti.metaInfo = (select l.metaInfo from Lv4 l where l.id = :id)", Title.class)
                .setParameter("id", id)
                .getResultList();
    }

    // 키워드 포함한 제목 찾기

    public List<Title> findLv1TitleByKeyword(String keyword) {
        return em.createQuery("select t from Title t join t.titleInfo ti join Lv1 l1 on l1.metaInfo = ti.metaInfo " +
                        "where t.titleText like concat('%',:keyword,'%')", Title.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    public List<Title> findLv2TitleByKeyword(String keyword) {
        return em.createQuery("select t from Title t join t.titleInfo ti join Lv2 l2 on l2.metaInfo = ti.metaInfo " +
                        "where t.titleText like concat('%',:keyword,'%')", Title.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }


    public List<Title> findLv3TitleByKeyword(String keyword) {
        return em.createQuery("select t from Title t join t.titleInfo ti join Lv3 l3 on l3.metaInfo = ti.metaInfo " +
                        "where t.titleText like concat('%',:keyword,'%')", Title.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }


    public List<Title> findLv4TitleByKeyword(String keyword) {
        return em.createQuery("select t from Title t join t.titleInfo ti join Lv4 l4 on l4.metaInfo = ti.metaInfo " +
                        "where t.titleText like concat('%',:keyword,'%')", Title.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

}
