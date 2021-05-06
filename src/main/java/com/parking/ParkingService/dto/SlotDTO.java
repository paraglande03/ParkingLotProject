package com.parking.ParkingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SlotDTO {

    private String parkingLotNum;
    private String slotNumber;

}
