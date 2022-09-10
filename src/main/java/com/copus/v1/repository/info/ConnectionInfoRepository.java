package com.copus.v1.repository.info;

import com.copus.v1.domain.enums.ConnectionType;
import com.copus.v1.domain.info.Connection;
import com.copus.v1.domain.info.ConnectionInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConnectionInfoRepository {
    @Repository
    public class TitleRepository {
        @PersistenceContext
        private EntityManager em;

        public ConnectionInfo findOne(Long id) {
            return em.find(ConnectionInfo.class, id);
        }

        public List<ConnectionInfo> findAll(Long id) {
            return em.createQuery("select c from ConnectionInfo c", ConnectionInfo.class)
                    .getResultList();
        }

        public List<ConnectionInfo> findByConnections(List<Connection> connections) {
            return em.createQuery("select c from ConnectionInfo c where c.connections = :connections", ConnectionInfo.class)
                    .setParameter("connections", connections)
                    .getResultList();
        }

    }
}


