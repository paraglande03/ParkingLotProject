package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;

public interface IVehicleService {

    public Vehicle addVehicle(VehicleDTO vehicleDTO);

    public Vehicle unParkVehicle(String vehicleNumber);

    public ResponseDto checkFull();

    public ResponseDto findVehicle(String vehicleId);
}
