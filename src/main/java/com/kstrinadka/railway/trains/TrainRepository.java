package com.kstrinadka.railway.trains;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface TrainRepository extends JpaRepository<Train, Long> {


    /**
     * Получить перечень поездов на указанном маpшpуте
     */
    @Query(value = "SELECT DISTINCT tr.*  \n" +
            "FROM Timetable tb, Trains tr\n" +
            "WHERE tb.TrainNumber = tr.TrainNumber\n" +
            "        AND tb.RouteNumber = :id ;", nativeQuery = true)
    List<Train> getAllTrainsOnRoute(@Param("id") Long id);


    /**
     * перечень поездов по длительности маршрута
     */
    @Query(value = "SELECT DISTINCT Trains.*, routes.duration\n" +
            "FROM Timetable, Trains, Tickets, routes\n" +
            "WHERE Timetable.TrainNumber = Trains.TrainNumber\n" +
            "    AND Tickets.FlightNumber = Timetable.FlightNumber\n" +
            "    AND routes.routenumber = timetable.routenumber\n" +
            "ORDER BY routes.duration;", nativeQuery = true)
    List<Train> getAllTrainsByRouteDuration();


    /**
     * перечень поездов по цене билета
     */
    @Query(value = "SELECT DISTINCT Trains.*, routes.cost\n" +
            "FROM Timetable, Trains, Tickets, routes\n" +
            "WHERE Timetable.TrainNumber = Trains.TrainNumber\n" +
            "    AND Tickets.FlightNumber = Timetable.FlightNumber\n" +
            "    AND routes.routenumber = timetable.routenumber\n" +
            "ORDER BY routes.cost;", nativeQuery = true)
    List<Train> getAllTrainsByTicketCost();




}
