package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class RelatorioDespesas {
    private YearMonth mes;
    private List<Despesa> despesas;
    private BigDecimal total;
}
