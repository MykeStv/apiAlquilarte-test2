package com.maycolsr.ApiAlquilarte.service;

import com.maycolsr.ApiAlquilarte.model.Alquiler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlquilerService {

    Alquiler addAlquiler(Alquiler alquiler);
    List<Alquiler> getAlquileres();
    Alquiler getAlquiler(Integer id);
}
