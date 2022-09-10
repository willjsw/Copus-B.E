package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.meta.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Author> findAuthorNameByConsonant(String consonant1,String consonant2) {
        return em.createQuery("select a from Author a join a.authorInfo ai " +
                        "where ai.type ='저자' and substring(a.nameKor,1,1) between :consonant1 AND :consonant2", Author.class)
                .setParameter("consonant1", consonant1)
                .setParameter("consonant2", consonant2)
                .getResultList();
    }

    public List<Author> findAuthorNameByLv1Id(String id) {
        return em.createQuery("select a from Author a join a.authorInfo ai " +
                        "where ai.metaInfo = " +
                        "(select l.metaInfo from Lv1 l where l.id = :id) ", Author.class)
                .setParameter("id", id)
                .getResultList();
    }

}


