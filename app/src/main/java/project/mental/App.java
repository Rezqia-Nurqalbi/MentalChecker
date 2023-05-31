package project.mental;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private String name;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showStartScene();
    }

    private void showStartScene() {
        primaryStage.setTitle("Mental Checker");

        Button startButton = new Button("Mulai");
        startButton.setOnAction(e -> showNameInputScene());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(startButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showNameInputScene() {
        Label nameLabel = new Label("Masukkan nama Anda:");
        TextField nameField = new TextField();
        Button nextButton = new Button("Selanjutnya");
        nextButton.setOnAction(e -> {
            name = nameField.getText();
            showMenuScene();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(nameLabel, nameField, nextButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMenuScene() {
        Label menuLabel = new Label("Pilih menu:");
        Button mentalCheckerButton = new Button("Mental Checker");
        mentalCheckerButton.setOnAction(e -> showMentalCheckerScene());
        Button tekaTekiButton = new Button("Teka-Teki");
        tekaTekiButton.setOnAction(e -> showTekaTekiScene());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(menuLabel, mentalCheckerButton, tekaTekiButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }

    private void showMentalCheckerScene() {
        // Kode Anda untuk tampilan pertanyaan dan pilihan jawaban Mental Checker
    }

    private void showTekaTekiScene() {
        // Kode Anda untuk tampilan teka-teki
    }

    private void showResultScene(String result) {
        Label resultLabel = new Label("Hasil: " + result);
        Button closeButton = new Button("Tutup");
        closeButton.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(resultLabel, closeButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}