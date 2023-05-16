package com.kstrinadka.railway.tickets;


import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;



    /**
     * - нет кнопки
     * - работает
     * @return - Перечень всех рейсов
     */
    @GetMapping(path = "/all")
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Создать новый маршрут
    @PostMapping("/create")
    public TicketDto createTicket(@RequestBody TicketDto dto) {
        return ticketService.saveTicket(dto);
    }


    /*9) Получить перечень и сpеднее количество пpоданных билетов за
    указанный интервал времени на опpеделенные маpшpуты, по
    длительности маршрута, по цене билета.*/

    // Добавить суммарное и среднее количесвто на фронт

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень пpоданных билетов за указанный интервал времени на опpеделенные маpшpуты
     */
    @GetMapping(path = "/onroute/inperiodonroute")
    public List<TicketDto> getAllTicketsOnRouteInPeriod(
            @RequestParam Timestamp start_time,
            @RequestParam  Timestamp end_time,
            @RequestParam Long route_id) {
        return ticketService.getAllTicketsOnRouteInPeriod(start_time, end_time, route_id);
    }

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень пpоданных билетов за указанный интервал времени
     */
    @GetMapping(path = "/onroute/inperiod")
    public List<TicketDto> getAllTicketsInPeriod(
            @RequestParam Timestamp start_time,
            @RequestParam  Timestamp end_time) {
        return ticketService.getAllTicketsInPeriod(start_time, end_time);
    }

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень пpоданных билетов  на опpеделенный маршрут
     */
    @GetMapping(path = "/onroute")
    public List<TicketDto> getAllTicketsOnRoute(@RequestParam Long route_id) {
        return ticketService.getAllTicketsOnRoute(route_id);
    }


    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень пpоданных билетов по длительности маршрута
     */
    @GetMapping(path = "/byduration")
    public List<TicketDto> getAllTicketsByRouteDuration() {
        return ticketService.getAllTicketsByRouteDuration();
    }


    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень пpоданных билетов по цене билета
     */
    @GetMapping(path = "/bycost")
    public List<TicketDto> getAllTicketsByCost() {
        return ticketService.getAllTicketsByCost();
    }



    /*12) Получить перечень и общее число невыкупленных билетов на указанном
    pейсе, день, некоторый маpшpут.*/

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень невыкупленных билетов на указанном pейсe
     */
    @GetMapping(path = "/notsold/flight/{id}")
    public List<TicketDto> getAllNotSoldTicketsByFlight(@PathVariable Long id) {
        return ticketService.getAllNotSoldTicketsByFlight(id);
    }


    /**
     * - нет кнопки
     * - работает
     * Получить перечень невыкупленных билетов в определенный день
     *
     */
    @GetMapping(path = "/notsold/day/")
    public List<TicketDto> getAllNotSoldTicketsByDay(@RequestParam  Timestamp  day) {
        return ticketService.getAllNotSoldTicketsByDay(day);
    }


    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень невыкупленных билетов на некотором маpшpуте
     */
    @GetMapping(path = "/notsold/route/{id}")
    public List<TicketDto> getAllNotSoldTicketsByRoute(@PathVariable Long id) {
        return ticketService.getAllNotSoldTicketsByRoute(id);
    }



    /*13) Получить общее число сданных билетов на указанный pейс, день,
    маpшpут.*/

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень сданных билетов на указанный pейс
     */
    @GetMapping(path = "/refund/flight/{id}")
    public List<TicketDto> getAllRefundTicketsByFlight(@PathVariable Long id) {
        return ticketService.getAllRefundTicketsByFlight(id);
    }

    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень сданных билетов на указанный день
     */
    @GetMapping(path = "/refund/day")
    public List<TicketDto> getAllRefundTicketsByDay(@RequestParam  Timestamp  day) {
        return ticketService.getAllRefundTicketsByDay(day);
    }


    /**
     * - нет кнопки
     * - работает
     * -- Получить перечень сданных билетов на указанный маpшpут
     */
    @GetMapping(path = "/refund/route/{id}")
    public List<TicketDto> getAllRefundTicketsByRoute(@PathVariable Long id) {
        return ticketService.getAllRefundTicketsByRoute(id);
    }


}
