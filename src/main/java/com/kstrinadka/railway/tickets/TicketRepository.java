package com.kstrinadka.railway.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
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




    /**
     * -- Получить перечень пpоданных билетов за указанный интервал времени на опpеделенные маpшpуты
     */
    @Query(value = "SELECT ts.*\n" +
            "FROM Tickets ts, Timetable tb\n" +
            "WHERE ts.FlightNumber = tb.FlightNumber\n" +
            "  AND ts.TimePurchase >= :start_time \n" +
            "  AND ts.TimePurchase <= :end_time \n" +
            "  AND (tb.RouteNumber = :route_id )\n" +
            "ORDER BY tb.Arrival - tb.Departure ;", nativeQuery = true)
    List<Ticket> getAllTicketsOnRouteInPeriod(@Param("start_time") Timestamp start_time,
                                              @Param("end_time") Timestamp end_time,
                                              @Param("route_id") Long route_id);



    /**
     * -- Получить перечень пpоданных билетов по длительности маршрута
     */
    @Query(value = "SELECT tk.*\n" +
            "FROM Tickets tk, Timetable tb\n" +
            "WHERE tk.FlightNumber = tb.FlightNumber\n" +
            "ORDER BY (tb.Arrival - tb.Departure);", nativeQuery = true)
    List<Ticket> getAllTicketsByRouteDuration();

    /**
     * -- Получить перечень пpоданных билетов по цене билета
     */
    List<Ticket> findAllByOrderByCost();


    /**
     * -- Получить перечень невыкупленных билетов на указанном pейсe
     */
    @Query(value = "SELECT tk.*\n" +
            "FROM tickets tk\n" +
            "WHERE tk.passengerpassport IS NULL\n" +
            "    AND tk.flightnumber = :flight_id \n" +
            "GROUP BY tk.ticketid;", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByFlight(@Param("flight_id") Long flight_id);


    /**
     * -- Получить перечень невыкупленных билетов в определенный день
     */
    @Query(value = "SELECT tk.* \n" +
            "FROM Tickets tk, Timetable tb \n" +
            "WHERE tk.PassengerPassport IS NULL\n" +
            "        AND tb.FlightNumber = tk.FlightNumber\n" +
            "        AND tb.Departure >= :start_day \n" +
            "        AND tb.Departure <= :end_day ;", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByDay(@Param("start_day") Timestamp start_day,
                                              @Param("end_day") Timestamp end_day);


    /**
     * -- Получить перечень невыкупленных билетов на некотором маpшpуте
     */
    @Query(value = "SELECT tk.*  \n" +
            "FROM Tickets tk, Timetable tb \n" +
            "WHERE tk.PassengerPassport IS NULL\n" +
            "        AND tb.FlightNumber = tk.FlightNumber\n" +
            "        AND tb.RouteNumber = :route_id ;", nativeQuery = true)
    List<Ticket> getAllNotSoldTicketsByRoute(@Param("route_id") Long route_id);


    /**
     * -- Получить общее число сданных билетов на указанный pейс
     */
    @Query(value = "SELECT tk.* \n" +
            "FROM Tickets tk\n" +
            "WHERE tk.ReturnTicket = TRUE AND\n" +
            "        tk.FlightNumber = :flight_id ;", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByFlight(@Param("flight_id") Long flight_id);

    /**
     * -- Получить общее число сданных билетов на указанный день
     */
    @Query(value = "SELECT tk.*\n" +
            "FROM Tickets tk\n" +
            "WHERE tk.ReturnTicket = TRUE AND\n" +
            "        tk.ReturnDate >= :start_day AND\n" +
            "        tk.ReturnDate <= :end_day ;", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByDay(@Param("start_day") Timestamp start_day,
                                           @Param("end_day") Timestamp end_day);

    /**
     * -- Получить перечень сданных билетов на указанный маpшpут
     */
    @Query(value = "SELECT tk.*\n" +
            "FROM Tickets tk, Timetable tb \n" +
            "WHERE tk.ReturnTicket = TRUE AND\n" +
            "        tb.FlightNumber = tk.FlightNumber AND\n" +
            "        tb.RouteNumber = :route_id ;", nativeQuery = true)
    List<Ticket> getAllRefundTicketsByRoute(@Param("route_id") Long route_id);
}
