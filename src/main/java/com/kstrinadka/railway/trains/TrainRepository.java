package com.kstrinadka.railway.trains;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface TrainRepository extends JpaRepository<Train, Long> {


    /**
     * Получить перечень поездов на указанном маpшpуте
     */
    @Query(value = """
            SELECT DISTINCT tr.* \s
            FROM Timetable tb, Trains tr
            WHERE tb.TrainNumber = tr.TrainNumber
                    AND tb.RouteNumber = :id ;""", nativeQuery = true)
    List<Train> getAllTrainsOnRoute(@Param("id") Long id);


    /**
     * перечень поездов по длительности маршрута
     */
    @Query(value = """
            SELECT DISTINCT tr.*, MIN(routes.duration) duration
            FROM Timetable, Trains tr, Tickets, routes
            WHERE Timetable.TrainNumber = tr.TrainNumber
                AND Tickets.FlightNumber = Timetable.FlightNumber
                AND routes.routenumber = timetable.routenumber
            GROUP BY tr.trainnumber
            ORDER BY duration;""", nativeQuery = true)
    List<Train> getAllTrainsByRouteDuration();


    /**
     * перечень поездов по цене билета
     */
    @Query(value = """
            SELECT DISTINCT tr.*, MIN(routes.cost) route_cost
            FROM Timetable, Trains tr, Tickets, routes
            WHERE Timetable.TrainNumber = tr.TrainNumber
                AND Tickets.FlightNumber = Timetable.FlightNumber
                AND routes.routenumber = timetable.routenumber
            GROUP BY tr.trainnumber
            ORDER BY route_cost;""", nativeQuery = true)
    List<Train> getAllTrainsByTicketCost();




}
