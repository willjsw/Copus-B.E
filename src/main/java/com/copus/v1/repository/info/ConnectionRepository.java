package com.copus.v1.repository.info;


import com.copus.v1.domain.enums.ConnectionType;
import com.copus.v1.domain.info.Connection;
import com.copus.v1.domain.info.ConnectionInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConnectionRepository {
    @PersistenceContext
    private EntityManager em;

    public Connection findOne(Long id) {
        return em.find(Connection.class, id);
    }

    public List<Connection> findAll(Long id) {
        return em.createQuery("select c from Connection c", Connection.class)
                .getResultList();
    }

    public List<Connection> findByConnectionInfo(ConnectionInfo connectionInfo) {
        return em.createQuery("select c from Connection c where c.connectionInfo = :connectionInfo", Connection.class)
                .setParameter("connectionInfo", connectionInfo)
                .getResultList();
    }

    public List<Connection> findByType(ConnectionType type) {
        return em.createQuery("select c from Connection c where c.type = :type", Connection.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<Connection> findByConnectionStart(String connectionStart) {
        return em.createQuery("select c from Connection c where c.connectionStart = :connectionStart", Connection.class)
                .setParameter("connectionStart", connectionStart)
                .getResultList();
    }

    public List<Connection> findByConnectionEnd(String connectionEnd) {
        return em.createQuery("select c from Connection c where c.connectionEnd = :connectionEnd", Connection.class)
                .setParameter("connectionEnd", connectionEnd)
                .getResultList();
    }
}


