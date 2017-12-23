package assignment2;
import java.util.Scanner;

public class Startup {
    public void Startup(){

    }

    public int text(Scanner console, int setFlag){
        int ret = 0;
        if(setFlag == 0) {
            System.out.println("Welcome to Mastermind.  Here are the rules.\n\n" +
                    "This is a text version of the classic board game Mastermind.\n" +
                    "The computer will think of a secret code. The code consists of 4 colored pegs. The pegs MUST be one of six colors: blue, green, orange, purple, red, or yellow.\nA color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in.\nAfter you make a valid guess the result (feedback) will be displayed. " +
                    "The result consists of a black peg for each peg you have guessed exactly correct (color and position)\nin your guess. For each peg in the guess that is the correct color, but is out of position, you get a white peg.\nFor each peg, which is fully incorrect, you get no feedback. " +
                    "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\nWhen entering guesses you only need to enter the first character of each color as a capital letter.");
            System.out.print("You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N): ");

            String s = console.next();
            if (s.equals("Y")) {
                ret = 1;
            } else ret = 0;
        }
        else if(setFlag == 1)
        {
           ret = 1;
        }
       return ret;
    }

}
