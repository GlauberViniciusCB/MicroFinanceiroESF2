package com.Microservice.MicroFinanceiro.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import com.Microservice.MicroFinanceiro.Model.NotaFiscal;

@Component
public class DANFEGenerator {
     public byte[] gerarDanfePdf(NotaFiscal nota) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 12);
            content.newLineAtOffset(100, 700);
            content.showText("DANFE - Documento Auxiliar da NFe");
            content.newLineAtOffset(0, -20);
            content.showText("Número: " + nota.getNumero());
            content.newLineAtOffset(0, -20);
            content.showText("Chave de Acesso: " + nota.getChaveAcesso());
            content.newLineAtOffset(0, -20);
            content.showText("Pedido: " + nota.getPedidoColeta().getDecricao());
            content.endText();

            content.close();
            document.save(baos);
            document.close();
            return baos.toByteArray();
        }
    }
}
