package com.maycolsr.ApiAlquilarte.repository;

import com.maycolsr.ApiAlquilarte.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository<tipo de dato de la clase, tipo de dato de la PrimaryKey de la clase>
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario getByUserAndPassword(String user, String password);

}
