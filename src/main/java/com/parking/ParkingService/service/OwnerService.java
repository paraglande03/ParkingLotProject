package com.parking.ParkingService.service;

import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        List<Vehicle>vehicles=vehicleRepository.findAll();
        return vehicles;
    }

}
