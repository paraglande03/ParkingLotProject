package com.parking.ParkingService.exception;

import com.parking.ParkingService.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.NoSuchElementException;

@ControllerAdvice
public class ExcwptionHandler {


    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<ResponseDto> twoOrMoreAssigningException(JpaSystemException exception){
        ResponseDto responseDto =new ResponseDto("Slot is already occupied! ");
        return  new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @ExceptionHandler(ParkingServiceException.class)
    public ResponseEntity<ResponseDto> incorrectIdException(ParkingServiceException exception){
        ResponseDto responseDto =new ResponseDto("Error : ");
        return  new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseDto> noSuchValue(NoSuchElementException exception){
        ResponseDto responseDto =new ResponseDto("Please Enter valid Number ");
        return  new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
