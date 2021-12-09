package com.maycolsr.ApiAlquilarte.controller;

import com.maycolsr.ApiAlquilarte.model.Alquiler;
import com.maycolsr.ApiAlquilarte.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin("*")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alquiler> getAlquileres() {
        return this.alquilerService.getAlquileres();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Alquiler getAlquiler(@PathVariable("id") Integer id) {
        return this.alquilerService.getAlquiler(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Alquiler addAlquiler(@RequestBody Alquiler alquiler) {
        return this.alquilerService.addAlquiler(alquiler);
    }

}
