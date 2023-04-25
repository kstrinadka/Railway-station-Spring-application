package com.kstrinadka.railway.mappers;


import com.kstrinadka.railway.dto.FlightDto;
import com.kstrinadka.railway.model.Flight;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;


@Component
public class FlightMapper {


    public FlightDto map(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightnumber(flight.getFlightnumber());
        flightDto.setTrainnumber(flight.getTrainnumber());
        flightDto.setDeparture(flight.getDeparture());
        flightDto.setArrival(flight.getArrival());
        flightDto.setRoutenumber(flight.getRoutenumber());
        flightDto.setCancel(flight.getCancel());
        flightDto.setReasoncancellation(flight.getReasoncancellation());
        flightDto.setTimedelay(flight.getTimedelay());
        flightDto.setDelay(flight.getDelay());
        flightDto.setIsRegistrationOpen(isRegistrationOpen(flight.getDeparture()));
        return flightDto;
    }

    private Boolean isRegistrationOpen(Date departure) {
        LocalDate now = LocalDate.now();
        LocalDate startFlight = departure.toLocalDate();
        return startFlight.isAfter(now);
    }
}
