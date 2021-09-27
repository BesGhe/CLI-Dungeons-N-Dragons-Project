import CharacterTypes.Characters;

public class Dice {
    public static int diceRoll(int numberOfSides){
        //int numberOfSides = 20; can now use diff dice for attack & defense
        int diceRoll = (int)(Math.random()*numberOfSides);
        if(diceRoll==0){
            diceRoll+=1;
        }
        return diceRoll;
    }

    public static int sumAttack(Characters player){
        int roll = Dice.diceRoll(15);
        int attack = player.getAttack();
        int sum = roll+attack;
        System.out.println("Attack dice roll of " + roll);
        return sum;
    }

    public static int sumDefense(Characters player){
        int roll = Dice.diceRoll(10);
        int defense = player.getDefense();
        int sum = roll+defense;
        System.out.println("Defense dice roll of " + roll);
        return sum;
    }


}
