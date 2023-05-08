package com.kstrinadka.railway.flights;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = """
            SELECT (NumberOfSeats.seatsnumber - SoldTickets.countOfSoldTickets) as RemainSeats\s
            FROM (SELECT tr.locomotiveid, tb.flightnumber, l.seatsnumber \s
                  FROM timetable tb, trains tr, locomotives l \s
                  WHERE tb.trainnumber = tr.trainnumber \s
                    AND tr.locomotiveid = l.locomotiveid \s
                    AND tb.flightnumber = :flightNumber) as NumberOfSeats, \s
                 (SELECT COUNT(*) as countOfSoldTickets, tk.flightnumber \s
                  FROM timetable tb, tickets tk \s
                  WHERE tb.flightnumber = tk.flightnumber \s
                    AND tb.flightnumber = :flightNumber \s
                  GROUP BY tk.flightnumber \s
                  ORDER BY tk.flightnumber) as SoldTickets""", nativeQuery = true)
    Long getAmountOfRemainTicketsByFlightNumber(Long flightNumber);


    /**
     * -- Получить перечень отмененных pейсов полностью
     */
    List<Flight> findAllByCancelIsTrue();

    /**
     * -- Получить перечень отмененных pейсов в указанном напpавлении
     */
    @Query(value = """
            SELECT tb.*
            FROM Timetable tb, (SELECT rt.RouteNumber, (SELECT StationsOnRoute.StationID
                                                         FROM StationsOnRoute
                                                         WHERE StationsOnRoute.RouteNumber = rt.RouteNumber
                                                         ORDER BY StationsOnRoute.OrderStation DESC
                                                         LIMIT 1) AS FinalStation
                             FROM Routes rt) AS FinalStationPerRoute
            WHERE tb.Cancel = TRUE
              AND tb.RouteNumber = FinalStationPerRoute.RouteNumber
              AND FinalStationPerRoute.FinalStation = :final_station_id ;""", nativeQuery = true)
    List<Flight> getAllCanceledFlightsOnDirection(@Param("final_station_id") Long final_station_id);

    /**
     * -- Получить перечень отмененных pейсов по указанному маpшpуту
     */
    @Query(value = """
            SELECT tb.*\s
            FROM Timetable tb
            WHERE tb.Cancel = TRUE
            \t  AND tb.RouteNumber = :route_id ;\s""", nativeQuery = true)
    List<Flight> getAllCanceledFlightsOnRoute(@Param("route_id") Long route_id);

    /**
     * -- Получить перечень задеpжанных pейсов
     */
    List<Flight> findAllByDelayIsTrue();

    /**
     * -- Получить перечень задеpжанных pейсов по указанной пpичине
     */
    @Query(value = """
            SELECT tb.*
            FROM Timetable tb
            WHERE tb.TimeDelay != '00:00:00' AND
                    tb.ReasonCancellation = :reason ;\s""", nativeQuery = true)
    List<Flight> getAllDelayedFlightsByReason(@Param("reason") String reason);

    /**
     * -- Получить перечень задеpжанных pейсов по указанному маpшpуту
     */
    @Query(value = """
            SELECT tb.*
            FROM Timetable tb
            WHERE tb.delay = true
                AND tb.RouteNumber = :route_id ;""", nativeQuery = true)
    List<Flight> getAllDelayedFlightsByRoute(@Param("route_id") Long route_id);
}
