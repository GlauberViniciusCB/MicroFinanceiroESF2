package com.Microservice.MicroFinanceiro.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Microservice.MicroFinanceiro.Model.Fatura;
import com.Microservice.MicroFinanceiro.Model.enums.StatusFatura;
import com.Microservice.MicroFinanceiro.Repository.FaturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FaturaService {

    private final FaturaRepository repository;

    public Fatura gerarFatura(Fatura fatura){
        fatura.setDataEmissao(LocalDate.now());
        fatura.setStatus(StatusFatura.ABERTA);
        return repository.save(fatura);
    }

    public List<Fatura> listarPorCliente(Long idCliente){
        return repository.findAllByClientes(idCliente);
    }

    public Fatura registrarPagamento(Long id){
        Fatura fatura = repository.findById(id).orElseThrow(()-> new RuntimeException("Fatura não Encontrada") );
        fatura.setStatus(StatusFatura.PAGA);
        fatura.setDataPagamento(LocalDate.now());
        return repository.save(fatura);
    }
    
}



// parei aqui 