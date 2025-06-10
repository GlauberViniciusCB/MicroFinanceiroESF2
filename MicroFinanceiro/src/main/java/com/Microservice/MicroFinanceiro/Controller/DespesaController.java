package com.Microservice.MicroFinanceiro.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.MicroFinanceiro.Model.Despesa;
import com.Microservice.MicroFinanceiro.Repository.DespesaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaRepository repository;

@PostMapping 
public ResponseEntity<Despesa> criar(@RequestBody @Valid Despesa despesa){
    return ResponseEntity.ok(repository.save(despesa));
}

@GetMapping("/mensal")
public List <Despesa> relatorioMensal(@RequestParam int ano, @RequestParam int mes){
    LocalDate inicio = LocalDate.of(ano,mes,1);
    LocalDate fim = inicio.withDayOfMonth(inicio.lengthOfMonth());
    return repository.findAllByDataBetween(inicio, fim);
}

}
