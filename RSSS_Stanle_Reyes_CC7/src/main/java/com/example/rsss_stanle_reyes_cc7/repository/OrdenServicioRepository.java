package com.example.rsss_stanle_reyes_cc7.repository;

import com.example.rsss_stanle_reyes_cc7.model.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
}
