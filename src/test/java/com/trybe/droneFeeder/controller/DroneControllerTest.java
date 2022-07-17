package com.trybe.droneFeeder.controller;

import org.junit.jupiter.api.Test;

import com.trybe.droneFeeder.model.Drone;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class DroneControllerTest {

  @Test
  public void testCreateSuccess() {
    Drone drone = new Drone();
    drone.setName("Drone Teste 1");
    given()
      .contentType("application/json")
      .body(drone)
      .when().post("/drone")
      .then()
      .statusCode(200);
  }
  
  @Test
  public void testCreateWithoutName() {
    Drone drone = new Drone();
    given()
      .contentType("application/json")
      .body(drone)
      .when().post("/drone")
      .then()
      .statusCode(400);
  }
  
  @Test
  public void testCreateEmptyName() {
    Drone drone = new Drone();
    drone.setName("");
    given()
      .contentType("application/json")
      .body(drone)
      .when().post("/drone")
      .then()
      .statusCode(500);
  }
}
