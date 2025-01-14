package com.example.lanchonete;

public class Pagamento {
    double calcularDesconto(double valorTotal, String formaDePagamento) {
        if (formaDePagamento.equals("dinheiro") || formaDePagamento.equals("pix")) {
            return valorTotal * 0.05;
        }
        return 0.0;
    }

    double calcularAcrescimo(double valorTotal, String formaDePagamento) {
        if (formaDePagamento.equals("credito")) {
            return valorTotal * 0.03;
        }
        return 0.0;
    }

    boolean formaDePagamentoValida(String formaDePagamento) {
        return formaDePagamento.equals("dinheiro") || formaDePagamento.equals("pix")
                || formaDePagamento.equals("debito") || formaDePagamento.equals("credito");
    }
}
