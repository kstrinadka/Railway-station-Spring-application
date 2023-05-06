package com.kstrinadka.railway.trains;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {




    private TrainRepository trainRepository;
    private TrainMapper trainMapper;

    public TrainService(TrainRepository trainRepository,
                        TrainMapper trainMapper) {
        this.trainRepository = trainRepository;
        this.trainMapper = trainMapper;
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
}
