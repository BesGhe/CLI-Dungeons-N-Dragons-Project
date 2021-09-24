package CharacterTypes;

import java.util.ArrayList;
import java.util.Random;

public class Characters {

    public String name;
    public int totalHealth;
    public int currentHealth;
    public int attack;
    public int defense;
    public int speed;

    @Override
    public String toString() {
        return name + "'s Stats\n" +
                "Starting HP: " + totalHealth +
                "\nCurrent HP: " + currentHealth +
                "\nAttack: " + attack +
                "\nDefense: " + defense +
                "\nSpeed: " + speed +
                "\n\n";
        //how to display char stats
    }
}













