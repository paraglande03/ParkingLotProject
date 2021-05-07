package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){

        ResponseDto responseDto=new ResponseDto("Added parking lot",parkingLotService.addParkingLot(parkingLotDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);



    }

}
