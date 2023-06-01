package project.mental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        nameField.setPromptText("name");
        Button nextButton = new Button("Selanjutnya");
        nextButton.setOnAction(e -> {
            user1.setName(name);
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
        // tekaTekiButton.setOnAction(e -> showTekaTekiScene());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(menuLabel, mentalCheckerButton, tekaTekiButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }

    private void showMentalCheckerScene() {
       
        // Inisialisasi semua scene
        Scene scene1 = createMentalScene("1. Seperti apa perasaanmu saat ini?");
        Scene scene2 = createMentalScene("2. Apa kamu merasa percaya diri dengan \nsemua kondisimu sekarang?");
        Scene scene3 = createMentalScene("3. Apakah Kamu Mudah Tersinggung dengan \nOmongan dan Respon Orang Lain Terhadapmu?");
        Scene scene4 = createMentalScene("4. Apakah perasaan cemas atau tidak nyaman\n di sekitar orang lain mengganggu Anda?");
        Scene scene5 = createMentalScene("5. Apakah Anda pernah merasa bahwa Anda \ntelah dipengaruhi oleh\n perasaan gelisah, cemas, atau gugup?");
        Scene scene6 = createMentalScene("6.Selama 12 bulan terakhir, seberapa sering\n Anda merasa sendirian \natau kesepian?");
        Scene scene7 = createMentalScene("7.Selama 12 bulan terakhir, seberapa sering \nAnda secara serius \nmempertimbangkan untuk mencoba bunuh diri?");
        Scene scene8 = createMentalScene("8.Selama 12 bulan terakhir, apakah Anda pernah\n merencanakan bagaimana\n Anda akan mencoba bunuh diri?");
        Scene scene9 = createMentalScene("9.Apakah Anda merasa tidak berharga atau merasa \nbersalah secara \nberlebihan?");
        Scene scene10 = createMentalScene("10.Apakah Anda sering merasa kelelahan fisik \ndan mental tanpa \nalasan yang jelas?");
        // Tambahkan scene lainnya di sini...

        // Simpan semua scene dalam sebuah array
        scenes = new Scene[]{scene1, scene2, scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10};
        // Tambahkan scene lainnya di sini...

        // Atur scene pertama yang akan ditampilkan
        currentSceneIndex = 0;
        primaryStage.setScene(scenes[currentSceneIndex]);
        primaryStage.show();

        // Tombol untuk berpindah ke scene berikutnya
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> nextScene());

        

    }

    
    
    private Scene createMentalScene(String question) {
        Label pertanyaan=new Label(question);
        GridPane gridpane=new GridPane();
        gridpane.setPadding(new Insets(2,2,2,2));
        gridpane.setHgap(1);
        gridpane.setVgap(5);
        GridPane.setConstraints(pertanyaan, 7, 1);
        gridpane.getChildren().addAll(pertanyaan);
        Button yesButton = new Button("Iya");
        yesButton.setOnAction(e->{
            user1.answerA();
            nextScene();
        });
        Button smButton = new Button("Terkadang");
        smButton.setOnAction(e->{
            user1.answerB();
            nextScene();
        });
        Button noButton = new Button("Tidak");
        noButton.setOnAction(e->{
            user1.answerC();
            nextScene();
        });
        
        
        gridpane.getChildren().addAll(yesButton,noButton,smButton);
        GridPane.setConstraints(yesButton, 6, 2);
        GridPane.setConstraints(smButton, 7, 2);
        GridPane.setConstraints(noButton, 8, 2);
        gridpane.setAlignment(Pos.CENTER);
        StackPane stackPane=new StackPane(gridpane);
        return new Scene(stackPane, 400, 400);
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
            primaryStage.setScene(show_result());    
        }
        else{
        primaryStage.setScene(scenes[currentSceneIndex]);
        }
    }


    // private void showTekaTekiScene() {
    //     Scene scene1 =createplayscene(" Saya adalah sebuah angka. Jika saya membagi 20 menjadi dua bagian, saya akan mendapatkan dua angka yang jika ditambahkan, akan menghasilkan hasil yang sama seperti ketika saya mengalikannya. Apa angka saya?", "5", "5","8", "10");
    // }
    // private Scene createplayscene(String question,String answer,String A,String B,String C) {
    //     Label pertanyaan=new Label(question);
    //     GridPane gridpane=new GridPane();
    //     gridpane.setPadding(new Insets(2,2,2,2));
    //     gridpane.setHgap(1);
    //     gridpane.setVgap(5);
    //     GridPane.setConstraints(pertanyaan, 7, 1);
    //     gridpane.getChildren().addAll(pertanyaan);
    //     Button AButton = new Button(A);
    //     AButton.setOnAction(e->{
    //         user1.answerA();
    //         nextScene();
    //     });
    //     Button smButton = new Button(B);
    //     smButton.setOnAction(e->{
    //         user1.answerB();
    //         nextScene();
    //     });
    //     Button noButton = new Button("Tidak");
    //     noButton.setOnAction(e->{
    //         user1.answerC();
    //         nextScene();
    //     });
    
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