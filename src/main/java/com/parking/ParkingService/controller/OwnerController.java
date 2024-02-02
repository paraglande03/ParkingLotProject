package com.parking.ParkingService.controller;


import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.ParkingLot;
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
import java.util.Objects;

@RestController
@RequestMapping("/owner")
@CrossOrigin(value = "*")
public class OwnerController {

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private SlotService slotService;

    // CRUDs For Parking Spaces
    @PostMapping("/parkinglot")
    public ResponseEntity<ResponseDto> addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){
        ResponseDto responseDto=new ResponseDto("Added parking lot",parkingLotService.addParkingLot(parkingLotDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/parkinglot")
    public ResponseEntity<Object> deleteParkingLot( @RequestParam("id") int id){
        parkingLotService.deleteParkingLot(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/vehicle/all")
    public ResponseEntity<ResponseDto> allVehicles(){
        ResponseDto responseDto=new ResponseDto("All vehicles:", ownerService.getAllVehicles());
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    @PostMapping("/entry")
    public ResponseEntity<ResponseDto> parkVehicle(@RequestBody VehicleDTO vehicleDTO){

        Vehicle vehicle = vehicleService.addVehicle(vehicleDTO);
        ResponseDto responseDto;
        if(Objects.isNull(vehicle)){
            responseDto=new ResponseDto("Sorry Currently there are no parking spaces left " ,"Lava Kuthapn");
        }
        else {
            if(vehicle.isNewCustomer()){
                responseDto=new ResponseDto("Vehicle Parked in floor-"+vehicle.getParkingLot().getFloorNo()+" slot-"+vehicle.getParkingLot().getSlotNo() ,vehicle);

            }
            else {
                responseDto=new ResponseDto("Vehicle is already Parked in space!",vehicle);
            }
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/exit/{vehicleNumber}")
    public ResponseEntity<ResponseDto> unparkCar(@PathVariable("vehicleNumber") String vehicleNumber){
        ResponseDto responseDto;
        Vehicle vehicle = vehicleService.unParkVehicle(vehicleNumber);
        if(Objects.isNull(vehicle)){
            responseDto= new ResponseDto("Please enter correct Vehicle Number","","");
        }
        else {
            responseDto =  new ResponseDto("Thanks For Visiting",vehicle,vehicle.getParkingLot());
        }
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

    @GetMapping("/parkingLots")
    public ResponseEntity<ResponseDto> getAllParkingLots(){
        List<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();
        ResponseDto responseDto = new ResponseDto("These are Parking Spaces you have!",parkingLots);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @GetMapping("/getVehicleByParkingLot/{lotId}")
    public  ResponseEntity<ResponseDto> getVehicleByParkingLot(@PathVariable("lotId")int id){
        Vehicle vehicle = vehicleService.getVehicleByLotId(id);
        ResponseDto responseDto = new ResponseDto("This is the Vehicle Parked",vehicle);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }


}
