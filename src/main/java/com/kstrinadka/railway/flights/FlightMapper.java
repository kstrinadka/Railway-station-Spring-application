package com.kstrinadka.railway.flights;


import com.kstrinadka.railway.flights.dto.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FlightMapper {

    // сущность -> DTO
    @Mapping(target = "train", source = "train")
    @Mapping(target = "route", source = "route")
    FlightDto flightToDto(Flight flight);
    List<FlightDto> flightsToDtos(List<Flight> flights);


    // DTO -> сущность
    @Mapping(target = "train", source = "train")
    @Mapping(target = "route", source = "route")
    Flight dtoToFlight(FlightDto dto);
    List<Flight> dtosToFlights(List<FlightDto> dtos);

}
