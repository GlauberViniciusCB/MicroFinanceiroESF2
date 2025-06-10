package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Microservice.MicroFinanceiro.Model.enums.StatusFatura;
import com.Microservice.MicroFinanceiro.Model.enums.StatusNota;

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
public class Fatura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private Cliente idCliente;
    private BigDecimal valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    
    @Enumerated(EnumType.STRING)
    private StatusFatura status;
    
    private LocalDate dataPagamento;
}
