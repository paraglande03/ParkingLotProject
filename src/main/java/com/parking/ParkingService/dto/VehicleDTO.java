package com.parking.ParkingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor@ToString
public class VehicleDTO {

    private String vehicleNumber;
    private String color;
    private String model;
    private String slotId;
    private String lotId;
}
