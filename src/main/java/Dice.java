import CharacterTypes.Characters;

public class Dice {
    public static int diceRoll(){
        int numberOfSides = 10;
        int diceRoll = (int)(Math.random()*numberOfSides);
        return diceRoll;
    }

    public static int sumAttack(Characters player){
        int roll = Dice.diceRoll();
        int attack = player.attack;
        int sum = roll+attack;
        System.out.println("Dice roll of " + roll);
        return sum;
    }

    public static int sumDefense(Characters player){
        int roll = Dice.diceRoll();
        int defense = player.defense;
        int sum = roll+defense;
        System.out.println("Dice roll of " + roll);
        return sum;
    }
}
