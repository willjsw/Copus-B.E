package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv1;
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
        return em.createQuery("select l2 from Lv2 l2 where l2.id =: id", Lv2.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Lv2> findLv2ByLv1Id(String level_1_Id) {
        return em.createQuery("select l2 from Lv2 l2 join Lv1 as l1 on l2.lv1 = l1 " +
                        "where l1.id =:level_1_Id", Lv2.class)
                .setParameter("level_1_Id", level_1_Id)
                .getResultList();
    }

    public List<Lv2> findLv2ByLv2Title(String level_2_Title) {
        return em.createQuery("select l2 from Lv2 l2 join l2.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_2_Title,'%')", Lv2.class)
                .setParameter("level_2_Title", level_2_Title)
                .getResultList();
    }

}