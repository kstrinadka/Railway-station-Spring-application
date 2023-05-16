package com.kstrinadka.railway.workers;

import com.kstrinadka.railway.brigades.BrigadeDto;
import com.kstrinadka.railway.brigades.BrigadeMapper;
import com.kstrinadka.railway.brigades.BrigadesService;
import com.kstrinadka.railway.workers.dto.AdministratorDto;
import com.kstrinadka.railway.workers.dto.DepartmentDto;
import com.kstrinadka.railway.workers.dto.WorkerDto;
import com.kstrinadka.railway.workers.dto.WorkerFrontDto;
import com.kstrinadka.railway.workers.mappers.AdministratorMapper;
import com.kstrinadka.railway.workers.mappers.DepartmentMapper;
import com.kstrinadka.railway.workers.mappers.WorkerMapperMS;
import com.kstrinadka.railway.workers.model.Worker;
import com.kstrinadka.railway.workers.repositories.AdministratorRepository;
import com.kstrinadka.railway.workers.repositories.WorkerRepository;
import com.kstrinadka.railway.workers.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {



    private final WorkerRepository workerRepository;
    private final AdministratorMapper administratorMapper;
    private final AdministratorRepository administratorRepository;
    private final WorkerMapperMS workerMapper;
    private final DepartmentService departmentService;
    private final BrigadesService brigadesService;
    private final DepartmentMapper departmentMapper;
    private final BrigadeMapper brigadeMapper;

    @Autowired
    public WorkerService(WorkerRepository workerRepository,
                         WorkerMapperMS workerMapper,
                         AdministratorRepository administratorRepository,
                         AdministratorMapper administratorMapper,
                         BrigadesService brigadesService,
                         DepartmentService departmentService,
                         BrigadeMapper brigadeMapper,
                         DepartmentMapper departmentMapper) {
        this.workerRepository = workerRepository;
        this. workerMapper = workerMapper;
        this.administratorMapper = administratorMapper;
        this.administratorRepository = administratorRepository;
        this.departmentService = departmentService;
        this.brigadesService = brigadesService;
        this.brigadeMapper = brigadeMapper;
        this.departmentMapper = departmentMapper;
    }

    // Сохранить работника в базу данных
    public WorkerDto saveWorker(WorkerDto workerDto) {
        Worker worker = workerMapper.DtoToWorker(workerDto);
        return workerMapper.workerToDto(workerRepository.save(worker));
    }

    // Обновить работника по id в базе данных
    public WorkerDto updateWorker(Long id, WorkerDto workerDto) {
        Worker existingWorker = getWorkerById(id);
        existingWorker.setName(workerDto.getName());
        existingWorker.setSurname(workerDto.getSurname());
        existingWorker.setMiddlename(workerDto.getMiddlename());
        existingWorker.setGender(workerDto.getGender());
        existingWorker.setBirthday(workerDto.getBirthday());
        existingWorker.setCountchildren(workerDto.getCountchildren());
        existingWorker.setStationstartdate(workerDto.getStationstartdate());
        existingWorker.setSalary(workerDto.getSalary());

        existingWorker.setDepartment(departmentMapper.dtoToDepartment(workerDto.getDepartment()));
        existingWorker.setBrigade(brigadeMapper.dtoToBrigade(workerDto.getBrigade()));

        return workerMapper.workerToDto(workerRepository.save(existingWorker));
    }

    // Удалить работника по id из базы данных
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }

    public Worker getWorkerById(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
        return worker;
    }

    public WorkerDto getWorkerDtoById(Long id) {
        return workerMapper.workerToDto(getWorkerById(id));
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

    public ResponseEntity<WorkerDto> createWorkerFront(WorkerFrontDto frontDto) {
        try {
            return getWorkerDtoAndSaveResponseEntity(frontDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    /**
     * Создает сущность работника, вытаскивая вложенные сущности из БД.
     */
    private ResponseEntity<WorkerDto> getWorkerDtoAndSaveResponseEntity(WorkerFrontDto frontDto) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setSurname(frontDto.getSurname());
        workerDto.setName(frontDto.getName());
        workerDto.setMiddlename(frontDto.getMiddlename());
        workerDto.setGender(frontDto.getGender());
        workerDto.setBirthday(frontDto.getBirthday());
        workerDto.setCountchildren(frontDto.getCountchildren());
        workerDto.setStationstartdate(frontDto.getStationstartdate());
        workerDto.setSalary(frontDto.getSalary());

        BrigadeDto brigadeDto = brigadesService.getBrigadeDtoById(frontDto.getBrigadeid());
        workerDto.setBrigade(brigadeDto);
        DepartmentDto departmentDto = departmentService.getDepartmentDtoById(frontDto.getDepartmentid());
        workerDto.setDepartment(departmentDto);

        Worker worker = workerRepository.save(workerMapper.DtoToWorker(workerDto));
        WorkerDto savedWorkerDto = workerMapper.workerToDto(worker);

        return ResponseEntity.ok(savedWorkerDto);
    }
}
