package com.example.lanchonete;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<String, Item> itens = new HashMap<>();

    public Cardapio() {
        itens.put("cafe", new Item("cafe", "Café", 3.0));
        itens.put("chantily", new Item("chantily", "Chantily (extra do café)", 1.5));
        itens.put("suco", new Item("suco", "Suco", 6.2));
        itens.put("sanduiche", new Item("sanduiche", "Sanduíche", 6.5));
        itens.put("queijo", new Item("queijo", "Queijo (extra do sanduíche)", 2.0));
        itens.put("salgado", new Item("salgado", "Salgado", 7.25));
        itens.put("combo1", new Item("combo1", "Combo 1", 9.5));
        itens.put("combo2", new Item("combo2", "Combo 2", 7.5));
    }

    public Item getItem(String codigo) {
        return itens.get(codigo);
    }

    public boolean contemItem(String codigo) {
        return itens.containsKey(codigo);
    }
}
