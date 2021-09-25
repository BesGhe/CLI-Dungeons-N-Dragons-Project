import CharacterTypes.*;

import java.util.Scanner;

public class Printout {

    public static void goodHit () {

        System.out.println("Oooh good hit!");
    }

    public static void gotEm (){

        System.out.println("That's gotta hurt!");
    }

public static void niceTryPlayer(){

        System.out.println("Aaah, you thought!");
}

public static void enterToContinue(){

        System.out.println("Press \"ENTER\" to continue...");
        Scanner gameChoices = new Scanner(System.in);
        gameChoices.nextLine();
        //can add press 0 to quit
    }

}
