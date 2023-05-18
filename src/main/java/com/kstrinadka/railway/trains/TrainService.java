package com.kstrinadka.railway.trains;


import com.kstrinadka.railway.locomotives.dto.LocomotiveDto;
import com.kstrinadka.railway.locomotives.LocomotiveService;
import com.kstrinadka.railway.trains.dto.TrainDto;
import com.kstrinadka.railway.trains.dto.TrainFrontDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private TrainRepository trainRepository;
    private TrainMapper trainMapper;
    private final LocomotiveService locomotiveService;

    public TrainService(TrainRepository trainRepository,
                        TrainMapper trainMapper,
                        LocomotiveService locomotiveService) {
        this.trainRepository = trainRepository;
        this.trainMapper = trainMapper;
        this.locomotiveService = locomotiveService;
    }

    public List<TrainDto> getAllTrains() {
        return trainMapper.trainsToDtos(trainRepository.findAll());
    }

    public List<TrainDto> getAllTrainsOnRoute(Long id) {
        return trainMapper.trainsToDtos(trainRepository.getAllTrainsOnRoute(id));
    }

    public List<TrainDto> getAllTrainsByRouteDuration() {
        return trainMapper.trainsToDtos(trainRepository.getAllTrainsByRouteDuration());
    }

    public List<TrainDto> getAllTrainsByTicketCost() {
        return trainMapper.trainsToDtos(trainRepository.getAllTrainsByTicketCost());
    }

    public TrainDto saveTrain(TrainDto dto) {
        return trainMapper.trainToDto(trainRepository.save(trainMapper.dtoToTrain(dto)));
    }

    /**
     * @param frontDto - поступившая с фронта дто
     * @return - ответ сервера на создание нового поезда
     */
    public ResponseEntity<TrainDto> createTrainFront(TrainFrontDto frontDto) {
        try {
            return getTrainDtoResponseEntity(frontDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Пытается достать локомотив, указанный при создании нового поезда
     */
    private ResponseEntity<TrainDto> getTrainDtoResponseEntity(TrainFrontDto frontDto) {
        LocomotiveDto locomotiveDto = locomotiveService.getLocomotiveDtoById(frontDto.getLocomotiveid());
        TrainDto trainDto = new TrainDto();
        trainDto.setTypetrain(frontDto.getTypetrain());
        trainDto.setLocomotive(locomotiveDto);
        Train train = trainRepository.save(trainMapper.dtoToTrain(trainDto));
        TrainDto savedTrainDto = trainMapper.trainToDto(train);
        return ResponseEntity.ok(savedTrainDto);
    }

    public Train getTrainById(Long id) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        return train;
    }

    public TrainDto getTrainDtoById(Long id) {
        return trainMapper.trainToDto(getTrainById(id));
    }
}
