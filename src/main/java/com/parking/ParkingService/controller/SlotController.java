package com.parking.ParkingService.controller;

import com.parking.ParkingService.dto.ResponseDto;
import com.parking.ParkingService.dto.SlotDTO;
import com.parking.ParkingService.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addSlot(@RequestBody SlotDTO slotDTO){

        ResponseDto responseDto=new ResponseDto("added new slot",slotService.addSlot(slotDTO));
        return  new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }

}
