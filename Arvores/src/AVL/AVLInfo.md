# Árvores AVL
    - Foram criadas por Adelson-Velsky e Lands, juntando as iniciais = (AVL).
 
* Ávores AVL são ávores binárias de buscas que se alto balanceiam, a partir do fator de balanceamento de cada nó.
    - Esse fator de balanceamento é a subtração da altura da sub-árvore esquerda com a altura da sub-árvore direita de determinado nó.
    - Com isso, uma árvore binária só é considerada AVL quando todos seus nós tem fator de balanceamento igual módulo de até 1.
 
* Desbalanceamento:
    - O desbalanceamento ocorre quando o fator de balanceamento de determinado nó é menor que -1 ou maior que +1.
    - Se tal fato ocorrer, é necessário fazer ajustes, com isso será utilizado quatro métodos para balancear esta árvore:
    - RES ( Rotação esquerda simples ): Quando o nó tem fator de balanceamento menor que -1 e o fator de balanceamento da sub-árvore
    a direita é menor que zero, é realizado uma rotação esquerda simples, que consiste em: o nó desbalanceado irá virar a sub-árvore esquerda da atual sub-árvore direita e terá uma nova sub-árvore direita, que será a antiga sub-árvore esquerda do nó "pai" atual;
    - RDS ( Rotação direita simples ): Quando o nó tem fator de balanceamento maior que +1 e o fator de balanceamento da sub-árvore
    a esquerda é maior que zero, é realizado uma rotação direita simples, que consiste em: o nó desbalanceado irá virar a sub-árvore direita da atual sub-árvore esquerda e terá uma nova sub-árvore esquerda, que será a antiga sub-árvore direita do nó "pai" atual;
    - RED( Rotação esquerda dupla ): Quando o nó tem fator de balanceamento menor que -1 e o fator de balanceamento da sub-árvore direita é maior que zero, é realizado uma rotação composta ou rotação dupla, que consiste em realizar uma rotação direita simples na sub-árvore a direita e após isso uma rotação esquerda simples no nó desbalanceado;
    - RDD ( Rotação direita dupla ): Quando o nó tem fator de balanceamento maior que +1 e o fator de balanceamento da sub-árvore
  esquerda é menor que zero, é realizado uma rotação composta ou rotação dupla, que consiste em realizar uma rotação esquerda simples na sub-árvore a esquerda e após isso uma rotação direita simples no nó desbalanceado.

* Complexidade:
    - Ávores AVL tem complexidade O(log(n)) para todos os casos, em todas suas operações adicionar, buscar e remover.