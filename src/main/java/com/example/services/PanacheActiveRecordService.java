package com.example.services;

import com.example.entities.EntityPanacheActiveRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PanacheActiveRecordService {

    @Transactional
    public Response create(String name) {
        EntityPanacheActiveRecord entityPanacheActiveRecord = new EntityPanacheActiveRecord();
        entityPanacheActiveRecord.name = name;
        entityPanacheActiveRecord.persist();
        return Response.ok(entityPanacheActiveRecord).build();
    }

    public Response getNames() {
        return Response.ok(EntityPanacheActiveRecord.findAllNames())
                .build();
    }

    public Response findByName(String name) {
        return Response.ok(EntityPanacheActiveRecord.findByName(name))
                .build();
    }
}
