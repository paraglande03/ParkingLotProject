package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends JpaRepository<Vehicle, String> {


    @Query(value = " select * from vehicle where vehicle_number = :number ",nativeQuery = true)
    Optional<Vehicle> findByNumber(String number);

    @Query(value = " select * from vehicle where color = :color ",nativeQuery = true)
    List<Vehicle> findByColor(String color);

    @Query(value = " select * from vehicle where color = :color and model = :make",nativeQuery = true)
    List<Vehicle> findByParam(String color,String make);

    @Query(value = " select * from vehicle where model = :model ",nativeQuery = true)
    List<Vehicle> findByModel(String model);

//
//    @Query(value = " select * from vehicle  v where v.in_time >= compareTime",nativeQuery = true)
//    List<Vehicle> getCarsByTime( int compareTime);



}
