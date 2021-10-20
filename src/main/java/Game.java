import CharacterTypes.*;
import CharacterTypes.Character;

import java.util.*; //imported a bunch & changes to *


public class Game {


    public static void main(String[] args) {

        System.out.println("Welcome to Def Jam Vendetta!\n" +
                "\n---------------------------------------\n");

        ArrayList<Character> listCharacters = new ArrayList<>();
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

        Character player1 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Character player2 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Character player3 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        System.out.println("1. " + player1 + "2. " + player2 + "3. " + player3); //show chosen user characters


        System.out.println("Your opponent, Bes, has these players:");
        Character dealer1 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Character dealer2 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        Character dealer3 = listCharacters.get(randomSelect.nextInt(listCharacters.size()));
        System.out.println("1. " + dealer1 + "2. " + dealer2 + "3. " + dealer3); //show chosen dealer characters


        Character[] player3Choices = {player1, player2, player3};
        Character[] dealer3Choices = {dealer1, dealer2, dealer3};
        //player & dealer's hands after random

        System.out.println("Select a player to start with: \n" +
                "1. " + player1.getName() + " 2. " + player2.getName() + " 3. " + player3.getName());

        Character firstDealerPlayer = new Character();
        int firstDealer = randomSelect.nextInt(dealer3Choices.length);
        if (firstDealer == 0) {
            firstDealer = randomSelect.nextInt(dealer3Choices.length);
        }

        Character firstChosenPlayer = new Character();
        Character[] player2Choices;


        int firstPick = gameChoices.nextInt();
        switch (firstPick) {
            case 1:
                firstChosenPlayer = player1;
                player2Choices = new Character[]{player2, player3};
                break;
            case 2:
                firstChosenPlayer = player2;
                player2Choices = new Character[]{player1, player3};
                break;
            case 3:
                firstChosenPlayer = player3;
                player2Choices = new Character[]{player1, player2};
                break;
            //add case if another number is chosen
            default:
                throw new IllegalStateException("Unexpected value: " + firstPick); //needed to use player2choices[] in checkvitals,             player2Choices changes over time
        }

//make dealer2Choices
        System.out.println("Bes starts with: " + firstDealer);
        Character[] dealer2Choices;

        switch (firstDealer) {
            case 1:
                firstDealerPlayer = dealer1;
                dealer2Choices = new Character[]{dealer2, dealer3};
                break;
            case 2:
                firstDealerPlayer = dealer2;
                dealer2Choices = new Character[]{dealer1, dealer3};
                break;
            case 3:
                firstDealerPlayer = dealer3;
                dealer2Choices = new Character[]{dealer1, dealer2};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + firstDealer); //needed to use dealer2Choices[] in checkvitals
        }

        System.out.println("Let's start the game!\n" +
                "---------------------------------------" +
                "\n---------------------------------------");

        //COMPARE PLAYER SPEEDS
        int firstPlayerSpeed = firstChosenPlayer.getSpeed();
        int firstDealerSpeed = firstDealerPlayer.getSpeed();


        while (true) {
            if (firstPlayerSpeed >= firstDealerSpeed) {
                System.out.println("You attack first!\n");

                //FIRST PLAYER ATTACK
                int attack = Dice.sumAttack(firstChosenPlayer);
                int defense = Dice.sumDefense(firstDealerPlayer);
                firstChosenPlayer.getCurrentHealth();
                firstDealerPlayer.getCurrentHealth();
                System.out.println("Your total attack is " + attack);
                System.out.println("Bes total defense is " + defense);
                int thisSum = attack - defense;
                System.out.println("Total damage of...." + thisSum);
                if (thisSum > 0) {
                    firstDealerPlayer.currentHealth -= thisSum;
                    Printout.goodHit();
                } else {
                    Printout.niceTryPlayer();
                }
                System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth +
                        "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

                //Characters[] player2choices =  {player1,player2};
                Character.checkPlayerVitals(firstChosenPlayer, player2Choices);
                Character.checkDealerVitals(firstDealerPlayer, dealer2Choices);
                Printout.enterToContinue();

                //FIRST PLAYER DEFEND
                attack = Dice.sumAttack(firstDealerPlayer);
                defense = Dice.sumDefense(firstChosenPlayer);
                System.out.println("Bes' total attack is " + attack);
                System.out.println("Your total defense is " + defense);
                thisSum = attack - defense;
                System.out.println("Total damage of.... " + thisSum);
                if (thisSum > 0) {
                    firstChosenPlayer.currentHealth -= thisSum;
                    Printout.gotEm();
                } else {
                    Printout.niceTryPlayer();
                }
                System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

                Character.checkPlayerVitals(firstChosenPlayer, player2Choices);
                Character.checkDealerVitals(firstDealerPlayer, dealer2Choices);
                Printout.enterToContinue();


            } else {
                System.out.println("You're are defending first!\n");

                //FIRST PLAYER DEFEND----
                int attack = Dice.sumAttack(firstDealerPlayer);
                int defense = Dice.sumDefense(firstChosenPlayer);
                firstChosenPlayer.getCurrentHealth();
                firstDealerPlayer.getCurrentHealth();
                System.out.println("Bes' total attack is " + attack);
                System.out.println("Your total defense is " + defense);
                int thisSum = attack - defense;
                System.out.println("Bes' total damage is " + thisSum);
                if (thisSum > 0) {
                    firstChosenPlayer.currentHealth -= thisSum;
                    Printout.goodHit();
                } else {
                    Printout.niceTryPlayer();
                }
                System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth +
                        "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

                Character.checkPlayerVitals(firstChosenPlayer, player2Choices);
                Character.checkDealerVitals(firstDealerPlayer, dealer2Choices);
                Printout.enterToContinue();


                //FIRST PLAYER ATTACK
                attack = Dice.sumAttack(firstChosenPlayer);
                defense = Dice.sumDefense(firstDealerPlayer);
                firstChosenPlayer.getCurrentHealth();
                firstDealerPlayer.getCurrentHealth();
                System.out.println("Your total attack is " + attack);
                System.out.println("Bes total defense is " + defense);
                thisSum = attack - defense;
                System.out.println("Your total damage is " + thisSum);
                if (thisSum > 0) {
                    firstDealerPlayer.currentHealth -= thisSum;
                    Printout.goodHit();
                }
                System.out.println("\nYour current health is: " + firstChosenPlayer.currentHealth + "\nand Bes' current health is: " + firstDealerPlayer.currentHealth + "\n");

                Character.checkPlayerVitals(firstChosenPlayer, player2Choices);
                Character.checkDealerVitals(firstDealerPlayer, dealer2Choices);
                Printout.enterToContinue();
                Character nextDealer = dealer2Choices[0]; //next dealer character when needed. finish after presentation
            }
        }
    }
}



//math first, conditionals

