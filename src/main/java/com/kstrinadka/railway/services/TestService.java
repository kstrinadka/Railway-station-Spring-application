package com.kstrinadka.railway.services;


import com.kstrinadka.railway.dto.TicketDto;
import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.mappers.TicketMapper;
import com.kstrinadka.railway.mappers.WorkerMapper;
import com.kstrinadka.railway.model.Ticket;
import com.kstrinadka.railway.model.Worker;
import com.kstrinadka.railway.repository.TicketRepository;
import com.kstrinadka.railway.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerMapper workerMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    public WorkerDto getWorker(Long id) {
        Worker worker = workerRepository.getReferenceById(id);
        WorkerDto workerDto = workerMapper.toDTO(worker);
        return workerDto;
    }

    public List<WorkerDto> findAllWorkers() {
        List<Worker> workers = workerRepository.findAll();
        List<WorkerDto> workerDtoList = workerMapper.toDTOList(workers);
        return workerDtoList;
    }

    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toModel(ticketDto);
        return ticketMapper.toDto(ticketRepository.save(ticket));
    }
}
