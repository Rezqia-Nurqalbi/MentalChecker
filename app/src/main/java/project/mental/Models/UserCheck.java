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
        //kurang point 
    }

    void answerB(){

    }

    void answerC(){

    }

    void showResult(){
        //pake pengkondisian 
    }

    @Override
    void greet(String Username) {
    
    }

    
}
