package com.example;

import com.example.services.JpaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
public class JpaResource {

    @Inject
    JpaService jpaService;

    @POST
    @Path("/jpa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createName(@QueryParam("name") String name) {
        System.out.println("Name: "+name);
        return jpaService.create(name);
    }

    @GET
    @Path("/jpa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNames() {
        return jpaService.getNames();
    }

    @GET
    @Path("/jpa/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@QueryParam("name") String name) {
        return jpaService.findByName(name);
    }
}
