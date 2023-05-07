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
            SELECT DISTINCT Trains.*, routes.duration
            FROM Timetable, Trains, Tickets, routes
            WHERE Timetable.TrainNumber = Trains.TrainNumber
                AND Tickets.FlightNumber = Timetable.FlightNumber
                AND routes.routenumber = timetable.routenumber
            ORDER BY routes.duration;""", nativeQuery = true)
    List<Train> getAllTrainsByRouteDuration();


    /**
     * перечень поездов по цене билета
     */
    @Query(value = """
            SELECT DISTINCT Trains.*, routes.cost
            FROM Timetable, Trains, Tickets, routes
            WHERE Timetable.TrainNumber = Trains.TrainNumber
                AND Tickets.FlightNumber = Timetable.FlightNumber
                AND routes.routenumber = timetable.routenumber
            ORDER BY routes.cost;""", nativeQuery = true)
    List<Train> getAllTrainsByTicketCost();




}
