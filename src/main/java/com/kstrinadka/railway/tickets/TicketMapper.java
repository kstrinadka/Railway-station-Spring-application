package com.kstrinadka.railway.tickets;


import com.kstrinadka.railway.tickets.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TicketMapper {

    // сущность -> DTO
    @Mapping(target = "passenger", source = "passenger")
    @Mapping(target = "flight", source = "flight")
    TicketDto ticketToDto(Ticket ticket);
    List<TicketDto> ticketsToDtos(List<Ticket> tickets);


    // DTO -> сущность
    @Mapping(target = "passenger", source = "passenger")
    @Mapping(target = "flight", source = "flight")
    Ticket dtoToTicket(TicketDto dto);
    List<Ticket> dtosToTickets(List<TicketDto> dtos);

}
