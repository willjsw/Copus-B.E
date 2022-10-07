package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv4Repository {
    @PersistenceContext
    private EntityManager em;
    public Lv4 findOne(String keyword) {
        return em.find(Lv4.class, keyword);
    }
    public List<Lv4> findAllByLv4IdKeyword(String keyword) {
        return em.createQuery("select l from Lv4 l where l.id =: keyword", Lv4.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    public List<Lv4> findAllByLv3Id(String lv3Id) {
        return em.createQuery("""
                        select l4 from Lv4 l4
                        inner join Lv3 l3 on l4.lv3 = l3
                        where l3.id = :lv3Id
                        """, Lv4.class)
                .setParameter("lv3Id", lv3Id)
                .getResultList();
    }


    public List<Lv4> findLv4ByLv3Title(String level_2_Title, String level_3_Title) {
        return em.createQuery("select l4 from Lv4 l4 join l4.lv3 l3 " +
                        "join l3.metaInfo ti on l3 = " +
                        "(select l3 from Lv3 l3 join l3.lv2 l2 " +
                        "join l2.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_2_Title,'%')) " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText = :level_3_Title", Lv4.class)
                .setParameter("level_2_Title", level_2_Title)
                .setParameter("level_3_Title", level_3_Title)
                .getResultList();
    }

    public List<Lv4> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("""
                        select l4 from Lv4 l4
                        inner join BodyInfo bi on l4.bodyInfo.id = bi.id
                        inner join Content c on c.bodyInfo.id = bi.id
                        where c.contentText like concat('%',:contentKeyword,'%')
                        """, Lv4.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }

    public List<Lv4> findAllByContent(String contentText) {
        return em.createQuery("select l4 from Lv4 l4 inner join Content c " +
                        "where c.contentText like concat('%',:contentText,'%') ", Lv4.class)
                .setParameter("contentText", contentText)
                .getResultList();

    }
}