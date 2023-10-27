/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import static assessment2rpg.GameStart.userInput;
import javax.swing.JOptionPane;

/**
 * ********************
 * Group 75 COMP603/52A Project 1 Sahil Dhanda 20122024
 *
 * @author sahil ********************
 */
//BattleStart class - the main battle loop of the game.
public class BattleStart {

    //All the various miscellaneous variables needed for this class
    boolean victory = false;
    boolean loss = false;
    boolean forfeit = false;
    String battleChoice = "";
    int battleChoiceNum = 0;
    boolean battleActionConfirmed = false;
    int hitMax = 20;
    int hitMin = 1;
    boolean critical = false;
    int hitDamage = 0;
    int turnCounter = 1;
    int shockDamage = 0;
    int directDamage = 0;
    public String combatLog = "test";

    //all the player variables needed for this class
    RPGPlayer battlePlayer = null;
    int playerHealth = 100;
    int playerMana = 50;
    boolean playerCharge = false;
    int playerDefenseModifier = 0;
    int playerDodgeModifier = 0;
    int playerTurnsCharged = 0;
    boolean playerFlurry = false;
    boolean playerParry = false;
    int turnPlayerDamage = 0;

    //all the enemy variables needed for this class
    RPGEnemy battleEnemy = null;
    boolean enemyTurn=false;
    int enemyHealth = 100;
    boolean enemyCharge = false;
    int enemyTurnsCharged = 0;
    int enemyDodgeModifier = 0;
    int enemyAttackModifier = 0;
    boolean enemyPhaseChange = false;
    boolean enemyDefend = false;

    //constructor to create the BattleStart object and set a few values based on the input RPGPlayer and RPGEnemy objects
    public BattleStart(RPGPlayer newplayer, RPGEnemy newenemy) {
        battlePlayer = newplayer;  //sets battlePlayer as input RPGPlayer object
        playerHealth = RPGPlayer.playerClass.getHealthPoints();  //sets the player's health to the health of the RPGPlayerClass using the getter
        playerMana = RPGPlayer.playerClass.getManaPoints();      //sets the player's mana to the mana of the RPGPlayerClass using the getter
        battleEnemy = newenemy;   //sets battleEnemy as input RPGEnemy object
        enemyHealth = RPGEnemy.enemyClass.getHealthPoints();     //sets the enemy's health to the health of the RPGEnemyClass using the getter
        combatLog = "";
    }

    //player attack class with switch cases depending on playerClass the player is using
    public void attack() {
        switch (RPGPlayer.className) //switch case based on playerClass name
        {
            case ("warrior"): // if user is playing a warrior
            {
                combatLog = combatLog.concat("You slash at the " + RPGEnemy.enemyClass.name + " with your sword!\n");
                targetEnemy();
                battleActionConfirmed=true;
                break;
            }
            case ("mage"): // if user is playing a mage
            {
                combatLog = combatLog.concat("You fire a magic bolt at the " + RPGEnemy.enemyClass.name + "!\n");
                targetEnemy();
                battleActionConfirmed=true;
                break;
            }
            case ("monk"): // if user is playing a monk
            {
                if (playerFlurry == true) //and if they have activated their Flurry of blows ability
                {
                    combatLog = combatLog.concat("You pummel the " + RPGEnemy.enemyClass.name + " with a barrage of blows!\n");
                    targetEnemy();
                    targetEnemy();
                    targetEnemy();
                    battleActionConfirmed=true;
                    break;
                }
                combatLog = combatLog.concat("You strike at the " + RPGEnemy.enemyClass.name + " with your fist!\n");
                targetEnemy();
                battleActionConfirmed=true;
                break;
            }
        }
    }

    //player defend class with switch cases depending on playerClass the player is using
    public String defend() {
        switch (RPGPlayer.className) //switch case based on playerClass name
        {
            case ("warrior"): // if user is playing a warrior
            {
                //sets the playerDefenseModifier to the PlayerClasses defense essentially doubling the player's defense
                playerDefenseModifier = (RPGPlayer.playerClass.getDefense());
                battleActionConfirmed=true;
                return ("You brace for the enemy's attack doubling your defense for the turn");
            }
            case ("mage"): // if user is playing a mage
            {
                //sets the playerDefenseModifier to the PlayerClass's defense essentially doubling the player's defense
                playerDefenseModifier = (RPGPlayer.playerClass.getDefense());
                battleActionConfirmed=true;
                return ("You prepare a magical shield doubling your defense for the turn");
            }

            case ("monk"): // if user is playing a monk
            {
                //sets the playerDodgeModifier to the PlayerClass's dodge essentially doubling the player's defense
                playerDodgeModifier = (RPGPlayer.playerClass.getDodge());
                battleActionConfirmed=true;
                return ("You use your inner energy to enhance your dodging ability");
            }
        }
        return "failed";
    }

