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

    public List<Lv1> findAll() {
        return em.createQuery("select l1 from Lv1 l1", Lv1.class).getResultList();
    }
    public Lv1 findOne(String level_1_Id) {
        return em.find(Lv1.class, level_1_Id);
    }

    public List<Lv1> findAllByLv1IdKeyword(String keyword) {
        return em.createQuery("""
                        select l from Lv1 l
                        where l.id = :keyword
                        """, Lv1.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    public List<Lv1> findAllByLv2IdKeyword(String lv2IdKeyword) {
        return em.createQuery("""
                        select l1 from Lv1 l1
                        inner join Lv2 l2 on l2.lv1 =l1
                        where l2.id = :keyword
                        """, Lv1.class)
                .setParameter("keyword", lv2IdKeyword)
                .getResultList();
    }

    public List<Lv1> findAllByLv3IdKeyword(String lv3IdKeyword) {
        return em.createQuery("""
                        select l1 from Lv1 l1
                        inner join Lv2 l2 on l2.lv1 = l1
                        inner join Lv3 l3 on l3.lv2 = l2
                        where l3.id = :keyword
                        """, Lv1.class)
                .setParameter("keyword", lv3IdKeyword)
                .getResultList();
    }

    public List<Lv1> findAllByLv4IdKeyword(String lv4IdKeyword) {
        return em.createQuery("""
                        select l1 from Lv1 l1
                        inner join Lv2 l2 on l2.lv1 = l1
                        inner join Lv3 l3 on l3.lv2 = l2
                        inner join Lv4 l4 on l4.lv3 = l3
                        where l4.id = :keyword
                        """, Lv1.class)
                .setParameter("keyword", lv4IdKeyword)
                .getResultList();
    }

    public List<Lv1> findAllByContentKeyword(String contentKeyword) {
        return em.createQuery("""
                        select l1 from Lv1 l1
                        inner join Lv2 l2
                        inner join Lv3 l3
                        inner join Lv4 l4
                        inner join Content c  
                        where c.contentText like concat('%',:contentKeyword,'%')
                        """, Lv1.class)
                .setParameter("contentKeyword", contentKeyword)
                .getResultList();

    }

    public List<Lv1> findLv1ByConsonant(String consonantStart, String consonantEnd) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ti " +
                        "where ti.id = any(select t.titleInfo.id from Title t " +
                        "where t.type = '한글서명' and substring(t.titleText,1,1) between :consonant1 AND :consonant2)", Lv1.class)
                .setParameter("consonant1", consonantStart)
                .setParameter("consonant2", consonantEnd)
                .getResultList();
    }

    public List<Lv1> findLv1ByAuthorName(String authorname) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ai " +
                        "where ai.id = any(select a.authorInfo.id from Author a where a.nameKor = :authorname or a.nameChn = :authorname)", Lv1.class)
                .setParameter("authorname", authorname)
                .getResultList();
    }

    public List<Lv1> findLv1ByAuthorId(Long authorId) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ai " +
                        "where ai.id = any(select a.authorInfo.id from Author a where a.id = :authorId)", Lv1.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }

    public List<Lv1> findLv1ByLv1Title(String title) {
        return em.createQuery("select l from Lv1 l join l.metaInfo ti " +
                        "where ti.id = any(select t.titleInfo.id from Title t where t.titleText =: title)", Lv1.class)
                .setParameter("title", title)
                .getResultList();
    }


}