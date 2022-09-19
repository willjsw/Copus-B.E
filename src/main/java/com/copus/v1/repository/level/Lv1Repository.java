package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Lv1;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Lv1Repository {
    @PersistenceContext
    private EntityManager em;

    public List<Lv1> findLv1ByConsonant(String consonant1, String consonant2) {
        return em.createQuery("select l1 from Lv1 l1 join l1.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.type = '한글서명' and substring(t.titleText,1,1) between :consonant1 AND :consonant2", Lv1.class)
                .setParameter("consonant1", consonant1)
                .setParameter("consonant2", consonant2)
                .getResultList();
    }
    public List<Lv1> findLv1ByAuthorName(String authorname) {
        return em.createQuery("select l1 from Lv1 l1 join l1.metaInfo ai " +
                        "join Author as a on a.authorInfo = ai " +
                        "where a.nameKor = :authorname or a.nameChn = :authorname", Lv1.class)
                .setParameter("authorname", authorname)
                .getResultList();
    }

    public List<Lv1> findLv1ByLv1Title(String level_1_Title) {
        return em.createQuery("select l1 from Lv1 l1 join l1.metaInfo ti " +
                        "join Title as t on ti.id = t.titleInfo.id " +
                        "where t.titleText like concat('%',:level_1_Title,'%')", Lv1.class)
                .setParameter("level_1_Title", level_1_Title)
                .getResultList();
    }

}