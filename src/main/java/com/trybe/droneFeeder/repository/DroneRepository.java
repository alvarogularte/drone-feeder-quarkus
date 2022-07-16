package com.trybe.droneFeeder.repository;

import com.trybe.droneFeeder.model.Drone;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<Drone, Long> {

}
