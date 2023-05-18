package com.kstrinadka.railway.tickets;


import com.kstrinadka.railway.flights.FlightService;
import com.kstrinadka.railway.flights.dto.FlightDto;
import com.kstrinadka.railway.passengers.PassengerDto;
import com.kstrinadka.railway.passengers.PassengerService;
import com.kstrinadka.railway.tickets.dto.TicketDto;
import com.kstrinadka.railway.tickets.dto.TicketFrontDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final PassengerService passengerService;
    private final FlightService flightService;

    @Autowired
    public TicketService(TicketRepository ticketRepository,
                         TicketMapper ticketMapper,
                         PassengerService passengerService,
                         FlightService flightService) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.passengerService = passengerService;
        this.flightService = flightService;
    }


    public List<TicketDto> getAllTickets() {
        return ticketMapper.ticketsToDtos(ticketRepository.findAll());
    }

    public List<TicketDto> getAllTicketsOnRouteInPeriod(Timestamp start_time, Timestamp end_time, Long route_id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllTicketsOnRouteInPeriod(start_time, end_time, route_id));
    }

    public List<TicketDto> getAllTicketsByRouteDuration() {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllTicketsByRouteDuration());
    }


    public List<TicketDto> getAllTicketsByCost() {
        return ticketMapper.ticketsToDtos(ticketRepository.findAllByOrderByCost());
    }


    public List<TicketDto> getAllNotSoldTicketsByFlight(Long id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllNotSoldTicketsByFlight(id));
    }

    // прибавляется день, чтобы смотерть билеты между этими двумя датами
    public List<TicketDto> getAllNotSoldTicketsByDay(Timestamp day) {
        Timestamp startDay = day;
        Calendar c = Calendar.getInstance();
        c.setTime(startDay); // устанавливаем дату, с которой будет производить операции
        c.add(Calendar.DAY_OF_MONTH, 1); // прибавляем 1 день к установленной дате
        Timestamp endDay = new Timestamp(c.getTimeInMillis()); // получаем измененную дату

        return ticketMapper.ticketsToDtos(ticketRepository.getAllNotSoldTicketsByDay(startDay, endDay));
    }


    public List<TicketDto> getAllNotSoldTicketsByRoute(Long id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllNotSoldTicketsByRoute(id));
    }

    public List<TicketDto> getAllRefundTicketsByDay(Timestamp day) {
        Timestamp startDay = day;
        Calendar c = Calendar.getInstance();
        c.setTime(startDay); // устанавливаем дату, с которой будет производить операции
        c.add(Calendar.DAY_OF_MONTH, 1); // прибавляем 1 день к установленной дате
        Timestamp endDay = new Timestamp(c.getTimeInMillis()); // получаем измененную дату

        return ticketMapper.ticketsToDtos(ticketRepository.getAllRefundTicketsByDay(startDay, endDay));
    }

    public List<TicketDto> getAllRefundTicketsByFlight(Long id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllRefundTicketsByFlight(id));
    }


    public List<TicketDto> getAllRefundTicketsByRoute(Long id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllRefundTicketsByRoute(id));
    }

    public List<TicketDto> getAllTicketsInPeriod(Timestamp start_time, Timestamp end_time) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllTicketsInPeriod(start_time,end_time));
    }

    public List<TicketDto> getAllTicketsOnRoute(Long route_id) {
        return ticketMapper.ticketsToDtos(ticketRepository.getAllTicketsOnRoute(route_id));
    }

    public TicketDto saveTicket(TicketDto dto) {
        return ticketMapper.ticketToDto(ticketRepository.save(ticketMapper.dtoToTicket(dto)));
    }

    public ResponseEntity<TicketDto> createTicketFront(TicketFrontDto frontDto) {
        try {
            return getTicketDtoResponseEntity(frontDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ResponseEntity<TicketDto> getTicketDtoResponseEntity(TicketFrontDto frontDto) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setCost(frontDto.getCost());
        ticketDto.setTimepurchase(frontDto.getTimepurchase());
        ticketDto.setPacking(frontDto.getPacking());
        ticketDto.setReturnticket(frontDto.getReturnticket());
        ticketDto.setReturndate(frontDto.getReturndate());

        PassengerDto passengerDto = passengerService.getPassengerDtoById(frontDto.getPassengerpassport());
        ticketDto.setPassenger(passengerDto);

        FlightDto flightDto = flightService.getFlightDtoById(frontDto.getFlightnumber());
        ticketDto.setFlight(flightDto);

        Ticket ticket = ticketRepository.save(ticketMapper.dtoToTicket(ticketDto));
        TicketDto savedTicketDto = ticketMapper.ticketToDto(ticket);
        return ResponseEntity.ok(savedTicketDto);
    }
}
