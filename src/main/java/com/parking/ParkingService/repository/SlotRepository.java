package com.parking.ParkingService.repository;

import com.parking.ParkingService.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, String> {
}
