package com.kstrinadka.railway.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/passengers")
public class PassengerController {


    @Autowired
    private PassengerService passengerService;



    /**
     * - кнопка работает
     * - работает
     * @return - Перечень всех пассажирова
     */
    @GetMapping(path = "/all")
    public List<PassengerDto> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // Создать нового пассажира
    @PostMapping("/create")
    public PassengerDto createPassenger(@RequestBody PassengerDto dto) {
        return passengerService.savePassenger(dto);
    }


    /*11) Получить перечень и общее число пассажиpов на указанном pейсе,
    уехавших в указанный день, уехавших за гpаницу в указанный день, по
    пpизнаку сдачи вещей в багажное отделение, по половому пpизнаку, по
    возpасту.*/


    /**
     * - кнопка работает
     * - работает
     * -- Получить перечень пассажиpов на указанном pейсе
     */
    @GetMapping(path = "/byflight/{id}")
    public List<PassengerDto> getAllPassengersByFlight(@PathVariable Long id) {
        return passengerService.getAllPassengersByFlight(id);
    }

    /**
     * - кнопка работает
     * - работает
     * -- Получить перечень пассажиpов уехавших в указанный день
     */
    @GetMapping(path = "/bydepartureday")
    public List<PassengerDto> getAllPassengersByDepartureDay(@RequestParam Timestamp  day) {
        return passengerService.getAllPassengersByDepartureDay(day);
    }

    /**
     * - кнопка работает
     * - работает
     * -- Получить перечень пассажиpов уехавших за границу в указанный день
     */
    @GetMapping(path = "/bydepartureday/abroad")
    public List<PassengerDto> getAllPassengersAbroadByDepartureDay(@RequestParam  Timestamp  day) {
        return passengerService.getAllPassengersAbroadByDepartureDay(day);
    }

    /**
     * - кнопка работает
     * - работает
     * Перечень всех пассажиров по пpизнаку сдачи вещей в багажное отделение
     */
    @GetMapping(path = "/packing/true")
    public List<PassengerDto> getAllPassengersByPackingIsTrue() {
        return passengerService.getAllPassengersByPackingIsTrue();
    }

    /**
     * - кнопка работает
     * - работает
     * Перечень всех пассажирова по половому пpизнаку
     */
    @GetMapping(path = "/gender")
    public List<PassengerDto> getAllPassengersByGenderIdentity(@RequestParam String gender) {
        return passengerService.getAllPassengersByGenderIdentity(gender);
    }

    /**
     * - кнопка работает
     * - работает
     * Перечень всех пассажирова по возрасту
     */
    @GetMapping(path = "/byage")
    public List<PassengerDto> getAllPassengersByAge() {
        return passengerService.getAllPassengersByAge();
    }

}
