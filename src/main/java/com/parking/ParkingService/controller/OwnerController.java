package com.parking.ParkingService.controller;


import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/vehicle/all")
    public ResponseEntity<ResponseDto> allVehicles(){
        ResponseDto responseDto=new ResponseDto("All vehicles:", ownerService.getAllVehicles());
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    


}
