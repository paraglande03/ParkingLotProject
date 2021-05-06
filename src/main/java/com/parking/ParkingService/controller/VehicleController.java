package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addVehicle(@RequestBody VehicleDTO vehicleDTO){

        ResponseDto responseDto=new ResponseDto("Parked Vehicle",vehicleService.addVehicle(vehicleDTO));
      return  new   ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
