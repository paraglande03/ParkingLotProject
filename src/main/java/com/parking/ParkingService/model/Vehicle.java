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

    @Enumerated(value = EnumType.STRING)
    private CarType type;

    public Vehicle(VehicleDTO vehicleDTO) {
        this.vehicleNumber = vehicleDTO.getVehicleNumber();
        this.type = vehicleDTO.getType();
    }

    @OneToOne
    @JoinColumn(name = "parkingLot_id")
    private ParkingLot parkingLot;

    @OneToOne
    private Billing billing;

}
