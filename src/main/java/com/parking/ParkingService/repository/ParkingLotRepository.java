package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer>{
}
