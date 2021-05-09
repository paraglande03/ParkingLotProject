package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/police")
public class PoliceDepartmentController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/find/color/{color}")
    public ResponseEntity<ResponseDto> findByColor(@PathVariable("color") String color){
        ResponseDto responseDto = new ResponseDto(color+" cars parked are : ", vehicleService.findByColor(color));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<ResponseDto> findByParam(@RequestParam ("color") String color,@RequestParam ("make") String make){
        ResponseDto responseDto = new ResponseDto(color +" "+make +" cars parked are : ", vehicleService.findByParam(color,make));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/find/model/{model}")
    public ResponseEntity<ResponseDto> findByModel(@PathVariable("model") String model){
        ResponseDto responseDto = new ResponseDto(model+" cars parked are : ", vehicleService.findByModel(model));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/time/{minutes}")
    public ResponseEntity<ResponseDto> findCarParkedInTime(@PathVariable("minutes") int minutes){

        ResponseDto responseDto = new ResponseDto("Cars parked in "+ minutes+" minutes are :",vehicleService.getCarsByTime(minutes));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


}
