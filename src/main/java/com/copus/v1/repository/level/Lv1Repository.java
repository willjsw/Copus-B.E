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
        return em.createQuery("select l from Lv1 l join l.metaInfo ti " +
                        "where ti.id = any(select t.titleInfo.id from Title t " +
                        "where t.type = '한글서명' and substring(t.titleText,1,1) between :consonant1 AND :consonant2)", Lv1.class)
                .setParameter("consonant1", consonant1)
                .setParameter("consonant2", consonant2)
                .getResultList();
    }
    public List<Lv1> findLv1ByAuthorName(String authorname) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ai " +
                        "where ai.id = any(select a.authorInfo.id from Author a where a.nameKor = :authorname or a.nameChn = :authorname)", Lv1.class)
                .setParameter("authorname", authorname)
                .getResultList();
    }

    public List<Lv1> findLv1ByLv1Title(String title) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ti " +
                        "where ti.id = any(select t.titleInfo.id from Title t where t.titleText =: title)", Lv1.class)
                .setParameter("title", title)
                .getResultList();
    }

}