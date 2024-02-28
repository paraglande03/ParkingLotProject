package com.parking.ParkingService.service;

import com.ctc.wstx.util.StringUtil;
import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.VehicleDTO;
import com.parking.ParkingService.exception.ParkingServiceException;
import com.parking.ParkingService.model.Billing;
import com.parking.ParkingService.model.CarType;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.BillingRepository;
import com.parking.ParkingService.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.ParkingService.repository.VehicleRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService  implements IVehicleService{

   @Autowired
   private VehicleRepository vehicleRepository;

   @Autowired
   private NotificationService notificationService;

   @Autowired
   private ParkingLotRepository parkingLotRepository;

   @Autowired
   private BillingRepository billingRepository;

   @Override
   public Vehicle addVehicle(VehicleDTO vehicleDTO) {

      Vehicle vehicle =  new Vehicle(vehicleDTO);
      ParkingLot parkingLot = parkingLotRepository.findEmptyParkingLot();
      if(Objects.isNull(parkingLot)){
         return null;
      }
      else {
         Optional<Vehicle> vehicleOptional = vehicleRepository.findByNumber(vehicle.getVehicleNumber());
         if(vehicleOptional.isPresent()){
            vehicle = vehicleOptional.get();
            vehicle.setNewCustomer(false);
         }
         else {

            vehicle.setNewCustomer(true);
            parkingLot.setEmpty(false);
            Billing billing = new Billing();
            billing.setVehicleId(vehicle.getVehicleNumber());
            vehicle.setParkingLot(parkingLotRepository.save(parkingLot));
            vehicle.setBilling( billingRepository.save(billing));
            vehicle=  vehicleRepository.save(vehicle);
         }
         return vehicle;
      }
   }

   @Override
   public Vehicle unParkVehicle(String vehicleNumber) {
      Optional<Vehicle> vehicleOpt = vehicleRepository.findByNumber(vehicleNumber);

      if(vehicleOpt.isPresent()){
         Vehicle vehicle = vehicleOpt.get();
         // calculate billing
         setBillingAmount(vehicle.getBilling().getInTime(), vehicle.getType(), vehicle.getBilling());
         ParkingLot parkingLot = vehicle.getParkingLot();
         parkingLot.isEmpty=true;
         parkingLotRepository.save(parkingLot);
         vehicleRepository.deleteById(vehicleNumber);
            notificationService.sendBilling(vehicle.getBilling(),vehicle);
         return vehicle;
      }
      return null;
   }

   public void setBillingAmount(LocalDateTime inTime, CarType type, Billing billing){
      LocalDateTime currentTime = LocalDateTime.now();
      Duration duration = Duration.between(inTime,currentTime );
      long minutes = duration.toMinutes();

      int charge =0;
      switch (type){
         case SUV:
            charge = getChargeByType(minutes,100,30);
             break;
         case HATCH:
            charge = getChargeByType(minutes,80,20);
            break;
         case MULTI_AXLE:
            charge = getChargeByType(minutes,150,50);
            break;
         case TWO_WHEELER:
            charge = getChargeByType(minutes,50,10);;
            break;
      }


      billing.setOutTime(currentTime);
      billing.setParkedTime(duration.toHoursPart()+" hr"+duration.toMinutesPart()+" min");
      billing.setAmount(charge);
      billingRepository.save(billing);
   }


   public int getChargeByType(long minutes,int initialRateFor3Hrs,int rateAfter3Hrs){
         int charge =0;

               if(minutes<=180){
                  charge = initialRateFor3Hrs;
               }
               else {
                  charge = initialRateFor3Hrs;
                  minutes = minutes-180;

                  int hours = (int) (minutes/60);
                  int rem = (int) (minutes%60);
                  if(rem>0){
                     hours=hours+1;
                  }
                  charge = charge + (rateAfter3Hrs*hours);
               }
       return charge;
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
      return null;
   }


   @Override
   public ResponseDto parkingCharge(String vehicleId) {
      LocalTime time = LocalTime.now();

//      int parkedHr = vehicleRepository.findById(vehicleId).orElseThrow().getInTime().getHour();
//      int parkedTime= (parkedHr*60)+(vehicleRepository.findById(vehicleId).orElseThrow(()-> new ParkingServiceException(" Please enter valid vehicle id")).getInTime().getMinute());
//
//      int unparkHr = time.getHour()*60;
//
//      int unparkTime= unparkHr+time.getMinute();
//
//      int totalparkedTime = unparkTime-parkedTime;

      return new ResponseDto(" minutes!" );


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

      List<Vehicle> matchingObject = null;
//              vehiclesAll.stream().
//              filter(p -> p.getInTime().plusMinutes(minutes).isAfter(currentTime)).collect(Collectors.toList());

      return matchingObject;

   }

   public Vehicle getVehicleByLotId(int id) {
    Optional<Vehicle> vehicleOptional = vehicleRepository.findByParkingLotId(id);
       return vehicleOptional.orElse(null);
   }



}


