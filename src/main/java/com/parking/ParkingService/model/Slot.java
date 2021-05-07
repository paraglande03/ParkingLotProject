package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingService.dto.SlotDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Slot {
    @Id
    private String slotNumber;
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ParkingLot parkingLot;

    @OneToOne(mappedBy = "slot")
    @JsonIgnore
    private Vehicle vehicle;

    public Slot(SlotDTO slotDTO){
        this.slotNumber= slotDTO.getSlotNumber();

    }
}
