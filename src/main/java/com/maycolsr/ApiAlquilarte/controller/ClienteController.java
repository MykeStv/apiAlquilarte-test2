package com.maycolsr.ApiAlquilarte.controller;


import com.maycolsr.ApiAlquilarte.model.Cliente;
import com.maycolsr.ApiAlquilarte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes") //podria modificar está ruta
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @RequestMapping(method = RequestMethod.POST)
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return this.clienteService.addCliente(cliente);
    }




}
