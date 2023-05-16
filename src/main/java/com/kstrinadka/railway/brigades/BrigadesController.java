package com.kstrinadka.railway.brigades;


import com.kstrinadka.railway.workers.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/brigades")
public class BrigadesController {

    private final BrigadesService brigadesService;
    //private final LocomotiveService locomotiveService;

    @Autowired
    public BrigadesController(BrigadesService brigadesService) {
        this.brigadesService = brigadesService;
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


    // Создать новую бригаду
    @PostMapping("/create")
    public BrigadeDto createBrigade(@RequestBody BrigadeDto brigadeDto) {
        return brigadesService.createBrigade(brigadeDto);
    }

    // Обновить работника по id
    @PutMapping("/update/{id}")
    public BrigadeDto updateBrigade(@PathVariable Long id, @RequestBody BrigadeDto brigadeDto) {
        return brigadesService.updateBrigade(id, brigadeDto);
    }

    // Удалить бригаду по уникальному имени
    @DeleteMapping("/delete")
    public void deleteBrigade(@RequestParam  String name) {
        brigadesService.deleteBrigade(name);
    }

}
