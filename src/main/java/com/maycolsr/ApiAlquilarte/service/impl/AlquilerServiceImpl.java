package com.maycolsr.ApiAlquilarte.service.impl;

import com.maycolsr.ApiAlquilarte.model.Alquiler;
import com.maycolsr.ApiAlquilarte.repository.AlquilerRepository;
import com.maycolsr.ApiAlquilarte.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Override
    public Alquiler addAlquiler(Alquiler alquiler) {
        return this.alquilerRepository.save(alquiler);
    }

    @Override
    public List<Alquiler> getAlquileres() {
        return this.alquilerRepository.findAll();
    }

    @Override
    public Alquiler getAlquiler(Integer id) {
        Optional<Alquiler> alquiler = this.alquilerRepository.findById(id);

        if(alquiler.isPresent()) {
            return alquiler.get();
        }
        else {
            return new Alquiler();
        }

    }
}
