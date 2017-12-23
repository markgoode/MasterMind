package assignment2;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int setFlag = 0;

        while (true) {

            boolean check = false;
            if (args[0].equals("1")) {                                      //handles test mode
                check = true;
            }
            else check = false;


            Startup startup = new Startup();                               //prints start screen
            int ready = startup.text(console, setFlag);
            if (ready == 1) {
            }
            else System.exit(0);
            setFlag = 0;
            Game game = new Game(check, console);                          //sends testmode value to game and creates object

            ComputerPlayer computer = new ComputerPlayer();
            computer.generateCode(game.testMode());                         //creates code dependent on testmode value

            HumanPlayer human = new HumanPlayer();

            GameRunner gr = new GameRunner(GameConfiguration.guessNumber);
            String[] pastguess = new String[(GameConfiguration.guessNumber)];       // creates String array to store History guesses
            int[] pastpegs = new int[GameConfiguration.guessNumber * 2];            // creates int array to store History pegs
            History history = new History(pastguess, pastpegs);

            while (gr.remaining() != 0) {                                           // loops turns while guesses remaining
                boolean valid = false;
                gr.printRemaining();
                while (valid == false) {                                            // loops until valid human code
                    gr.guessPrompt();
                    String attempt = human.enterGuess(console);
                    valid = computer.checkValid(attempt);                           // checks if human entered code valid
                    if (valid == true) {
                        human.playercode = attempt;
                    }
                    else if (valid == false) {
                        gr.invalidPrompt();
                    }
                }

                if (human.playercode.equals("HISTORY") == false) {                  // checks and stores guess if not a history entry
                    int[] pegs;
                    pegs = computer.checkGuess(human.playercode);
                    history.addGuess(human.playercode, gr.remaining());
                    history.addPegs(pegs, gr.remaining());

                    boolean newgame = false;
                    gr.resultPrompt(human.playercode, pegs);                        // prints result of current guess
                    if (gr.gameOver() == true) {
                        newgame = gr.newGame(console);
                    }
                    if (newgame == true) {                                          // checks if user wants to start new game
                        setFlag = 1;
                        break;
                    }
                    else
                        gr.oneLess();
                }
                else if (human.playercode.equals("HISTORY")) {                      // if history entry, prints history to screen
                    history.printHistory(gr.remaining());
                }


            }
            if(gr.gameOverStatus == 1)                                              // sets guesses and gameoverstatus to default, starts new game
            {
                  gr.gameOverStatus = 0;
                  gr.guessesleft = GameConfiguration.guessNumber;
            }


        }
    }
}
