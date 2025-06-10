package com.Microservice.MicroFinanceiro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.MicroFinanceiro.Model.NotaFiscal;

public interface NfeRepository extends JpaRepository<NotaFiscal,Long> {
    
}
