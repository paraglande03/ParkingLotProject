package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.exception.ParkingServiceException;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Slot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.SlotRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.ParkingService.repository.VehicleRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

      ParkingLot parkingLot =parkingLotRepository.findById(vehicleDTO.getLotId()).orElseThrow(()-> new ParkingServiceException(" VEHICLE IS ALREADY PARKED !"));
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
      int parkedTime= (parkedHr*60)+(vehicleRepository.findById(vehicleId).orElseThrow(()-> new ParkingServiceException(" Please enter valid vehicle id")).getInTime().getMinute());

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

   @Override
   public List<Vehicle> findByParam(String color, String make) {
      List<Vehicle> vehicles = vehicleRepository.findByParam(color,make);
      return vehicles;
   }
   @Override
   public List<Vehicle> findByModel(String model) {

      List<Vehicle> vehicles = vehicleRepository.findByModel(model);

      return vehicles;
   }

   @Override
   public List<Vehicle> getCarsByTime(int minutes) {

      LocalDateTime currentTime = LocalDateTime.now();

      List<Vehicle> vehiclesAll = vehicleRepository.findAll();

      List<Vehicle> matchingObject = vehiclesAll.stream().
              filter(p -> p.getInTime().plusMinutes(minutes).isAfter(currentTime)).collect(Collectors.toList());

      return matchingObject;











   }


}


