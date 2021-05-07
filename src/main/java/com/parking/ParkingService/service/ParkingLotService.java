package com.parking.ParkingService.service;


import com.parking.ParkingService.dto.ParkingLotDTO;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private SlotRepository slotRepository;

    public ParkingLot addParkingLot(ParkingLotDTO parkingLotDTO){
        ParkingLot parkingLot=new ParkingLot(parkingLotDTO);
        return parkingLotRepository.save(parkingLot);
    }
}
