package com.copus.v1.repository;

import com.copus.v1.domain.level.Lv1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Repository

public class TitleRepositoryTest {

    @PersistenceContext
    private EntityManager em;


    public List<Lv1> findLv1ByItemName(String consonant1,String consonant2) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ti " +
                        "where ti.id = any(select t.titleInfo.id from Title t " +
                "where t.type = '한글서명' and substring(t.titleText,1,1) between :consonant1 AND :consonant2)", Lv1.class)
                .setParameter("consonant1", consonant1)
                .setParameter("consonant2", consonant2)
                .getResultList();
    }


    @Test
    void Title(){
        List<Lv1> lv1 = findLv1ByItemName("가","자");
        System.out.println("결과:"+lv1.get(0).getId());

    }

}
