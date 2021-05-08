package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Slot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.ParkingService.repository.VehicleRepository;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService  implements IVehicleService{

   @Autowired
   private VehicleRepository vehicleRepository;

   @Autowired
   private SlotRepository slotRepository;

   @Autowired
   private ParkingLotRepository parkingLotRepository;



   @Override
   public Vehicle addVehicle(VehicleDTO vehicleDTO ){

      Vehicle vehicle = new Vehicle(vehicleDTO);

      Slot slot=slotRepository.findById(vehicleDTO.getSlotId()).orElseThrow();
      vehicle.setSlot(slot);

      ParkingLot parkingLot =parkingLotRepository.findById(vehicleDTO.getLotId()).orElseThrow();
      vehicle.setParkingLot(parkingLot);

      return vehicleRepository.save(vehicle);
   }

   @Override
   public Vehicle unParkVehicle(String vehicleNumber) {
      vehicleRepository.deleteById(vehicleNumber);
      return null;
   }

   @Override
   public ResponseDto checkFull() {
      List<Vehicle> vehicles = vehicleRepository.findAll();
      if (vehicles.size()>=4){
         return new ResponseDto("Parking lot is full!");
      }
      else {
         return new ResponseDto("Parking lot has slots empty!");
      }

   }

   @Override
   public ResponseDto findVehicle(String vehicleId) {

      int lot= vehicleRepository.findById(vehicleId).orElseThrow().getParkingLot().getParkingLotId();
      String slot=vehicleRepository.findById(vehicleId).orElseThrow().getSlot().getSlotNumber();

      ResponseDto responseDto = new ResponseDto("Parking lot number:"+lot+" Slot number :" +slot)      ;

      return responseDto;
   }

   @Override
   public ResponseDto parkingCharge(String vehicleId) {
      LocalTime time = LocalTime.now();

      int parkedHr = vehicleRepository.findById(vehicleId).orElseThrow().getInTime().getHour();
      int parkedTime= (parkedHr*60)+(vehicleRepository.findById(vehicleId).orElseThrow().getInTime().getMinute());

      int unparkHr = time.getHour()*60;

      int unparkTime= unparkHr+time.getMinute();

      int totalparkedTime = unparkTime-parkedTime;

      return new ResponseDto(totalparkedTime+" minutes!" );


   }

   @Override
   public List<Vehicle> findByColor(String color) {

     List<Vehicle> vehicles = vehicleRepository.findByColor(color);

      return vehicles;
   }

}


