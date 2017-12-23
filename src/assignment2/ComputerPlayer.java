package assignment2;

public class ComputerPlayer {
    public String secretCode;

    public void ComputerPlayer(){};

    public void generateCode(boolean testmodevalue){
        secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
        if(testmodevalue == true) {
            System.out.println("\nGenerating secret code ...(for this example the secret code is " + secretCode + ")\n");
        }
        else{
            System.out.println("\nGenerating secret code ...\n");
        }

    }


    public boolean checkValid(String z){
        boolean valid = false;
        int flag = 0;
        if(z.equals("HISTORY")){                                                                                      //valid if history
            valid = true;
            return valid;
        }
        else if(z.length() != GameConfiguration.pegNumber){                                                           //cant be greater than pegNumber
            valid = false;
            return valid;
        }
        for(int i =0; i<4; i++)
        {
            for(int j = 0; j<GameConfiguration.colors.length; j++)
            {
                if( z.charAt(i) == GameConfiguration.colors[j].charAt(0)){                  //makes sure each letter is in valid colors
                    flag = 1;
                    continue;
                }
            }
            if(flag == 0){
                valid = false;
                break;
            }

        }
        if(flag == 1){                                                                      //if flag stays 1, valid entry
            valid = true;
        }

        return valid;

    }

    public int[] checkGuess(String z){
        int blackpegs = 0;
        int whitepegs = 0;
        char[] x = z.toCharArray();
        char[] secret = secretCode.toCharArray();

        for(int i = 0; i<4; i++)
        {
            if(x[i] == secret[i])                                                  //replaces blackpeg spot with dash
            {
                blackpegs++;
                x[i] = '-';
                secret[i] = '-';
            }
        }

        for(int i = 0; i<4; i++)
        {
            for(int j = 0; j<4; j++)
            {
                if((x[i] == secret[j]) && (x[i] != '-'))                            // replaces whitepeg slot with dash
                {
                    whitepegs++;
                    x[i] = '-';
                    secret[j] = '-';
                    continue;
                }
            }
        }

        int [] pegs = new int[2];                                                   // stores pegs in int array, returns array
        pegs[0] = blackpegs;
        pegs[1] = whitepegs;

        return pegs;



    }

}
