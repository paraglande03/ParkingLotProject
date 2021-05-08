package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airportsecurity")
public class AirportSecurityController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/checkfull")
    public ResponseEntity<ResponseDto> checkFull(){
        ResponseDto responseDto = new ResponseDto("Parking Lot Status: ", vehicleService.checkFull());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
