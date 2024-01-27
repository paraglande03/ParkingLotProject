package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer>{
    @Query(value = " SELECT * FROM parking_lot WHERE is_empty = 1 LIMIT 1; ",nativeQuery = true)
    ParkingLot findEmptyParkingLot();
}
