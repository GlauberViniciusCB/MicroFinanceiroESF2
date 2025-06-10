package com.Microservice.MicroFinanceiro.Model;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoColeta {
    private Long id;
    private String decricao;
    private BigDecimal valor;
}
