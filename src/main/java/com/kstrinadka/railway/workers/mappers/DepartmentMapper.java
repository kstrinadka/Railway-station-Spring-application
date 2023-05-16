package com.kstrinadka.railway.workers.mappers;


import com.kstrinadka.railway.workers.dto.DepartmentDto;
import com.kstrinadka.railway.workers.model.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    // сущность -> DTO

    DepartmentDto departmentToDto(Department department);
    List<DepartmentDto> departmentsToDtos(List<Department> departments);

    // DTO -> сущность
    Department dtoToDepartment(DepartmentDto dto);
    List<Department> dtosToDepartments(List<DepartmentDto> dtos);
}
