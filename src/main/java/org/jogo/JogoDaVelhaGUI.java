package org.jogo;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jogo.classes.JogoDavelha;

public class JogoDaVelhaGUI extends Application {

    private JogoDavelha jogoDaVelha;
    private GridPane tabuleiro;
    private boolean jogoIniciado = false;

    @Override
    public void start(Stage primaryStage) {
        jogoDaVelha = new JogoDavelha();

        primaryStage.setTitle("Jogo da Velha");


        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setStyle("-fx-background-color: #FFC0CB;");

        // Adiciona a mensagem inicial
        root.getChildren().add(mensagemInicial());

        tabuleiro = criarTabuleiro();
        root.getChildren().addAll(tabuleiro);

        // Adiciona o botão de iniciar o jogo
        Button btnIniciar = new Button("Iniciar Jogo");

       btnIniciar.setStyle("-fx-background-color: #FFD1DC;; -fx-background-radius: 1em;");

        btnIniciar.setStyle("-fx-background-color: #FFD1DC; -fx-background-radius: 20em;");

// Adiciona efeito visual quando o botão é pressionado
        btnIniciar.setOnMousePressed(event -> btnIniciar.setStyle("-fx-background-color: #FFA07A; -fx-background-radius: 20em;"));

// Remove o efeito visual quando o botão é solto
        btnIniciar.setOnMouseReleased(event -> btnIniciar.setStyle("-fx-background-color: #FFD1DC; -fx-background-radius: 20em;"));

        btnIniciar.setMinSize(120, 40);
        btnIniciar.setOnAction(event -> iniciarJogo());
        root.getChildren().add(btnIniciar);

        Scene scene = new Scene(root, 320, 450);

        primaryStage.setOnCloseRequest(event -> Platform.exit());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane criarTabuleiro() {
        GridPane tabuleiro = new GridPane();
        tabuleiro.setAlignment(Pos.CENTER);
        tabuleiro.setHgap(5);
        tabuleiro.setVgap(5);
      ;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = criarBotao(row, col);
                button.setStyle("-fx-background-color: #FFD1DC; -fx-background-radius: 1em;");
                tabuleiro.add(button, col, row);
            }
        }

        return tabuleiro;
    }

    private Button criarBotao(int row, int col) {
        Button button = new Button();
        button.setMinSize(90, 100);

        // Adiciona verificação se o jogo foi iniciado
        button.setOnAction(event -> {
            if (jogoIniciado) {
                fazerJogada(button, row, col);
            } else {
                mostrarAlerta("Jogo não iniciado", "Pressione o botão 'Iniciar Jogo' para começar.");
            }
        });

        return button;
    }

    private void fazerJogada(Button button, int row, int col) {
        if (!jogoDaVelha.terminou() && jogoDaVelha.fazerJogada(row, col)) {
            button.setText(jogoDaVelha.getJogadorAtual().name());

            if (jogoDaVelha.verificarVitoria()) {
                mostrarAlerta("Vitória!", "Jogador " + jogoDaVelha.getJogadorAtual().name() + " venceu!");
                reiniciarJogo();
            } else if (jogoDaVelha.terminou()) {
                mostrarAlerta("Empate!", "O jogo terminou em empate!");
                reiniciarJogo();
            } else {
                jogoDaVelha.alternarJogador();
//                mostrarMensagemJogadorAtual();
            }
        }
    }

    private void reiniciarJogo() {
        jogoDaVelha.reiniciar();

        // Limpar textos dos botões no tabuleiro
        for (Node node : tabuleiro.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setText("");

            }
        }

        jogoIniciado = false;
        mostrarMensagemInicial();
    }

    private void mostrarMensagemJogadorAtual() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Próximo Movimento");
        alert.setHeaderText(null);
        alert.setContentText("Vez do jogador " + jogoDaVelha.getJogadorAtual().name());
        alert.showAndWait();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void mostrarMensagemInicial() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Início do Jogo");
        alert.setHeaderText(null);
        alert.setContentText("Pressione 'Iniciar Jogo' para começar.");
        alert.showAndWait();
    }

    private VBox mensagemInicial() {
        VBox mensagemInicial = new VBox();
        mensagemInicial.setAlignment(Pos.CENTER);
        mensagemInicial.setSpacing(10);

        // Adiciona a mensagem inicial
        mensagemInicial.getChildren().add(new Text("Bem-vindo ao Jogo da Velha!"));
        mensagemInicial.getChildren().add(new Text("O Jogador X começa o jogo."));

        return mensagemInicial;
    }

    private void iniciarJogo() {
        jogoDaVelha.reiniciar();
//        mostrarMensagemJogadorAtual();
        jogoIniciado = true;

        // Limpar textos dos botões no tabuleiro
        for (Node node : tabuleiro.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setText("");
            }
        }
    }}