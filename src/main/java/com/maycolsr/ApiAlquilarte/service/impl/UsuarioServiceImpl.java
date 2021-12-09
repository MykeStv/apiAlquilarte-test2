package com.maycolsr.ApiAlquilarte.service.impl;

import com.maycolsr.ApiAlquilarte.model.Usuario;
import com.maycolsr.ApiAlquilarte.repository.UsuarioRepository;
import com.maycolsr.ApiAlquilarte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario login(Usuario usuario) {
        //return this.usuarioRepository.getByUserAndPassword(usuario.getUser(), usuario.getPassword());
        Usuario u = this.usuarioRepository.getByUserAndPassword(usuario.getUser(), usuario.getPassword());
        if (u != null) {
            usuario.setId(u.getId());
            usuario.setNombre(u.getNombre());
            usuario.setTipo(u.getTipo());
        }

        return usuario;
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }
}
