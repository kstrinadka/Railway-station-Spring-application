package com.kstrinadka.railway.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {



    @Query(value = """
            SELECT r.cost
            FROM timetable tb, routes r
            WHERE tb.routenumber = r.routenumber
                    AND tb.flightnumber  = :flightNumber""", nativeQuery = true)
    Long getTicketCostForFlightNumber(Long flightNumber);



    @Query(value = """
            SELECT tk.flightnumber
            FROM tickets tk
            WHERE tk.ticketid = :ticketId""", nativeQuery = true)
    Long getFlightNumberByTicketId(Long ticketId);




    /**
     * -- Получить перечень пpоданных билетов за указанный интервал времени на опpеделенные маpшpуты
     */
    @Query(value = """
            SELECT ts.*
            FROM Tickets ts, Timetable tb
            WHERE ts.FlightNumber = tb.FlightNumber
              AND ts.TimePurchase >= :start_time\s
              AND ts.TimePurchase <= :end_time\s
              AND (tb.RouteNumber = :route_id )
            ORDER BY tb.Arrival - tb.Departure ;""", nativeQuery = true)
    List<Ticket> getAllTicketsOnRouteInPeriod(@Param("start_time") Timestamp start_time,
                                              @Param("end_time") Timestamp end_time,
                                              @Param("route_id") Long route_id);

    /**
     * -- Получить перечень пpоданных билетов за указанный интервал времени
     */
    @Query(value = """
            SELECT ts.*
            FROM Tickets ts, Timetable tb
            WHERE ts.FlightNumber = tb.FlightNumber
              AND ts.TimePurchase >= :start_time\s
              AND ts.TimePurchase <= :end_time\s
            ORDER BY tb.Arrival - tb.Departure ;""", nativeQuery = true)
    List<Ticket> getAllTicketsInPeriod(@Param("start_time") Timestamp start_time,
                                              @Param("end_time") Timestamp end_time);


    /**
     * -- Получить перечень пpоданных билетов на опpеделенные маpшpуты
     */
    @Query(value = """
            SELECT ts.*
            FROM Tickets ts, Timetable tb
            WHERE ts.FlightNumber = tb.FlightNumber
              AND (tb.RouteNumber = :route_id )
            ORDER BY tb.Arrival - tb.Departure ;""", nativeQuery = true)
    List<Ticket> getAllTicketsOnRoute(@Param("route_id") Long route_id);


    /**
     * -- Получить перечень пpоданных билетов по длительности маршрута
     */
    @Query(value = """
            SELECT tk.*
            FROM Tickets tk, Timetable tb
            WHERE tk.FlightNumber = tb.FlightNumber
            ORDER BY (tb.Arrival - tb.Departure);""", nativeQuery = true)
    List<Ticket> getAllTicketsByRouteDuration();

    /**
     * -- Получить перечень пpоданных билетов по цене билета
     */
    List<Ticket> findAllByOrderByCost();


    /**
     * -- Получить перечень невыкупленных билетов на указанном pейсe
     */
    @Query(value = """
            SELECT tk.*
            FROM tickets tk
            WHERE tk.passengerpassport IS NULL
                AND tk.flightnumber = :flight_id\s
            GROUP BY tk.ticketid;""", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByFlight(@Param("flight_id") Long flight_id);


    /**
     * -- Получить перечень невыкупленных билетов в определенный день
     */
    @Query(value = """
            SELECT tk.*\s
            FROM Tickets tk, Timetable tb\s
            WHERE tk.PassengerPassport IS NULL
                    AND tb.FlightNumber = tk.FlightNumber
                    AND tb.Departure >= :start_day\s
                    AND tb.Departure <= :end_day ;""", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByDay(@Param("start_day") Timestamp start_day,
                                              @Param("end_day") Timestamp end_day);


    /**
     * -- Получить перечень невыкупленных билетов на некотором маpшpуте
     */
    @Query(value = """
            SELECT tk.* \s
            FROM Tickets tk, Timetable tb\s
            WHERE tk.PassengerPassport IS NULL
                    AND tb.FlightNumber = tk.FlightNumber
                    AND tb.RouteNumber = :route_id ;""", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByRoute(@Param("route_id") Long route_id);


    /**
     * -- Получить общее число сданных билетов на указанный pейс
     */
    @Query(value = """
            SELECT tk.*\s
            FROM Tickets tk
            WHERE tk.ReturnTicket = TRUE AND
                    tk.FlightNumber = :flight_id ;""", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByFlight(@Param("flight_id") Long flight_id);

    /**
     * -- Получить общее число сданных билетов на указанный день
     */
    @Query(value = """
            SELECT tk.*
            FROM Tickets tk
            WHERE tk.ReturnTicket = TRUE AND
                    tk.ReturnDate >= :start_day AND
                    tk.ReturnDate <= :end_day ;""", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByDay(@Param("start_day") Timestamp start_day,
                                           @Param("end_day") Timestamp end_day);

    /**
     * -- Получить перечень сданных билетов на указанный маpшpут
     */
    @Query(value = """
            SELECT tk.*
            FROM Tickets tk, Timetable tb\s
            WHERE tk.ReturnTicket = TRUE AND
                    tb.FlightNumber = tk.FlightNumber AND
                    tb.RouteNumber = :route_id ;""", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByRoute(@Param("route_id") Long route_id);
}
