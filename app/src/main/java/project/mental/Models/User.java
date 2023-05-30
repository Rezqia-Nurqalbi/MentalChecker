package project.mental.Models;

abstract class User {
    private String name;
    private int pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public User(String name) {
        this.name = name;
        // this.pass = pass;
    }

    // public abstract String calculateMentalState();
    abstract void greet(String Username);
}