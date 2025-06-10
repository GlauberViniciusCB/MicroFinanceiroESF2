package com.Microservice.MicroFinanceiro.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.MicroFinanceiro.Model.Despesa;


public interface DespesaRepository extends JpaRepository<DespesaRepository, Long> {
    List<Despesa> findAllByDataBetween(LocalDate inicio, LocalDate fim);

    Despesa save(Despesa despesa);
}
