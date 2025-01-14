package com.example.lanchonete;

import java.util.HashMap;
import java.util.Map;

public class CaixaDaLanchonete {
    private Cardapio cardapio;
    private Pagamento pagamento;

    public CaixaDaLanchonete() {
        this.cardapio = new Cardapio();
        this.pagamento = new Pagamento();
    }

    public String calcularValorDaCompra(String itens, String formaDePagamento) {
        if (itens == null || itens.isEmpty()) {
            return "Não há itens no carrinho de compra";
        }

        String[] itensDoPedido = itens.split(",");
        Map<String, Integer> contagemItens = new HashMap<>();
        double valorTotal = 0.0;
        boolean possuiPrincipalCafe = false;
        boolean possuiPrincipalSanduiche = false;

        for (String item : itensDoPedido) {
            item = item.trim();

            if (!cardapio.contemItem(item)) {
                return "Item não encontrado no cardápio: " + item;
            }

            contagemItens.put(item, contagemItens.getOrDefault(item, 0) + 1);

            if (item.equals("cafe")) {
                possuiPrincipalCafe = true;
            }

            if (item.equals("sanduiche")) {
                possuiPrincipalSanduiche = true;
            }

            valorTotal += cardapio.getItem(item).getValor();
        }

        // Validações de itens extras
        if (contagemItens.containsKey("chantily") && !possuiPrincipalCafe) {
            return "Item extra não pode ser pedido sem o principal";
        }

        if (contagemItens.containsKey("queijo") && !possuiPrincipalSanduiche) {
            return "Item extra não pode ser pedido sem o principal";
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