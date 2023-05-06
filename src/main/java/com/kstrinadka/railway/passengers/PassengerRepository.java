package com.kstrinadka.railway.passengers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {


    /**
     * -- Получить перечень пассажиpов на указанном pейсе
     */
    @Query(value = """
            SELECT ps.*\s
            FROM Passengers ps, Tickets tk
            WHERE ps.PassportNumber = tk.PassengerPassport
                AND tk.FlightNumber = :flight_id ;\s""", nativeQuery = true)
    List<Passenger> getAllPassengersByFlight(@Param("flight_id") Long flight_id);

    /**
     * -- Получить перечень пассажиpов уехавших в указанный день
     */
    @Query(value = """
            SELECT ps.* \s
            FROM Passengers ps, Tickets tk, Timetable tb
            WHERE ps.PassportNumber = tk.PassengerPassport
                AND tk.ReturnTicket = FALSE
                AND tk.FlightNumber = tb.FlightNumber
                AND tb.Departure >= :start_day\s
                AND tb.Departure <= :end_day  \s
                AND tb.Cancel = FALSE;\s""", nativeQuery = true)
    List<Passenger> getAllPassengersByDepartureDay(@Param("start_day") Timestamp start_day,
                                          @Param("end_day") Timestamp end_day);

    /**
     * -- Получить перечень пассажиpов уехавших за границу в указанный день
     */
    @Query(value = """
            SELECT ps.*\s
            FROM Passengers ps, Tickets tk, Timetable tb, Routes rt
            WHERE ps.PassportNumber = tk.PassengerPassport
                AND tk.ReturnTicket = FALSE
                AND tk.FlightNumber = tb.FlightNumber
                AND tb.Departure >= :start_day\s
                AND tb.Departure <= :end_day  \s
                AND tb.Cancel = FALSE
                AND rt.RouteNumber = tb.RouteNumber
                AND rt.Category = 'Международный'
            ORDER BY tk.Packing;\s""", nativeQuery = true)
    List<Passenger> getAllPassengersAbroadByDepartureDay(@Param("start_day") Timestamp start_day,
                                                @Param("end_day") Timestamp end_day);

    /**
     * -- Перечень всех пассажирова по пpизнаку сдачи вещей в багажное отделение
     */
    @Query(value = """
            SELECT DISTINCT ps.*\s
            FROM Passengers ps, Tickets tk
            WHERE ps.PassportNumber = tk.PassengerPassport
                AND tk.packing = true
            ORDER BY ps.birthday;\s""", nativeQuery = true)
    List<Passenger> getAllPassengersByPackingIsTrue();

    /**
     * -- Перечень всех пассажирова по половому пpизнаку
     */
    @Query(value = """
            SELECT DISTINCT ps.* \s
            FROM Passengers ps, Tickets tk, Timetable tb, Routes rt
            WHERE ps.gender = :gender \s
            ORDER BY ps.birthday; \s""", nativeQuery = true)
    List<Passenger> getAllPassengersByGenderIdentity(@Param("gender") String gender);

    /**
     * -- Перечень всех пассажирова по возрасту
     */
    @Query(value = """
            SELECT ps.*\s
            FROM Passengers ps
            ORDER BY ps.birthday;\s""", nativeQuery = true)
    List<Passenger> getAllPassengersByAge();




}
