package com.trybe.droneFeeder.service;

import com.trybe.droneFeeder.dto.DroneDto;
import com.trybe.droneFeeder.dto.UpdateDroneDto;
import com.trybe.droneFeeder.model.Drone;
import com.trybe.droneFeeder.repository.DroneRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class DroneService {

  @Inject
  private DroneRepository repository;
  
  public List<Drone> getAll() {
    return repository.listAll();
  }
  
  public Drone getDroneById(Long id) {
    return repository.findById(id);
  }
  
  @Transactional
  public void create(DroneDto droneDto) {
    var drone = new Drone();
    drone.setId(droneDto.getId());
    drone.setName(droneDto.getName());

    repository.persist(drone);
  }

  @Transactional
  public void update(UpdateDroneDto droneDto, Long id) {
    var drone = repository.findById(id);
    drone.setName(droneDto.getName());
    
    repository.persist(drone);
  }
  
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
