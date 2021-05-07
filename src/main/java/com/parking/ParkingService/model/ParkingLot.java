package com.parking.ParkingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parking.ParkingService.dto.ParkingLotDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingLot {
    @Id
    public Integer parkingLotId;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    public List<Slot> slots;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    public List<Vehicle> vehicles;

    public ParkingLot(ParkingLotDTO parkingLotDTO){
        this.parkingLotId= parkingLotDTO.lotId;

    }

}
