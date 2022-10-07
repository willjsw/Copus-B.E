package com.copus.v1.repository;

import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.meta.TitleRepository;
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

    public List<Title> findAllLv4Title(){
        return em.createQuery("select t from Title t" +
                " inner join TitleInfo ti on t.titleInfo = ti" +
                " inner join MetaInfo mi on ti.metaInfo = mi" +
                " inner join Lv4 l4 on l4.metaInfo = mi ",Title.class).getResultList();
    }

    public List<Title> findAllLv3Title(){
        return em.createQuery("select t from Title t" +
                " inner join TitleInfo ti on t.titleInfo = ti" +
                " inner join MetaInfo mi on ti.metaInfo = mi" +
                " inner join Lv3 l3 on l3.metaInfo = mi ",Title.class).getResultList();
    }

    public List<Title> findAllLv2Title(){
        return em.createQuery("select t from Title t" +
                " inner join TitleInfo ti on t.titleInfo = ti" +
                " inner join MetaInfo mi on ti.metaInfo = mi" +
                " inner join Lv2 l2 on l2.metaInfo = mi ",Title.class).getResultList();
    }



    @Test
    void Title(){
        List<Title> l4Title = findAllLv4Title();
        List<Title> l3Title = findAllLv3Title();
        List<Title> l2Title = findAllLv2Title();

        for(Title lt : l2Title){
            System.out.println(lt.getTitleText()+"\n");
        }

    }

}