    //player ability class with switch cases depending on playerClass the player is using
    //and switch cases depending on which ability the player uses
    //if player exits out of this class without selecting an ability they are sent back to battle menu
    public void ability(int index) {
        switch (RPGPlayer.className) //switch case based on the user's class name
        {
            case ("warrior"): //if user is playing a warrior
            {
                switch (index) //switch case depending on which ability the user entered
                {
                    case (1):            //case for ability 1 that falls through to the case with the specific ability name
                    {
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana) //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break; //break from switch case and returns to ability menu
                        } else // if player has more playermana than the manacost of the ability
                        {
                            combatLog = combatLog.concat("\nYou perform a Cross Slash, hitting the " + RPGEnemy.enemyClass.name + " twice!\n");
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)))); //reduces playermana by the manacost of the ability
                            for (int i = 1; i <= 2; i++) //for loop that will loop twice as this ability damages the opponent twice
                            {
                                directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2)));
                                //sets directDamage to the value in the ability arraylist
                                hitDamage = calculateDamageDirect(directDamage); //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                                damageEnemy(hitDamage, battleEnemy, (RPGEnemy.enemyClass.getDefense()));
                                //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                            }
                            battleActionConfirmed = true; //confirms battle choice
                            break; //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                    case (2):                 //case for ability 2 that falls through to the case with the specific ability name
                    {
                        //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;  //break from switch case and returns to ability menu
                        } else // if player has more playermana than the manacost of the ability
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduces playermana by the manacost of the ability
                            combatLog = combatLog.concat("\nYou perform a Swift Counter, getting into a counter stance!\n");
                            playerParry = true;           //sets the playerParry boolean to true
                            battleActionConfirmed = true; //confirms battle choice
                            break;   //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                    case (3):         //case for ability 3 that falls through to the case with the specific ability name
                    {
                        //if ability 3's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;      //break from switch case and returns to ability menu
                        } else // if player has more playermana than the manacost of the ability
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)))); //reduces playermana by the manacost of the ability
                            combatLog = combatLog.concat("\nYou begin to charge up your Blade Dance!\n");
                            playerCharge = true;  //sets playerCharge boolean to true
                            playerTurnsCharged++;       //Increments the playerTurnsCharged variable by 1
                            battleActionConfirmed = true; //confirms battle choice
                            break;      //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                }
                break;
            }
            case ("mage"): //if user is playing a mage
            {
                switch (index) //switch case depending on which ability the user entered
                {
                    case (1):         //case for ability 1 that falls through to the case with the specific ability name
                    {
                        //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break; //break from switch case and returns to ability menu
                        } else //if user has enough mana
                        {
                            String fireboltChecker = JOptionPane.showInputDialog("How many bolts to summon? (8 mana/bolt)(up to 5)\n Current Mana: " + playerMana+"\n");
                            //waits for user input, makes it lowercase and assigns it to battleChoice
                            fireboltChecker = fireboltChecker.replaceAll("[^1-9]","");
                            if ("".equals(fireboltChecker))
                            {
                                combatLog = combatLog.concat("invalid number of bolts.\n");
                                break;
                            }
                            battleChoiceNum = Integer.parseInt(fireboltChecker);  //gets the number from battle choice, parses it as it is a string and then assigns it to battleChoiceNum
                            if ((battleChoiceNum) * 8 > playerMana) //if battlechoicenum times 8 is lower than the player's mana they cant cast the spell
                            {
                                combatLog = combatLog.concat("Not enough mana.\n");
                                break; //break from switch case and returns to ability menu
                            } else if ((battleChoiceNum) > 5) //if battlechoicenum is greater than 5 then they cannot cast the spell
                            {
                                combatLog = combatLog.concat("Too many bolts.\n");
                            } else if ((battleChoiceNum) < 1) //if battlechoicenum is less than 1 then they cannot cast the spell
                            {
                                combatLog = combatLog.concat("Invalid number of bolts.\n");
                            } else //if the number of bolts is valid and they have enough mana to cast
                            {
                                combatLog = combatLog.concat("\nYou fire off a Fire Bolt, which splits off into " + battleChoiceNum + " fire bolts which strike " + RPGEnemy.enemyClass.name + " " + battleChoiceNum + " times!\n");
                                playerMana = (playerMana - ((Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3))) * battleChoiceNum));
                                //reduces player's mana by the cost of the ability times the number of bolts cast
                                for (int i = 1; i <= battleChoiceNum; i++) //for loop that will loop for the number of bolts the user entered
                                {
                                    directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2)));
                                    //sets directDamage to the value in the ability arraylist
                                    hitDamage = calculateDamageDirect(directDamage);
                                    //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                                    damageEnemy(hitDamage, battleEnemy, (RPGEnemy.enemyClass.getDefense()));
                                    //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                                    RPGEnemy.enemyClass.addDebuff("Flame", 2); //inflicts 2 stacks of Flame into enemy's status effects hashmap
                                    combatLog = combatLog.concat("Inflicted 2 Burn onto " + RPGEnemy.enemyClass.name + "\n");
                                }
                                battleActionConfirmed = true; //confirms battle choice
                                break; //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                            break; //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                    case (2):                 //case for ability 2 that falls through to the case with the specific ability name
                    {
                        //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;
                        } else //if user has enough mana
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduce player mana by ability cost
                            combatLog = combatLog.concat("\nYou summon a set of magical armour, increasing your defense and damaging attacking enemies for the turn!\n");
                            playerDefenseModifier = 4; //sets playerdefense modifier to 4
                            playerParry = true;      //sets playerParry Boolean to true
                            battleActionConfirmed = true; //confirms battle choice
                            break; //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                    case (3):                 //case for ability 3 that falls through to the case with the specific ability name
                    {
                        //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;
                        } else //if user has enough mana
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)))); //reduce playerMana by ability cost
                            combatLog = combatLog.concat("\nYou begin to channel a Lightning Storm to strike your enemies!\n");
                            playerCharge = true; //sets playerCharge boolean to true
                            playerChargeAbility();   //calls playerChargeAbility method
                            battleActionConfirmed = true; //confirms battle choice
                            break;  //break from switch case and returns to main battle loop as battle choice is confirmed
                        }
                    }
                }
                break;
            }
            case ("monk"): //if user is playing a monk
            {
                switch (index) //switch case depending on which ability the user entered
                {
                    case (1):             //case for ability 1 that falls through to the case with the specific ability name
                    {
                        //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;
                        } else //if player has enough mana
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3))));   //reduce player mana by ability cost
                            combatLog = combatLog.concat("You strike the " + RPGEnemy.enemyClass.name + " with an open palm disrupting their body's energy!\n");
                            RPGEnemy.enemyClass.addDebuff("Vulnerable", 3); //puts 3 stacks of Vulnerable onto enemy's status effect hashmap
                            combatLog = combatLog.concat("Inflicted 2 Vulnerable onto " + RPGEnemy.enemyClass.name + "\n"); //it says 2 stacks as 1 stack will get lost at the end of the turn
                            directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2))); //directdamage is set to the damage value of the ability
                            hitDamage = calculateDamageDirect(directDamage); //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                            damageEnemy(hitDamage, battleEnemy, 0); //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage while ignoring the enemy's defense
                            battleActionConfirmed = true; //confirms battle choice
                            break;
                        }
                    }
                    case (2):                 //case for ability 2 that falls through to the case with the specific ability name
                    {
                        //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;
                        } else //if player has enough mana
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduce mana by ability cost
                            combatLog = combatLog.concat("You center your spirit, healing yourself of bodily ailments!\n");
                            //uses playerClass's setDebuff method to set all status effects to 0
                            RPGPlayer.playerClass.setDebuff("Vulnerable", 0);
                            RPGPlayer.playerClass.setDebuff("Shock", 0);
                            RPGPlayer.playerClass.setDebuff("Flame", 0);
                            combatLog = combatLog.concat("Cleared Status effects!\n");
                            playerHealth = playerHealth + (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(2)));
                            //heals player health by the "damage" value of the ability
                            combatLog = combatLog.concat("You regained " + (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(2))) + " Health!\n");
                            battleActionConfirmed = true; //confirms battle choice
                            break;
                        }
                    }
                    case (3):                 //case for ability 3 that falls through to the case with the specific ability name
                    {
                        //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                        //using parseInt as the arrayList is full of strings and not integers
                        if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana) {
                            combatLog = combatLog.concat("Not enough mana.\n");
                            break;
                        } else //if player has enough mana
                        {
                            playerMana = (playerMana - (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3))));
                            combatLog = combatLog.concat("You gather your body's energy in your fists!\n");
                            playerFlurry = true;   //sets playerFlurry boolean to true
                            playerTurnsCharged=3;
                            battleActionConfirmed = true;//confirms battle choice
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    //method used for activating player abilities that take multiple turns to use.
    public void playerChargeAbility() {
        battleActionConfirmed = true;
        switch (RPGPlayer.className) //switch case for which class player is using
        {
            case ("warrior"): //if user is playing warrior
            {
                
                if (playerTurnsCharged<3)
                {
                    playerTurnsCharged++;
                    break;
                }
                combatLog = combatLog.concat("\nYou perform a Blade Dance, a whirlwind of metal around you, as you rush the " + RPGEnemy.enemyClass.name + "!");
                playerTurnsCharged = 0; //sets the playerTurnsCharged variable to 0 to reset the ability
                int PlayerHits = 5;   //individual variable allows for easy editing of the number of hits this ability performs
                for (int i = 0; i < PlayerHits; i++) // loops for the number of times set by player hits
                {
                    directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(2))); //sets direct damage to the ability's damage value
                    hitDamage = calculateDamageDirect(directDamage);  //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                    damageEnemy(hitDamage, battleEnemy, RPGEnemy.enemyClass.getDefense());
                    //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                }
                playerCharge = false; //sets the playerCharge boolean to false indicating the ability is finished casting
                break; //returns to battle menu
            }
            case ("mage"): //if user is playing mage
            {
                playerTurnsCharged++;
                combatLog = combatLog.concat("Lightning strikes the ground all around you!");
                if (playerTurnsCharged == 2) //if player has been charging this ability for 2 turns
                {
                    playerTurnsCharged = 0; //sets turns charged to 0
                    playerCharge = false;  //and sets playerCharge to false
                }
                directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(2)));  //sets direct damage to the ability's damage value
                hitDamage = calculateDamageDirect(directDamage);   //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                damageEnemy(hitDamage, battleEnemy, RPGEnemy.enemyClass.getDefense());
                //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                RPGEnemy.enemyClass.addDebuff("Shock", 4); //puts 4 shock into the enemy's status effect hashmap
                combatLog = combatLog.concat("Inflicted 4 Shock onto " + RPGEnemy.enemyClass.name + "\n");
                break; //returns to battle menu
            }
        }
    }

    //method for decideing what the enemy does on it's turn
    public void enemyTurn() {
        int enemyChoice = (int) (Math.random() * (20) + 1);
        //randomizer with range of 1 to 20
        if (enemyChoice <= 19) { //if enemy gets less than or equal to 19 they get to use an ability or attack
            EnemyAbility();
        } else //otherwise if they get 20 they lose their turn
        {
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " got confused and wasted it's turn.\n");
        }
    }

    public void EnemyAttack() {
        switch (RPGEnemy.enemyClass.name) //switch case based on what enemy you are fighting
        {
            case ("Slime"): //if slime
            {
                combatLog = combatLog.concat("Slime tries to slam into you!\n");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Skeleton"): //if skeleton
            {
                combatLog = combatLog.concat("Skeleton slashes at you with a sharpened bone!\n");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Revenant"): //if revenant
            {
                combatLog = combatLog.concat("Revenant furiously claws at you with it's razor sharp broken bones!\n");
                targetPlayer();
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Ghost"): //if ghost
            {
                combatLog = combatLog.concat("Ghost swipes at you with it's cold ghostly hands!\n");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
        }
    }

    //method for triggering enemy abilites
    public void EnemyAbility() {
        switch (RPGEnemy.enemyClass.name) //switches based on type of enemy
        {
            case ("Slime"): //if slime
            {
                //if statments are ordered so enemy will use the most powerful ability that is off cooldown,
                //otherwise they will just attack if nothing is off cooldown
                if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyCharge = true; //sets enemyCharge boolean to true to trigger the enemy's special ability next turn
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " spends it's turn swallowing up objects.\nYou dont think your armour will help much against it's next attack!\n");
                    RPGEnemy.enemyClass.getAbility(3).set(3, "6"); //sets the ability back on 6 turns of cooldown
                    break;
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend = true; //sets enemyDefend boolean to true
                    enemyDodgeModifier = RPGEnemy.enemyClass.getDodge(); // sets enemyDodgeModifier to the enemy's classes base dodge rate, effectively double their dodge rate
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " flattens itself out.\nIts gonnna be harder to hit it for a bit!\n");
                    RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets the ability back on 4 turns of cooldown
                    break;
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " throws a glob of acidic slime at you.\nIt melts right through your defense!\n");
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2))); //gets damage from ability arraylist 
                    hitDamage = calculateDamageDirect(directDamage); //and calculates the damage using the method
                    damagePlayer(hitDamage, battlePlayer, 0); //calls damagePlayer method to deal damage based on hit damage and ignoring player's defence
                    RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets the ability back on 2 turns of cooldown
                    break;
                } else //if everything is on cooldown
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
            case ("Revenant"): //if enemy is Revenant  (phase 2 version of skeleton), fall through to skeleton case
            case ("Skeleton"): //if enemy is skeleton
            {
                if ((Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0 
                        && (enemyHealth < (RPGEnemy.enemyClass.getHealthPoints() / 2)) //and thye are below half health
                        && (enemyPhaseChange != true))// and if enemy phase change is not yet true
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " gets so angry it loses it's head and vows to take you down!"
                            + "\nYou dont think this is a normal skeleton anymore!");
                    RPGEnemy.enemyClass.name = "Revenant"; //changes enemy name from skeleton to Revenant
                    enemyPhaseChange = true;  //and sets enemyPhaseChange to true
                    break;
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend = true; //sets enemyDefend to true
                    RPGEnemy.enemyClass.addDebuff("Vulnerable", 2); //inflicts 2 stacks of vulnerable to it's own status effect hashmap
                    if ("Revenant".equals(RPGEnemy.enemyClass.name)) //if the enemy is called Revenant, it triggeres a different description
                    {
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " taps into its sheer rage and pulls itself back together."
                                + "\nIt looks easier to damage right now!");
                        RPGEnemy.enemyClass.getAbility(2).set(3, "3"); //sets the ability back on 3 turns of cooldown
                        break;
                    } else //if it is not called a revenant
                    {
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " taps into its undead nature and begins to reconstruct some of it's body."
                                + "\nIt looks easier to damage right now!");
                        RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets the ability back on 4 turns of cooldown
                        break;
                    }
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    if ("Revenant".equals(RPGEnemy.enemyClass.name)) //if enemy is revenant triggers a more powerful version of the ability
                    {
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " rips off one of its ribs and throws it at you in anger.\nIt seems to hurt itself when it does this!\n");
                        enemyHealth = enemyHealth - (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.08); // deals damage to itself equal to 8% of its max health
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " took " + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.08) + " Damage!");
                        directDamage = (int) ((Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2))) * 1.5); //dealts 1.5 times the usual damage of the ability
                        hitDamage = calculateDamageDirect(directDamage);
                        damagePlayer(hitDamage, battlePlayer, RPGPlayer.playerClass.getDefense());
                        RPGPlayer.playerClass.addDebuff("Flame", 2);
                        combatLog = combatLog.concat("Inflicted 2 Burn onto " + RPGPlayer.name + "\n");
                        RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets cooldown to 2 turns
                        break;
                    } else //if not a revenant trigger the normal version of the ability
                    {
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " takes one of it's bones and throws it at you.\nIt seems to hurt itself when it does this!\n");
                        enemyHealth = enemyHealth - (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.1); //loses 10% of its health
                        combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " took " + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.1) + " Damage!\n");
                        directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2))); // sets directDamage to the damage value of the ability
                        hitDamage = calculateDamageDirect(directDamage);
                        damagePlayer(hitDamage, battlePlayer, RPGPlayer.playerClass.getDefense());
                        RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets cooldown to 2 turns
                        break;
                    }
                } else //otherwise it attacks if no abilities are avalible
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
            case ("Ghost"): //enemy is ghost
            {
                if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyCharge = true; //sets enemy charge to true
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " spends it's turn charging up a bolt of ghostly electricity.\nYou don't think you can get out of the way of this one!");
                    RPGEnemy.enemyClass.getAbility(3).set(3, "6"); //sets cooldown to 6 turns
                    break;
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend = true; //sets enemy defend to true
                    enemyDodgeModifier = 21; //sets enemy dodge modifier to 21 giving it at least a 110% to dodge all attacks for next round
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " becomes translucent.\nAny weak attacks will go right through it.");
                    RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets cooldown to 4 turns
                    break;
                } else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " shoots a bolt of ghostly energy.\nIt goes straight through your defense!\nYou feel more vulnerable now.");
                    RPGPlayer.playerClass.addDebuff("Vulnerable", 3); //gives player 3 stacks of vulnerable on their status effect HashMap
                    //this will only last 2 turns as the first stack will be lost at the end of the turn
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2)));
                    hitDamage = calculateDamageDirect(directDamage);
                    damagePlayer(hitDamage, battlePlayer, 0);
                    RPGEnemy.enemyClass.getAbility(1).set(3, "3");//sets cooldown to 4 turns
                    break;
                } else //otherwise it attacks if no abilities are avalible
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
        }
    }

    //method for resolving enemy charge abilities that take multiple turns to cast
    public void enemyChargeAbility() {
        switch (RPGEnemy.enemyClass.name) //switch case for type of enemy
        {
            case ("Slime"): //if slime
            {
                int EnemyHits = (int) (Math.random() * (4) + 1); //sets enemy hits to random amount from 4 to 1
                for (int i = 0; i <= EnemyHits; i++) //loops for number of enemyHits
                {
                    directDamage = (int) (Math.random() * (5) + 4); //sets directDamage to random number from 8-4
                    hitDamage = calculateDamageDirect(directDamage);
                    damagePlayer(hitDamage, battlePlayer, (int) (RPGPlayer.playerClass.getDefense() / 3)); //damages player while ignoring 2/3 of their defense
                }
                enemyCharge = false; //sets enemy charge to false
                break;
            }
            case ("Ghost"): //if ghost
            {
                int EnemyHits = (int) (Math.random() * (7) + 3);  //sets enemy hits to random amount from 9 to 3
                for (int i = 0; i <= EnemyHits; i++) //loops for number of enemyHits
                {
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(2))); //sets directDamage to ability damage value
                    hitDamage = calculateDamageDirect(directDamage);
                    damagePlayer(hitDamage, battlePlayer, 0); //damages player while ignoring their defense
                    RPGPlayer.playerClass.addDebuff("Shock", 1); //inflicts 1 stack of shock to player's status effects hashmap
                    combatLog = combatLog.concat("Inflicted 1 Shock onto " + RPGPlayer.name + "\n");
                }
                enemyCharge = false; //sets enemy charge to false
                break;
            }
        }
    }

    //method for when player attacks enemy with a normal attack, with accuracy calculation
    public void targetEnemy() {
        int HitChance = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number from 20-1
        if (HitChance < (RPGEnemy.enemyClass.getDodge() + enemyDodgeModifier)) //if hitchance is less than the enemy's dodge chance plus dodge modifier player misses
        {
            switch (RPGEnemy.enemyClass.name) //switch depending on enemy type
            {
                case ("Slime"): //if slime
                {
                    combatLog = combatLog.concat("You Missed!\nThe Slime morphs itself so your attack passes through.\n");
                    break;
                }
                case ("Skeleton"): //if skeleton
                {
                    combatLog = combatLog.concat("You Missed!\nYour attack passes right through the Skeleton's ribcage.\n");
                    break;
                }
                case ("Revenant"): //if revenant
                {
                    combatLog = combatLog.concat("You Missed?\nYour attack connected with the Revenant but its too angry to notice.\n");
                    break;
                }
                case ("Ghost"): //if ghost
                {
                    if (enemyDodgeModifier > 20) //if ghost's second ability is active
                    {
                        combatLog = combatLog.concat("You Missed!\nYour attack phases right through it as you expected.\n");
                        break;
                    } else //otherwise
                    {
                        combatLog = combatLog.concat("You Missed!\nThe Ghost slips right out of your range as you swing.\n");
                        break;
                    }
                }
            }
        } else {
            hitDamage = calculateDamage(RPGPlayer.playerClass.getAttackPoints()); //call the calculateDamage function which uses the player's class attack power
            damageEnemy(hitDamage, battleEnemy, RPGEnemy.enemyClass.getDefense()); //damage the enemy using the calculated damage, taking into account the enemy's defense     
        }
    }

    //method for when enemy attacks the player with a normal attack, with accuracy calculation
    public void targetPlayer() {
        int HitChance = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number from 20-1
        if (HitChance < (RPGPlayer.playerClass.getDodge() + playerDodgeModifier)) //if hitchance is less than the player's dodge chance plus dodge modifier enemy misses
        {
            switch (RPGPlayer.className) //switch depending on player class
            {
                case ("warrior"): //warrior
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " Missed!\nYou blocked their attack using your heavy armour.\n");
                    break;
                }
                case ("mage"): //mage
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " Missed!\nYou put up a magical barrier at the last second.\n");
                    break;
                }
                case ("monk"): //monk
                {
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " Missed!\nYou dodged out of the way of their blow.\n");
                    break;
                }
            }
        } else {
            if (enemyPhaseChange == true) //if the enemy has changed phase
            {
                enemyAttackModifier = 6; //add 6 to the enemy's attack modifier
            }
            //call the calculateDamage function which uses the enemy's class attack power plus the enemy attack modifier
            hitDamage = calculateDamage(RPGEnemy.enemyClass.getAttackPoints() + enemyAttackModifier);
            //damage the player using the calculated damage, taking into account the player's defense and defense modifier
            damagePlayer(hitDamage, battlePlayer, (RPGPlayer.playerClass.getDefense() + playerDefenseModifier));
        }
    }

    //method to calculate hit damage using either player or enemy's attack power
    public int calculateDamage(int dmgStat) {
        int CriticalHit = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number between 20 and 1 inclusive
        if (CriticalHit > 18) //if the number is greater than 18
        {
            critical = true; //critical boolean is set to true
        }
        int Damage = (int) (Math.random() * ((dmgStat + (dmgStat / 2)) - (dmgStat - (dmgStat / 2)) + 1) + (dmgStat - (dmgStat / 2)));
        //random number between 1.5x attack power, and 0.5x attack power
        if (critical == true) // if critical boolean is true
        {
            Damage = (Damage * 2); //double the damage for a critical hit
            critical = false;
            combatLog = combatLog.concat("Critical Hit!!(2X DMG)\n");
        }
        return Damage; //return the final damage
    }

    //method to calculate hit damage using input number instead of attack power
    public int calculateDamageDirect(int directDamage) {
        int CriticalHit = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number between 20 and 1 inclusive
        if (CriticalHit >= 18) //if the number is greater than 18
        {
            critical = true; //critical boolean is set to true
        }
        int Damage = directDamage; //base damage is set to input damage
        if (critical == true) // if critical boolean is true
        {
            Damage = (Damage * 2); //double the damage for a critical hit
            critical = false;
            combatLog = combatLog.concat("Critical Hit!!(2X DMG)\n");
        }
        return Damage;  //return the final damage
    }

    //method for resolving damage against enemies
    //takes into account status effects the enemy may have
    //and any on hit relics the player may have
    public void damageEnemy(int damage, RPGEnemy enemy, int mitigation) {
        if (RPGEnemy.enemyClass.getDebuff("Shock") > 0) //if enemy has more than 0 shock in their status effect hashmap
        {
            shockDamage = (RPGEnemy.enemyClass.getDebuff("Shock")); //assigns shockDamage as the number of shock the enemy has
        }
        int mitigateddamage = damage - mitigation; //reduces provided hit damage by the enemies defense(mitigation)
        if (RPGEnemy.enemyClass.getDebuff("Vulnerable") > 0) //if enemy has more than 0 vulnerable in their status effect hashmap
        {
            mitigateddamage = (mitigateddamage * 2); //double hit damage for a vulnerable hit
            combatLog = combatLog.concat("Vulnerable Hit!!(2X DMG)\n");
        }
        if ((mitigateddamage + shockDamage) <= 0) //if hit damage and shock damage combined is less than or equal to 0
        {
            combatLog = combatLog.concat("You failed to deal any damage through enemy's defense!\n");
            return; //return without dealing damage
        }
        enemyHealth = enemyHealth - (mitigateddamage + shockDamage); //deal damage to enemyHealth equal to hit damage and shock damage
        if (RPGEnemy.enemyClass.getDebuff("Shock") != 0) //if the enemy had more than 0 shock
        {
            //print the damage dealt as well as shock damage dealt
            combatLog = combatLog.concat("You deal " + mitigateddamage + " damage + " + shockDamage + " shock damage to " + RPGEnemy.enemyClass.name + "!\n");
        } else //if enemy had no shock
        {
            //only prints the damage dealt
            combatLog = combatLog.concat("You deal " + mitigateddamage + " damage to " + RPGEnemy.enemyClass.name + "!\n");
        }
        //adds the damage dealt to the turnPlayerDamage variable that keeps track of damage dealt by player each round
        turnPlayerDamage = turnPlayerDamage + mitigateddamage;
        if ("Hit".equals(RPGPlayer.playerRelic.getTrigger())) //if the player's relic trigger condition is on "Hit"   
        {
            //triggers the relic using the relicTriggerEnemy method from the relic class
            RPGPlayer.playerRelic.relicTriggerEnemy(RPGEnemy.enemyClass);
            combatLog = combatLog.concat(RPGPlayer.playerRelic.printRelicLogEnemy(RPGEnemy.enemyClass));
        }
    }

    //method for resolving damage against the player
    //takes into account status effects the player may have
    //and any on "get hit" relics the player may have
    public void damagePlayer(int damage, RPGPlayer player, int mitigation) {
        if (RPGPlayer.playerClass.getDebuff("Shock") > 0) //if player has more than 0 shock in their status effect hashmap
        {
            shockDamage = (RPGPlayer.playerClass.getDebuff("Shock")); //assigns shockDamage as the number of shock the player has
        }
        int mitigateddamage = damage - mitigation; //reduces provided hit damage by the player's defense(mitigation)
        if (RPGPlayer.playerClass.getDebuff("Vulnerable") > 0) //if player has more than 0 vulnerable in their status effect hashmap
        {
            mitigateddamage = (mitigateddamage * 2); //double hit damage for a vulnerable hit
            combatLog = combatLog.concat("Vulnerable Hit!!(2X DMG)\n");
        }
        if ((mitigateddamage + shockDamage) <= 0) //if hit damage and shock damage combined is less than or equal to 0
        {
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " failed to deal any damage through your defense!\n");
            return; //return without dealing damage
        }
        playerHealth = playerHealth - (mitigateddamage + shockDamage); //deal damage to enemyHealth equal to hit damage and shock damage
        if (RPGPlayer.playerClass.getDebuff("Shock") > 0) //if the enemy had more than 0 shock
        {
            //print the damage dealt as well as shock damage dealt
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " deals " + mitigateddamage + " damage + " + shockDamage + " shock damage to you!\n");
        } else //if enemy had no shock
        {
            //only prints the damage dealt
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " deals " + mitigateddamage + " damage to you!\n");
        }
        if ("GetHit".equals(RPGPlayer.playerRelic.getTrigger())) //if the player's relic trigger condition is on "GetHit"   
        {
            //triggers the relic using the relicTriggerEnemy method from the relic class and does damage based on return value
            enemyHealth = enemyHealth - (RPGPlayer.playerRelic.relicTriggerEnemy(RPGEnemy.enemyClass));
            combatLog = combatLog.concat(RPGPlayer.playerRelic.printRelicLogEnemy(RPGEnemy.enemyClass));

        }
        if (playerParry == true) //if playerParry is currently true
        {
            switch (RPGPlayer.className) //switch depending on class used
            {
                case ("warrior"): //if warrior
                {
                    combatLog = combatLog.concat("You counterattack using Swift Counter!\n");
                    //damage enemy using enemy's damage value, and accounting for their defense
                    damageEnemy(mitigateddamage, battleEnemy, RPGEnemy.enemyClass.getDefense());
                    break;
                }
                case ("mage"): //if mage
                {
                    combatLog = combatLog.concat("Your Mage Armour lashes out!\n");
                    //damage enemy using damage of 4, and accounting for their defense
                    damageEnemy(4, battleEnemy, RPGEnemy.enemyClass.getDefense());
                    break;
                }
            }
        }
    }

    //method to resolve and reduce status effects at the end of the turn
    public String resolveStatusEffects() {
        String statusLog="";
        if (RPGEnemy.enemyClass.getDebuff("Flame") > 0) //if enemy has 1 or more flame
        {
            enemyHealth = enemyHealth - (RPGEnemy.enemyClass.getDebuff("Flame")); //deal damage equal to the number of flame enemy has
            statusLog = statusLog.concat("\n" + RPGEnemy.enemyClass.name + " takes " + RPGEnemy.enemyClass.getDebuff("Flame") + " damage from Burn!");
            RPGEnemy.enemyClass.removeDebuff("Flame", 1); //removes 1 stack of flame using the removeDebuff method from enemyClass
        }
        if (RPGEnemy.enemyClass.getDebuff("Shock") > 0) //if enemy has 1 or more shock
        {
            RPGEnemy.enemyClass.removeDebuff("Shock", 1); //removes 1 stack of shock using the removeDebuff method from enemyClass
        }
        if (RPGEnemy.enemyClass.getDebuff("Vulnerable") > 0) //if enemy has 1 or more vulnerable
        {
            RPGEnemy.enemyClass.removeDebuff("Vulnerable", 1); //remove 1 stack of vulnerable
            if (RPGEnemy.enemyClass.getDebuff("Vulnerable") == 0) //if the enemy now has 0 stacks of vulnerable
            {
                statusLog = statusLog.concat(RPGEnemy.enemyClass.name + " no longer looks vulnerable!");   //prints message indicating this
            }
        }

        if (RPGPlayer.playerClass.getDebuff("Flame") > 0) //if enemy has 1 or more flame
        {
            playerHealth = playerHealth - (RPGPlayer.playerClass.getDebuff("Flame")); //deal damage equal to the number of flame player has
            statusLog = statusLog.concat("You take " + RPGPlayer.playerClass.getDebuff("Flame") + " damage from Burn!");
            RPGPlayer.playerClass.removeDebuff("Flame", 1); //removes 1 stack of flame using the removeDebuff method from playerClass
        }
        if (RPGPlayer.playerClass.getDebuff("Shock") > 0) //if player has 1 or more shock
        {
            RPGPlayer.playerClass.removeDebuff("Shock", 1); //removes 1 stack of shock using the removeDebuff method from playerClass
        }
        if (RPGPlayer.playerClass.getDebuff("Vulnerable") > 0) //if player has 1 or more vulnerable
        {
            RPGPlayer.playerClass.removeDebuff("Vulnerable", 1);  //remove 1 stack of vulnerable
            if (RPGPlayer.playerClass.getDebuff(("Vulnerable")) == 0) //if the player now has 0 stacks of vulnerable
            {
                statusLog = statusLog.concat("You no longer feel vulnerable!");    //prints message indicating this
            }
        }
        return statusLog;
    }
    
    public String statusCounter()
    {
        String statusText="";
        statusText = statusText.concat("Debuff Stacks: \n");
        if (RPGPlayer.playerClass.getDebuff("Flame")!=0) //if the given key exists in the status effect hashmap and is not zero
        {
            statusText = statusText.concat("Burn - "+RPGPlayer.playerClass.getDebuff("Flame")+" \n"); //print the value at the given key of the status effect map
        }
        if (RPGPlayer.playerClass.getDebuff("Shock")!=0) //if the given key exists in the status effect hashmap and is not zero
        {
            statusText = statusText.concat("Shock - "+RPGPlayer.playerClass.getDebuff("Shock")+" \n"); //print the value at the given key of the status effect map
        }
        if (RPGPlayer.playerClass.getDebuff("Vulnerable")!=0) //if the given key exists in the status effect hashmap and is not zero
        {
            statusText = statusText.concat("Vulnerable - "+RPGPlayer.playerClass.getDebuff("Vulnerable")+" \n"); //print the value at the given key of the status effect map
        }
        return statusText;
    }

    public String playerTurnEnd() {
        String combatLogReturn = combatLog;
        combatLog = "";
        if (battleActionConfirmed != true)
        {
            enemyTurn=false;
            return combatLogReturn;
        }
        enemyTurn=true;
        return combatLogReturn;
    }

    public String enemyTurnEnd() {
        String combatLogReturn = combatLog;
        combatLog = "";
        enemyTurn=false;
        return combatLogReturn;
    }

    //method for resolving all end of turn effects
    //and any things that take place between turns
    public String turnEnd() {
        turnCounter++;
        combatLog = combatLog.concat("\nTurn End:\n");
        playerDefenseModifier = 0;  // sets all stat and attack modifiers to 0
        playerDodgeModifier = 0;
        enemyDodgeModifier = 0;
        enemyAttackModifier = 0;
        playerParry = false; //sets playerParry to false
        if ("EndTurn".equals(RPGPlayer.playerRelic.getTrigger())) //if player's relic trigger condition is "EndTurn"
        {
            //heals player based on the damage dealt that turn (turnPlayerDamage) and sets turnPlayerDamage back to 0 for next turn
            playerHealth = RPGPlayer.playerRelic.relicTriggerSelf(playerHealth, turnPlayerDamage, RPGPlayer.playerClass.getHealthPoints());
            combatLog = combatLog.concat(RPGPlayer.playerRelic.printRelicLogSelf());
            turnPlayerDamage = 0;
        }
        if (enemyPhaseChange == true) //if enemy has changed phase
        {
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " is slowly falling apart!\n");
            enemyHealth = enemyHealth - (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.05); //enemy loses 5% of health
            combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " took " + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.05) + " Damage!\n");
        }
        //if player is not charging an attack and has less than maximum mana
        if ((playerCharge != true) && (playerMana < RPGPlayer.playerClass.getManaPoints())) {
            playerMana = (playerMana + RPGPlayer.playerClass.getIntellect()); //restore playerMana by the player class's intellect stat
            if (playerMana > RPGPlayer.playerClass.getManaPoints()) //if playerMana is more than max mana
            {
                playerMana = (RPGPlayer.playerClass.getManaPoints()); //set to exactly max mana
            }
        }
        if (playerFlurry == true) //if playerFlurry is true
        {
            playerTurnsCharged--; //increment number of playerTurnsCharged by 1
            if (playerTurnsCharged < 1) //if player has been charging for 3 turns
            {
                playerTurnsCharged = 0;
                playerFlurry = false; //set playerFlurry to false
                combatLog = combatLog.concat("The energy in your fists subsides.");
            }
        }
        for (int i = 1; i <= 3; i++) //loops 3 times with values 1,2,and 3 to reduce cooldown of enemy abilities
        {
            int currentCooldown = Integer.parseInt(RPGEnemy.enemyClass.getAbility(i).get(3));
            //gets the current cooldown of the corresponding enemy ability at key "i" in the enemyAbility hashmap
            if (currentCooldown != 0) //if the cooldown is not 0
            {
                currentCooldown = currentCooldown - 1; //reduces the cooldown by 1
                RPGEnemy.enemyClass.getAbility(i).set(3, Integer.toString(currentCooldown));
                // and set the cooldown in the hashmap to the reduced value
            }
        }
        if (enemyDefend == true) //if enemyDefend is true
        {
            switch (RPGEnemy.enemyClass.name) //switch based on enemy type
            {
                case ("Slime"): //if slime
                {
                    enemyDodgeModifier = RPGEnemy.enemyClass.getDodge();
                    //gets the dodge stat of the enemy and assigns it to enemy dodge modifier
                    enemyDefend = false;  //sets enemyDefend to false
                    break;
                }
                case ("Revenant"): //if Revenant
                {
                    enemyHealth = enemyHealth + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.12); //restore 12% of its health
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " is pulling itself back together!\n");
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " regained " + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.12) + " Health!\n");
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged >= 2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend = false; //set enemyDefend to false
                    }
                    break;
                }
                case ("Skeleton"): //if skeleton
                {
                    enemyHealth = enemyHealth + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.08); //restore 8% of its health
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " is reconstructing itself!\n");
                    combatLog = combatLog.concat(RPGEnemy.enemyClass.name + " regained " + (int) (RPGEnemy.enemyClass.getHealthPoints() * 0.08) + " Health!\n");
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged >= 2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend = false;  //set enemyDefend to false
                    }
                    break;
                }
                case ("Ghost"): //if ghost
                {
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged >= 2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend = false; //set enemyDefend to false 
                    }
                    break;
                }
            }
        }
        combatLog = combatLog.concat(resolveStatusEffects()); //calls resolveStatusEffects method to trigger and reduce all status effects
        if ((enemyHealth <= 0) && (playerHealth > 0)) //if enemy has less than or is equal to 0 health and player has more than 0 health
        {
            victory = true; //victory boolean is set to true
        } else if (playerHealth <= 0) //if player has less than or is equal to 0 health
        {
            loss = true;   //loss boolean is set to true
        }
        String combatLogReturn = combatLog;
        combatLog = "";
        enemyTurn=false;
        return combatLogReturn;
    }

}
