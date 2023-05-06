package com.kstrinadka.railway.flights;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FlightMapper {


    // сущность -> DTO
    @Mapping(target = "trainnumber", source = "train.trainnumber")
    @Mapping(target = "routenumber", source = "route.routenumber")
    FlightDto flightToDto(Flight flight);
    List<FlightDto> flightsToDtos(List<Flight> flights);


    // DTO -> сущность
    @Mapping(target = "train.trainnumber", source = "trainnumber")
    @Mapping(target = "route.routenumber", source = "routenumber")
    Flight dtoToFlight(FlightDto dto);
    List<Flight> dtosToFlights(List<FlightDto> dtos);

}
