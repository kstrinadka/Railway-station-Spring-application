package com.kstrinadka.railway.brigades;


import com.kstrinadka.railway.workers.mappers.DepartmentMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class},
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BrigadeMapper {

    // сущность -> DTO
    @Mapping(target = "departmentid", source = "department.departmentid")
    BrigadeDto brigadeToDto(Brigade brigade);

    List<BrigadeDto> brigadesToDtos(List<Brigade> brigades);

    // DTO -> сущность
    @Mapping(target = "department.departmentid", source = "departmentid")
    Brigade dtoToBrigade(BrigadeDto dto);
    List<Brigade> dtosToBrigades(List<BrigadeDto> dtos);
}
