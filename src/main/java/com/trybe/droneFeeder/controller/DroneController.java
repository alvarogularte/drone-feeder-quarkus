package com.trybe.droneFeeder.controller;

import com.trybe.droneFeeder.dto.UpdateDroneDto;
import com.trybe.droneFeeder.model.Drone;
import com.trybe.droneFeeder.service.DroneService;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneController {

  @Inject
  private DroneService service;

  @GET
  public List<Drone> findAll() {
    return service.getAll();
  }

  @GET
  @Path("/{id}")
  public Drone getDroneById(@PathParam("id") Long id) {
    return service.getDroneById(id);
  }

  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void create(Drone drone) {
    Drone.persist(drone);
  }

  @PATCH
  @Path("/{id}")
  public void update(@PathParam("id") Long id, UpdateDroneDto droneDto) {
    service.update(droneDto, id);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }
  
}
