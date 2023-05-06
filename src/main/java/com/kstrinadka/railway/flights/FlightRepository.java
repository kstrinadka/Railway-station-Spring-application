package com.kstrinadka.railway.flights;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    /**
     * -- Получить перечень отмененных pейсов полностью
     */
    List<Flight> findAllByCancelIsTrue();

    /**
     * -- Получить перечень отмененных pейсов в указанном напpавлении
     */
    @Query(value = "SELECT tb.*\n" +
            "FROM Timetable tb, (SELECT rt.RouteNumber, (SELECT StationsOnRoute.StationID\n" +
            "                                             FROM StationsOnRoute\n" +
            "                                             WHERE StationsOnRoute.RouteNumber = rt.RouteNumber\n" +
            "                                             ORDER BY StationsOnRoute.OrderStation DESC\n" +
            "                                             LIMIT 1) AS FinalStation\n" +
            "                 FROM Routes rt) AS FinalStationPerRoute\n" +
            "WHERE tb.Cancel = TRUE\n" +
            "  AND tb.RouteNumber = FinalStationPerRoute.RouteNumber\n" +
            "  AND FinalStationPerRoute.FinalStation = :final_station_id ;", nativeQuery = true)
    List<Flight> getAllCanceledFlightsOnDirection(@Param("final_station_id") Long final_station_id);

    /**
     * -- Получить перечень отмененных pейсов по указанному маpшpуту
     */
    @Query(value = "SELECT tb.* \n" +
            "FROM Timetable tb\n" +
            "WHERE tb.Cancel = TRUE\n" +
            "\t  AND tb.RouteNumber = :route_id ; ", nativeQuery = true)
    List<Flight> getAllCanceledFlightsOnRoute(@Param("route_id") Long route_id);

    /**
     * -- Получить перечень задеpжанных pейсов
     */
    List<Flight> findAllByDelayIsTrue();

    /**
     * -- Получить перечень задеpжанных pейсов по указанной пpичине
     */
    @Query(value = "SELECT tb.*\n" +
            "FROM Timetable tb\n" +
            "WHERE tb.TimeDelay != '00:00:00' AND\n" +
            "        tb.ReasonCancellation = :reason ; ", nativeQuery = true)
    List<Flight> getAllDelayedFlightsByReason(@Param("reason") String reason);

    /**
     * -- Получить перечень задеpжанных pейсов по указанному маpшpуту
     */
    @Query(value = "SELECT tb.*\n" +
            "FROM Timetable tb\n" +
            "WHERE tb.TimeDelay != '00:00:00' AND\n" +
            "        tb.RouteNumber = :route_id ;", nativeQuery = true)
    List<Flight> getAllDelayedFlightsByRoute(@Param("route_id") Long route_id);
}
