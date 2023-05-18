package com.kstrinadka.railway.tickets.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TicketFrontDto {
    private Long ticketid;
    private Long passengerpassport;
    private Long flightnumber;
    private Long cost;
    private LocalDateTime timepurchase;
    private Boolean packing;
    private Boolean returnticket;
    private Date returndate;
}
