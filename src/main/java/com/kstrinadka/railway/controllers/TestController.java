package com.kstrinadka.railway.controllers;


import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    TestService testService;

    @GetMapping(path = "/worker/{id}")
    public WorkerDto getWorker(@PathVariable Long id) {
        return testService.getWorker(id);
    }

    @GetMapping(path = "/workers")
    public List<WorkerDto> getAllUsers() {
        List<WorkerDto> workerDtoList = testService.findAllWorkers();
        return workerDtoList;
    }

    @PostMapping("/createticket")
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        TicketDto createdTicket = testService.createTicket(ticketDto);
        return createdTicket;
    }
}
