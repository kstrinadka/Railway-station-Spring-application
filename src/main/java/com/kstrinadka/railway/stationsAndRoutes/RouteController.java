package com.kstrinadka.railway.stationsAndRoutes;


import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/routes")
public class RouteController {


    @Autowired
    RouteService routeService;


    /**
     * - нет кнопки
     * - работает
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
     * - работает
     *
     * -- Получить перечень маршрутов указанной категоpии
     */
    @GetMapping(path = "/category")
    public List<RouteDto> getAllRoutesByCategory(@RequestParam String category) {
        return routeService.getAllRoutesByCategory(category);
    }

    /**
     * - нет кнопки
     * - работает
     *
     * -- Получить перечень маршрутов следующих в определенном напpавлении
     */
    @GetMapping(path = "/direction")
    public List<RouteDto> getAllRoutesByDirection(@RequestParam String direction) {
        return routeService.getAllRoutesByDirection(direction);
    }

}
