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

    public void reset(){
        this.mentalScore = 100;
    }

    public void answerC(){
        mentalScore -= 0;
    }

    public String showResult(){
        //pake pengkondisian 
        if (mentalScore >= 0 && mentalScore <= 45) 
        {return("Kondisimu sedang tidak baik..., kami menyarankan agar kamu segera bertemu dengan psikolog / psikiater \n Tidak apa-apa untuk merasa tidak stabil. Tidak apa-apa untuk memutuskan hubungan. \nTidak apa-apa bersembunyi dari dunia. Tidak apa-apa butuh bantuan. \nTidak apa-apa untuk tidak baik-baik saja. Penyakit mental Anda bukanlah kegagalan pribadi.");
        } else if (mentalScore >= 46 && mentalScore <= 70)
            {return("Kamu Berada dikondisi kurang Baik...\n Kamu tidak dapat mengontrol semuanya. Terkadang kamu hanya perlu rileks \ndan yakin bahwa segala sesuatunya akan berhasil. \nLepaskan sedikit dan biarkan hidup terjadi.");
        } else if (mentalScore >= 71 && mentalScore <= 85)
            {return("Kondisimu baik! \nTetap seperti itu ya!");
        }else if (mentalScore >= 86 && mentalScore <= 100)
            {return("Selamat Kamu berada di kondisi yang baik! \nStay Happy ya!");}
        else {
            return "Kossong";
        }

    }

    @Override
    public String greet() {
        return "Selamat Datang " + name + " Di mental checker \nPada bagian ini,anda akan menjawab 10 pertanyaan mengenai mental anda\n Selamat mencoba!";
    }
}
