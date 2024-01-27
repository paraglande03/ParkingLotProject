package com.parking.ParkingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDto {

    public String message;

    private Object data;

    private Object value;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String message){
        this.message=message;
    }

}
