package com.application.service;

import com.domain.model.Tipo;
import com.domain.repository.TipoRepository;
import com.domain.service.TipoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements TipoService {
    private  final TipoRepository tipoRepository;

    public TipoServiceImpl(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public Optional<Tipo> findById(Long id) {
        return  tipoRepository.findById(id);
    }

    @Override
    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }
}
