package com.parking.ParkingService.service;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.model.Slot;
import com.parking.ParkingService.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;


    public Slot addSlot(SlotDTO slotDTO){
        Slot slot=new Slot(slotDTO);
        return slotRepository.save(slot);

    }

}
