package com.trybe.droneFeeder.controller;

import com.trybe.droneFeeder.model.Drone;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drones")
public class DroneController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Drone> findAll() {
    return Drone.listAll();
  }

  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void create(Drone drone) {
    Drone.persist(drone);
  }
}
