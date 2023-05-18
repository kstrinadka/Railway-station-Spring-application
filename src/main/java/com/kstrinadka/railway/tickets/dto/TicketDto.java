package com.kstrinadka.railway.tickets.dto;

import com.kstrinadka.railway.flights.dto.FlightDto;
import com.kstrinadka.railway.passengers.PassengerDto;
import com.kstrinadka.railway.tickets.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Ticket} entity
 */
@Data
@NoArgsConstructor
public class TicketDto implements Serializable {
    private Long ticketid;
    private PassengerDto passenger;
    private FlightDto flight;
    private Long cost;
    private LocalDateTime timepurchase;
    private Boolean packing;
    private Boolean returnticket;
    private Date returndate;
}
