package com.kstrinadka.railway.stationsAndRoutes;


import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import com.kstrinadka.railway.tickets.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {


    @Autowired
    RouteService routeService;


    /**
     * - нет кнопки
     * - не проверено
     * @return - Перечень всех маршрутов
     */
    @GetMapping(path = "/all")
    public List<RouteDto> getAllRoutes() {
        return routeService.getAllRoutes();
    }



    /*10) Получить перечень и общее число маршрутов указанной категоpии,
    следующих в определенном напpавлении.*/


    /**
     * - нет кнопки
     * - не проверено
     *
     * -- Получить перечень маршрутов указанной категоpии
     */
    @GetMapping(path = "/category")
    public List<RouteDto> getAllRoutesByCategory(@RequestParam String category) {
        return routeService.getAllRoutesByCategory(category);
    }

    /**
     * - нет кнопки
     * - не проверено
     *
     * -- Получить перечень маршрутов следующих в определенном напpавлении
     */
    @GetMapping(path = "/direction")
    public List<RouteDto> getAllRoutesByDirection(@RequestParam String direction) {
        return routeService.getAllRoutesByDirection(direction);
    }

}
