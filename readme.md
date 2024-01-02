# Criação do Jogo da Velha com uso de pilha para fazer verificaçoes

Este é um jogo implementado em Java, incluindo uma interface gráfica de usuário (GUI) que utiliza uma pilha para rastrear o histórico de movimentos.

## Funcionalidades

- **Jogo da Velha Funcional:** A lógica do jogo da velha está implementada na classe `JogoDavelha`. Os jogadores X e O podem fazer suas jogadas, e o jogo verifica automaticamente se houve uma vitória ou empate.

- **Interface Gráfica de Usuário (GUI):** A classe `JogoDaVelhaGUI` estende `Application` para fornecer uma interface gráfica para o jogo. A GUI é construída usando JavaFX.

- **Histórico de Movimentos com Pilha:** A classe `JogoDavelha` utiliza uma pilha (`historicoMovimentos`) para manter o histórico de movimentos dos jogadores. Cada vez que um jogador faz uma jogada, a posição é empilhada na pilha. Isso é usado para rastrear o histórico de movimentos e facilitar a verificação de vitória e empate.


## Como Jogar

1. **Iniciar o Jogo:**
   - Execute o aplicativo Java.
   - Pressione o botão "Iniciar Jogo" para começar.

2. **Fazer uma Jogada:**
   - Clique em qualquer célula do tabuleiro para fazer uma jogada.
   - Apenas jogadas válidas são permitidas (células não ocupadas).

3. **Vitória ou Empate:**
   - O jogo verifica automaticamente se há uma vitória ou empate após cada jogada, utilizando a pilha para rastrear o histórico.
   - Se houver uma vitória, um alerta será exibido indicando o vencedor.
   - Se houver um empate, um alerta será exibido indicando o empate.

4. **Reiniciar o Jogo:**
   - Após o término do jogo, clique em "Iniciar Jogo" para reiniciar.

## Estrutura do Código

- `JogoDavelha`: Lógica do jogo, incluindo verificação de vitória, empate e histórico de movimentos utilizando uma pilha.
- `Posicao`: Representa uma posição no tabuleiro.
- `JogoDaVelhaGUI`: Interface gráfica que utiliza JavaFX para interação com o usuário.


## Para Executar o Projeto

- Java Development Kit (JDK) instalado (versão 17)
- Ter o JavaFX SDK instalado

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/Tallia-Sousa/AtividadeJogoDaVelhaUsoPilha

