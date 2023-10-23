/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * ********************
 * Group 75 COMP603/52A Project 1 Sahil Dhanda 20122024
 *
 * @author sahil
 *********************
 */
//GameStart Method - introduces you to the game and guides you through choosing a class,
//relic and enemy.
public class GameStart implements Runnable {

    public static Scanner userInput = new Scanner(System.in); //creates a new public static scanner object so it is accessable in other classes
    RPGPlayer newPlayer = null;     //initializes all the variables as empty so they can be filled by player input
    String username = "None";
    String playerClassSelection = "None";
    Boolean playerClassSelectionConfirmed = false;
    String relicSelection = "None";
    String enemySelection = "None";
    RPGEnemy newEnemy = null;
    String userChoice = "";

    //the primary method of this class that will run you through choosing name,
    //class, relic, and enemy.
    
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
    
    void startGame() {
        //CHOOSING NAME
        userChoice = "";  //clears userChoice variable to prevent skipping of if statements and double printing from acidental looping
        System.out.println("\nThen lets begin.");
        System.out.print("name");
        //once user has entered a name
        username = userChoice; //assigns that name to username variable
        System.out.println("\n" + username + "...  What a strange name...");

        //CHOOSING PLAYER CLASS
        System.out.println("Now, what kind of person are you?");
        System.out.println("Are you a:");
        System.out.println("1) Warrior");
        System.out.println("2) Mage");
        System.out.println("3) Monk");
        //CHOOSING PLAYER RELIC
        //gives details about the 3 avalible relics
        System.out.println("\nAnd what relic have you been gifted with to aid you on your journey?");
        System.out.println("I only know of 3 relics. Which one of these do you possess?");
        System.out.println("'Flame Blade' - Inflict 2 burn stacks on every hit. \n[Burn] - Deal 1 damage per stack and reduce stack by 1 at end of turn");
        System.out.println("'Lightning Bracer' - Deal 2-5 damage to enemies when they attack you with a 50% of shock. \n[Shock] - take 1 extra damage for each stack and reduce stack by 1 at end of turn");
        System.out.println("'Holy Stone' - Heal half the damage you deal at end of turn");
        System.out.println("Do you have the:");
        System.out.println("1) Flame Blade");
        System.out.println("2) Lightning Bracer");
        System.out.println("3) Holy Stone");
        //while the player doesnt input a valid relic or it's corresponding number
        
                System.out.println("\nI see let me write this all down.");
                //creates new RPGPlayer object based on the variables player has filled out so far
                System.out.println("Very well " + RPGPlayer.name + ", all your details are in order.");
                RPGPlayer.printStatus();   //calls the printStatus method from the RPGPlayer object based on it's values
                System.out.println("");
        

        

        //CHOOSING ENEMY CLASS
        System.out.println("Now choose your opponent!");
        System.out.println("Our selection is a bit limited but we have three different monsters for you to face today!");
        System.out.println("'Slime' - A very agile monster, it can flatten it's body to evade and suck up objects to throw at opponents.");
        System.out.println("'Skeleton' - A skeletal warrior, it wears armour and has a high health. It seems angry for some reason.");
        System.out.println("'Ghost' - A spectral monster, it can occasionally phase though attacks and cause shock.");
        System.out.println("Who will you choose to fight?");
        System.out.println("1) Slime (easy)");
        System.out.println("2) Ghost (medium)");
        System.out.println("3) Skeleton (hard)");
        userChoice = "";   //clears userChoice to prevent accidental inputs
        while (!"slime".equals(userChoice.toLowerCase()) //while userChoice is not a valid monster or corresponding number, it will loop
                && !"1".equals(userChoice.toLowerCase())
                && !"ghost".equals(userChoice.toLowerCase())
                && !"2".equals(userChoice.toLowerCase())
                && !"skeleton".equals(userChoice.toLowerCase())
                && !"3".equals(userChoice.toLowerCase())) {
            try //try block to prevent input missmatch errors
            {
                userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                if (!"slime".equals(userChoice.toLowerCase()) //if user input is not valid
                        && !"1".equals(userChoice.toLowerCase())
                        && !"ghost".equals(userChoice.toLowerCase())
                        && !"2".equals(userChoice.toLowerCase())
                        && !"skeleton".equals(userChoice.toLowerCase())
                        && !"3".equals(userChoice.toLowerCase())) {
                    System.out.println("Sorry I didnt quite understand you, could you repeat that?");
                    System.out.println("Who will you choose to fight?");
                    System.out.println("1) Slime (easy)");
                    System.out.println("2) Ghost (medium)");
                    System.out.println("3) Skeleton (hard)");
                }
            } catch (InputMismatchException e) //in case of input missmatch
            {
                System.out.println("What language is that? could you repeat that?");
                System.out.println("Who will you choose to fight?");
                System.out.println("1) Slime (easy)");
                System.out.println("2) Ghost (medium)");
                System.out.println("3) Skeleton (hard)");
            }
        }
        switch (userChoice) //switch case depending on user input
        {
            case ("1"):     //case 1 falls through to slime
            case ("slime"): //if userChoice is slime
            {
                enemySelection = "slime";  //sets enemySelection as slime
                newEnemy = new RPGEnemy(enemySelection);  //creates new RPGEnemy object of type slime
                break;  //break from switch case
            }
            case ("2"):         //case 2 falls through to slime
            case "ghost": //if userChoice is ghost
            {
                enemySelection = "ghost";     //sets enemySelection as ghost
                newEnemy = new RPGEnemy(enemySelection); //creates new RPGEnemy object of type ghost
                break;  //break from switch case
            }
            case ("3"):         //case 3 falls through to slime
            case ("skeleton"): //if userChoice is skeleton
            {
                enemySelection = "skeleton";  //sets enemySelection as skelton
                newEnemy = new RPGEnemy(enemySelection); //creates new RPGEnemy object of type skeleton
                break;  //break from switch case
            }
        }
        //CREATING NEW BATTLE
        //creates new BattleStart object with the RPGPlayer object, and the RPGEnemy object
        BattleStart Battle = new BattleStart(newPlayer, newEnemy);
        Battle.startBattleLoop(); //calls the startBattleLoop method of the battle object
    }

}
