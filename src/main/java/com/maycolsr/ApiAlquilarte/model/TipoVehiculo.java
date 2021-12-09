package com.maycolsr.ApiAlquilarte.model;


import javax.persistence.*;

//Tabla MySQL
@Entity
@Table(name = "tipovehiculo") //nombre de la tabla
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;


    //GETTER && SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
