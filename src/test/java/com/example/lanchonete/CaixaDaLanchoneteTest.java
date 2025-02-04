package com.example.lanchonete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CaixaDaLanchoneteTest {

    @Test
    void pedidoVazioRetornaMensagem() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Não há itens no carrinho de compra", caixa.calcularValorDaCompra("", "dinheiro"));
    }

    @Test
    void pedidoComItemInvalidoRetornaMensagem() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Item não encontrado no cardápio: chocolate",
                caixa.calcularValorDaCompra("cafe,chocolate", "dinheiro"));
    }

    @Test
    void pedidoComPixAplicaDesconto() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Valor total da compra: R$ 2,85", caixa.calcularValorDaCompra("cafe", "pix"));
    }

    @Test
    void pedidoComFormaPagamentoInvalida() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Forma de pagamento inválida", caixa.calcularValorDaCompra("cafe", "cheque"));
    }

    @Test
    void pedidoComVariosItensComPix() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Valor total da compra: R$ 12,07", caixa.calcularValorDaCompra("suco,sanduiche", "pix"));
    }

    @Test
    void pedidoComVariosItensComCredito() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Valor total da compra: R$ 13,08", caixa.calcularValorDaCompra("suco,sanduiche", "credito"));
    }

    @Test
    void pedidoComItemExtraSemPrincipalRetornaMensagem() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Item extra não pode ser pedido sem o principal",
                caixa.calcularValorDaCompra("chantily", "dinheiro"));
    }

    @Test
    void pedidoComPrincipalEExtraValido() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Valor total da compra: R$ 4,50",
                caixa.calcularValorDaCompra("cafe,chantily", "debito"));
    }

    @Test
    void pedidoComComboNaoValidaItemExtra() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Item extra não pode ser pedido sem o principal",
                caixa.calcularValorDaCompra("combo1,chantily", "dinheiro"));
    }

    @Test
    void pedidoComMultiplosExtrasEPrincipalValido() {
        CaixaDaLanchonete caixa = new CaixaDaLanchonete();
        assertEquals("Valor total da compra: R$ 6,00",
                caixa.calcularValorDaCompra("cafe,chantily,chantily", "debito"));
    }
}
