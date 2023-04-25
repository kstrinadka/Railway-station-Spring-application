package com.kstrinadka.railway.mappers;


import com.kstrinadka.railway.dto.WorkerDto;
import com.kstrinadka.railway.model.Worker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkerMapper {

    public WorkerDto toDTO(Worker worker) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setWorkerId(worker.getWorkerId());
        workerDto.setSurname(worker.getSurname());
        workerDto.setName(worker.getName());
        workerDto.setMiddlename(worker.getMiddlename());
        workerDto.setGender(worker.getGender());
        workerDto.setBirthday(worker.getBirthday());
        workerDto.setCountchildren(worker.getCountchildren());
        workerDto.setStationstartdate(worker.getStationstartdate());
        workerDto.setSalary(worker.getSalary());
        workerDto.setDepartmentid(worker.getDepartmentid());
        workerDto.setBrigadeid(worker.getBrigadeid());
        return workerDto;
    }

    public Worker toEntity(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setWorkerId(workerDto.getWorkerId());
        worker.setSurname(workerDto.getSurname());
        worker.setName(workerDto.getName());
        worker.setMiddlename(workerDto.getMiddlename());
        worker.setGender(workerDto.getGender());
        worker.setBirthday(workerDto.getBirthday());
        worker.setCountchildren(workerDto.getCountchildren());
        worker.setStationstartdate(workerDto.getStationstartdate());
        worker.setSalary(workerDto.getSalary());
        worker.setDepartmentid(workerDto.getDepartmentid());
        worker.setBrigadeid(workerDto.getBrigadeid());
        return worker;
    }

    public List<WorkerDto> toDTOList(List<Worker> userList) {
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
