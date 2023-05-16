package com.kstrinadka.railway.trains;


import com.kstrinadka.railway.trains.dto.TrainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainMapper {

    // сущность -> DTO
    @Mapping(target = "locomotive", source = "locomotive")
    TrainDto trainToDto(Train train);
    List<TrainDto> trainsToDtos(List<Train> trains);


    // DTO -> сущность
    @Mapping(target = "locomotive", source = "locomotive")
    Train dtoToTrain(TrainDto dto);
    List<Train> dtosToTrains(List<TrainDto> dtos);

}
