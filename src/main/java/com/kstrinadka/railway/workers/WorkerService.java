package com.kstrinadka.railway.workers;


import com.kstrinadka.railway.brigades.BrigadesService;
import com.kstrinadka.railway.workers.dto.AdministratorDto;
import com.kstrinadka.railway.workers.dto.WorkerDto;
import com.kstrinadka.railway.workers.mappers.AdministratorMapper;
import com.kstrinadka.railway.workers.mappers.WorkerMapperMS;
import com.kstrinadka.railway.workers.model.Worker;
import com.kstrinadka.railway.workers.repositories.AdministratorRepository;
import com.kstrinadka.railway.workers.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {



    private final WorkerRepository workerRepository;
    private final AdministratorMapper administratorMapper;
    private final AdministratorRepository administratorRepository;
    private final WorkerMapperMS workerMapper;

    @Autowired
    public WorkerService(WorkerRepository workerRepository,
                         WorkerMapperMS workerMapper,
                         AdministratorRepository administratorRepository,
                         AdministratorMapper administratorMapper,
                         BrigadesService brigadesService) {
        this.workerRepository = workerRepository;
        this. workerMapper = workerMapper;
        this.administratorMapper = administratorMapper;
        this.administratorRepository = administratorRepository;
    }


    public WorkerDto getWorker(Integer id) {
        return null;
    }

    public List<WorkerDto> getAllWorkers() {
        return workerMapper.listWorkerToDtos(workerRepository.findAll());
    }


    public List<AdministratorDto> getAdministration() {
        return administratorMapper.administratorsToDtos(administratorRepository.findAll());
    }

    public List<WorkerDto> getByWorkExperience() {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByOrderByStationstartdateAsc());
    }

    public List<WorkerDto> getByDepartment(Long id) {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByDepartmentDepartmentid(id));
    }

    public List<WorkerDto> getByGenderIdentity(String gender) {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByGender(gender));
    }

    public List<WorkerDto> getByChildrenCount() {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByOrderByCountchildren());
    }

    public List<WorkerDto> getBySalary() {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByOrderBySalary());
    }

    public List<WorkerDto> getByBrigade(Long id) {
        return workerMapper.listWorkerToDtos(workerRepository.findAllByBrigadeBrigadeid(id));
    }

    public List<WorkerDto> getBrigadeWorkersByLocomotive(Long id) {
        return workerMapper.listWorkerToDtos(workerRepository.getBrigadeWorkersByLocomotive(id));
    }

    public List<WorkerDto> getLocomotiveDrivers() {
        return workerMapper.listWorkerToDtos(workerRepository.getLocomotiveDrivers());
    }

    public List<WorkerDto> getLocomotiveDriversPassedMedExamInYear(Long year) {
        return workerMapper.listWorkerToDtos(workerRepository.getLocomotiveDriversPassedMedExamInYear(year));
    }
}
