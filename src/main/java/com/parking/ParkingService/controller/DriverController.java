package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @PostMapping("/park")
    public ResponseEntity<ResponseDto> parkVehicle(@RequestBody VehicleDTO vehicleDTO){

        Vehicle vehicle = vehicleService.addVehicle(vehicleDTO);
        ResponseDto responseDto;
        if(Objects.isNull(vehicle)){
             responseDto=new ResponseDto("Sorry Currently there are not parking spaces left " ,"Lava Kuthapn");
        }
        else {
             responseDto=new ResponseDto("Vehicle Parked in Lot " ,vehicle);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/find/{vehicleId}")
    public ResponseEntity<ResponseDto> findVehicle(@PathVariable("vehicleId") String vehicleId){
        ResponseDto responseDto =new ResponseDto(" Your vehicle is parked Here: ",vehicleService.findVehicle(vehicleId));
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
