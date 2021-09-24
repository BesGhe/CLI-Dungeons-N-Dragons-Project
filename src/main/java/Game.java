
import CharacterTypes.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to Def Jam Vendetta!\n\n Here are the available characters:\n");

        ArrayList<Characters> listCharacters = new ArrayList<>();
        // list for choosing a player, array list to be able to adjust later
        listCharacters.add(new Ghostface());
        listCharacters.add(new BigBoi());
        listCharacters.add(new MethodMan());
        listCharacters.add(new ChildishGambino());
        listCharacters.add(new DMX());
        listCharacters.add(new Nas());
        listCharacters.add(new KanyeWest());
        listCharacters.add(new KendrickLamar());

        System.out.println(listCharacters);

        //CHOOSE PLAYERS
        Random randomSelect = new Random();
        Scanner gameChoices = new Scanner(System.in);


        System.out.println("Hello GZA, here are your players:");

        Characters player1 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Characters player2 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Characters player3 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        System.out.println("1. " + player1 + "2. " + player2 + "3. " + player3);

        System.out.println("Your opponent, Bes, has these players:");
        Characters dealer1 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Characters dealer2 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Characters dealer3 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        System.out.println("1. " + dealer1 + "2. " + dealer2 + "3. " + dealer3);

        Characters[] player3Choices = {player1, player2, player3};
        Characters[] dealer3Choices = {dealer1, dealer2, dealer3};
        //player & dealer's hands after random

        System.out.println("Select a player to start with: \n" +
                "1. " + player1.name + " 2. " + player2.name + " 3. " + player3.name);
        int firstPlayer = gameChoices.nextInt();

        int firstDealer = randomSelect.nextInt(dealer3Choices.length);
        System.out.println("Bes starts with: " + firstDealer);


        //COMPARE PLAYER SPEEDS
        int firstPlayerSpeed = player1.speed;
        int firstDealerSpeed = dealer1.speed;

        if (firstPlayerSpeed >= firstDealerSpeed) {
            System.out.println("You attack first\n");
            int firstAttack = Dice.sumAttack(player1);
            int firstDefense = Dice.sumDefense(dealer1);
            System.out.println("Your total attack is " + firstAttack);
            System.out.println("Bes total defense is " + firstDefense);
            int thisSum = firstAttack-firstDefense;
            System.out.println("Oh snap, your total damage is " + thisSum);


        } else {
            System.out.println("You're are defending first\n\n");
            int firstAttack = Dice.sumAttack(dealer1);
            int firstDefense = Dice.sumDefense(player1);
            System.out.println("Your total attack is " + firstAttack);
            System.out.println("Bes total defense is " + firstDefense);
            int thisSum = firstAttack-firstDefense;
            System.out.println("Uh oh, Bes' total damage is " + thisSum);

        }




    }

    public static int gameSum(Characters choice) {
        return Dice.sumAttack(choice);

    }

        /*
        -dice random for both
        -dice added to the attacker's attack
        -dice added to defense point
        -compare
         */


}