package com.kstrinadka.railway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.kstrinadka.railway.model.Ticket} entity
 */
@Data
@NoArgsConstructor
public class TicketDto implements Serializable {
    private Long ticketid;
    private Long passengerpassport;
    private Long flightnumber;
    private Long cost;
    private LocalDateTime timepurchase;
    private Boolean packing;
    private Boolean returnticket;
    private LocalDateTime returndate;
}