package com.kstrinadka.railway.brigades;

import com.kstrinadka.railway.workers.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrigadesService {

    private final BrigadeRepository brigadeRepository;
    private final BrigadeMapper brigadeMapper;

    @Autowired
    public BrigadesService(BrigadeRepository brigadeRepository,
                           BrigadeMapper brigadeMapper){
        this.brigadeMapper = brigadeMapper;
        this.brigadeRepository = brigadeRepository;
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

}
