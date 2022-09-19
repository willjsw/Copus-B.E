package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv1;
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
        return em.createQuery("select l3 from Lv3 l3 where l3.id =: id", Lv3.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv2Id(String level_2_Id) {
        return em.createQuery("select l3 from Lv3 l3 join Lv2 as l2 on l3.lv2 = l2 " +
                        "where l2.id =: level_2_Id", Lv3.class)
                .setParameter("level_2_Id", level_2_Id)
                .getResultList();
    }

    public List<Lv3> findLv3ByLv3Title(String level_3_Title) {
        return em.createQuery("select l3 from Lv3 l3 join l3.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_3_Title,'%')", Lv3.class)
                .setParameter("level_3_Title", level_3_Title)
                .getResultList();
    }

}
