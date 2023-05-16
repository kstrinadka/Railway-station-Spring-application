package com.kstrinadka.railway.flights;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    public FlightService(FlightMapper flightMapper,
                         FlightRepository flightRepository) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
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
}
