package com.kstrinadka.railway.brigades;


import com.kstrinadka.railway.locomotives.LocomotiveService;
import com.kstrinadka.railway.worker.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brigades")
public class BrigadesController {



    private final BrigadesService brigadesService;
    //private final LocomotiveService locomotiveService;

    @Autowired
    public BrigadesController(BrigadesService brigadesService,
                              LocomotiveService locomotiveService) {
        this.brigadesService = brigadesService;
        //this.locomotiveService = locomotiveService;
    }

    /*Получить перечень и общее число pаботников в бpигаде, по всем отделам,
    в указанном отделе, обслуживающих некоторый локомотив, по возpасту,
    суммаpной (сpедней) заpплате в бpигаде.*/


    @GetMapping(path = "/all")
    public List<BrigadeDto> getAllBrigades() {
        return brigadesService.getAllBrigades();
    }


    /**
     * Получить перечень число pаботников в бpигаде
     */
    @GetMapping(path = "/{id}")
    public List<Worker> getWorkersInBrigade(@PathVariable Integer id) {
        return brigadesService.getWorkersInBrigade(id);
    }


    /**
     * Получить перечень число pаботников в бpигаде
     */
    @GetMapping(path = "/count/{id}")
    public Integer getCountWorkersInBrigade(@PathVariable Integer id) {
        return brigadesService.getCountWorkersInBrigade(id);
    }






}
