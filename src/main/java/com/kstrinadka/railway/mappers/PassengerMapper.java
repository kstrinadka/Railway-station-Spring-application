package com.kstrinadka.railway.mappers;


import com.kstrinadka.railway.dto.PassengerDto;
import com.kstrinadka.railway.model.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public Passenger toModel(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setName(passengerDto.getName());
        passenger.setMiddlename(passengerDto.getMiddlename());
        passenger.setSurname(passengerDto.getSurname());
        passenger.setGender(passengerDto.getGender());
        passenger.setBirthday(passengerDto.getBirthday());
        return passenger;
    }


    public PassengerDto toDto(Passenger passenger) {
        PassengerDto dto = new PassengerDto();
        dto.setName(passenger.getName());
        dto.setMiddlename(passenger.getMiddlename());
        dto.setSurname(passenger.getSurname());
        dto.setGender(passenger.getGender());
        dto.setGender(passenger.getGender());
        dto.setBirthday(passenger.getBirthday());
        dto.setPassportnumber(passenger.getPassportnumber());
        return dto;
    }

}
