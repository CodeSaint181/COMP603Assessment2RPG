/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import java.util.Scanner;
import java.util.InputMismatchException;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

//GameStart Method - introduces you to the game and guides you through choosing a class,
//relic and enemy.
public class GameStart {
    public static Scanner userInput = new Scanner(System.in); //creates a new public static scanner object so it is accessable in other classes
    RPGPlayer newPlayer = null;     //initializes all the variables as empty so they can be filled by player input
    String username = "None";
    String playerClassSelection = "None";
    Boolean playerClassSelectionConfirmed = false;
    String relicSelection = "None";
    String enemySelection = "None";
    RPGEnemy newEnemy = null;
    String userChoice="";
    
    //the primary method of this class that will run you through choosing name,
    //class, relic, and enemy.
    void startGame() 
    {
        intro(); //calls the intro method to introduce you to the game
        
        //1 is begin game, 2 is exit
        while (!"1".equals(userChoice) && !"2".equals(userChoice))  //While the user does not enter either 1 or 2 it will repeat forever
        {
            userChoice = userInput.next();  //waits for user input and assigns it to userChoice variable
            if(!"1".equals(userChoice) && !"2".equals(userChoice))  //if input is not 1 or 2
            {
		System.out.println("\nPlease enter '1' or '2'");  
            }
        }
        
        switch(userChoice) { //switch case depending on user input
            case ("1"):      //if user entered 1 to start game
            {
                //CHOOSING NAME
                userChoice = "";  //clears userChoice variable to prevent skipping of if statements and double printing from acidental looping
                System.out.println("\nThen lets begin.");
                System.out.print("What is your name Traveller? \n");
                userInput.nextLine();   //clears userInput scanner
                while ("".equals(userChoice))   //while userChoice is empty, loop
                {
                    userChoice=userInput.nextLine();   //wait for user input and assigns it to userChoice variable
                    if ("".equals(userChoice))         //if userInput is still empty
                    {
                        System.out.println("Well theres no need to be shy Traveller!");
                        System.out.println("So, what is your name");
                    }
                } 
                //once user has entered a name
                username = userChoice; //assigns that name to username variable
                System.out.println("\n"+username+"...  What a strange name...");
                
                //CHOOSING PLAYER CLASS
                System.out.println("Now, what kind of person are you?");
                System.out.println("Are you a:");
                System.out.println("1) Warrior");
                System.out.println("2) Mage");
                System.out.println("3) Monk");
                while (playerClassSelectionConfirmed == false) //while the player hasnt confirmed the class they selected
                {
                    //if the player has chosen a class but did not confirm it, this will trigger and ask them what class they are again.
                    if ("warrior".equals(playerClassSelection.toLowerCase())
                            || ("1".equals(playerClassSelection.toLowerCase()))
                            || "mage".equals(playerClassSelection.toLowerCase())
                            || ("2".equals(playerClassSelection.toLowerCase()))
                            || "monk".equals(playerClassSelection.toLowerCase())
                            || ("3".equals(playerClassSelection.toLowerCase())))
                    {
                        System.out.println("Are you a:");
                        System.out.println("1) Warrior");
                        System.out.println("2) Mage");
                        System.out.println("3) Monk");
                        userChoice = userInput.nextLine().toLowerCase();  //wait for user input turns it lowercase and assigns it to userChoice variable 
                    }
                    
                    //while the player hasnt selected a valid class or corresponding number this will loop
                    while (!"warrior".equals(userChoice.toLowerCase())
                            && (!"1".equals(userChoice.toLowerCase()))
                            && !"mage".equals(userChoice.toLowerCase())
                            && (!"2".equals(userChoice.toLowerCase()))
                            && !"monk".equals(userChoice.toLowerCase())
                            && (!"3".equals(userChoice.toLowerCase())))
                    {
                        try {  //try block to check for input mismatch errors
                            userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                            if(!"warrior".equals(userChoice.toLowerCase()) //if the player hasnt selected a valid class or corresponding number
                                && (!"1".equals(userChoice.toLowerCase()))
                                && !"mage".equals(userChoice.toLowerCase())
                                && (!"2".equals(userChoice.toLowerCase()))
                                && !"monk".equals(userChoice.toLowerCase())
                                && (!"3".equals(userChoice.toLowerCase())))
                            {
                            System.out.println("Sorry I didnt quite understand you, could you repeat that?");
                            System.out.println("Are you a:");
                            System.out.println("1) Warrior");
                            System.out.println("2) Mage");
                            System.out.println("3) Monk");
                            } 
                        }
                        catch (InputMismatchException e) { //in the case of an input missmatch error
                            System.out.println("What language is that? could you repeat that?");
                            System.out.println("Are you a:");
                            System.out.println("1) Warrior");
                            System.out.println("2) Mage");
                            System.out.println("3) Monk");
                        }
                    }
                    switch (userChoice) { //switch case depending on user input
                        case ("1"):         //in the case userChoice is 1 it will fall through to warrior
                        case ("warrior"):   //in the case userChoice is warrior
                        {
                            playerClassSelection="warrior";    //sets playerClassSelection to warrior  
                            System.out.println("\nAh so you are a warrior!");    //prints details and info about the warrior class
                            System.out.println("You rely on your strong attacks and high defence to reduce damage.\n"
                                    + "You can use your skills to counter attack and deliver a large number of blows");
                            System.out.println("And your special abilities are 'Cross Slash', 'Swift Counter', and 'Blade Dance'.");
                            System.out.println("Does that sound right to you? (y/n)");
                            userInput.reset();  //clears userInput to prevent accidental inputs
                            userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                            if ("y".equals(userChoice))    //if player enters "y" to confirm class selection
                            {
                                playerClassSelectionConfirmed = true;   //set playerClassSelectionConfirmed to true
                                break;                                  //and break from switch case
                            }
                            else  //otherwise return back to class selection
                            {
                                System.out.println("Hmm, perhaps I misheard you.");
                                System.out.println("What Class were you again?");
                                break;  //break from switchcase
                            }
                        }
                        case ("2"):         //in the case userChoice is 2 it will fall through to mage
                        case ("mage"):      //in the case userChoice is mage
                        {
                            playerClassSelection="mage";        //sets playerClassSelection to mage 
                            System.out.println("\nAh very impressive, you are a mage!");    //prints details and info about the mage class
                            System.out.println("You use your high mana to cast elemental spells and inflict debuffs.\n"
                                    + "You can cast your Mage Armour to reduce damage.");
                            System.out.println("And your special abilities are 'Fire Bolts', 'Mage Armour', and 'Lightning Storm'.");
                            System.out.println("Does that sound right to you? (y/n)");
                            userInput.reset();     //clears userInput to prevent accidental inputs
                            userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                            if ("y".equals(userChoice))     //if player enters "y" to confirm class selection
                            {
                                playerClassSelectionConfirmed = true;   //set playerClassSelectionConfirmed to true
                                break;                                  //and break from switch case
                            }
                            else        //otherwise return back to class selection
                            {
                                System.out.println("Hmm, perhaps I misheard you.");
                                System.out.println("What Class were you again?");
                                break;  //break from switchcase
                            }
                        }
                        case ("3"):         //in the case userChoice is 3 it will fall through to monk
                        case ("monk"):      //in the case userChoice is monk
                        {
                            playerClassSelection="monk";        //sets playerClassSelection to monk
                            System.out.println("\nI see, you are a monk!");     //prints details and info about the monk class
                            System.out.println("You use your high agility to dodge attacks instead of block.\n"
                                    + "You can use your skills to heal yourself and attack multiple times a turn.");
                            System.out.println("And your special abilities are 'Quivering Palm', 'Golden Soul', and 'Flurry of Blows'.");
                            System.out.println("Does that sound right to you? (y/n)");
                            userInput.reset();      //clears userInput to prevent accidental inputs
                            userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                            if ("y".equals(userChoice))     //if player enters "y" to confirm class selection
                            {
                                playerClassSelectionConfirmed = true;   //set playerClassSelectionConfirmed to true
                                break;                                  //and break from switch case
                            }
                            else            //otherwise return back to class selection
                            {
                                System.out.println("Hmm, perhaps I misheard you.");
                                System.out.println("What Class were you again?");
                                break;      //break from switchcase
                            }
                        }
                    }
                }
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
                while (!"flame blade".equals(userChoice.toLowerCase())
                        && !"1".equals(userChoice.toLowerCase())
                        && !"lightning bracer".equals(userChoice.toLowerCase())
                        && !"2".equals(userChoice.toLowerCase())
                        && !"holy stone".equals(userChoice.toLowerCase())
                        && !"3".equals(userChoice.toLowerCase()))
                {
                    userInput.reset(); //reset userInput to prevent accidental inputs
                    try  //try block to check for input mismatch errors
                    {
                        userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                        if(!"flame blade".equals(userChoice.toLowerCase()) //if the player hasnt selected a valid relic or corresponding number
                            && !"1".equals(userChoice.toLowerCase())
                            && !"lightning bracer".equals(userChoice.toLowerCase())
                            && !"2".equals(userChoice.toLowerCase())
                            && !"holy stone".equals(userChoice.toLowerCase())
                            && !"3".equals(userChoice.toLowerCase()))
                        {
                            System.out.println("Sorry I didnt quite understand you, could you repeat that?");
                            System.out.println("Do you have the:");
                            System.out.println("1) Flame Blade");
                            System.out.println("2) Lightning Bracer");
                            System.out.println("3) Holy Stone");
                        } 
                    }
                    catch (InputMismatchException e)  //in the case of an input missmatch error
                    {
                        System.out.println("What language is that? could you repeat that?");
                        System.out.println("Do you have the:");
                        System.out.println("1) Flame Blade");
                        System.out.println("2) Lightning Bracer");
                        System.out.println("3) Holy Stone");
                    }
                    
                }
                switch (userChoice)  //switch case based on userChoice variable
                {
                    case ("1"):             //case 1 falls through to flame blade
                    case ("flame blade"):   //if userChoice is flame blade 
                    {
                        relicSelection = "flame blade";  //set relicSelection as "flame blade"
                        break;   //break from switch case
                    }
                    case ("2"):                 //case 2 falls through to lightning bracer
                    case ("lightning bracer"):  //if userChoice is lightning bracer 
                    {
                        relicSelection = "lightning bracer";    //set relicSelection as "lightning bracer"
                        break;   //break from switch case
                    }
                    case ("3"):                 //case 3 falls through to holy stone
                    case ("holy stone"):        //if userChoice is holy stone 
                    {
                        relicSelection = "holy stone";      //set relicSelection as "holy stone"
                        break;   //break from switch case
                    }
                }
                System.out.println("\nI see let me write this all down.");
                //creates new RPGPlayer object based on the variables player has filled out so far
                newPlayer = new RPGPlayer(username,playerClassSelection,relicSelection);
                System.out.println("Very well "+RPGPlayer.name+", all your details are in order.");
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
                userChoice="";   //clears userChoice to prevent accidental inputs
                while (!"slime".equals(userChoice.toLowerCase())  //while userChoice is not a valid monster or corresponding number, it will loop
                        && !"1".equals(userChoice.toLowerCase())
                        && !"ghost".equals(userChoice.toLowerCase()) 
                        && !"2".equals(userChoice.toLowerCase())
                        && !"skeleton".equals(userChoice.toLowerCase())
                        && !"3".equals(userChoice.toLowerCase()))
                {
                    try //try block to prevent input missmatch errors
                    {
                        userChoice = userInput.nextLine().toLowerCase(); //wait for user input turns it lowercase and assigns it to userChoice variable 
                        if (!"slime".equals(userChoice.toLowerCase())   //if user input is not valid
                            && !"1".equals(userChoice.toLowerCase())
                            && !"ghost".equals(userChoice.toLowerCase()) 
                            && !"2".equals(userChoice.toLowerCase())
                            && !"skeleton".equals(userChoice.toLowerCase())
                            && !"3".equals(userChoice.toLowerCase()))
                        {
                            System.out.println("Sorry I didnt quite understand you, could you repeat that?");
                            System.out.println("Who will you choose to fight?");
                            System.out.println("1) Slime (easy)");
                            System.out.println("2) Ghost (medium)");
                            System.out.println("3) Skeleton (hard)");
                        } 
                    }
                    catch (InputMismatchException e) //in case of input missmatch
                    {
                        System.out.println("What language is that? could you repeat that?");
                        System.out.println("Who will you choose to fight?");
                        System.out.println("1) Slime (easy)");
                        System.out.println("2) Ghost (medium)");
                        System.out.println("3) Skeleton (hard)");
                    }
                }
                switch (userChoice)  //switch case depending on user input
                {
                    case ("1"):     //case 1 falls through to slime
                    case ("slime"): //if userChoice is slime
                    {
                        enemySelection="slime";  //sets enemySelection as slime
                        newEnemy = new RPGEnemy(enemySelection);  //creates new RPGEnemy object of type slime
                        break;  //break from switch case
                    }
                    case ("2"):         //case 2 falls through to slime
                    case "ghost":       //if userChoice is ghost
                    {
                        enemySelection="ghost";     //sets enemySelection as ghost
                        newEnemy = new RPGEnemy(enemySelection); //creates new RPGEnemy object of type ghost
                        break;  //break from switch case
                    }
                    case ("3"):         //case 3 falls through to slime
                    case ("skeleton"): //if userChoice is skeleton
                    {
                        enemySelection="skeleton";  //sets enemySelection as skelton
                        newEnemy = new RPGEnemy(enemySelection); //creates new RPGEnemy object of type skeleton
                        break;  //break from switch case
                    }
                }
                //CREATING NEW BATTLE
                //creates new BattleStart object with the RPGPlayer object, and the RPGEnemy object
                BattleStart Battle = new BattleStart(newPlayer, newEnemy); 
                Battle.startBattleLoop(); //calls the startBattleLoop method of the battle object
                break;
            }

            case ("2"): { //if user enters 2 at main menu exit the program
                System.out.println("Until next time!");
            }
        }

        
    }
    
    void intro() {
            System.out.println("  _____ ____  __  __ _____   __   ___ ____    _____  _____   _____ \n" +
                               " / ____/ __ \\|  \\/  |  __ \\ / /  / _ \\___ \\  |  __ \\|  __ \\ / ____|\n" +
                               "| |   | |  | | \\  / | |__) / /_ | | | |__) | | |__) | |__) | |  __ \n" +
                               "| |   | |  | | |\\/| |  ___/ '_ \\| | | |__ <  |  _  /|  ___/| | |_ |\n" +
                               "| |___| |__| | |  | | |   | (_) | |_| |__) | | | \\ \\| |    | |__| |\n" +
                               " \\_____\\____/|_|  |_|_|    \\___/ \\___/____/  |_|  \\_\\_|     \\_____|");
            System.out.println("Welcome player to the COMP603 RPG Fighting Game!");
            System.out.println("This is a One on One RPG Fight against an enemy of your choice.");
            System.out.println("I bid you welcome!");
            System.out.println("But first you must choose...");
            System.out.println("\t1) Begin Game");
            System.out.println("\t2) Exit");
	}
}
