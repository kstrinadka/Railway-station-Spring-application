package com.kstrinadka.railway.stationsAndRoutes.mappers;


import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import com.kstrinadka.railway.stationsAndRoutes.model.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RouteMapper {

    // сущность -> DTO
    RouteDto routeToDto(Route route);
    List<RouteDto> routesToDtos(List<Route> routes);


    // DTO -> сущность
    Route dtoToRoute(RouteDto dto);
    List<Route> dtosToRoutes(List<RouteDto> dtos);

}
