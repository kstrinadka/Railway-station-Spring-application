package com.kstrinadka.railway.controllers;


import com.kstrinadka.railway.dto.FlightDto;
import com.kstrinadka.railway.dto.PassengerDto;
import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.model.Ticket;
import com.kstrinadka.railway.services.PassengerService;
import com.kstrinadka.railway.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Интерфейс, доступный пассажиру
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {


    @Autowired
    PassengerService  passengerService;


    @GetMapping(path = "/timetable")
    public List<FlightDto> getWorker() {
        return passengerService.getTimetable();
    }


    @PostMapping("/byticket")
    public Optional<TicketDto> buyTicket(@RequestParam("passportid") Long passportId, @RequestParam("flightNumber") Long flightNumber) {
        Optional<TicketDto> answer = passengerService.buyTicket(passportId, flightNumber);
        return answer;
    }

    @GetMapping("/remaintickets/{flightnumber}")
    public Long getAmountOfRemainTicketsByFlightId(@PathVariable Long flightnumber) {
        return passengerService.getAmountOfRemainTicketsByFlightNumber(flightnumber);
    }

    @GetMapping("/ticketcost/{flightnumber}")
    public Long getTicketCost(@PathVariable Long flightnumber) {
        return passengerService.getTicketCost(flightnumber);
    }

    @GetMapping("/ticket/getflightnumber/{id}")
    public Long getFlightNumberByTicketId(@PathVariable Long id){
        return passengerService.getFlightNumberByTicketId(id);
    }

    //todo
    @PostMapping("/getOrCreatePassenger")
    public PassengerDto getOrCreatePassenger(@RequestBody PassengerDto passengerDto) {
        PassengerDto answer = passengerService.getOrCreatePassenger(passengerDto);
        return answer;
    }

}
