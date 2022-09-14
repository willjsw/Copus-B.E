package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv3;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv3Repository {
    @PersistenceContext
    private EntityManager em;

    public List<Lv3> findLv3ByLv3Id(String id) {
        return em.createQuery("select l from Lv3 l where l.id =: id", Lv3.class)
                .setParameter("id", id)
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
