package CharacterTypes;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.reflect.Array.get;

public class Characters {

    private String name;
    public int totalHealth;
    public int currentHealth = totalHealth;
    public int attack;
    public int defense;
    public int speed;


    Characters[] player2Choices;

    @Override
    public String toString() {

        return getName() + "'s Stats\n" +
                "Current HP: " + currentHealth +
                "\nAttack: " + attack +
                "\nDefense: " + defense +
                "\nSpeed: " + speed +
                "\n\n";
        //how to display char stats
    }

    public static int checkPlayerVitals(Characters player, Characters[] leftovers){

        Scanner scan = new Scanner(System.in);

        if (player.currentHealth<=0){
            System.out.println("Oh no, " + player.getName() + " is gone!\n" +
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

        int dealerHere = randomSelect.nextInt(deadDealer.length); //randomly choose next character
        if (dealer.currentHealth<=0){
            System.out.println("Oh no, " + dealer.getName() + " is gone!\n" +
                    "I will choose another player:\n" +
                    Arrays.toString(deadDealer) + "CHOICE>>" + Array.get(deadDealer, dealerHere));//show leftover characters & then                     choice characters
        }
        return dealer.currentHealth;
    }


    public int getCurrentHealth() {

        return currentHealth;
    }


    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }
}