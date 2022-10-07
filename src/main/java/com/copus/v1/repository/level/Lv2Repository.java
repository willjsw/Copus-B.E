package com.copus.v1.repository.level;

import com.copus.v1.domain.info.meta.StoreHouse;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv2Repository {
    @PersistenceContext
    private EntityManager em;
    public Lv2 findOne(String level_2_Id) {
        return em.find(Lv2.class, level_2_Id);
    }

    public List<Lv2> findAllByLv1Id(String lv1Id) {
        return em.createQuery("""
                        select l2 from Lv2 l2
                        inner join Lv1 l1 on l2.lv1 = l1
                        where l1.id = :lv1Id
                        """, Lv2.class)
                .setParameter("lv1Id", lv1Id)
                .getResultList();
    }

    public List<Lv2> findAllByLv2IdKeyword(String keyword) {
        return em.createQuery("""
                        select l from Lv2 l
                        where l.id = :keyword
                        """, Lv2.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }



    public List<Lv2> findAllByLv3IdKeyword(String lv3IdKeyword) {
        return em.createQuery("""
                        select l2 from Lv2 l2
                        inner join Lv3 l3 on l3.lv2 = l2
                        where l3.id = :keyword
                        """, Lv2.class)
                .setParameter("keyword", lv3IdKeyword)
                .getResultList();
    }

    public List<Lv2> findAllByLv4IdKeyword(String lv4IdKeyword) {
        return em.createQuery("""
                        select l2 from Lv2 l2
                        inner join Lv3 l3 on l3.lv2 = l2
                        inner join Lv4 l4 on l4.lv3 = l3
                        where l4.id = :keyword
                        """, Lv2.class)
                .setParameter("keyword", lv4IdKeyword)
                .getResultList();
    }
    public List<Lv2> findLv2ByLv2Title(String level_2_Title) {
        return em.createQuery("""
                        select l2 from Lv2 l2
                        inner join TitleInfo ti on ti.metaInfo = l2.metaInfo
                        inner join Title t on t.titleInfo = ti
                        where t.titleText like concat('%',:level_2_Title,'%')
                        """, Lv2.class)
                .setParameter("level_2_Title", level_2_Title)
                .getResultList();
    }


    public List<Lv2> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("""
                        select l2 from Lv2 l2
                        inner join Lv3 l3
                        inner join Lv4 l4
                        inner join Content c  
                        where c.contentText like concat('%',:contentKeyword,'%')
                        """, Lv2.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }
    public List<Lv2> findLv2ByLv2Id(String id){
        return em.createQuery("select l from Lv2 l where l.id =: id", Lv2.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Lv2> findLv2ByLv1Title(String level_1_Title) {
        return em.createQuery("select l2 from Lv2 l2 join Lv1 as l1 on l2.lv1 = l1 " +
                        "join TitleInfo as ti on l1.metaInfo = ti.metaInfo " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText =:level_1_Title", Lv2.class)
                .setParameter("level_1_Title", level_1_Title)
                .getResultList();
    }





}