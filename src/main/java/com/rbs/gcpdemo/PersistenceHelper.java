package com.rbs.gcpdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ken Finnigan
 */
@ApplicationScoped
public class PersistenceHelper {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
}
