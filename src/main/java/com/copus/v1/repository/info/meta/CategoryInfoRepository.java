package com.copus.v1.repository.info.meta;


import com.copus.v1.domain.info.meta.Category;
import com.copus.v1.domain.info.meta.CategoryInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryInfoRepository {
    @PersistenceContext
    private EntityManager em;

    public CategoryInfo findOne (Long id){
        return em.find(CategoryInfo.class, id);
    }

    public List<CategoryInfo> findAll(Long id){
        return em.createQuery("select c from CategoryInfo c", CategoryInfo.class)
                .getResultList();
    }

    public List<CategoryInfo> findByContent(List<Category> categories){
        return em.createQuery("select c from CategoryInfo c where c.categories = :categories", CategoryInfo.class)
                .setParameter("categories",categories)
                .getResultList();
    }
}


