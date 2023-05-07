package com.kstrinadka.railway.workers.mappers;


import com.kstrinadka.railway.workers.dto.AdministratorDto;
import com.kstrinadka.railway.workers.model.Administrator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WorkerMapperMS.class, DepartmentMapper.class},
        unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdministratorMapper {

    // сущность -> DTO
    // Worker маппится в adminid (Worker -> Long) , непрорядок
    @Mapping(target = "adminid", source = "pk.worker.workerId")
    @Mapping(target = "hisdepartmentid", source = "pk.department.departmentid")
    AdministratorDto administratorToDto(Administrator administrator);
    List<AdministratorDto> administratorsToDtos(List<Administrator> administrators);

    // DTO -> сущность
    @Mapping(target = "pk.worker.workerId", source = "adminid")
    @Mapping(target = "pk.department.departmentid", source = "hisdepartmentid")
    Administrator dtoToAdministrator(AdministratorDto dto);
    List<Administrator> dtosToAdministrators(List<AdministratorDto> dtos);

}
