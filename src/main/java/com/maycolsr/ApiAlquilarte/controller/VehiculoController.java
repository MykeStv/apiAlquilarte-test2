package com.maycolsr.ApiAlquilarte.controller;

import com.maycolsr.ApiAlquilarte.model.Vehiculo;
import com.maycolsr.ApiAlquilarte.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos") //ruta url de acceso
@CrossOrigin("*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehiculo> getVehiculos(){
        return this.vehiculoService.getVehiculos();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    //@PathVariable puede o no tener el ("id"), igual funciona
    public Vehiculo getVehiculo(@PathVariable("id") Integer id) {
        //Vehiculo vehiculo = this.vehiculoService.getVehiculo(id);
        //return vehiculo;
        return this.vehiculoService.getVehiculo(id);
    }

    //POST para agregar
    @RequestMapping(method = RequestMethod.POST)
    public Vehiculo addVehiculo(@RequestBody Vehiculo vehiculo) {
        return this.vehiculoService.addVehiculo(vehiculo);
    }

    //PUT para actualizar
    @RequestMapping(method = RequestMethod.PUT)
    public Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo){
        return this.vehiculoService.updateVehiculo(vehiculo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Integer id) {
        this.vehiculoService.deliteVehiculo(id);
        return ResponseEntity.ok(null);
    }
}
