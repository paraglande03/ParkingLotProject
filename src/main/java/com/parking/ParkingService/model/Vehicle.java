package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingService.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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


    @Enumerated(value = EnumType.STRING)
    private CarType carType;


    @CreationTimestamp
    private LocalDateTime inTime;


    @OneToOne
    private Slot slot;

    @ManyToOne
    private ParkingLot parkingLot;



    public Vehicle(VehicleDTO vehicleDTO){
        this.vehicleNumber=vehicleDTO.getVehicleNumber();
        this.color=vehicleDTO.getColor();
        this.model=vehicleDTO.getModel();
        this.carType=vehicleDTO.getCarType();

    }

}
