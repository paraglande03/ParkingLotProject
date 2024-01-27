package com.parking.ParkingService.service;


import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;



    public ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO) {
        ParkingLot parkingLot = new ParkingLot(parkingLotDTO);

        return parkingLotRepository.save(parkingLot);
    }

    public void deleteParkingLot(int id) {
         parkingLotRepository.deleteById(id);
    }

//    public ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO){
//        ParkingLot parkingLot=new ParkingLot(parkingLotDTO);
//        return parkingLotRepository.save(parkingLot);
//    }
}
