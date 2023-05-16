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

    public Brigade getBrigadeById(Long id) {
        Brigade brigade = brigadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brigade not found"));
        return brigade;
    }

    public Integer getCountWorkersInBrigade(Integer id) {
        return null;
    }

    public List<BrigadeDto> getAllBrigades() {
        return brigadeMapper.brigadesToDtos(brigadeRepository.findAll());
    }

    public BrigadeDto createBrigade(BrigadeDto brigadeDto) {
        return brigadeMapper.brigadeToDto(brigadeRepository.save(brigadeMapper.dtoToBrigade(brigadeDto)));
    }

    public void deleteBrigade(String name) {
        Brigade brigade = brigadeRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Brigade with name " + name + " not found"));
        brigadeRepository.delete(brigade);
    }

    public BrigadeDto updateBrigade(Long id, BrigadeDto brigadeDto) {
        return null;
    }

    public BrigadeDto getBrigadeDtoById(Long brigadeid) {
        return brigadeMapper.brigadeToDto(getBrigadeById(brigadeid));
    }
}
