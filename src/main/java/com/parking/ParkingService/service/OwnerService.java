package com.parking.ParkingService.service;

import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getAllVehicles(){
        List<Vehicle>vehicles=vehicleRepository.findAll();
        vehicles.forEach(v-> {
                String inTimeString = v.getBilling().getInTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                v.getBilling().setInTimeString(inTimeString);
                vehicleService.setBillingAmount(v.getBilling().getInTime(), v.getType(),v.getBilling());
                }
                );
        return vehicles;
    }


    public Optional<ParkingLot> getAllVehiclesbyLotId(int lotId) {
        Optional<ParkingLot> vehicles = parkingLotRepository.findById(lotId);
        return vehicles;
    }
}
