# Caixa da Lanchonete
Construa a lógica que calcula o valor de uma compra de acordo com o cardápio, regras e descontos da Lanchonete.
## Cardápio
  | codigo    | descrição                   | valor   |
  |-----------|-----------------------------|---------|
  | cafe      | Café                        | R$ 3,00 |
  | chantily  | Chantily (extra do Café)    | R$ 1,50 |
  | suco      | Suco Natural                | R$ 6,20 |
  | sanduiche | Sanduíche                   | R$ 6,50 |
  | queijo    | Queijo (extra do Sanduíche) | R$ 2,00 |
  | salgado   | Salgado                     | R$ 7,25 |
  | combo1    | 1 Suco e 1 Sanduíche        | R$ 9,50 |
  | combo2    | 1 Café e 1 Sanduíche        | R$ 7,50 |
## Formas de pagamento
Atualmente a Lanchonete aceita as seguintes formas de pagamento:
 - pix
 - dinheiro
 - debito
 - credito
## Descontos e Taxas:
 - Pagamento em pix ou dinheiro tem 5% de desconto
 - Pagamento a crédito tem acréscimo de 3% no valor total
## Outras regras:
- É possível pedir uma lista de itens.
- Caso item extra seja informado num pedido que não tenha o respectivo item principal, apresentar mensagem "Item extra não pode ser pedido sem o principal".
- Combos não são considerados como item principal.
- É possível pedir mais de um item extra sem precisar de mais de um principal.
- Se não forem pedidos itens, apresentar mensagem "Não há itens no carrinho de compra"
- Se a quantidade de itens for zero, apresentar mensagem "Quantidade inválida".
- Se o código do item não existir, apresentar mensagem "Item inválido"
- Se a forma de pagamento não existir, apresentar mensagem "Forma de pagamento inválida"
## OUPUTS
O valor da compra deve ser formatado com `R$` e decimais separados por vírgula.
Dica: Para padronizar a quantidade de decimais, utilize o método `toFixed` do JavaScript. Esse método serve o propósito deste desafio, porém na vida real a regra de arredondamento deve ser conferida! Para saber mais consulte a [Documentação do Number](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/toFixed).