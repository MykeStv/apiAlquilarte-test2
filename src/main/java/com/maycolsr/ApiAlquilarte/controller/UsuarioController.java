package com.maycolsr.ApiAlquilarte.controller;

import com.maycolsr.ApiAlquilarte.filter.RequestFilter;
import com.maycolsr.ApiAlquilarte.model.Usuario;
import com.maycolsr.ApiAlquilarte.service.UsuarioService;
import com.maycolsr.ApiAlquilarte.util.UsuarioUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin("*")
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public UsuarioUtil login(@RequestBody Usuario usuario) {

        Usuario u = this.usuarioService.login(usuario); //creo un nuevo objeto

        UsuarioUtil usuarioUtil = new UsuarioUtil();
        //tomando los valores de u y almacenandolos en usuarioUtil
        usuarioUtil.setId(u.getId());
        usuarioUtil.setNombre(u.getNombre());
        usuarioUtil.setUser(u.getUser());
        usuarioUtil.setPassword(u.getPassword());
        usuarioUtil.setTipo(u.getTipo());
        //El token sera almacenado en esta variable y enviado al objeto usuarioUtil
        String token = "";

        if (u.getId() != 0) {
            long tiempo = System.currentTimeMillis(); //Captura el tiempo en milisegundos
            token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, RequestFilter.KEY)
                    .setSubject(usuarioUtil.getUser())
                    .setIssuedAt(new Date(tiempo)) //tiempo de inicio
                    .setExpiration(new Date(tiempo + 900000)) //tiempo de expiracion, 900000ms = 15 min
                    .claim("user", usuarioUtil.getUser())
                    .claim("tipo", usuarioUtil.getTipo())
                    .compact();
        }
        usuarioUtil.setToken(token); //se asigna el token obtenido

        return usuarioUtil;
    }

    @CrossOrigin("*")
    @RequestMapping(path = "/registrar", method = RequestMethod.POST)
    private Usuario addUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.registrar(usuario);
    }

}
