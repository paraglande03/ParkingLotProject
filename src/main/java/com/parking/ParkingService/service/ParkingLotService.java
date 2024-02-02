package com.parking.ParkingService.service;


import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Vehicle;
import com.parking.ParkingService.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.findAll();
    }


//    public ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO){
//        ParkingLot parkingLot=new ParkingLot(parkingLotDTO);
//        return parkingLotRepository.save(parkingLot);
//    }
}
