package com.parking.ParkingService.model;

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

    @OneToMany(mappedBy = "parkingLot")
    public List<Slot> slots;

    public ParkingLot(ParkingLotDTO parkingLotDTO){
        this.parkingLotId= parkingLotDTO.lotId;

    }

}
