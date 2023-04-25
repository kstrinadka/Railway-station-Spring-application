package com.kstrinadka.railway.services;


import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.mappers.WorkerMapper;
import com.kstrinadka.railway.mappers.WorkerMapperMS;
import com.kstrinadka.railway.model.Worker;
import com.kstrinadka.railway.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {



    private WorkerRepository workerRepository;
    private final WorkerMapperMS workerMapper;

    @Autowired
    public WorkerService(WorkerRepository workerRepository,
                         @Qualifier("workerMapperMSImpl") WorkerMapperMS workerMapper) {
        this.workerRepository = workerRepository;
        this. workerMapper = workerMapper;
    }




    public void testFindWorker() {
        Optional<Worker> optionalWorker = workerRepository.findById(5L);
    }

    public Worker getWorker(Integer id) {
        return null;
    }

    public List<WorkerDto> getAllWorkers() {
        //List<WorkerDto> workerDtos = workerMapper.toDTOList(workerRepository.findAll());
        List<WorkerDto> mappedList = workerMapper.listWorkerToDtos(workerRepository.findAll());

        return mappedList;
    }
}
