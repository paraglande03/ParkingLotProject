package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
