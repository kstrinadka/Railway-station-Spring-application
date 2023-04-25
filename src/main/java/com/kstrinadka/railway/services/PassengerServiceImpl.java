package com.kstrinadka.railway.services;


import com.kstrinadka.railway.dto.FlightDto;
import com.kstrinadka.railway.dto.PassengerDto;
import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.mappers.FlightMapper;
import com.kstrinadka.railway.mappers.PassengerMapper;
import com.kstrinadka.railway.mappers.TicketMapper;
import com.kstrinadka.railway.model.Flight;
import com.kstrinadka.railway.model.Passenger;
import com.kstrinadka.railway.model.Ticket;
import com.kstrinadka.railway.repository.FlightRepository;
import com.kstrinadka.railway.repository.PassengerRepository;
import com.kstrinadka.railway.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PassengerServiceImpl implements PassengerService{

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    PassengerRepository passengerRepository;

//    @Autowired
//    FlightRepository flightRepository;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    TicketMapper ticketMapper;



    @Override
    public List<FlightDto> getTimetable() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            FlightDto flightDto = flightMapper.map(flight);
            flightDtos.add(flightDto);
        }
        return flightDtos;
    }

    @Override
    public Optional<TicketDto> buyTicket(Long passportId, Long flightNumber) {
        System.out.println("flightnumber = " + flightNumber);
        Long amountOfRemainTickets = getAmountOfRemainTicketsByFlightNumber(flightNumber);
        System.out.println("amountOfRemainTickets = " + amountOfRemainTickets);
        if (amountOfRemainTickets.equals(0)) {
            return Optional.empty();
        }
        TicketDto newTicket = createTicketForPassportId(passportId, flightNumber);
        Optional<TicketDto> answer = Optional.ofNullable(newTicket);
        return answer;
    }


    @Override
    public Long getTicketCost(Long flightnumber) {
        return ticketRepository.getTicketCostForFlightNumber(flightnumber);
    }

    @Override
    public Long getFlightNumberByTicketId(Long id) {
        return ticketRepository.getFlightNumberByTicketId(id);
    }

    @Override
    public Long getAmountOfRemainTicketsByFlightNumber(Long flightNumber) {
        return flightRepository.getAmountOfRemainTicketsByFlightNumber(flightNumber);
    }

    //todo
    @Override
    public PassengerDto getOrCreatePassenger(PassengerDto passengerDto) {
        Passenger passenger = passengerMapper.toModel(passengerDto);
        if (passengerRepository.exists(Example.of(passenger))) {
            return passengerMapper.toDto(passengerRepository.findOne(Example.of(passenger)).get());
        }
        else {
            return passengerMapper.toDto(passengerRepository.save(passenger));
        }

    }

    @Transactional
    private TicketDto createTicketForPassportId(Long passportId, Long flightnumber) {
        Ticket ticket = new Ticket();
        ticket.setPassengerpassport(passportId);
        ticket.setFlightnumber(flightnumber);
        ticket.setCost(getTicketCost(flightnumber));
        ticket.setTimepurchase(getCurrentDate());
        ticket.setPacking(true);
        ticket.setReturndate(null);
        ticket.setReturnticket(false);

        ticketRepository.save(ticket);

        TicketDto ticketDto = ticketMapper.toDto(ticket);
        return ticketDto;
    }


    private LocalDateTime getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }


    //инжектим сюда различные штуки:
    //мапперы
    //репозитории
    //другие сервисы






}
