package com.Microservice.MicroFinanceiro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.MicroFinanceiro.Model.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura,Long> {
    List<Fatura> findAllByClientes(Long idCliente);
}
