package com.Microservice.MicroFinanceiro.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Microservice.MicroFinanceiro.Model.NotaFiscal;
import com.Microservice.MicroFinanceiro.Model.PedidoColeta;
import com.Microservice.MicroFinanceiro.Model.enums.StatusNota;
import com.Microservice.MicroFinanceiro.Repository.NfeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NfeService {
    private final NfeRepository repository;
    private final DANFEGenerator danfeGenerator;
   
    public NotaFiscal emitirNota(PedidoColeta pedido){
        NotaFiscal nota = new NotaFiscal();
        nota.setNumero(UUID.randomUUID().toString().substring(0,8));
        nota.setDataEmissao(LocalDateTime.now());
        nota.setChaveAcesso(UUID.randomUUID().toString().replace("-", "").substring(0,44));
        nota.setStatus((StatusNota.EMITIDA));
        nota.setPedidoColeta(pedido);
        
        try {
            byte[] pdf = danfeGenerator.gerarDanfePdf(nota);
            nota.setDanfePdf(pdf);
        } catch (Exception e) {
            nota.setStatus(StatusNota.FALHA_NA_API_SEFAZ);
        }

        return repository.save(nota);
    }
    
    public NotaFiscal getNotaFiscal(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Nota Não Encontrada."));
    }

}

