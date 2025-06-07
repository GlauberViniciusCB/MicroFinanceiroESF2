package com.Microservice.MicroFinanceiro.Model;

import java.time.LocalDateTime;

import com.Microservice.MicroFinanceiro.Model.enums.StatusNota;

public class NotaFiscal {
    private Long id;
    private String numero;
    private PedidoColeta pedidoColeta;
    private LocalDateTime dataEmissao;
    private String chaveAcesso;
    private StatusNota status;
    private byte [] danfePdf;
}
