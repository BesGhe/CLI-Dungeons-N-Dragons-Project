
import CharacterTypes.*;

import java.util.*;


public class Game {



    public static void main(String[] args) {
        System.out.println("Welcome to Def Jam Vendetta!\n" +
                "\n---------------------------------------\n");

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

        Collections.shuffle(listCharacters); //shuffle characters before picking

        //CHOOSE PLAYERS
        Random randomSelect = new Random();
        Scanner gameChoices = new Scanner(System.in);


        System.out.println("Hello there, here are your players:");

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

        Characters firstChosenPlayer = new Characters();
        int firstPick = gameChoices.nextInt();
        switch (firstPick) {
            case 1:
                firstChosenPlayer = player1;
                break;
            case 2:
                firstChosenPlayer = player2;
                break;
            case 3:
                firstChosenPlayer = player3;
                break;
            //add case if another number is chosen
        }

        Characters firstDealerPlayer = new Characters();
        int firstDealer = randomSelect.nextInt(dealer3Choices.length);
        if(firstDealer<=0){
            firstDealer = randomSelect.nextInt(dealer3Choices.length);
        }

        System.out.println("Bes starts with: " + firstDealer);
        switch (firstDealer) {
            case 1:
                firstDealerPlayer = dealer1;
                break;
            case 2:
                firstDealerPlayer = dealer2;
                break;
            case 3:
                firstDealerPlayer = dealer3;
                break;
        }

        System.out.println("Let's start the game!\n" +
                "---------------------------------------" +
                "\n---------------------------------------");

        //COMPARE PLAYER SPEEDS
        int firstPlayerSpeed = firstChosenPlayer.speed;
        int firstDealerSpeed = firstDealerPlayer.speed;

        if (firstPlayerSpeed >= firstDealerSpeed) {
            System.out.println("You attack first!\n");


            //FIRST PLAYER ATTACK
            int attack = Dice.sumAttack(firstChosenPlayer);
            int defense = Dice.sumDefense(firstDealerPlayer);
            firstChosenPlayer.getCurrentHealth();
            firstDealerPlayer.getCurrentHealth();
            System.out.println("Your total attack is " + attack);//8-10
            System.out.println("Bes total defense is " + defense);//10-8
            int thisSum = attack - defense;
            System.out.println("Your total damage is " + thisSum);//0+2
            if (thisSum > 0) {
                firstDealerPlayer.currentHealth -= thisSum;
                Printout.goodHit();
            }
            System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

            Printout.enterToContinue();


            //FIRST PLAYER DEFEND
            attack = Dice.sumAttack(firstDealerPlayer);
            defense = Dice.sumDefense(firstChosenPlayer);
            System.out.println("Bes' total attack is " + attack);//8-10
            System.out.println("Your total defense is " + defense);//10-8
            thisSum = attack - defense;
            System.out.println("Bes' total damage is " + thisSum);//0+2
            if (thisSum > 0) {
                firstChosenPlayer.currentHealth -= thisSum;
                Printout.gotEm();
            }
            System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

            Printout.enterToContinue();
        }



        else {
            System.out.println("You're are defending first!\n");


            //FIRST PLAYER DEFEND----
            int attack = Dice.sumAttack(firstDealerPlayer);
            int defense = Dice.sumDefense(firstChosenPlayer);
            firstChosenPlayer.getCurrentHealth();
            firstDealerPlayer.getCurrentHealth();
            System.out.println("Bes' total attack is " + attack);//8-10
            System.out.println("Your total defense is " + defense);//10-8
            int thisSum = attack - defense;
            System.out.println("Bes' total damage is " + thisSum);//0+2
            if (thisSum > 0) {
                firstChosenPlayer.currentHealth -= thisSum;
                Printout.goodHit();
            }
            System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

            Printout.enterToContinue();


            //FIRST PLAYER ATTACK
            attack = Dice.sumAttack(firstChosenPlayer);
            defense = Dice.sumDefense(firstDealerPlayer);
            firstChosenPlayer.getCurrentHealth();
            firstDealerPlayer.getCurrentHealth();
            System.out.println("Your total attack is " + attack);//8-10
            System.out.println("Bes total defense is " + defense);//10-8
            thisSum = attack - defense;
            System.out.println("Your total damage is " + thisSum);//0+2
            if (thisSum > 0) {
                firstDealerPlayer.currentHealth -= thisSum;
                Printout.goodHit();
            }
            System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

            Printout.enterToContinue();

        }


    }
//math first, conditionals
//Math ain't mathing yet

}