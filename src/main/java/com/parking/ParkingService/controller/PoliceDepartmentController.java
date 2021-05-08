package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/find/model/{make}")
    public ResponseEntity<ResponseDto> findByModel(@PathVariable("color") String make){
        ResponseDto responseDto = new ResponseDto(make+" cars parked are : ", vehicleService.findByModel(make));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
