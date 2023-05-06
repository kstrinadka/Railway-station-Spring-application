package com.kstrinadka.railway.worker.mappers;


import com.kstrinadka.railway.worker.dto.DepartmentDto;
import com.kstrinadka.railway.worker.model.Department;
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
