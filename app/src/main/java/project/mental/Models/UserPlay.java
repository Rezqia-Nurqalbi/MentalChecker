package project.mental.Models;

public class UserPlay  extends User{
    private int score=0;
    boolean checkAnswer;
    public String answer;
    public String key;

    
    public UserPlay(String name) {
        super(name);
        

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void checkAnswer(){
        if (key.equalsIgnoreCase(answer)){
            checkAnswer=true;
            score += 1;
        
        } else {
            score += 0;
            checkAnswer=false;
     
        }
        System.out.println(score);
    }
    
    public void setAnswer(String selected_answer){
        this.key=selected_answer;
    }

    public void answerA(String Selectanswer){
        this.answer=Selectanswer;
    }
    public void answerB(String Selectanswer){
        this.answer=Selectanswer;
    }
    public void answerC(String Selectanswer){
        this.answer=Selectanswer;
    }

    void cekScore() {
        System.out.println("skor anda "+this.score+"dari 10 pertanyaan");
    }

    @Override
    public String greet() {
        return "\tSelamat Datang " +name + " Di teka-teki\nPada bagian ini,anda akan menjawab 10 pertanyaan\nAnda siap? ";
    }

}
