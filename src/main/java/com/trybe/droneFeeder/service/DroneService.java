package com.trybe.droneFeeder.service;

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
  public void create(Drone drone) {
    repository.persist(drone);
  }
  
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
