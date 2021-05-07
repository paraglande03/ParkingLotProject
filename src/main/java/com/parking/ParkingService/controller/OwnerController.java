package com.parking.ParkingService.controller;


import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.service.OwnerService;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicle/all")
    public ResponseEntity<ResponseDto> allVehicles(){
        ResponseDto responseDto=new ResponseDto("All vehicles:", ownerService.getAllVehicles());
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    @PostMapping("/park")
    public ResponseEntity<ResponseDto> parkVehicle(@RequestBody VehicleDTO vehicleDTO){

        ResponseDto responseDto=new ResponseDto("Vehicle Parked in Lot "+vehicleDTO.getLotId()+" slot "+ vehicleDTO.getSlotId() ,vehicleService.addVehicle(vehicleDTO));
        return  new   ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }



}
