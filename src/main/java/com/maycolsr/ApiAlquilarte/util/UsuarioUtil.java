package com.maycolsr.ApiAlquilarte.util;

//Clase para almacenar la información del token permitiendo el acceso de usuario
public class UsuarioUtil {

    private Integer id;
    private String nombre;
    private String user;
    private String password;
    private String tipo;
    private String token;

    //CONSTRUCTORES
    public UsuarioUtil() {
    }

    public UsuarioUtil(Integer id, String nombre, String user, String password, String tipo, String token) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.tipo = tipo;
        this.token = token;
    }

    //GETTER && SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
