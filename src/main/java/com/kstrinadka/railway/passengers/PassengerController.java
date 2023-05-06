package com.kstrinadka.railway.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {


    @Autowired
    private PassengerService passengerService;




    /**
     * - нет кнопки
     * - не проверено
     * @return - Перечень всех пассажирова
     */
    @GetMapping(path = "/all")
    public List<PassengerDto> getAllPassengers() {
        return passengerService.getAllPassengers();
    }


    /*11) Получить перечень и общее число пассажиpов на указанном pейсе,
    уехавших в указанный день, уехавших за гpаницу в указанный день, по
    пpизнаку сдачи вещей в багажное отделение, по половому пpизнаку, по
    возpасту.*/


    /**
     * - нет кнопки
     * - не проверено
     * -- Получить перечень пассажиpов на указанном pейсе
     */
    @GetMapping(path = "/byflight/{id}")
    public List<PassengerDto> getAllPassengersByFlight(@PathVariable Long id) {
        return passengerService.getAllPassengersByFlight(id);
    }

    /**
     * - нет кнопки
     * - не проверено
     * -- Получить перечень пассажиpов уехавших в указанный день
     */
    @GetMapping(path = "/bydepartureday/{day}")
    public List<PassengerDto> getAllPassengersByDepartureDay(@PathVariable Timestamp day) {
        return passengerService.getAllPassengersByDepartureDay(day);
    }

    /**
     * - нет кнопки
     * - не проверено
     * -- Получить перечень пассажиpов уехавших за границу в указанный день
     */
    @GetMapping(path = "/bydepartureday/{day}")
    public List<PassengerDto> getAllPassengersAbroadByDepartureDay(@PathVariable Timestamp day) {
        return passengerService.getAllPassengersAbroadByDepartureDay(day);
    }

    /**
     * - нет кнопки
     * - не проверено
     * Перечень всех пассажирова по пpизнаку сдачи вещей в багажное отделение
     */
    @GetMapping(path = "/packing/true")
    public List<PassengerDto> getAllPassengersByPackingIsTrue() {
        return passengerService.getAllPassengersByPackingIsTrue();
    }

    /**
     * - нет кнопки
     * - не проверено
     * Перечень всех пассажирова по половому пpизнаку
     */
    @GetMapping(path = "/gender/{gender}")
    public List<PassengerDto> getAllPassengersByGenderIdentity(@PathVariable String gender) {
        return passengerService.getAllPassengersByGenderIdentity(gender);
    }

    /**
     * - нет кнопки
     * - не проверено
     * Перечень всех пассажирова по возрасту
     */
    @GetMapping(path = "/byage")
    public List<PassengerDto> getAllPassengersByAge() {
        return passengerService.getAllPassengersByAge();
    }

}
