package com.example.services;

import com.example.entities.EntityPanacheData;
import com.example.repository.PanacheDataRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PanacheDataService {
    @Inject
    PanacheDataRepository dataRepository;

    @Transactional
    public Response create(String name) {
        EntityPanacheData entityPanacheData = new EntityPanacheData();
        entityPanacheData.setName(name);
        dataRepository.persist(entityPanacheData);
        return Response.ok(entityPanacheData).build();
    }

    public Response getNames() {
        return Response.ok(dataRepository.listAll())
                .build();
    }

    public Response findByName(String name) {
        return Response.ok(dataRepository.find("name",name).firstResult())
                .build();
    }
}
