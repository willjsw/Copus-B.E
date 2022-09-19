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

    public List<Lv4> findLv4ByLv3Id(String level_3_Id) {
        return em.createQuery("select l4 from Lv4 l4 join l4.lv3 l3 "+
                        "where l3.id = :level_3_Id", Lv4.class)
                .setParameter("level_3_Id", level_3_Id)
                .getResultList();
    }
    public List<Lv4> findLv4ByLv4Title(String level_4_Title) {
        return em.createQuery("select l4 from Lv4 l4 join l4.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_4_Title,'%')", Lv4.class)
                .setParameter("level_4_Title", level_4_Title)
                .getResultList();
    }

    public List<Lv4> findLv4ByContent(String contentText) {
        return em.createQuery("select l4 from Lv4 l4 join Content c on l4.bodyInfo = c.bodyInfo and " +
                        "c.contentText like concat('%',:contentText,'%') ", Lv4.class)
                .setParameter("contentText", contentText)
                .getResultList();

    }
}