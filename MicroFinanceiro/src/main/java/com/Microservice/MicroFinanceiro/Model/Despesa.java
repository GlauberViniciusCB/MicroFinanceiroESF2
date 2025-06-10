package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Microservice.MicroFinanceiro.Model.enums.TipoDespesa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoDespesa tipo;    
    private  LocalDate data ;
    private String descricao;
}  

