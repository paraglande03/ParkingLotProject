package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.model.ParkingLot;
import com.parking.ParkingService.model.Slot;
import com.parking.ParkingService.repository.ParkingLotRepository;
import com.parking.ParkingService.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public Slot addSlot(SlotDTO slotDTO){
        Slot slot=new Slot(slotDTO);
        ParkingLot parkingLot=parkingLotRepository.findById(slotDTO.getParkingLotNum()).orElseThrow();
        slot.setParkingLot(parkingLot);
        return slotRepository.save(slot);

    }

}
