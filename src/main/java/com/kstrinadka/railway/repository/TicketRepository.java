package com.kstrinadka.railway.repository;

import com.kstrinadka.railway.model.Flight;
import com.kstrinadka.railway.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {



    @Query(value = "SELECT r.cost\n" +
            "FROM timetable tb, routes r\n" +
            "WHERE tb.routenumber = r.routenumber\n" +
            "        AND tb.flightnumber  = :flightNumber", nativeQuery = true)
    Long getTicketCostForFlightNumber(Long flightNumber);



    @Query(value = "SELECT tk.flightnumber\n" +
            "FROM tickets tk\n" +
            "WHERE tk.ticketid = :ticketId", nativeQuery = true)
    Long getFlightNumberByTicketId(Long ticketId);


}
