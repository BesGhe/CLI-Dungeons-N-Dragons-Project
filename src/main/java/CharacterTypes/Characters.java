package CharacterTypes;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.reflect.Array.get;

public class Characters {

    private String name;
    private int totalHealth;
    public int currentHealth = totalHealth;
    private int attack;
    private int defense;
    private int speed;


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

    Characters dealer;
    Characters[] deadDealer;

    public static int checkDealerVitals(Characters dealer, Characters[] deadDealer){

        Scanner scan = new Scanner(System.in);
        Random randomSelect = new Random();

        int dealerHere = randomSelect.nextInt(deadDealer.length); //randomly choose next character
        if (dealer.currentHealth<=0){
            dealer = deadDealer[0];
            System.out.println("Oh no, " + dealer.getName() + " is gone!\n" +
                    "I will choose another player:\n" +
                    dealer);//show leftover characters & then choose characters
            return dealer.currentHealth;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}