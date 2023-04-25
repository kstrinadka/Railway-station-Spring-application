package com.kstrinadka.railway.services;


import com.kstrinadka.railway.dto.FlightDto;
import com.kstrinadka.railway.dto.PassengerDto;
import com.kstrinadka.railway.dto.TicketDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Сервис для обработки запросов пассажиров
 */
@Service
public interface PassengerService {


    List<FlightDto> getTimetable();


    Optional<TicketDto> buyTicket(Long passportId, Long flightNumber);

    Long getTicketCost(Long flightnumber);

    Long getFlightNumberByTicketId(Long id);

    Long getAmountOfRemainTicketsByFlightNumber(Long flightNumber);

    PassengerDto getOrCreatePassenger(PassengerDto passengerDto);
}
