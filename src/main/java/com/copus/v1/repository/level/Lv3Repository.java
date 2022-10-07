package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv3Repository {
    @PersistenceContext
    private EntityManager em;
    public Lv3 findOne(String keyword) {
        return em.find(Lv3.class, keyword);
    }

    public List<Lv3> findAllByLv2Id(String lv2Id) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join Lv2 l2 on l3.lv2 = l2
                        where l2.id = :lv2Id
                        """, Lv3.class)
                .setParameter("lv2Id", lv2Id)
                .getResultList();
    }

    public List<Lv3> findAllByLv4IdKeyword(String lv4IdKeyword) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join Lv4 l4 on l4.lv3 = l3
                        where l4.id = :keyword
                        """, Lv3.class)
                .setParameter("keyword", lv4IdKeyword)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv3Title(String level_3_Title) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join TitleInfo ti on ti.metaInfo = l3.metaInfo
                        inner join Title t on t.titleInfo.id = ti.id
                        where t.titleText like concat('%',:level_3_Title,'%')
                        """, Lv3.class)
                .setParameter("level_3_Title", level_3_Title)
                .getResultList();
    }

    public List<Lv3> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("""
                        select l3 from Lv3 l3
                        inner join Lv4 l4 on  l4.lv3 =l3
                        inner join Content c  
                        where c.contentText like concat('%',:contentKeyword,'%')
                        """, Lv3.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }

    public List<Lv3> findAllByLv3IdKeyword(String keyword) {
        return em.createQuery("select l from Lv3 l where l.id =: keyword", Lv3.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv2Title( String level_2_Title) {
        return em.createQuery("select l3 from Lv3 l3 join Lv2 as l2 on l3.lv2 = l2 " +
                        "join TitleInfo as ti on l2.metaInfo = ti.metaInfo " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_2_Title,'%')", Lv3.class)
                .setParameter("level_2_Title", level_2_Title)
                .getResultList();
    }
}
