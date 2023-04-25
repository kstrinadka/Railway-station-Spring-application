package com.kstrinadka.railway.controllers;


import com.kstrinadka.railway.model.Worker;
import com.kstrinadka.railway.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping(path = "/{id}")
    public Worker getWorker(@PathVariable Integer id) {
        return workerService.getWorker(id);
    }
}

