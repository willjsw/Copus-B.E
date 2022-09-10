package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.enums.CategoryBodyType;
import com.copus.v1.domain.info.meta.CategoryBody;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryBodyRepository {
    @PersistenceContext
    private EntityManager em;

    public CategoryBody findOne (Long id){
        return em.find(CategoryBody.class, id);
    }

    public List<CategoryBody> findAll(Long id){
        return em.createQuery("select c from CategoryBody c", CategoryBody.class)
                .getResultList();
    }

    public List<CategoryBody> findByCategoryBodyType(CategoryBodyType type) {
        return em.createQuery("select c from CategoryBody c where c.type = :type", CategoryBody.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<CategoryBody> findByName(String name) {
        return em.createQuery("select c from CategoryBody c where c.name = :name", CategoryBody.class)
                .setParameter("name", name)
                .getResultList();
    }
}


