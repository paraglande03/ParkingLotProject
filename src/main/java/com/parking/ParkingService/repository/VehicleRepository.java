package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {



    @Query(value = " select * from vehicle where color = :color ",nativeQuery = true)
    List<Vehicle> findByColor(String color);

    @Query(value = " select * from vehicle where color = :color and model = :make",nativeQuery = true)
    List<Vehicle> findByParam(String color,String make);

}
