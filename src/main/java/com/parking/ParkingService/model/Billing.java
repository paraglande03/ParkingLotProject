package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @CreationTimestamp
    private LocalDateTime inTime;

    private LocalDateTime outTime;

    private String parkedTime;

    private int amount;

    private String vehicleId;

}
