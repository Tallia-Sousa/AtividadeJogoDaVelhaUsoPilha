module org.jogo.jogodavelhapilha {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires static lombok;

    opens org.jogo to javafx.graphics, javafx.fxml;


}