package com.kstrinadka.railway.mappers;


import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface WorkerMapperMS {

    // маппим сущность Worker в DTO WorkerDto
    WorkerDto workerToDto(Worker worker);
    List<WorkerDto> listWorkerToDtos(List<Worker> workers);

    // маппим DTO WorkerDto в сущность Worker
    Worker DtoToWorker(WorkerDto workerDto);
    List<Worker> listWorkerDtosToWorkers(List<WorkerDto> workerDtos);


}
