package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingService.dto.ParkingLotDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String floorNo;
    public String slotNo;
    public boolean isEmpty;

    public ParkingLot(ParkingLotDTO parkingLotDTO) {
        this.floorNo = parkingLotDTO.getFloorNo();
        this.slotNo = parkingLotDTO.getSlotNo();
        this.isEmpty = true;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "parkingLot")
    private Vehicle vehicle;

}
