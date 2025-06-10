package com.Microservice.MicroFinanceiro.Model;

import java.time.LocalDateTime;

import com.Microservice.MicroFinanceiro.Model.enums.StatusNota;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaFiscal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;


    private LocalDateTime dataEmissao;

    private String chaveAcesso;

    @Enumerated(EnumType.STRING)
    private StatusNota status;

    @Lob
    private byte [] danfePdf;

    @Embedded
    private PedidoColeta pedidoColeta;

}
