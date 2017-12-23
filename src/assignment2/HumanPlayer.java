package assignment2;
import java.util.Scanner;

public class HumanPlayer {
    public String playercode;

    public HumanPlayer(){};

    public HumanPlayer(String x){
        playercode = x;
    }

    public String enterGuess(Scanner console){
        String s = console.next();                                  // takes human guess each time
        return s;
    }


}
