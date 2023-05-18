package com.kstrinadka.railway.flights;


import com.kstrinadka.railway.flights.dto.FlightDto;
import com.kstrinadka.railway.flights.dto.FlightFrontDto;
import com.kstrinadka.railway.stationsAndRoutes.RouteService;
import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import com.kstrinadka.railway.trains.TrainService;
import com.kstrinadka.railway.trains.dto.TrainDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;
    private final TrainService trainService;
    private final RouteService routeService;

    public FlightService(FlightMapper flightMapper,
                         FlightRepository flightRepository,
                         TrainService trainService,
                         RouteService routeService) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
        this.trainService = trainService;
        this.routeService = routeService;
    }


    public Flight getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        return flight;
    }

    public FlightDto getFlightDtoById(Long id) {
        return flightMapper.flightToDto(getFlightById(id));
    }

    public List<FlightDto> getAllFlights() {
            return flightMapper.flightsToDtos(flightRepository.findAll());
    }

    public List<FlightDto> getAllCanceledFlights() {
        return flightMapper.flightsToDtos(flightRepository.findAllByCancelIsTrue());
    }

    public List<FlightDto> getAllCanceledFlightsOnDirection(Long final_station_id) {
        return flightMapper.flightsToDtos(flightRepository.getAllCanceledFlightsOnDirection(final_station_id));
    }

    public List<FlightDto> getAllCanceledFlightsOnRoute(Long route_id) {
        return flightMapper.flightsToDtos(flightRepository.getAllCanceledFlightsOnRoute(route_id));
    }

    public List<FlightDto> getAllDelayedFlights() {
        return flightMapper.flightsToDtos(flightRepository.findAllByDelayIsTrue());
    }


    public List<FlightDto> getAllDelayedFlightsByReason(String reason) {
        return flightMapper.flightsToDtos(flightRepository.getAllDelayedFlightsByReason(reason));
    }


    public List<FlightDto> getAllDelayedFlightsByRoute(Long route_id) {
        return flightMapper.flightsToDtos(flightRepository.getAllDelayedFlightsByRoute(route_id));
    }

    public FlightDto saveFlight(FlightDto dto) {
        Flight flight = flightMapper.dtoToFlight(dto);
        return flightMapper.flightToDto(flightRepository.save(flight));
    }

    /**
     * @param frontDto - поступившая с фронта дто
     * @return - ответ сервера на создание нового рейса
     */
    public ResponseEntity<FlightDto> createFlightFront(FlightFrontDto frontDto) {
        try {
            return getFlightDtoResponseEntity(frontDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ResponseEntity<FlightDto> getFlightDtoResponseEntity(FlightFrontDto frontDto) {
        FlightDto dto = new FlightDto();

        dto.setDeparture(frontDto.getDeparture());
        dto.setArrival(frontDto.getArrival());
        dto.setCancel(frontDto.getCancel());
        dto.setReasoncancellation(frontDto.getReasoncancellation());
        dto.setTimedelay(frontDto.getTimedelay());
        dto.setDelay(frontDto.getDelay());

        TrainDto trainDto = trainService.getTrainDtoById(frontDto.getTrainnumber());
        dto.setTrain(trainDto);

        RouteDto routeDto = routeService.getRouteDtoById(frontDto.getRoutenumber());
        dto.setRoute(routeDto);

        Flight flight = flightRepository.save(flightMapper.dtoToFlight(dto));
        FlightDto savedFlightDto = flightMapper.flightToDto(flight);
        return ResponseEntity.ok(savedFlightDto);
    }
}
