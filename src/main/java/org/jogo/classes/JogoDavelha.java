package org.jogo.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;
@Getter
@Setter

public class JogoDavelha {

    private Jogadores jogadorAtual = Jogadores.X;//um enum que armazena o jogador atual (X ou O).

    private Stack<Posicao> historicoMovimentos = new Stack<>();//pilha que mantém o histórico das posições das jogadas.
    private String[][] tabuleiro = new String[3][3]; //tabuleiro do jogo como uma matriz 3x3 de strings.
    // Armazenam os nomes dos jogadores X e O
    private String nomeJogadorX;
    private String nomeJogadorO;

//realiza uma jogada na posição especificada e atualiza o tabuleiro
    public boolean fazerJogada(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == null) {
            tabuleiro[linha][coluna] = jogadorAtual.name();
            historicoMovimentos.push(new Posicao(linha, coluna));//adiciona a jogada dos jogadores a pilha
            return true;
        }
        return false;
    }
//Usa a lista de movimentos guardados na pilha para saber se um dos jogadores ganhou o jogo.
    public boolean verificarVitoria() {
        if (historicoMovimentos.size() < 3) {
            return false; // Não há vitória se ainda não houve pelo menos 3 jogadas
        }

        Posicao ultimaJogada = historicoMovimentos.pop();
        int linha = ultimaJogada.getLinha();
        int coluna = ultimaJogada.getColuna();
        String jogador = tabuleiro[linha][coluna];

        // Verificar vitória na linha
        if (verificarLinha(linha, jogador)) {
            return true;
        }

        // Verificar vitória na coluna
        if (verificarColuna(coluna, jogador)) {
            return true;
        }

        // Verificar vitória na diagonal principal (se aplicável)
        if (linha == coluna && verificarDiagonalPrincipal(jogador)) {
            return true;
        }

        // Verificar vitória na diagonal secundária (se aplicável)
        if (linha + coluna == 2 && verificarDiagonalSecundaria(jogador)) {
            return true;
        }

        historicoMovimentos.push(ultimaJogada); // Restaurar a pilha para o estado original
        return false;
    }

    private boolean verificarLinha(int linha, String jogador) {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (!jogador.equals(tabuleiro[linha][coluna])) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarColuna(int coluna, String jogador) {
        for (int linha = 0; linha < 3; linha++) {
            if (!jogador.equals(tabuleiro[linha][coluna])) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarDiagonalPrincipal(String jogador) {
        for (int i = 0; i < 3; i++) {
            if (!jogador.equals(tabuleiro[i][i])) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarDiagonalSecundaria(String jogador) {
        for (int i = 0; i < 3; i++) {
            if (!jogador.equals(tabuleiro[i][2 - i])) {
                return false;
            }
        }
        return true;
    }

    public boolean terminou() {

        return historicoMovimentos.size() == 9 || verificarVitoria();
    }

    public void reiniciar() {
        historicoMovimentos.clear(); //limpa a pilha para reiniciar
        tabuleiro = new String[3][3];
        jogadorAtual = Jogadores.X;
    }
//alterna as vezes dos jogadores
    public void alternarJogador() {

        jogadorAtual = (jogadorAtual == Jogadores.X) ? Jogadores.O : Jogadores.X;
    }

}