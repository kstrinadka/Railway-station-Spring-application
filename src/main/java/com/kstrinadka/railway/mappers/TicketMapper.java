package com.kstrinadka.railway.mappers;


import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDto toDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.setTicketid(ticket.getTicketid());
        dto.setPassengerpassport(ticket.getPassengerpassport());
        dto.setFlightnumber(ticket.getFlightnumber());
        dto.setCost(ticket.getCost());
        dto.setTimepurchase(ticket.getTimepurchase());
        dto.setPacking(ticket.getPacking());
        dto.setReturnticket(ticket.getReturnticket());
        dto.setReturndate(ticket.getReturndate());
        return dto;
    }

    public Ticket toModel(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketid(ticketDto.getTicketid());
        ticket.setPassengerpassport(ticketDto.getPassengerpassport());
        ticket.setFlightnumber(ticketDto.getFlightnumber());
        ticket.setCost(ticketDto.getCost());
        ticket.setTimepurchase(ticketDto.getTimepurchase());
        ticket.setPacking(ticketDto.getPacking());
        ticket.setReturndate(ticketDto.getReturndate());
        ticket.setReturnticket(ticketDto.getReturnticket());
        return ticket;
    }
}
