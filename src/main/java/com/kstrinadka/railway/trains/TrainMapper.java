package com.kstrinadka.railway.trains;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrainMapper {

    // сущность -> DTO
    @Mapping(target = "locomotiveid", source = "locomotive.locomotiveid")
    TrainDto trainToDto(Train train);
    List<TrainDto> trainsToDtos(List<Train> trains);


    // DTO -> сущность
    @Mapping(target = "locomotive.locomotiveid", source = "locomotiveid")
    Train dtoToTrain(TrainDto dto);
    List<Train> dtosToTrains(List<TrainDto> dtos);

}
