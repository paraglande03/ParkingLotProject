package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;

public interface IVehicleService {

     Vehicle addVehicle(VehicleDTO vehicleDTO);

     Vehicle unParkVehicle(String vehicleNumber);

     ResponseDto checkFull();

     ResponseDto findVehicle(String vehicleId);

    ResponseDto parkingCharge(String vehicleId);
}
