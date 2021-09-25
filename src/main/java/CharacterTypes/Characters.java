package CharacterTypes;

import java.util.ArrayList;
import java.util.Random;

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
                "Starting HP: " + currentHealth +
                "\nAttack: " + attack +
                "\nDefense: " + defense +
                "\nSpeed: " + speed +
                "\n\n";
        //how to display char stats
    }

    public String getName() {
        return name;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}













