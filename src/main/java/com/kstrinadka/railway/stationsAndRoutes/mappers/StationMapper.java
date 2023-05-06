package com.kstrinadka.railway.stationsAndRoutes.mappers;



import com.kstrinadka.railway.stationsAndRoutes.dto.StationDto;
import com.kstrinadka.railway.stationsAndRoutes.model.Station;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StationMapper {

    // сущность -> DTO
    StationDto stationToDto(Station station);
    List<StationDto> stationsToDtos(List<Station> stations);

    // DTO -> сущность
    Station dtoToStation(StationDto dto);
    List<Station> dtosToStations(List<StationDto> dtos);

}
