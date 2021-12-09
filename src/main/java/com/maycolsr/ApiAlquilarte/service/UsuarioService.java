package com.maycolsr.ApiAlquilarte.service;

import com.maycolsr.ApiAlquilarte.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    Usuario login(Usuario usuario);
    Usuario registrar(Usuario usuario);
}
