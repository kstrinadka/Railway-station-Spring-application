package com.kstrinadka.railway.trains;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/trains")
public class TrainController {



    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }



    /*6) Получить перечень и общее число поездов на указанном маpшpуте, по
    длительности маршрута, по цене билета и по всем этим кpитеpиям сpазу.*/


    /**
     * - нет кнопки
     * - работает
     * @return - Перечень всех поездов
     */
    @GetMapping(path = "/all")
    public List<TrainDto> getAllTrains() {
        return trainService.getAllTrains();
    }


    /**
     * - нет кнопки
     * - работает
     * @return - Получить перечень поездов на указанном маpшpуте -> в форму циферку вводим
     */
    @GetMapping(path = "/route/{id}")
    public List<TrainDto> getAllTrainsOnRoute(@PathVariable Long id) {
        return trainService.getAllTrainsOnRoute(id);
    }


    /**
     * - нет кнопки
     * - работает\
     * @return - Получить перечень поездов по длительности маршрута -> можно отсортировать, но без поля длительности
     */
    @GetMapping(path = "/byrouteduration")
    public List<TrainDto> getAllTrainsByRouteDuration() {
        return trainService.getAllTrainsByRouteDuration();
    }


    /**
     * - нет кнопки
     * - работает\
     * @return - Получить перечень поездов по цене билета -> можно отсортировать, но без поля цены
     */
    @GetMapping(path = "/byticketcost")
    public List<TrainDto> getAllTrainsByTicketCost() {
        return trainService.getAllTrainsByTicketCost();
    }


}
