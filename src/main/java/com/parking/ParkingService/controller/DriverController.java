package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private VehicleService vehicleService;

    @DeleteMapping("/unpark/{vehicleNumber}")
    public ResponseEntity<ResponseDto> unparkCar(@PathVariable("vehicleNumber") String vehicleNumber){

        ResponseDto responseDto = new ResponseDto("Car Is Unparked!",vehicleService.unParkVehicle(vehicleNumber));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
