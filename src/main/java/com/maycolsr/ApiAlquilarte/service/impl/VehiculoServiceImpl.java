package com.maycolsr.ApiAlquilarte.service.impl;

import com.maycolsr.ApiAlquilarte.model.Vehiculo;
import com.maycolsr.ApiAlquilarte.repository.VehiculoRepository;
import com.maycolsr.ApiAlquilarte.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> getVehiculos() {
        return this.vehiculoRepository.findAll(); //findAll es de la interface vehiculo repository
    }

    @Override
    public Vehiculo getVehiculo(Integer id) {
        //Crea un opcional de vehiculo por si no lo encuentra con el id
        Optional<Vehiculo> vehiculo = this.vehiculoRepository.findById(id);
        if(vehiculo.isPresent()) { //si el objeto vehiculo existe entonces:
            return vehiculo.get();  //retornarlo
        }
        else {
            return new Vehiculo(); // si no está me retorna un nuevo objeto vehiculo vacio
        }
    }

    @Override
    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
        return this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        return this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void deliteVehiculo(Integer id) {
        this.vehiculoRepository.deleteById(id);
    }
}
