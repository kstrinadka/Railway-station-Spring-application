package com.kstrinadka.railway.locomotives;


import com.kstrinadka.railway.brigades.BrigadeDto;
import com.kstrinadka.railway.brigades.BrigadesService;
import com.kstrinadka.railway.locomotives.dto.LocomotiveDto;
import com.kstrinadka.railway.locomotives.dto.LocomotiveFrontDto;
import com.kstrinadka.railway.locomotives.model.Locomotive;
import com.kstrinadka.railway.stations.StationDto;
import com.kstrinadka.railway.stations.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LocomotiveService {


    private LocomotiveRepository locomotiveRepository;
    private LocomotiveMapper locomotiveMapper;
    private final StationService stationService;
    private final BrigadesService brigadesService;


    public LocomotiveService(LocomotiveRepository locomotiveRepository,
                             LocomotiveMapper locomotiveMapper,
                             StationService stationService,
                             BrigadesService brigadesService) {
        this.locomotiveRepository = locomotiveRepository;
        this.locomotiveMapper = locomotiveMapper;
        this.stationService = stationService;
        this.brigadesService = brigadesService;
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
                .orElseThrow(() -> new RuntimeException("Locomotive not found"));
        return locomotiveMapper.locomotiveToDto(locomotive);
    }

    public Locomotive getLocomotiveById(Long id) {
        Locomotive locomotive = locomotiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locomotive not found"));
        return locomotive;
    }

    public ResponseEntity<LocomotiveDto> createLocomotiveFront(LocomotiveFrontDto frontDto) {
        try {
            return getLocomotiveDtoResponseEntity(frontDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ResponseEntity<LocomotiveDto> getLocomotiveDtoResponseEntity(LocomotiveFrontDto frontDto) {
        LocomotiveDto locomotiveDto = new LocomotiveDto();

        locomotiveDto.setBirthday(frontDto.getBirthday());
        locomotiveDto.setNumberofroutes(frontDto.getNumberofroutes());
        locomotiveDto.setSeatsnumber(frontDto.getSeatsnumber());

        StationDto stationDto = stationService.getStationDtoById(frontDto.getStationid());
        locomotiveDto.setStation(stationDto);

        BrigadeDto locomotivebrigadeDto = brigadesService.getBrigadeDtoById(frontDto.getLocomotivebrigadeid());
        locomotiveDto.setLocomotivebrigade(locomotivebrigadeDto);
        BrigadeDto repairmenbrigadeidDto = brigadesService.getBrigadeDtoById(frontDto.getRepairmenbrigadeid());
        locomotiveDto.setRepairmenbrigade(repairmenbrigadeidDto);

        Locomotive locomotive = locomotiveRepository.save(locomotiveMapper.dtoToLocomotive(locomotiveDto));
        LocomotiveDto savedDto = locomotiveMapper.locomotiveToDto(locomotive);
        return ResponseEntity.ok(savedDto);
    }
}
