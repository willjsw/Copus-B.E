package com.copus.v1.repository.info.meta;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.info.meta.AuthorInfo;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public AuthorInfo findOne (Long id){
        return em.find(AuthorInfo.class, id);
    }

    public List<AuthorInfo> findAll(Long id){
        return em.createQuery("select a from AuthorInfo a", AuthorInfo.class)
                .getResultList();
    }

    public List<AuthorInfo> findByAuthorType(String type) {
        return em.createQuery("select a from AuthorInfo a where a.type = :type", AuthorInfo.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<AuthorInfo> findByAuthor(Author author) {
        return em.createQuery("select a from AuthorInfo a where a.author = :author", AuthorInfo.class)
                .setParameter("author", author)
                .getResultList();
    }
}


