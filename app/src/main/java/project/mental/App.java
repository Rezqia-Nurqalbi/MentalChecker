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
        Scene scene1 = createMentalScene("Apa kamu sering mendapati dirimu merasakan kesedihan yang berlebihan?");
        Scene scene2 = createMentalScene("Apa kamu merasa tidak percaya diri dengan semua kondisimu sekarang?");
        Scene scene3 = createMentalScene("Apakah Kamu Mudah Tersinggung dengan Omongan dan \nRespon Orang Lain Terhadapmu?");
        Scene scene4 = createMentalScene("Apakah perasaan cemas atau tidak nyaman \ndi sekitar orang lain mengganggu Anda?");
        Scene scene5 = createMentalScene("Apakah Anda pernah merasa bahwa Anda telah dipengaruhi \noleh perasaan gelisah, cemas, atau gugup?");
        Scene scene6 = createMentalScene("Selama 12 bulan terakhir, seberapa sering Anda \nmerasa sendirian atau kesepian?");
        Scene scene7 = createMentalScene("Selama 12 bulan terakhir, seberapa sering Anda \n secara serius mempertimbangkan untuk mencoba bunuh diri?");
        Scene scene8 = createMentalScene("Selama 12 bulan terakhir, apakah Anda pernah merencanakan \nbagaimana Anda akan mencoba bunuh diri?");
        Scene scene9 = createMentalScene("Apakah Anda merasa tidak berharga atau \nmerasa bersalah secara berlebihan?");
        Scene scene10 = createMentalScene("Apakah Anda sering merasa kelelahan fisik \ndan mental tanpa alasan yang jelas?");
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

        Image image1 = new Image(getClass().getResource("/bgmntal.png").toString());
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
        resultLabel.setTextAlignment(TextAlignment.CENTER);
        resultLabel.setFont(Font.font("Times New Roman", 20));
        Button button=new Button("Kembali ke menu utama");
        button.setOnAction(e->showMenuScene());
        Button button2=new Button("Logout");
        button2.setOnAction(e->showNameInputScene());
        HBox layou=new HBox(10);
        layou.setAlignment(Pos.BOTTOM_LEFT);

        Image hasil = new Image(getClass().getResource("/result.png").toString());
        ImageView result = new ImageView(hasil);
        result.setFitWidth(500);
        result.setFitHeight(300);
        
        layou.getChildren().addAll(button,button2);
        
        VBox layou1=new VBox(80);
        layou1.getChildren().addAll(resultLabel, result, layou);
        layou1.setAlignment(Pos.CENTER);
        layou1.getStyleClass().add("custom-scene2");
        
        Scene scene = new Scene(layou1, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return scene;
        
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
        Scene scene1 =createplayscene("Saya adalah sebuah angka. Jika saya membagi 20 menjadi dua bagian, saya akan mendapatkan dua angka yang jika ditambahkan, \nakan menghasilkan hasil yang sama seperti ketika saya mengalikannya. Apa angka saya?", "5", "5","8", "10");
        Scene scene2 =createplayscene("Aku bisa menghancurkan rasa lapar, membuatmu merasa kenyang, dan tidak pernah bergerak. Apa aku?","Pikiran", "Makanan", "Air", "Pikiran");
        Scene scene3=createplayscene("Aku berada di awal kehidupan, di akhir kematian, dan selalu hadir dalam perjalanan hidupmu. Apa aku?", "Harapan","Harapan", "Cinta", "Keberanian");
        Scene scene4=createplayscene("Aku memiliki banyak cabang tapi tidak memiliki daun. Aku tidak memancarkan cahaya, tetapi aku membuat orang terang. Apa aku?", "Jaringan Saraf","Pohon Keluarga","Listrik","Jaringan ");
        Scene scene5=createplayscene("Aku adalah sesuatu yang kamu bisa menemukan di dalam dirimu, memberimu kekuatan, \ndan membuatmu merasa tak terkalahkan. Apa aku?", "Kepercayaan Diri","Kepercayaan Diri", "Imajinasi","Waktu");
        Scene scene6=createplayscene("Aku bisa melihat segalanya, tetapi tidak memiliki mata. Aku bisa memecahkan teka-teki, \ntetapi tidak memiliki otak. Siapakah aku?","Cahaya","Kaca Pembesar","Cermin","Cahaya");
        Scene scene7=createplayscene("Aku mengalir tanpa henti, tetapi tidak bisa dipegang. Aku bisa merusak atau memperbaiki suasana hati. Apa aku?", "Emosi","Misteri","Rahasia","Pikiran");
        Scene scene8=createplayscene( "Aku ada ketika kamu membicarakannya, aku hilang ketika kamu menyebut namaku. Siapakah aku?","Rahasia", "Misteri","Rahasia","Pikiran");
        Scene scene9=createplayscene("Aku bisa menguji ketahananmu, tetapi tidak bisa dilihat. Aku bisa membuatmu tumbuh atau hancur. Siapakah aku?","Tekanan","Tekanan","Keberanian", "Kebanggaan");
        Scene scene10=createplayscene("Aku adalah sesuatu yang kamu ingin tetapi kamu tidak ingin memberikannya. \nKamu mencariku tetapi kamu tidak ingin menemukanku. Siapakah aku?", "Masalah","Kesulitan","Masalah","Kebutuhan");

        
        playscene=new Scene[]{scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10};
        primaryStage.setScene(playscene[currentSceneIndex]);
        primaryStage.show();
    }
    private Scene createplayscene(String question,String answer,String A,String B,String C) {
        Label pertanyaan=new Label(question);
        pertanyaan.setTextAlignment(TextAlignment.CENTER);
        pertanyaan.setFont(Font.font("Times New Roman", 18));
        
        Button AButton = new Button(A);
        AButton.setOnAction(e->{
            user1.answerA();
            nextPlayScene();
        });
        Button BButton = new Button(B);
        BButton.setOnAction(e->{
            user1.answerB();
            nextPlayScene();
        });
        Button CButton = new Button(C);
        CButton.setOnAction(e->{
            user1.answerC();
            nextPlayScene();
        });

        Image image1 = new Image(getClass().getResource("/tekateki.png").toString());
        ImageView bgTekateki = new ImageView(image1);
        bgTekateki.setFitWidth(1000);
        bgTekateki.setFitHeight(600);
        
        HBox layout=new HBox(10);
        layout.getChildren().addAll(AButton,BButton,CButton);
        layout.setAlignment(Pos.CENTER);
        VBox layout1=new VBox(10);
        layout1.getChildren().addAll(pertanyaan,layout);
        layout1.setAlignment(Pos.CENTER);

        StackPane layout2 = new StackPane(bgTekateki, layout1);

        Scene scene=new Scene(layout2, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return scene;
    }
    private void nextPlayScene() {
        
        currentSceneIndex++;
        
        if (currentSceneIndex >playscene.length-1) {
            currentSceneIndex = 0;
        Scene nextScene = show_result();
        primaryStage.setScene(nextScene);
        primaryStage.show();
        }

        else{
        primaryStage.setScene(playscene[currentSceneIndex]);
        }
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