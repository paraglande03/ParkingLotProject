package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Slot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.ParkingService.repository.VehicleRepository;

@Service
public class VehicleService  implements IVehicleService{

   @Autowired
   private VehicleRepository vehicleRepository;

   @Autowired
   private SlotRepository slotRepository;



   @Override
   public Vehicle addVehicle(VehicleDTO vehicleDTO ){




      Vehicle vehicle = new Vehicle(vehicleDTO);

      Slot slot=slotRepository.findById(vehicleDTO.getSlotId()).orElseThrow();
      vehicle.setSlot(slot);
      return vehicleRepository.save(vehicle);
   }

}



