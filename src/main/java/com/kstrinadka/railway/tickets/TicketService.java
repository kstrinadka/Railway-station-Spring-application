package com.kstrinadka.railway.tickets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository,
                         TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
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
}
