package com.example.services;

import com.example.entities.EntityJpa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class JpaService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Response create(String name) {
        EntityJpa entityJpa = new EntityJpa();
        entityJpa.setName(name);
        entityManager.persist(entityJpa);
        return Response.ok(entityJpa).build();
    }

    public Response getNames() {
        return Response.ok(entityManager.createNamedQuery(
                        "Entity.findAll", EntityJpa.class)
                .getResultList())
                .build();
    }

    public Response findByName(String name) {
        return Response.ok(entityManager.createNamedQuery(
                "Entity.findByName", EntityJpa.class)
                .setParameter("name", name)
                .getSingleResult())
                .build();
    }
}
