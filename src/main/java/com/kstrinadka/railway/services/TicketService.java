package com.kstrinadka.railway.services;


import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.model.Ticket;
import com.kstrinadka.railway.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {


    @Autowired
    TicketRepository ticketRepository;



    @Transactional
    public TicketDto createTicketForPassportId(Long passportId, Long flightnumber) {
        Long ticketCost = getTicketCost(flightnumber);
        TicketDto ticketDto = new TicketDto();
        Ticket ticket = new Ticket();
        ticket.setPassengerpassport(passportId);


        return null;
    }

    private Long getTicketCost(Long flightnumber) {
        return ticketRepository.getTicketCostForFlightNumber(flightnumber);
    }

}
