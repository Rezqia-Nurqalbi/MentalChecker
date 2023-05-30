package project.mental.Models;

public class UserCheck extends User {
    private int mentalScore; 

    public int getMentalScore() {
        return mentalScore;
    }

    public void setMentalScore(int mentalScore) {
        this.mentalScore = mentalScore;
    }

    public UserCheck(String name, int mentalScore) {
        super(name);
        this.mentalScore = mentalScore;
    }

    void answerA(){
        mentalScore -= 0;
    }

    void answerB(){
        mentalScore -= 5;
    }

    void answerC(){
        mentalScore -= 10;
    }

    void showResult(){
        //pake pengkondisian 
        if (mentalScore >= 0 && mentalScore <= 45) {
            System.out.println("Sangat Buruk");
        } else if (mentalScore >= 46 && mentalScore <= 70){
            System.out.println("Buruk");
        } else if (mentalScore >= 71 && mentalScore <= 85){
            System.out.println("Cukup Baik");
        } else if (mentalScore >= 86 && mentalScore <= 100){
            System.out.println("Sangat Baik");
        } else {
            System.out.println("Score Mental Tidak valid");
        }

    }

    @Override
    void greet(String Username) {
        System.out.println("Selamat Datang Di Aplikasi ini" + Username + "...");
    }   
}
