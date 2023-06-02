package project.mental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import project.mental.Models.UserCheck;

public class App extends Application {
    private Stage primaryStage;
    private String name;
    private Scene[] scenes;
    private Scene[]playscene;
    private int currentSceneIndex;
    UserCheck user1=new UserCheck(null);

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

    // private void showNameInputScene() {
    //     Label nameLabel = new Label("Masukkan nama Anda:");
    //     TextField nameField = new TextField();
    //     nameField.setPromptText("name");
    //     Button nextButton = new Button("Selanjutnya");
    //     nextButton.setOnAction(e -> {
    //         user1.setName(name);
    //         showMenuScene();
    //     });

    //     Image image = new Image(getClass().getResource("/scene2.png").toString());
    //     ImageView bguname = new ImageView(image);
    //     bguname.setFitWidth(500);
    //     bguname.setFitHeight(400);

    //     VBox scene2 = new VBox(10);
    //     scene2.setPrefWidth(1000);
    //     scene2.setAlignment(Pos.CENTER);
    //     scene2.getChildren().addAll(bguname,nameLabel, nameField, nextButton);
    //     scene2.getStyleClass().add("custom-scene2");

    //     Scene scene = new Scene(scene2, 1000, 600);
    //     scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }

    private void showNameInputScene() {
        Label nameLabel = new Label("Masukkan nama:");
        TextField nameField = new TextField();
        nameField.setPromptText("name");
    
        Label passwordLabel = new Label("Masukkan password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");
    
        Button nextButton = new Button("Selanjutnya");
        nextButton.setOnAction(e -> {
            String name = nameField.getText();
            String passwordText = passwordField.getText();
    
            if (!name.isEmpty() && !passwordText.isEmpty()) {
                try {
                    int password = Integer.parseInt(passwordText);
                    user1.setName(name);
                    user1.setPass(password);
                    showMenuScene();
                } catch (NumberFormatException ex) {
                    showAlert("Password harus berupa angka!");
                }
            } else {
                showAlert("Nama dan password tidak boleh kosong!");
            }
        });
    
        Image image = new Image(getClass().getResource("/scene2.png").toString());
        ImageView bguname = new ImageView(image);
        bguname.setFitWidth(500);
        bguname.setFitHeight(400);
    
        VBox scene2 = new VBox(10);
        scene2.setPrefWidth(1000);
        scene2.setAlignment(Pos.CENTER);
        scene2.getChildren().addAll(bguname, nameLabel, nameField, passwordLabel, passwordField, nextButton);
        scene2.getStyleClass().add("custom-scene2");
    
        Scene scene = new Scene(scene2, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // private void showMenuScene() {
    //     Label menuLabel = new Label("Pilih menu:");
    //     menuLabel.setFont(Font.font("ELEPHANT", 25));

    //     Button mentalCheckerButton = new Button("Mental Check");
    //     mentalCheckerButton.getStyleClass().add("custom-btnstart");
    //     mentalCheckerButton.setOnAction(e -> showMentalCheckerScene());

    //     Button tekaTekiButton = new Button("Teka-Teki");
    //     tekaTekiButton.getStyleClass().add("custom-btnstart");
    //     tekaTekiButton.setOnAction(e -> showTekaTekiScene());

    //     Image image = new Image(getClass().getResource("/menu.png").toString());
    //     ImageView bgmenu = new ImageView(image);
    //     bgmenu.setFitWidth(1000);
    //     bgmenu.setFitHeight(600);
    //     // bgmenu.setPreserveRatio(true);

    //     VBox layout = new VBox(10);
    //     layout.setAlignment(Pos.CENTER);
    //     layout.getChildren().addAll(menuLabel, mentalCheckerButton, tekaTekiButton);
    //     // layout.getStyleClass().add("custom-menu");

    //     StackPane layout2 = new StackPane(bgmenu, layout);

    //     Scene scene = new Scene(layout2, 1000, 600);
    //     scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    //     primaryStage.setScene(scene);
    // }

    private void showMenuScene() {
        Label menuLabel = new Label("Pilih menu:");
        menuLabel.setFont(Font.font("ELEPHANT", 25));
    
        Button mentalCheckerButton = new Button("Mental Check");
        mentalCheckerButton.getStyleClass().add("custom-btnstart");
        mentalCheckerButton.setOnAction(e -> showMentalCheckerScene());
    
        Button tekaTekiButton = new Button("Teka-Teki");
        tekaTekiButton.getStyleClass().add("custom-btnstart");
        tekaTekiButton.setOnAction(e -> showTekaTekiScene());
    
        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("custom-btnstart");
        backButton.setOnAction(e -> showStartScene()); // Kembali ke halaman sebelumnya
    
        Image image = new Image(getClass().getResource("/menu.png").toString());
        ImageView bgmenu = new ImageView(image);
        bgmenu.setFitWidth(1000);
        bgmenu.setFitHeight(600);
    
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(menuLabel, mentalCheckerButton, tekaTekiButton, backButton);
    
        StackPane layout2 = new StackPane(bgmenu, layout);
    
        Scene scene = new Scene(layout2, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
    }

    private void showMentalCheckerScene() {
        // Inisialisasi semua scene
        Scene scene1 = createMentalScene("1. Seperti apa perasaanmu saat ini?");
        Scene scene2 = createMentalScene("2. Apa kamu merasa percaya diri dengan semua kondisimu sekarang?");
        Scene scene3 = createMentalScene("3. Apakah Kamu Mudah Tersinggung dengan Omongan dan Respon Orang Lain Terhadapmu?");
        Scene scene4 = createMentalScene("4. Apakah perasaan cemas atau tidak nyaman di sekitar orang lain mengganggu Anda?");
        Scene scene5 = createMentalScene("5. Apakah Anda pernah merasa bahwa Anda telah dipengaruhi oleh perasaan gelisah, cemas, atau gugup?");
        Scene scene6 = createMentalScene("6.Selama 12 bulan terakhir, seberapa sering Anda merasa sendirian atau kesepian?");
        Scene scene7 = createMentalScene("7.Selama 12 bulan terakhir, seberapa sering Anda \n secara serius mempertimbangkan untuk mencoba bunuh diri?");
        Scene scene8 = createMentalScene("8.Selama 12 bulan terakhir, apakah Anda pernah merencanakan bagaimana Anda akan mencoba bunuh diri?");
        Scene scene9 = createMentalScene("9.Apakah Anda merasa tidak berharga atau merasa bersalah secara berlebihan?");
        Scene scene10 = createMentalScene("10.Apakah Anda sering merasa kelelahan fisik dan mental tanpa alasan yang jelas?");
        // Tambahkan scene lainnya di sini...

        // Simpan semua scene dalam sebuah array
        scenes = new Scene[]{scene1, scene2, scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10};
        // Tambahkan scene lainnya di sini...

        // Atur scene pertama yang akan ditampilkan
        currentSceneIndex = 0;
        primaryStage.setScene(scenes[currentSceneIndex]);
        primaryStage.show();
    }

    private Scene createMentalScene(String question) {
        Label pertanyaan=new Label(question);
        pertanyaan.setTextAlignment(TextAlignment.CENTER);
        pertanyaan.setFont(Font.font("Times New Roman", 25));
 
        
        Button yesButton = new Button("Iya");
        yesButton.getStyleClass().add("custom-btnstart");
        yesButton.setOnAction(e->{
            user1.answerA();
            nextScene();
        });
        Button smButton = new Button("Terkadang");
        smButton.getStyleClass().add("custom-btnstart");
        smButton.setOnAction(e->{
            user1.answerB();
            nextScene();
        });
        Button noButton = new Button("Tidak");
        noButton.getStyleClass().add("custom-btnstart");
        noButton.setOnAction(e->{
            user1.answerC();
            nextScene();
        });

        Image image1 = new Image(getClass().getResource("/image1.png").toString());
        ImageView bgscenemental = new ImageView(image1);
        bgscenemental.setFitWidth(1000);
        bgscenemental.setFitHeight(600);
        // bgscenemental.setPreserveRatio(true);

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(pertanyaan, yesButton, smButton, noButton);
        layout1.setAlignment(Pos.CENTER);
        // layout1.getStyleClass().add("custom-padding1");

        StackPane layout2 = new StackPane(bgscenemental, layout1);
        Scene scene = new Scene(layout2, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return scene;
    }
    private Scene show_result (){
        Label resultLabel=new Label(user1.showResult());
        Button button=new Button("Kembali ke menu utama");
        button.setOnAction(e->showMenuScene());
        Button button2=new Button("Logout");
        button2.setOnAction(e->showNameInputScene());
        HBox layou=new HBox(10);
        layou.setAlignment(Pos.CENTER);
        
        layou.getChildren().addAll(button,button2);
        
        VBox layou1=new VBox(10);
        layou1.getChildren().addAll(resultLabel,layou);
        
        return new Scene(layou1,400,400);
        
    }
    private void nextScene() {
        
        currentSceneIndex++;
        
        if (currentSceneIndex >scenes.length-1) {
            currentSceneIndex = 0;
        Scene nextScene = show_result();
        primaryStage.setScene(nextScene);
        primaryStage.show();
        }

        else{
        primaryStage.setScene(scenes[currentSceneIndex]);
        }
    }


   
    private void showTekaTekiScene() {
        Scene scene1 =createplayscene(" Saya adalah sebuah angka. Jika saya membagi 20 menjadi dua bagian, saya akan mendapatkan dua angka yang jika ditambahkan, akan menghasilkan hasil yang sama seperti ketika saya mengalikannya. Apa angka saya?", "5", "5","8", "10");
        Scene scene2 =createplayscene("Halo pak","A", "a", "B", "C");

    }
    private Scene createplayscene(String question,String answer,String A,String B,String C) {
        Label pertanyaan=new Label(question);
        
        Button AButton = new Button(A);
        AButton.setOnAction(e->{
            user1.answerA();
            nextScene();
        });
        Button BButton = new Button(B);
        BButton.setOnAction(e->{
            user1.answerB();
            nextScene();
        });
        Button CButton = new Button("Tidak");
        CButton.setOnAction(e->{
            user1.answerC();
            nextScene();
        });
        
        HBox layout=new HBox(10);
        layout.getChildren().addAll(AButton,BButton,CButton);
        VBox layout1=new VBox(10);
        layout1.getChildren().addAll(pertanyaan,layout1);
        Scene scene=new Scene(layout1, 600, 600);
        return scene;
    }


        
    
    private void showResultScene(String result ) {
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