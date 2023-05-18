package com.kstrinadka.railway.stations;

import org.springframework.stereotype.Service;

@Service
public class StationService {




    private final StationMapper stationMapper;
    private final StationRepository stationRepository;


    public StationService(StationMapper stationMapper,
                          StationRepository stationRepository) {
        this.stationMapper = stationMapper;
        this.stationRepository = stationRepository;
    }

    public Station getStationById(Long id) {
        Station station = stationRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Locomotive not found"));
        return station;
    }

    public StationDto getStationDtoById(Long id) {
        return stationMapper.stationToDto(getStationById(id));
    }

}
