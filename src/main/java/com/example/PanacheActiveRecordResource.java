package com.example;

import com.example.services.PanacheActiveRecordService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
public class PanacheActiveRecordResource {
    @Inject
    PanacheActiveRecordService panacheActiveRecordService;

    @POST
    @Path("/panache-active")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createName(@QueryParam("name") String name) {
        return panacheActiveRecordService.create(name);
    }

    @GET
    @Path("/panache-active")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNames() {
        return panacheActiveRecordService.getNames();
    }

    @GET
    @Path("/panache-active/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@QueryParam("name") String name) {
        return panacheActiveRecordService.findByName(name);
    }
}
