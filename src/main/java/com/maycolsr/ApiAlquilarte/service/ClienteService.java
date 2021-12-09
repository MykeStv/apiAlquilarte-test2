package com.maycolsr.ApiAlquilarte.service;

import com.maycolsr.ApiAlquilarte.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    Cliente addCliente(Cliente cliente);
    List<Cliente> getClientes();
    Cliente getCliente(Integer id);

}
