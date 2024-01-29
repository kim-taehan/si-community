package org.devleopx.sicommunity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class DefaultTestSupport {

    @PersistenceContext
    protected EntityManager entityManager;

    protected <T extends Object> void persist(T... ts) {
        for (T t : ts) {
            entityManager.persist(t);
        }
        flush();
    }

    protected void flush(){
        entityManager.flush();
        entityManager.clear();
    }

}
