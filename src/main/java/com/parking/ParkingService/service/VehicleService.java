package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.ParkingService.repository.VehicleRepository;

@Service
public class VehicleService  implements IVehicleService{

   @Autowired
   private VehicleRepository vehicleRepository;


   @Override
   public Vehicle addVehicle(VehicleDTO vehicleDTO) {

      Vehicle vehicle = new Vehicle(vehicleDTO);

      return vehicleRepository.save(vehicle);
   }
}
