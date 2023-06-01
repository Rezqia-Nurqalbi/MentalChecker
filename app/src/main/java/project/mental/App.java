package project.mental;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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


        Image image = new Image(getClass().getResource("/scene1.png").toString());
        ImageView bgscene1 = new ImageView(image);
        bgscene1.setFitWidth(600);
        bgscene1.setFitHeight(400);

        Label title = new Label("Selamat Datang");
        title.setFont(Font.font("ELEPHANT", 25));
        Button startButton = new Button("Mulai");
        startButton.getStyleClass().add("custom-btnstart");
        startButton.setOnAction(e -> showNameInputScene());



        VBox layout1 = new VBox(15);
        layout1.getChildren().addAll(title, bgscene1,startButton);
        layout1.setAlignment(Pos.CENTER);
        layout1.getStyleClass().add("custom-padding1");
        layout1.setStyle("-fx-padding:100px");

        Scene scene = new Scene(layout1, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
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

        Image image = new Image(getClass().getResource("/scene2.png").toString());
        ImageView bguname = new ImageView(image);
        bguname.setFitWidth(500);
        bguname.setFitHeight(400);

        VBox scene2 = new VBox(10);
        scene2.setAlignment(Pos.CENTER);
        scene2.getChildren().addAll(bguname,nameLabel, nameField, nextButton);
        scene2.getStyleClass().add("custom-scene2");

        Scene scene = new Scene(scene2, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
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