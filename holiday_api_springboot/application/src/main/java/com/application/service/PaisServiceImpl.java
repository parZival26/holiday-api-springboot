package com.application.service;

import com.domain.model.Pais;
import com.domain.repository.PaisRepository;
import com.domain.service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {
    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }


    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}
