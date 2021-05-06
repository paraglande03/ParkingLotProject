package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
