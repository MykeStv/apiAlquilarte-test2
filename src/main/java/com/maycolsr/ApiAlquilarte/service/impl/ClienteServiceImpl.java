package com.maycolsr.ApiAlquilarte.service.impl;


import com.maycolsr.ApiAlquilarte.model.Cliente;
import com.maycolsr.ApiAlquilarte.repository.ClienteRepository;
import com.maycolsr.ApiAlquilarte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //conexion con la base de datos
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente addCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Integer id) {
        //se crea un opcional del cliente, por si no se encuentra por su id
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get(); //retorna al cliente si está presente
        }
        else {
            return new Cliente();
        }
    }
}
