package com.Microservice.MicroFinanceiro.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.MicroFinanceiro.Model.Fatura;
import com.Microservice.MicroFinanceiro.Service.FaturaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/faturas")
@RequiredArgsConstructor
public class FaturaController {

    private final FaturaService service;

    @PostMapping
    public ResponseEntity <Fatura> gerarFatura(@RequestBody @Valid Fatura fatura){
        return ResponseEntity.ok(service.gerarFatura(fatura));
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Fatura> listarPorCliente(@PathVariable Long idCliente){
        return service.listarPorCliente(idCliente);
    }

    @PutMapping("/{id}/pagar")
    public ResponseEntity<Fatura> pagar(@PathVariable Long id){
        return ResponseEntity.ok(service.registrarPagamento(id));
    } 


}
