package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingService.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vehicle {
    @Id
    private String vehicleNumber;
    private String color;
    private String model;

    @OneToOne
    private Slot slot;

    @ManyToOne
    private ParkingLot parkingLot;



    public Vehicle(VehicleDTO vehicleDTO){
        this.vehicleNumber=vehicleDTO.getVehicleNumber();
        this.color=vehicleDTO.getColor();
        this.model=vehicleDTO.getModel();

    }

}
