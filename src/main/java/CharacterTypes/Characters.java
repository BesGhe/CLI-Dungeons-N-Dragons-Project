package CharacterTypes;

import java.util.*;

public class Characters {

    public String name;
    public int totalHealth;
    public int currentHealth = totalHealth;
    public int attack;
    public int defense;
    public int speed;

    @Override
    public String toString() {

        return name + "'s Stats\n" +
                "Current HP: " + currentHealth +
                "\nAttack: " + attack +
                "\nDefense: " + defense +
                "\nSpeed: " + speed +
                "\n\n";
        //how to display char stats
    }
    Characters[] player2Choices;
     public static int checkPlayerVitals(Characters player, Characters[] leftovers){

         Scanner scan = new Scanner(System.in);
        if (player.currentHealth<=0){
            System.out.println("Oh no, " + player.name + " is gone!\n" +
                    "please choose another player" +
                    Arrays.toString(leftovers));//shows the other 2 characters
            //how to choose only them
            int nextCharacter = scan.nextInt();
        }
        return player.currentHealth;
     }

    public static int checkDealerVitals(Characters dealer, Characters[] deadDealer){
        Scanner scan = new Scanner(System.in);
        Random randomSelect = new Random();
        if (dealer.currentHealth<=0){
            System.out.println("Oh no, " + dealer.name + " is gone!\n" +
                    "please choose another player" +
                    Arrays.toString(deadDealer));

            //choose next character
            // int nextCharacter = randomSelect.nextInt(deadDealer.length);

        }
        return dealer.currentHealth;
    }

    public int getCurrentHealth() {

        return currentHealth;
    }

    public Characters[] getPlayer2Choices() {
        return player2Choices;
    }

}













