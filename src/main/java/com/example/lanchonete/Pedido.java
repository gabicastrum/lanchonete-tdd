package com.example.lanchonete;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Map<String, Integer> itens = new HashMap<>();
    private Cardapio cardapio;

    public Pedido(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void adicionarItem(String codigo, int quantidade) {
        if (!cardapio.contemItem(codigo)) {
            throw new IllegalArgumentException("Item não encontrado no cardápio: " + codigo);
        }
        itens.put(codigo, itens.getOrDefault(codigo, 0) + quantidade);
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    public double calcularValorTotal() {
        return itens.entrySet().stream()
                .mapToDouble(entry -> cardapio.getItem(entry.getKey()).getValor() * entry.getValue())
                .sum();
    }

}