package project.mental.Models;

public class UserPlay  extends User{
    private int score;
    
    public UserPlay(String name, int score) {
        super(name);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    

    void cekScore() {
        System.out.println("skor anda "+this.score+"dari 10 pertanyaan");
    }

    @Override
    void greet(String Username) {
        System.out.println("Selamat Datang");
    }

}
