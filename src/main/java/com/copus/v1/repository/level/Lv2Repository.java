package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv2Repository {
    @PersistenceContext
    private EntityManager em;
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