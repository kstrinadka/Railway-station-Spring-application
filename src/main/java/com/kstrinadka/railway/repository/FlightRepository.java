package com.kstrinadka.railway.repository;


import com.kstrinadka.railway.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT (NumberOfSeats.seatsnumber - SoldTickets.countOfSoldTickets) as RemainSeats " +
            "FROM (SELECT tr.locomotiveid, tb.flightnumber, l.seatsnumber " +
            "      FROM timetable tb, trains tr, locomotives l " +
            "      WHERE tb.trainnumber = tr.trainnumber " +
            "        AND tr.locomotiveid = l.locomotiveid " +
            "        AND tb.flightnumber = :flightNumber) as NumberOfSeats, " +
            "     (SELECT COUNT(*) as countOfSoldTickets, tk.flightnumber " +
            "      FROM timetable tb, tickets tk " +
            "      WHERE tb.flightnumber = tk.flightnumber " +
            "        AND tb.flightnumber = :flightNumber " +
            "      GROUP BY tk.flightnumber " +
            "      ORDER BY tk.flightnumber) as SoldTickets", nativeQuery = true)
    Long getAmountOfRemainTicketsByFlightNumber(Long flightNumber);

}
