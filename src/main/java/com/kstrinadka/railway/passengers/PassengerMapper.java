package com.kstrinadka.railway.passengers;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PassengerMapper {

    // сущность -> DTO
    PassengerDto passengerToDto(Passenger passenger);
    List<PassengerDto> passengersToDtos(List<Passenger> passengers);


    // DTO -> сущность
    Passenger dtoToPassenger(PassengerDto dto);
    List<Passenger> dtosToPassengers(List<PassengerDto> dtos);

}
