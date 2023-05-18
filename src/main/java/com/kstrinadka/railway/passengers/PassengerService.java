package com.kstrinadka.railway.passengers;


import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class PassengerService {

    private PassengerMapper passengerMapper;
    private PassengerRepository passengerRepository;

    public PassengerService(PassengerMapper passengerMapper,
                            PassengerRepository passengerRepository) {
        this.passengerMapper = passengerMapper;
        this.passengerRepository = passengerRepository;
    }

    public List<PassengerDto> getAllPassengers() {
        return passengerMapper.passengersToDtos(passengerRepository.findAll());
    }

    public List<PassengerDto> getAllPassengersByFlight(Long id) {
        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersByFlight(id));
    }

    public List<PassengerDto> getAllPassengersByDepartureDay(Timestamp day) {
        Timestamp startDay = day;
        Calendar c = Calendar.getInstance();
        c.setTime(startDay); // устанавливаем дату, с которой будет производить операции
        c.add(Calendar.DAY_OF_MONTH, 1); // прибавляем 1 день к установленной дате
        Timestamp endDay = new Timestamp(c.getTimeInMillis()); // получаем измененную дату

        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersByDepartureDay(startDay, endDay));
    }

    public List<PassengerDto> getAllPassengersAbroadByDepartureDay(Timestamp day) {
        Timestamp startDay = day;
        Calendar c = Calendar.getInstance();
        c.setTime(startDay); // устанавливаем дату, с которой будет производить операции
        c.add(Calendar.DAY_OF_MONTH, 1); // прибавляем 1 день к установленной дате
        Timestamp endDay = new Timestamp(c.getTimeInMillis()); // получаем измененную дату

        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersAbroadByDepartureDay(startDay, endDay));
    }

    public List<PassengerDto> getAllPassengersByPackingIsTrue() {
        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersByPackingIsTrue());
    }

    public List<PassengerDto> getAllPassengersByGenderIdentity(String gender) {
        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersByGenderIdentity(gender));
    }

    public List<PassengerDto> getAllPassengersByAge() {
        return passengerMapper.passengersToDtos(passengerRepository.getAllPassengersByAge());
    }

    public PassengerDto savePassenger(PassengerDto dto) {
        Passenger passenger = passengerMapper.dtoToPassenger(dto);
        return passengerMapper.passengerToDto(passengerRepository.save(passenger));
    }

    public Passenger getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        return passenger;
    }

    public PassengerDto getPassengerDtoById(Long id) {
        return passengerMapper.passengerToDto(getPassengerById(id));
    }
}
