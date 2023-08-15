package com.example;

import com.example.services.PanacheDataService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1")
public class PanacheDataResource {

    @Inject
    PanacheDataService dataRepositoryService;

    @POST
    @Path("/panache-data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createName(@QueryParam("name") String name) {
        return dataRepositoryService.create(name);
    }

    @GET
    @Path("/panache-data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNames() {
        return dataRepositoryService.getNames();
    }

    @GET
    @Path("/panache-data/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@QueryParam("name") String name) {
        return dataRepositoryService.findByName(name);
    }
}
