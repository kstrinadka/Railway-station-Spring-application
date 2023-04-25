package com.kstrinadka.railway.controllers;


import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;





/**
 * Стандартные запросы из задания
 */
@RestController
@RequestMapping("/default")
public class DefaulRequestsController {



    private final WorkerService workerService;

    @Autowired
    public DefaulRequestsController(WorkerService workerService){
        this.workerService = workerService;
    }


    /*private final VacanciesService vacanciesService;
    private final JobDirectionService jobDirectionService;
    private final ColorService colorService;

    @Autowired
    public VacanciesController(VacanciesService vacanciesService,
                               JobDirectionService jobDirectionService,
                               ColorService colorService) {

        this.vacanciesService = vacanciesService;
        this.jobDirectionService = jobDirectionService;
        this.colorService = colorService;
    }
    }*/


    // 1) Получить перечень и общее число всех pаботников железнодорожной
    //станции, начальников отделов, pаботников указанного отдела, по стажу
    //pаботы на станции, половому пpизнаку, возpасту, пpизнаку наличия и
    //количества детей, pазмеpу заpаботной платы.

    /**
     * @return - Перечень всех pаботников железнодорожной станции
     */
    @GetMapping(path = "/allworkers")
    public List<WorkerDto> getAllWorkers() {
        return workerService.getAllWorkers();
    }


}
