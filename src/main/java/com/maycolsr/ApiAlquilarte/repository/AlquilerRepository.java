package com.maycolsr.ApiAlquilarte.repository;

import com.maycolsr.ApiAlquilarte.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
}

