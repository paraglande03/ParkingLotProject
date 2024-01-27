package com.parking.ParkingService.service;

import com.parking.ParkingService.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SlotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;



}
