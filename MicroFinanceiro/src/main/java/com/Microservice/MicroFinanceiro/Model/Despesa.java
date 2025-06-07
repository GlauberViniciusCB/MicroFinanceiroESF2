package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Microservice.MicroFinanceiro.Model.enums.TipoDespesa;

public class Despesa {
    private Long id;
    private BigDecimal valor;
    private  LocalDate data ;
    private TipoDespesa tipo;
    private String descricao;
}  

