package com.copus.v1.repository.level;

import com.copus.v1.domain.level.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    @PersistenceContext
    private EntityManager em;

  //실제 사용한 메소드
    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    }


//    public List<Item> findByChosung(String korString) {
//        return em.createQuery("select i from Item i where i.name = :korString", Item.class)
//                .setParameter("korString", korString)
//                .getResultList();
//    }



    /* 그냥 만들어만 둠

    public Item findById(String id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll(Long id) {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }



    public List<Item> findByOrg(String org) {
        return em.createQuery("select i from Item i where i.org = :org", Item.class)
                .setParameter("org", org)
                .getResultList();
    }

     */
}



