package com.kstrinadka.railway.tickets;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TicketMapper {

    // сущность -> DTO
    @Mapping(target = "passengerpassport", source = "passenger.passportnumber")
    @Mapping(target = "flightnumber", source = "flight.flightnumber")
    TicketDto ticketToDto(Ticket ticket);
    List<TicketDto> ticketsToDtos(List<Ticket> tickets);


    // DTO -> сущность
    @Mapping(target = "passenger.passportnumber", source = "passengerpassport")
    @Mapping(target = "flight.flightnumber", source = "flightnumber")
    Ticket dtoToTicket(TicketDto dto);
    List<Ticket> dtosToTickets(List<TicketDto> dtos);

}
