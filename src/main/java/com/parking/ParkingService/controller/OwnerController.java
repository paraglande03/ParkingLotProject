package com.parking.ParkingService.controller;


import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.service.OwnerService;
import com.parking.ParkingService.service.ParkingLotService;
import com.parking.ParkingService.service.SlotService;
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
    private ParkingLotService parkingLotService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private SlotService slotService;

    @PostMapping("/add/parkinglot")
    public ResponseEntity<ResponseDto> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){

        ResponseDto responseDto=new ResponseDto("Added parking lot",parkingLotService.addParkingLot(parkingLotDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @PostMapping("/add/slot")
    public ResponseEntity<ResponseDto> addSlot(@RequestBody SlotDTO slotDTO){

        ResponseDto responseDto=new ResponseDto("added new slot",slotService.addSlot(slotDTO));
        return  new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }

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

    @DeleteMapping("/unpark/{vehicleNumber}")
    public ResponseEntity<ResponseDto> unparkCar(@PathVariable("vehicleNumber") String vehicleNumber){

        ResponseDto responseDto = new ResponseDto("Car Is Unparked!",vehicleService.unParkVehicle(vehicleNumber));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/checkfull")
    public  ResponseEntity<ResponseDto> checkFull(){
        ResponseDto responseDto = new ResponseDto("Parking Lot Status: ", vehicleService.checkFull());
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @GetMapping("/charge/{vehicleId}")
    public ResponseEntity<ResponseDto> parkingCharge(@PathVariable("vehicleId") String vehicleId){
        ResponseDto responseDto = new ResponseDto("Total parking time is : ", vehicleService.parkingCharge(vehicleId));
        return new ResponseEntity<>(responseDto,HttpStatus.OK);


    }


}
