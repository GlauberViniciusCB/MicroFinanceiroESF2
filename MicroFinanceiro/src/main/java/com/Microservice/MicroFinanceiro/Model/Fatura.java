package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Fatura {
    private Long id;
    private Cliente Cliente;
    private BigDecimal valor;
    private LocalDate vencimento;
    private boolean paga;
    private String linkBoleto;

}
