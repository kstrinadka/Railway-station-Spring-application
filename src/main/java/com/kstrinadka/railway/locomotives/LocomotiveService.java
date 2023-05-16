package com.kstrinadka.railway.locomotives;


import com.kstrinadka.railway.locomotives.model.Locomotive;
import com.kstrinadka.railway.workers.model.Worker;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LocomotiveService {



    private LocomotiveRepository locomotiveRepository;
    private LocomotiveMapper locomotiveMapper;


    public LocomotiveService(LocomotiveRepository locomotiveRepository,
                             LocomotiveMapper locomotiveMapper) {
        this.locomotiveRepository = locomotiveRepository;
        this.locomotiveMapper = locomotiveMapper;
    }


    public List<LocomotiveDto> getAllLocomotives() {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.findAll());
    }

    public List<LocomotiveDto> getAllLocomotiveOnStation(Long station_id) {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotiveOnStation(station_id));
    }

    public List<LocomotiveDto> getAllLocomotiveOnStationInTime(Date time) {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotiveOnStationInTime(time));
    }

    public List<LocomotiveDto> getAllLocomotivesByArrivalTime() {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotivesByArrivalTime());
    }

    public List<LocomotiveDto> getAllLocomotivesByRoutesTaken() {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.findAllByOrderByNumberofroutes());
    }


    public List<LocomotiveDto> getAllLocomotiveByRoutesBeforeFirstRepair() {
        return null;
    }

    public List<LocomotiveDto> getAllLocomotivePassedInspectionInPeriod(Timestamp start_time, Timestamp end_time) {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotivePassedInspectionInPeriod(start_time, end_time));
    }

    public List<LocomotiveDto> getAllLocomotiveRepairedInTime(Date time) {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotiveRepairedInTime(time));
    }

    public List<LocomotiveDto> getAllLocomotiveRepairedCountTimes(Long count) {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.getAllLocomotiveRepairedCountTimes(count));
    }

    public List<LocomotiveDto> getAllLocomotivesByAge() {
        return locomotiveMapper.locomotivesToDtos(locomotiveRepository.findAllByOrderByBirthday());
    }

    public LocomotiveDto saveLocomotive(LocomotiveDto locomotiveDto) {
        Locomotive locomotive = locomotiveMapper.dtoToLocomotive(locomotiveDto);
        return locomotiveMapper.locomotiveToDto(locomotiveRepository.save(locomotive));
    }

    public LocomotiveDto getLocomotiveDtoById(Long id) {
        Locomotive locomotive = locomotiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locomotive not found"));;
        return locomotiveMapper.locomotiveToDto(locomotive);
    }

    public Locomotive getLocomotiveById(Long id) {
        Locomotive locomotive = locomotiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locomotive not found"));;
        return locomotive;
    }
}
