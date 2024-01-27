package com.parking.ParkingService.dto;

import lombok.Data;

@Data
public class ParkingLotDTO {
    private String floorNo;
    private String slotNo;
    private boolean isEmpty;

}
