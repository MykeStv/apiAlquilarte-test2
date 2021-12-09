package com.maycolsr.ApiAlquilarte.service;

import com.maycolsr.ApiAlquilarte.model.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculoService {

    List<Vehiculo> getVehiculos();
    Vehiculo getVehiculo(Integer id);
    Vehiculo updateVehiculo(Vehiculo vehiculo);
    Vehiculo addVehiculo(Vehiculo vehiculo);
    void deliteVehiculo(Integer id);

}
