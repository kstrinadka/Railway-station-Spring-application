package com.kstrinadka.railway.locomotives;

import com.kstrinadka.railway.locomotives.model.Locomotive;
import com.kstrinadka.railway.stationsAndRoutes.mappers.StationMapper;
import com.kstrinadka.railway.brigades.BrigadeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BrigadeMapper.class, StationMapper.class},
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LocomotiveMapper {


    // сущность -> DTO
    @Mapping(target = "stationid", source = "station.stationid")
    @Mapping(target = "locomotivebrigadeid", source = "locomotivebrigade.brigadeid")
    @Mapping(target = "repairmenbrigadeid", source = "repairmenbrigade.brigadeid")
    LocomotiveDto locomotiveToDto(Locomotive locomotive);
    List<LocomotiveDto> locomotivesToDtos(List<Locomotive> locomotives);


    // DTO -> сущность
    @Mapping(target = "station.stationid", source = "stationid")
    @Mapping(target = "locomotivebrigade.brigadeid", source = "locomotivebrigadeid")
    @Mapping(target = "repairmenbrigade.brigadeid", source = "repairmenbrigadeid")
    Locomotive dtoToLocomotive(LocomotiveDto dto);
    List<Locomotive> dtosToLocomotives(List<LocomotiveDto> dtos);

}
