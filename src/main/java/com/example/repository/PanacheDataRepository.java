package com.example.repository;

import com.example.entities.EntityPanacheData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheDataRepository implements PanacheRepository<EntityPanacheData> {
}
