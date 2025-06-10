package com.Microservice.MicroFinanceiro.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;   


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.MicroFinanceiro.Model.NotaFiscal;
import com.Microservice.MicroFinanceiro.Model.PedidoColeta;
import com.Microservice.MicroFinanceiro.Service.NfeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NfeController {
    private final NfeService service;

    @PostMapping
    public ResponseEntity<NotaFiscal> emitirNota(@RequestBody PedidoColeta pedido){
      NotaFiscal nota = service.emitirNota(pedido);
      return ResponseEntity.ok(nota);  
    }

    @GetMapping("/{id}/danfe")
    public ResponseEntity<byte[]> downloadDanfe(@PathVariable Long id){
        NotaFiscal nota = service.getNotaFiscal(id);
        if (nota.getDanfePdf() == null)return ResponseEntity.notFound().build();
           return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=danfe_" + nota.getNumero() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(nota.getDanfePdf());
    }
}
