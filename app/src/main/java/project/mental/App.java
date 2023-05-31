package project.mental;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private int currentQuestionIndex = 0;
    private String[] pertanyaan = {
        "Seperti apa perasaanmu saat ini?",
        "Apa kamu merasa percaya diri dengan semua kondisimu sekarang?",
        "Apakah Kamu Mudah Tersinggung dengan Omongan dan Respon Orang Lain Terhadapmu?",
        "Apakah perasaan cemas atau tidak nyaman di sekitar orang lain mengganggu Anda?",
        "Apakah Anda pernah merasa bahwa Anda telah dipengaruhi oleh perasaan gelisah, cemas, atau gugup?",
        "Selama 12 bulan terakhir, seberapa sering Anda merasa sendirian atau kesepian?",
        "Selama 12 bulan terakhir, seberapa sering Anda secara serius mempertimbangkan untuk mencoba bunuh diri?",
        "Selama 12 bulan terakhir, apakah Anda pernah merencanakan bagaimana Anda akan mencoba bunuh diri?",
        "Apakah Anda merasa tidak berharga atau merasa bersalah secara berlebihan?",
        "Apakah Anda sering merasa kelelahan fisik dan mental tanpa alasan yang jelas?"
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pertanyaan Mental");
        Label pertanyaanLabel = new Label(pertanyaan[currentQuestionIndex]);

        Button jawabanAButton = new Button("A. Ya");
        Button jawabanBButton = new Button("B. Tidak");
        Button jawabanCButton = new Button("C. Kadang-kadang");

    
        jawabanAButton.setOnAction(e -> {
            nextQuestion(primaryStage);
        });

        jawabanBButton.setOnAction(e -> {
            nextQuestion(primaryStage);
        });

        jawabanCButton.setOnAction(e -> {
            nextQuestion(primaryStage);
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(pertanyaanLabel, jawabanAButton, jawabanBButton, jawabanCButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void nextQuestion(Stage stage) {
        if (currentQuestionIndex < pertanyaan.length - 1) {
            currentQuestionIndex++; // Pindah ke pertanyaan berikutnya

            // Mengupdate label pertanyaan dengan pertanyaan berikutnya
            ((Label) stage.getScene().getRoot().getChildrenUnmodifiable().get(0)).setText(pertanyaan[currentQuestionIndex]);
        } else {
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
