package assignment2;

public class History {
    public String[] pguess;
    public int[] ppeg;

    public History(String [] pastguess, int[] pastpeg){
        pguess = pastguess;
        ppeg = pastpeg;
    }

    public void addGuess(String attempt, int guessRemaining){
        int slot = GameConfiguration.guessNumber - guessRemaining;
        pguess[slot] = attempt;

    }

    public void addPegs(int [] pegs, int guessRemaining){
        int slot = (GameConfiguration.guessNumber - guessRemaining) * 2;
        ppeg[slot] = pegs[0];                                               //puts black pegs in even slots
        ppeg[slot+1] = pegs[1];                                             //puts white pegs in odd slots
    }

    public String[] getGuess(){
        return pguess;
    }

    public int[] getPegs(){
        return ppeg;
    }

    public void printHistory(int guessRemaining){
        int printNumber = (GameConfiguration.guessNumber - guessRemaining);
        int j = 0;
        for(int i =0; i<printNumber; i++)
        {
            j = i*2;
            System.out.println(pguess[i] + "        " + ppeg[j] + "B_" + ppeg[j+1] + "W");
        }
        System.out.println("\n");
    }
}
