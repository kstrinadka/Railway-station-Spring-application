package com.kstrinadka.railway.workers.mappers;

import com.kstrinadka.railway.brigades.BrigadeMapper;
import com.kstrinadka.railway.workers.dto.WorkerDto;
import com.kstrinadka.railway.workers.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, BrigadeMapper.class},
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface WorkerMapperMS {

    // сущность -> DTO
    @Mapping(target = "department", source = "department")
    @Mapping(target = "brigade", source = "brigade")
    WorkerDto workerToDto(Worker worker);
    List<WorkerDto> listWorkerToDtos(List<Worker> workers);

    // DTO -> сущность
    @Mapping(target = "department", source = "department")
    @Mapping(target = "brigade", source = "brigade")
    Worker DtoToWorker(WorkerDto workerDto);
    List<Worker> listWorkerDtosToWorkers(List<WorkerDto> workerDtos);

}
