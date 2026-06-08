public class Player {
    //Attributes
    String name;
    private int guess;

    //Methods
    Player(String name){
        this.name = name;
    }

    int getGuess(){
        return guess;
    }

    void makeGuess(){
        this.guess = (int)(Math.random()*9) + 1;
        System.out.println(this.name + " guessed "+this.guess);
    }
}