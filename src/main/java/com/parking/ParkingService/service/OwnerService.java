package com.parking.ParkingService.service;

import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<Vehicle> getAllVehicles(){
        List<Vehicle>vehicles=vehicleRepository.findAll();
        return vehicles;
    }


    public Optional<ParkingLot> getAllVehiclesbyLotId(int lotId) {
        Optional<ParkingLot> vehicles = parkingLotRepository.findById(lotId);
        return vehicles;
    }
}
