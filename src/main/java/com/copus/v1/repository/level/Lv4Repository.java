package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv4;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv4Repository {
    @PersistenceContext
    private EntityManager em;

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

    public List<Lv4> findLv4ByContent(String contentText) {
        return em.createQuery("select l4 from Lv4 l4 join l4.lv3 l3 where l4.bodyInfo = " +
                        "any(select c.bodyInfo from Content c " +
                        "where c.contentText like concat('%',:contentText,'%')) ", Lv4.class)
                .setParameter("contentText", contentText)
                .getResultList();

    }
}