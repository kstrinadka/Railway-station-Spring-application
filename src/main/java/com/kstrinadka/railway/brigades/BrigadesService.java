package com.kstrinadka.railway.brigades;


import com.kstrinadka.railway.worker.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrigadesService {


    @Autowired
    BrigadeRepository brigadeRepository;

    @Autowired
    BrigadeMapper brigadeMapper;


    public BrigadesService(){

    }


    public List<Worker> getWorkersInBrigade(Integer id) {
        return null;
    }

    public Integer getCountWorkersInBrigade(Integer id) {
        return null;
    }

    public List<BrigadeDto> getAllBrigades() {
        return brigadeMapper.brigadesToDtos(brigadeRepository.findAll());
    }

    /*public List<WorkerDto> getByBrigadeId(Long id) {
        return brigadeMapper.brigadesToDtos(brigadeRepository.findAllByBrigadeid(id));
    }*/
}
