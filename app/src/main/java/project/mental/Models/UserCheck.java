package project.mental.Models;

public class UserCheck extends User {
    private int mentalScore; 

    public int getMentalScore() {
        return mentalScore;
    }

    public void setMentalScore(int mentalScore) {
        this.mentalScore = mentalScore;
    }

    public UserCheck(String name) {
        super(name);
        this.mentalScore = 100;
    }

    public void answerA(){
        mentalScore -= 10;
    }

    public void answerB(){
        mentalScore -= 5;
    }

    public void answerC(){
        mentalScore -= 0;
    }

    public String showResult(){
        //pake pengkondisian 
        if (mentalScore >= 0 && mentalScore <= 45) 
        {return("Sangat buruk");
        } else if (mentalScore >= 46 && mentalScore <= 70)
            {return("Buruk");
        } else if (mentalScore >= 71 && mentalScore <= 85)
            {return("Kondisimu baik \n ");
        }else if (mentalScore >= 86 && mentalScore <= 100)
            {return("Kamu berada di kondisi yang baik, Stay Happy ya!");}
         else {
            return null;
        }

    }

    @Override
    void greet(String Username) {
        System.out.println("Selamat Datang Di Aplikasi ini" + Username + "...");
    }   
}
