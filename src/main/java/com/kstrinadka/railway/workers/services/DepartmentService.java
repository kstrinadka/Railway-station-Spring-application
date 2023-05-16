package com.kstrinadka.railway.workers.services;


import com.kstrinadka.railway.workers.dto.DepartmentDto;
import com.kstrinadka.railway.workers.mappers.DepartmentMapper;
import com.kstrinadka.railway.workers.model.Department;
import com.kstrinadka.railway.workers.model.Worker;
import com.kstrinadka.railway.workers.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;


    public DepartmentService (DepartmentMapper departmentMapper,
                              DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }


    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public DepartmentDto getDepartmentDtoById(Long departmentid) {
        return departmentMapper.departmentToDto(getDepartmentById(departmentid));
    }
}
