package com.example.rsss_stanle_reyes_cc7.repository;

import com.example.rsss_stanle_reyes_cc7.model.Vheiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VheiculoRepository extends JpaRepository<Vheiculo, Long> {
}
