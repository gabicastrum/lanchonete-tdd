package com.example.lanchonete;

import java.util.HashMap;
import java.util.Map;

public class CaixaDaLanchonete {
    private Map<String, Double> cardapio;
    private Pagamento pagamento;

    public CaixaDaLanchonete() {
        cardapio = new HashMap<>();
        pagamento = new Pagamento();
        cardapio.put("cafe", 3.0);
        cardapio.put("chantily", 1.5);
        cardapio.put("suco", 6.2);
        cardapio.put("sanduiche", 6.5);
        cardapio.put("queijo", 2.0);
        cardapio.put("salgado", 7.25);
        cardapio.put("combo1", 9.5);
        cardapio.put("combo2", 7.5);

    }

    public String calcularValorDaCompra(String itens, String formaDePagamento) {
        if (itens == null || itens.isEmpty()) {
            return "Não há itens no carrinho de compra";
        }
        String[] itensDoPedido = itens.split(",");
        double valorTotal = 0.0;

        for (String item : itensDoPedido) {
            item = item.trim();
            if (!cardapio.containsKey(item)) {
                return "Item não encontrado no cardápio: " + item;
            }
            valorTotal += cardapio.get(item);
        }

        if (!pagamento.formaDePagamentoValida(formaDePagamento)) {
            return "Forma de pagamento inválida";
        }

        double desconto = pagamento.calcularDesconto(valorTotal, formaDePagamento);
        double acrescimo = pagamento.calcularAcrescimo(valorTotal, formaDePagamento);
        double valorFinal = valorTotal - desconto + acrescimo;

        return String.format("Valor total da compra: R$ %.2f", valorFinal).replace(".", ",");
    }
}
