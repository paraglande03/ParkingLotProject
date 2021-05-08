package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public interface IVehicleService {

     Vehicle addVehicle(VehicleDTO vehicleDTO);

     Vehicle unParkVehicle(String vehicleNumber);

     ResponseDto checkFull();

     ResponseDto findVehicle(String vehicleId);

    ResponseDto parkingCharge(String vehicleId);

   List<Vehicle>  findByColor(String color);

    List<Vehicle>  findByParam(String color, String make);

    List<Vehicle>  findByModel(String model);

    List<Vehicle> getCarsByTime(LocalDateTime compareTime);
}
