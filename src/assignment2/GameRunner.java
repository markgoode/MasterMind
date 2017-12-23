package assignment2;
import java.util.Scanner;

public class GameRunner {
    public int guessesleft;
    public int gameOverStatus;

    public GameRunner(int startguesses){
        guessesleft = startguesses;

    }

    public int remaining()
    {
        return guessesleft;
    }

    public void printRemaining(){
        System.out.println("You have " + guessesleft + " guesses left.");
    }

    public void oneLess()
    {
        guessesleft = guessesleft - 1;
    }

    public void guessPrompt()
    {
       System.out.print("What is your next guess?\n" +
               "Type in the characters for your guess and press enter.\nEnter guess: ");
    }

    public void invalidPrompt()
    {
        System.out.println("INVALID GUESS\n");
    }

    public void resultPrompt(String code, int[] pegs){
        System.out.print(code + " -> Result: ");
        int blackpegs = pegs[0];
        int whitepegs = pegs[1];
        int left = remaining() - 1;
        boolean gameover = false;

        if((whitepegs == 0) && (blackpegs == 0) && (left == 0))
        {
            gameover = true;
            System.out.println("No pegs - Sorry, you are out of guesses. You lose, boo-hoo.\n");
        }
        else if((whitepegs == 0) && (blackpegs == 0))
        {
            System.out.println("No pegs\n");
        }
        else if(blackpegs == GameConfiguration.pegNumber)
        {
            gameover = true;
            System.out.println(blackpegs + " black pegs - You win !!\n");
        }
        else if(left == 0)
        {
            gameover = true;
            System.out.println(blackpegs + " black pegs and " + whitepegs + " white pegs - Sorry, you are out of guesses. You lose, boo-hoo.\n");
        }
        else
        {
            System.out.println(blackpegs + " black pegs and " + whitepegs + " white pegs\n");
        }

        if(gameover == true)
        {
            gameOverStatus = 1;
        }

    }

    public boolean gameOver(){
        if(gameOverStatus == 1)
            return true;
        else return false;
    }


    public boolean newGame(Scanner console){
        System.out.print("\nAre you ready for another game (Y/N): ");
        String s = console.next();
        System.out.println();
        boolean game = false;
        if(s.equals("Y"))
        {
            game = true;
        }
        else System.exit(0);

        return game;
    }
}
