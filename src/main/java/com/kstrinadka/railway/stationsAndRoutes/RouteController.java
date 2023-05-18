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
     * - работает кнопка
     * - работает
     * @return - Перечень всех маршрутов
     */
    @GetMapping(path = "/all")
    public List<RouteDto> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    // Создать новый маршрут
    @PostMapping("/create")
    public RouteDto createRoute(@RequestBody RouteDto dto) {
        return routeService.saveRoute(dto);
    }


    /*// Создать новый маршрут
    @PostMapping("/create")
    public RouteDto createWorker(@RequestBody RouteDto routeDto) {
        return routeService.saveRoute(routeDto);
    }*/


    /*10) Получить перечень и общее число маршрутов указанной категоpии,
    следующих в определенном напpавлении.*/


    /**
     * - работает кнопка
     * - работает
     *
     * -- Получить перечень маршрутов указанной категоpии -> 'Туристический', 'Специальный', 'Внутренний', 'Международный'
     */
    @GetMapping(path = "/category")
    public List<RouteDto> getAllRoutesByCategory(@RequestParam String category) {
        return routeService.getAllRoutesByCategory(category);
    }

    /**
     * - работает кнопка
     * - работает
     *
     * -- Получить перечень маршрутов следующих в определенном напpавлении -> 'Station 4', ...
     */
    @GetMapping(path = "/direction")
    public List<RouteDto> getAllRoutesByDirection(@RequestParam String direction) {
        return routeService.getAllRoutesByDirection(direction);
    }

}
