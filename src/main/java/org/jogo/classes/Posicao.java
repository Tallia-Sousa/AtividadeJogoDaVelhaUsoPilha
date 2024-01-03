package org.jogo.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Essa classe é usada para armazenar as posições das jogadas no tabuleiro. Cada vez que um
// jogador faz uma jogada, uma nova instância de Posicao é criada
// para representar essa jogada, e essa instância é armazenada na
// pilha historicoMovimentos

public class Posicao {
    private final int linha;
    private final int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }


}
