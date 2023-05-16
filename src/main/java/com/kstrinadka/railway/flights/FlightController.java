package com.kstrinadka.railway.flights;

import com.kstrinadka.railway.locomotives.LocomotiveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Создать нового рейса
    @PostMapping("/create")
    public FlightDto createLocomotive(@RequestBody FlightDto dto) {
        return flightService.saveFlight(dto);
    }

    /**
     * - работает кнопка
     * - работает
     * @return - Перечень всех рейсов
     */
    @GetMapping(path = "/all")
    public List<FlightDto> getAllFlights() {
        return flightService.getAllFlights();
    }


    /*7) Получить перечень и общее число отмененных pейсов полностью, в
    указанном напpавлении, по указанному маpшpуту.*/
    /**
     * - работает кнопка
     * - работает бэк
     * @return - перечень отмененных pейсов полностью
     */
    @GetMapping(path = "/canceled")
    public List<FlightDto> getAllCanceledFlights() {
        return flightService.getAllCanceledFlights();
    }

    /**
     * - работает кнопка
     * - работает бэк
     * @return - Получить перечень отмененных pейсов в указанном напpавлении
     */
    @GetMapping(path = "/canceled/station/{final_station_id}")
    public List<FlightDto> getAllCanceledFlightsOnDirection(@PathVariable Long final_station_id) {
        return flightService.getAllCanceledFlightsOnDirection(final_station_id);
    }

    /**
     * - работает кнопка
     * - работает
     * @return - Получить перечень отмененных pейсов по указанному маpшpуту
     */
    @GetMapping(path = "/canceled/onroute/{route_id}")
    public List<FlightDto> getAllCanceledFlightsOnRoute(@PathVariable Long route_id) {
        return flightService.getAllCanceledFlightsOnRoute(route_id);
    }


    /*8) Получить перечень и общее число задеpжанных pейсов полностью, по
    указанной пpичине, по указанному маpшpуту, и количество сданных
    билетов за вpемя задеpжки.*/
    /**
     * - работает кнопка
     * - работает
     * @return - Получить перечень задеpжанных pейсов
     */
    @GetMapping(path = "/delayed")
    public List<FlightDto> getAllDelayedFlights() {
        return flightService.getAllDelayedFlights();
    }

    /**
     * - работает кнопка
     * - работает
     * @return - Получить перечень задеpжанных pейсов по указанной пpичине --> 'Авария', 'Поломка', 'Непогода', 'По расписанию'
     */
    @GetMapping(path = "/delayed/byreason")
    public List<FlightDto> getAllDelayedFlightsByReason(@RequestParam String reason) {
        return flightService.getAllDelayedFlightsByReason(reason);
    }

    /**
     * - работает кнопка
     * - работает
     * @return - Получить перечень задеpжанных pейсов по указанному маpшpуту
     */
    @GetMapping(path = "/delayed/byroute/{route_id}")
    public List<FlightDto> getAllDelayedFlightsByRoute(@PathVariable Long route_id) {
        return flightService.getAllDelayedFlightsByRoute(route_id);
    }
}
