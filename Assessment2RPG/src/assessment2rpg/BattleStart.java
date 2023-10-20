/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import static assessment2rpg.GameStart.userInput;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

//BattleStart class - the main battle loop of the game.
public class BattleStart {

    //All the various miscellaneous variables needed for this class
    boolean victory = false;
    boolean loss = false;
    boolean forfeit = false;
    String battleChoice = "";
    int battleChoiceNum=0;
    boolean battleChoiceConfirm = false;
    int hitMax = 20;
    int hitMin = 1;
    boolean critical = false;
    int hitDamage = 0;
    int turnCounter=1;
    int shockDamage=0;
    int directDamage=0;
    
    //all the player variables needed for this class
    RPGPlayer battlePlayer = null;
    int playerHealth = 100;
    int playerMana=50;
    boolean playerCharge = false;
    int playerDefenseModifier=0;
    int playerDodgeModifier=0;
    int playerTurnsCharged=0;
    boolean playerFlurry = false;
    boolean playerParry = false;
    int turnPlayerDamage=0;
    
    //all the enemy variables needed for this class
    RPGEnemy battleEnemy = null;
    int enemyHealth = 100;
    boolean enemyCharge = false;
    int enemyTurnsCharged=0;
    int enemyDodgeModifier=0;
    int enemyAttackModifier=0;
    boolean enemyPhaseChange = false;
    boolean enemyDefend = false;
    

    //constructor to create the BattleStart object and set a few values based on the input RPGPlayer and RPGEnemy objects
    public BattleStart(RPGPlayer newplayer, RPGEnemy newenemy) 
    {
        battlePlayer = newplayer;  //sets battlePlayer as input RPGPlayer object
        playerHealth = RPGPlayer.playerClass.getHealthPoints();  //sets the player's health to the health of the RPGPlayerClass using the getter
        playerMana = RPGPlayer.playerClass.getManaPoints();      //sets the player's mana to the mana of the RPGPlayerClass using the getter
        battleEnemy = newenemy;   //sets battleEnemy as input RPGEnemy object
        enemyHealth = RPGEnemy.enemyClass.getHealthPoints();     //sets the enemy's health to the health of the RPGEnemyClass using the getter

    }

    //Method to manage the menu and display for the battle
    public void startBattleLoop() 
    {
        System.out.println("Begin Battle\n\n\n\n");
        while (victory != true && loss != true && forfeit != true) { //while player hasnt won, lost, or forfeited yet, this will loop

            System.out.println("\nTurn "+turnCounter+":"); //prints a turn counter
            turnCounter++; //turn counter will increment every tun
            battleChoiceConfirm = false;   
            while (battleChoiceConfirm != true)  //while user hasnt confirmed battle choice, it will loop
            {
                // player's status screen with name, health, mana, attack points, defense, and dodge chance
                // it gets all these values but using the getters
                System.out.println("=================");
                System.out.print("Player: ");
                System.out.println(RPGPlayer.name);
                System.out.println("Health: " + RPGPlayer.playerClass.getHealthPoints() + " / " + playerHealth);
                System.out.println("Mana: " + RPGPlayer.playerClass.getManaPoints() + " / " + playerMana);
                System.out.println("Attack Points: "+RPGPlayer.playerClass.getAttackPoints());
                System.out.println("Defense: "+RPGPlayer.playerClass.getDefense());
                System.out.println("Dodge Chance: "+RPGPlayer.playerClass.getDodge()*5+"%");
                System.out.println("================="); 
                //prints out the abilities using the getAbility method from the playerClass to return certain snippets of the ArrayList
                System.out.println("- "+RPGPlayer.playerClass.getAbility(1).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(1).get(3)+" - "+RPGPlayer.playerClass.getAbility(1).get(1));
                System.out.println("- "+RPGPlayer.playerClass.getAbility(2).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(2).get(3)+" - "+RPGPlayer.playerClass.getAbility(2).get(1));
                System.out.println("- "+RPGPlayer.playerClass.getAbility(3).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(3).get(3)+" - "+RPGPlayer.playerClass.getAbility(3).get(1));
                System.out.println("=================");
                //prints out debuff stacks using the getDebuff method from the playerclass to check for debuffs and print the value
                System.out.println("Debuff Stacks: ");
                if (RPGPlayer.playerClass.getDebuff("Flame")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Burn - "+RPGPlayer.playerClass.getDebuff("Flame")+", "); //print the value at the given key of the status effect map
                }
                if (RPGPlayer.playerClass.getDebuff("Shock")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Shock - "+RPGPlayer.playerClass.getDebuff("Shock")+", "); //print the value at the given key of the status effect map
                }
                if (RPGPlayer.playerClass.getDebuff("Vulnerable")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Vulnerable - "+RPGPlayer.playerClass.getDebuff("Vulnerable")+", "); //print the value at the given key of the status effect map
                }
                
                // enemy's status screen with name, health, attack points, defense, and dodge chance
                // it gets all these values but using the getters
                System.out.println("=================");
                System.out.print("Enemy: ");
                System.out.println(battleEnemy.name);
                System.out.println("Health: " + RPGEnemy.enemyClass.getHealthPoints() + " / " + enemyHealth);
                System.out.println("Attack Points: "+RPGEnemy.enemyClass.getAttackPoints());
                System.out.println("Defense: "+RPGEnemy.enemyClass.getDefense());
                System.out.println("Dodge Chance: "+RPGEnemy.enemyClass.getDodge()*5+"%");
                System.out.println("================="); 
                //prints out the abilities using the getAbility method from the enemyClass to return certain snippets of the ArrayList
                System.out.println("- "+RPGEnemy.enemyClass.getAbility(1).get(0)+" - Cooldown: "+RPGEnemy.enemyClass.getAbility(1).get(3)+" turns - "+RPGEnemy.enemyClass.getAbility(1).get(1));
                System.out.println("- "+RPGEnemy.enemyClass.getAbility(2).get(0)+" - Cooldown: "+RPGEnemy.enemyClass.getAbility(2).get(3)+" turns - "+RPGEnemy.enemyClass.getAbility(2).get(1));
                System.out.println("- "+RPGEnemy.enemyClass.getAbility(3).get(0)+" - Cooldown: "+RPGEnemy.enemyClass.getAbility(3).get(3)+" turns - "+RPGEnemy.enemyClass.getAbility(3).get(1));
                System.out.println("================="); 
                //prints out debuff stacks using the getDebuff method from the enemyclass to check for debuffs and print the value
                System.out.println("Debuff Stacks: ");
                if (RPGEnemy.enemyClass.getDebuff("Flame")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Burn - "+RPGEnemy.enemyClass.getDebuff("Flame")+", "); //print the value at the given key of the status effect map
                }
                if (RPGEnemy.enemyClass.getDebuff("Shock")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Shock - "+RPGEnemy.enemyClass.getDebuff("Shock")+", "); //print the value at the given key of the status effect map
                }
                if (RPGEnemy.enemyClass.getDebuff("Vulnerable")!=0) //if the given key exists in the status effect hashmap and is not zero
                {
                    System.out.println("Vulnerable - "+RPGEnemy.enemyClass.getDebuff("Vulnerable")+", "); //print the value at the given key of the status effect map
                }
                System.out.println("=================");
                //Players turn
                System.out.println("Your Turn:\n");
                if (playerCharge != true) //if player is not charging an attack
                {
                    System.out.println("What would you like to do:");
                    System.out.println("1) Attack");
                    System.out.println("2) Defend");
                    System.out.println("3) Ability");
                    System.out.println("4) Forfeit");
                    battleChoice = userInput.nextLine().toLowerCase();  //waits for user input, makes it lowercase and assigns it to battleChoice
                    switch (battleChoice)  //switch case depending on battleChoice
                    {
                        case ("1"):       //case 1 fallthrough to attack
                        case ("attack"):   //case attack
                        {
                            battleChoiceConfirm = true;  //confirms battle choice
                            attack();  //calls attack method from this class
                            break;   //breaks from switch case
                        }
                        case ("2"):     //case 2 fallthrough to defend
                        case ("defend"):    //case defend
                        {
                            battleChoiceConfirm = true; //confirms battle choice
                            defend(); //calls defend method from this class
                            break;  //breaks from switch case
                        }
                        case ("3"):         //case 3 fallthrough to ability
                        case ("ability"):   //case ability
                        {
                            ability();  //calls ability method without confirming battle choice
                                        //if user exits from ability without casting an ability they will be presented with battle menu again
                            break; //breaks from switch case
                        }
                        case ("4"):     //case 4 fallthrough to forfeit
                        case ("forfeit"):   //case forfeit
                        {
                            forfeit(); //calls forfeit method from this class
                            break;  //breaks from switch case
                        }
                    }
                }
                else  //else if they are charging an attack they dont get to make an action this turn and will finish charging their attack
                {
                    switch (RPGPlayer.className)   //switch case based on what playerClass player is using
                        {
                            case ("warrior"):   //if they are playing warrior
                            {
                                if (playerTurnsCharged==2)  //if player has been charging attack for 2 turns already
                                {
                                    playerChargeAbility();  // calls playerChargeAbility mthod from this class
                                    battleChoiceConfirm = true;  //confirms battle choice
                                    System.out.println("You spent your turn performing Blade Dance");
                                }
                                if (playerTurnsCharged==1) //if player has only charged attack for 1 turn
                                {
                                    System.out.println("You continue to charge up your Blade Dance!");
                                    playerTurnsCharged++; //increment the number of turns player has been charging attack by 1
                                    battleChoiceConfirm = true; //confirms battle choice
                                }
                                break;  //break from switch case
                            }
                            case ("mage"): 
                            {
                                if (playerTurnsCharged==1)  //if player has already charged attack for 1 turn
                                {
                                    playerTurnsCharged++; //increment the number of turns player has been charging attack by 1
                                    playerChargeAbility(); // calls playerChargeAbility mthod from this class
                                    System.out.println("You finish channeling Lighting Storm!");
                                    System.out.println("You spent your turn channelling Lightning Storm");
                                    battleChoiceConfirm = true; //confirms battle choice
                                }
                                break; //break from switch case
                            }
                        }
                    
                }
            }
            if (enemyHealth <=0) // if enemy has less than or equal to 0 hitpoints you win
            {
                victory = true; //sets victory boolean to true
            }
            if ((forfeit !=true) && (victory !=true)) //if you have neither won nor forfeited
            {
                //Enemy's turn
                System.out.println("Enemy Turn:\n");
                if (enemyCharge == true) //if enemy is charging attack
                {
                    enemyChargeAbility(); // calls enemyChargeAbility mthod from this class
                }
                else //if enemy is not charging attack
                {
                    enemyTurn(); //call enemyTurn method from this class
                    if ("Revenant".equals(battleEnemy.name)) //if the enemy is a Revenant
                    {
                        enemyTurn(); //call enemyTurn method from this class for an extra turn
                    }
                }
            }
            turnEnd(); //call turnEnd method from this class to resolve turn end effects
        }
        if (victory==true) //if victory boolean is true
        {
            System.out.println("\nCongratulations, you won!");
            System.out.println("Since you are so good, maybe next time you should try a different class, relic or enemy.");
        }
        if (loss==true) //if loss boolean is true
        {
            System.out.println("\nHow unfortunate, you died...");
            System.out.println("Perhaps you should try again later.");
        }
    }

    //player attack class with switch cases depending on playerClass the player is using
    public void attack() 
    {
        switch (RPGPlayer.className)  //switch case based on playerClass name
        {
            case ("warrior"): // if user is playing a warrior
            {
                System.out.println("You slash at the "+battleEnemy.name+" with your sword!");
                targetEnemy();  //calls targetEnemy method from this class
                break;  //break from switch case
            }
            case ("mage"):  // if user is playing a mage
            {
                System.out.println("You fire a magic bolt at the "+battleEnemy.name+"!");
                targetEnemy();  //calls targetEnemy method from this class
                break;  //break from switch case
            }
            case ("monk"):  // if user is playing a monk
            {
                if (playerFlurry==true) //and if they have activated their Flurry of blows ability
                {
                    System.out.println("You pummel the "+battleEnemy.name+" with a barrage of blows!");
                    targetEnemy();  //calls targetEnemy method from this class
                    targetEnemy();  //calls targetEnemy method from this class
                    targetEnemy();  //calls targetEnemy method from this class
                    break;  //break from switch case
                }
                System.out.println("You strike at the "+battleEnemy.name+" with your fist!");
                targetEnemy();   //calls targetEnemy method from this class
                break;  //break from switch case
            }
        }
    }

    //player defend class with switch cases depending on playerClass the player is using
    public void defend() 
    {
        switch (RPGPlayer.className) //switch case based on playerClass name
        {
            case ("warrior"):  // if user is playing a warrior
            {
                //sets the playerDefenseModifier to the PlayerClasses defense essentially doubling the player's defense
                playerDefenseModifier=(RPGPlayer.playerClass.getDefense()); 
                System.out.println("You brace for the enemy's attack doubling your defense for the turn");
                break; //break from switch case
            }
            case ("mage"):  // if user is playing a mage
            {
                //sets the playerDefenseModifier to the PlayerClass's defense essentially doubling the player's defense
                playerDefenseModifier=(RPGPlayer.playerClass.getDefense());
                System.out.println("You prepare a magical shield doubling your defense for the turn");
                break; //break from switch case
            }
            
            case ("monk"): // if user is playing a monk
            {
                //sets the playerDodgeModifier to the PlayerClass's dodge essentially doubling the player's defense
                playerDodgeModifier=(RPGPlayer.playerClass.getDodge());
                break; //break from switch case
            }
        }
    }

    //player ability class with switch cases depending on playerClass the player is using
    //and switch cases depending on which ability the player uses
    //if player exits out of this class without selecting an ability they are sent back to battle menu
    public void ability() 
    {
        //while the player doesnt enter cancel and while the player hasnt confirmed their battle choice, this will loop
        while ((!"cancel".equals(battleChoice)) && (battleChoiceConfirm != true))
        {
            System.out.println("Which ability do you use? (type 'cancel' to return')");
            System.out.println("1) "+RPGPlayer.playerClass.getAbility(1).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(1).get(3)+" - Desc: "+RPGPlayer.playerClass.getAbility(1).get(1));
            System.out.println("2) "+RPGPlayer.playerClass.getAbility(2).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(2).get(3)+" - Desc: "+RPGPlayer.playerClass.getAbility(2).get(1));
            System.out.println("3) "+RPGPlayer.playerClass.getAbility(3).get(0)+" - Mana Cost: "+RPGPlayer.playerClass.getAbility(3).get(3)+" - Desc: "+RPGPlayer.playerClass.getAbility(3).get(1));
            //prints the player's abilities using RPGPlayer.playerClass's getAbility(key) method to return the arraylist for each ability for the current class
            //and then gets the selected index of the ability arraylist
            
            battleChoice = userInput.nextLine().toLowerCase(); //waits for user input, makes it lowercase and assigns it to battleChoice
           
            switch (RPGPlayer.className) //switch case based on the user's class name
            {
                case ("warrior"): //if user is playing a warrior
                {
                    switch (battleChoice)     //switch case depending on which ability the user entered
                    {
                        case ("1"):            //case for ability 1 that falls through to the case with the specific ability name
                        case ("cross slash"):  //case for specific name of warrior ability 1 "cross slash"
                        {
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana) 
                            //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                            //using parseInt as the arrayList is full of strings and not integers
                            {
                                System.out.println("Not enough mana.");
                                break; //break from switch case and returns to ability menu
                            }
                            else 
                            // if player has more playermana than the manacost of the ability
                            {
                                System.out.println("You perform a Cross Slash, hitting the "+battleEnemy.name+" twice!\n");
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)))); //reduces playermana by the manacost of the ability
                                for (int i=1;i<=2;i++)
                                //for loop that will loop twice as this ability damages the opponent twice
                                {                                    
                                    directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2)));
                                            //sets directDamage to the value in the ability arraylist
                                    hitDamage = calculateDamageDirect(directDamage); //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                                    damageEnemy(hitDamage, battleEnemy,(RPGEnemy.enemyClass.getDefense()));
                                            //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                                }
                                battleChoiceConfirm = true; //confirms battle choice
                                break; //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                        case ("2"):                 //case for ability 2 that falls through to the case with the specific ability name
                        case ("swift counter"):   //case for specific name of warrior ability 2 "swift counter"
                        {
                                    //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana)              
                            {
                                System.out.println("Not enough mana.");
                                break;  //break from switch case and returns to ability menu
                            }
                            else    // if player has more playermana than the manacost of the ability
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduces playermana by the manacost of the ability
                                System.out.println("You perform a Swift Counter, getting into a counter stance!\n");
                                playerParry=true;           //sets the playerParry boolean to true
                                battleChoiceConfirm = true; //confirms battle choice
                                break;   //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                        case ("3"):         //case for ability 3 that falls through to the case with the specific ability name
                        case ("blade dance"):    //case for specific name of warrior ability 3 "blade dance"
                        {
                                            //if ability 3's mana cost from the ability arraylist is greater than the user's playerMana
                                            //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana)   
                            {
                                System.out.println("Not enough mana.");
                                break;      //break from switch case and returns to ability menu
                            }
                            else    // if player has more playermana than the manacost of the ability
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)))); //reduces playermana by the manacost of the ability
                                System.out.println("\nYou begin to charge up your Blade Dance!");
                                playerCharge = true;  //sets playerCharge boolean to true
                                playerTurnsCharged++;       //Increments the playerTurnsCharged variable by 1
                                battleChoiceConfirm = true; //confirms battle choice
                                break;      //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                    }
                }
                case ("mage"):      //if user is playing a mage
                {
                    switch (battleChoice)    //switch case depending on which ability the user entered
                    {
                        case ("1"):         //case for ability 1 that falls through to the case with the specific ability name
                        case ("fire bolt"):         //case for specific name of mage ability 1 "fire bolt"
                        {
                            //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break; //break from switch case and returns to ability menu
                            }
                            else  //if user has enough mana
                            {
                                System.out.println("How many bolts to summon? (8 mana/bolt)(up to 5)");
                                System.out.println("Current Mana: "+playerMana); //prints the user's current mana
                                battleChoice = userInput.nextLine().toLowerCase(); //waits for user input, makes it lowercase and assigns it to battleChoice
                                battleChoiceNum = Integer.parseInt(battleChoice);  //gets the number from battle choice, parses it as it is a string and then assigns it to battleChoiceNum
                                if((battleChoiceNum)*8>playerMana) //if battlechoicenum times 8 is lower than the player's mana they cant cast the spell
                                {
                                    System.out.println("Not enough mana.");
                                    break; //break from switch case and returns to ability menu
                                }
                                else if((battleChoiceNum)>5) //if battlechoicenum is greater than 5 then they cannot cast the spell
                                {
                                    System.out.println("Too many bolts.");
                                }
                                else if((battleChoiceNum)<1) //if battlechoicenum is less than 1 then they cannot cast the spell
                                {
                                    System.out.println("invalid number of bolts.");
                                }
                                else //if the number of bolts is valid and they have enough mana to cast
                                {
                                    System.out.println("You fire off a Fire Bolt, which splits off into "+battleChoiceNum+" fire bolts which strike "+battleEnemy.name+" "+battleChoiceNum+" times!\n");
                                    playerMana=(playerMana-((Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)))*battleChoiceNum));
                                    //reduces player's mana by the cost of the ability times the number of bolts cast
                                    for (int i=1;i<=battleChoiceNum;i++)
                                        //for loop that will loop for the number of bolts the user entered
                                    {                                    
                                        directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2)));
                                        //sets directDamage to the value in the ability arraylist
                                        hitDamage = calculateDamageDirect(directDamage);
                                        //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                                        damageEnemy(hitDamage, battleEnemy,(RPGEnemy.enemyClass.getDefense()));
                                        //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                                        RPGEnemy.enemyClass.addDebuff("Flame",2); //inflicts 2 stacks of Flame into enemy's status effects hashmap
                                        System.out.println("Inflicted 2 Burn onto "+battleEnemy.name+"\n");
                                    }
                                    battleChoiceConfirm = true; //confirms battle choice
                                    break; //break from switch case and returns to main battle loop as battle choice is confirmed
                                }
                                break; //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                        case ("2"):                 //case for ability 2 that falls through to the case with the specific ability name
                        case ("mage armour"):       //case for specific name of mage ability 2 "mage armour"
                        {
                            //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break;
                            }
                            else //if user has enough mana
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduce player mana by ability cost
                                System.out.println("You summon a set of magical armour, increasing your defense and damaging attacking enemies for the turn!\n");
                                playerDefenseModifier=4; //sets playerdefense modifier to 4
                                playerParry=true;      //sets playerParry Boolean to true
                                battleChoiceConfirm = true; //confirms battle choice
                                break; //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                        case ("3"):                 //case for ability 3 that falls through to the case with the specific ability name
                        case ("lightning storm"):       //case for specific name of mage ability 3 "lightning storm"
                        {
                            //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break;
                            }
                            else  //if user has enough mana
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)))); //reduce playerMana by ability cost
                                System.out.println("\nYou begin to channel a Lightning Storm to strike your enemies!");
                                playerCharge = true; //sets playerCharge boolean to true
                                playerTurnsCharged++; //increments playerTurnsCharged by 1
                                playerChargeAbility();   //calls playerChargeAbility method
                                battleChoiceConfirm = true; //confirms battle choice
                                break;  //break from switch case and returns to main battle loop as battle choice is confirmed
                            }
                        }
                    }
                }
                case ("monk"):           //if user is playing a monk
                {
                    switch (battleChoice)    //switch case depending on which ability the user entered
                    {
                        case ("1"):             //case for ability 1 that falls through to the case with the specific ability name
                        case ("quivering palm"):    //case for specific name of monk ability 1 "quivering palm"
                        {
                            //if ability 1's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break;
                            }
                            else //if player has enough mana
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(3))));   //reduce player mana by ability cost
                                System.out.println("You strike the "+battleEnemy.name+" with an open palm disrupting their body's energy!\n");
                                RPGEnemy.enemyClass.addDebuff("Vulnerable",3); //puts 3 stacks of Vulnerable onto enemy's status effect hashmap
                                System.out.println("Inflicted 2 Vulnerable onto "+battleEnemy.name+"\n"); //it says 2 stacks as 1 stack will get lost at the end of the turn
                                directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(1).get(2))); //directdamage is set to the damage value of the ability
                                hitDamage = calculateDamageDirect(directDamage); //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                                damageEnemy(hitDamage, battleEnemy,0); //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage while ignoring the enemy's defense
                                battleChoiceConfirm = true; //confirms battle choice
                                break;
                            }
                        }
                        case ("2"):                 //case for ability 2 that falls through to the case with the specific ability name
                        case ("golden soul"):       //case for specific name of warrior ability 2 "golden soul"
                        {
                            //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break;
                            }
                            else //if player has enough mana
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(3)))); //reduce mana by ability cost
                                System.out.println("You center your spirit, healing yourself of bodily ailments!\n");
                                //uses playerClass's setDebuff method to set all status effects to 0
                                RPGPlayer.playerClass.setDebuff("Vulnerable",0);
                                RPGPlayer.playerClass.setDebuff("Shock",0);
                                RPGPlayer.playerClass.setDebuff("Flame",0);
                                System.out.println("Cleared Status effects!");
                                playerHealth=playerHealth+(Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(2)));
                                //heals player health by the "damage" value of the ability
                                System.out.println("You regained "+(Integer.parseInt(RPGPlayer.playerClass.getAbility(2).get(2)))+" Health!");
                                battleChoiceConfirm = true; //confirms battle choice
                                break;
                            }
                        }
                        case ("3"):                 //case for ability 3 that falls through to the case with the specific ability name
                        case ("flurry of blows"):       //case for specific name of warrior ability 3 "blade dance"
                        {
                            //if ability 2's mana cost from the ability arraylist is greater than the user's playerMana
                                    //using parseInt as the arrayList is full of strings and not integers
                            if (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3)) > playerMana)
                            {
                                System.out.println("Not enough mana.");
                                break;
                            }
                            else //if player has enough mana
                            {
                                playerMana=(playerMana-(Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(3))));
                                System.out.println("\nYou gather your body's energy in your fists!");
                                playerFlurry=true;   //sets playerFlurry boolean to true
                                battleChoiceConfirm = true;//confirms battle choice
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    //method used for activating player abilities that take multiple turns to use.
    public void playerChargeAbility()
    {
        switch (RPGPlayer.className)  //switch case for which class player is using
        {
            case ("warrior"):   //if user is playing warrior
            {
                System.out.println("\nYou perform a Blade Dance, a whirlwind of metal around you, as you rush the "+battleEnemy.name+"!");
                playerTurnsCharged=0; //sets the playerTurnsCharged variable to 0 to reset the ability
                int PlayerHits = 5;   //individual variable allows for easy editing of the number of hits this ability performs
                for (int i = 0; i<PlayerHits;i++) // loops for the number of times set by player hits
                {
                    directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(2))); //sets direct damage to the ability's damage value
                    hitDamage = calculateDamageDirect(directDamage);  //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                    damageEnemy(hitDamage, battleEnemy,RPGEnemy.enemyClass.getDefense());
                    //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                }
                playerCharge = false; //sets the playerCharge boolean to false indicating the ability is finished casting
                break; //returns to battle menu
            }
            case ("mage"):    //if user is playing mage
            {
                System.out.println("Lightning strikes the ground all around you!");
                if (playerTurnsCharged==2) //if player has been charging this ability for 2 turns
                {
                    playerTurnsCharged=0; //sets turns charged to 0
                    playerCharge = false;  //and sets playerCharge to false
                }
                directDamage = (Integer.parseInt(RPGPlayer.playerClass.getAbility(3).get(2)));  //sets direct damage to the ability's damage value
                hitDamage = calculateDamageDirect(directDamage);   //calculates the hitDamage using calculateDamageDirect method which skips the damage randomizer
                damageEnemy(hitDamage, battleEnemy,RPGEnemy.enemyClass.getDefense());
                //calls damageEnemy method to damage battleEnemy's health by the provided hitdamage and accounting for the enemy class's defense
                RPGEnemy.enemyClass.addDebuff("Shock",4); //puts 4 shock into the enemy's status effect hashmap
                System.out.println("Inflicted 4 Shock onto "+battleEnemy.name+"\n");
                break; //returns to battle menu
            }
        }
    }

    //method for if the player decides to forfeit at the battle menu
    public void forfeit() 
    {
        forfeit=true; //sets forfeit to true
        battleChoiceConfirm = true;  //confirms battle choice 
        System.out.println("You decide to forfeit the battle.");
        System.out.println("Maybe you will win next time...");
    }

    //method for decideing what the enemy does on it's turn
    public void enemyTurn() 
    {
        int enemyChoice = (int) (Math.random() * (20) + 1);
        //randomizer with range of 1 to 20
        if (enemyChoice <= 19) { //if enemy gets less than or equal to 19 they get to use an ability or attack
            EnemyAbility();
        } 
        else //otherwise if they get 20 they lose their turn
        {
            System.out.println(battleEnemy.name + " got confused and wasted it's turn.");
        }
    }

    public void EnemyAttack() 
    {
        switch (battleEnemy.name) //switch case based on what enemy you are fighting
        {
            case ("Slime"): //if slime
            {
                System.out.println("Slime tries to slam into you!");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Skeleton"):  //if skeleton
            {
                System.out.println("Skeleton slashes at you with a sharpened bone!");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Revenant"):  //if revenant
            {
                System.out.println("Revenant furiously claws at you with it's razor sharp broken bones!");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
            case ("Ghost"):  //if ghost
            {
                System.out.println("Ghost swipes at you with it's cold ghostly hands!");
                targetPlayer(); //calls targetPlayer method that calculates the chance of hitting, the damage, and any crits before dealing damage
                break;
            }
        }
    }

    
    //method for triggering enemy abilites
    public void EnemyAbility() 
    {
        switch (battleEnemy.name) //switches based on type of enemy
        {
            case ("Slime"): //if slime
            {
                //if statments are ordered so enemy will use the most powerful ability that is off cooldown,
                //otherwise they will just attack if nothing is off cooldown
                if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyCharge = true; //sets enemyCharge boolean to true to trigger the enemy's special ability next turn
                    System.out.println(battleEnemy.name+" spends it's turn swallowing up objects.\nYou dont think your armour will help much against it's next attack!");
                    RPGEnemy.enemyClass.getAbility(3).set(3, "6"); //sets the ability back on 6 turns of cooldown
                    break;
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend=true; //sets enemyDefend boolean to true
                    enemyDodgeModifier=RPGEnemy.enemyClass.getDodge(); // sets enemyDodgeModifier to the enemy's classes base dodge rate, effectively double their dodge rate
                    System.out.println(battleEnemy.name+" flattens itself out.\nIts gonnna be harder to hit it for a bit!");
                    RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets the ability back on 4 turns of cooldown
                    break;
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    System.out.println(battleEnemy.name+" throws a glob of acidic slime at you.\nIt melts right through your defense!");
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2))); //gets damage from ability arraylist 
                    hitDamage = calculateDamageDirect(directDamage); //and calculates the damage using the method
                    damagePlayer(hitDamage, battlePlayer,0); //calls damagePlayer method to deal damage based on hit damage and ignoring player's defence
                    RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets the ability back on 2 turns of cooldown
                    break;
                }
                else  //if everything is on cooldown
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
            case ("Revenant"): //if enemy is Revenant  (phase 2 version of skeleton), fall through to skeleton case
            case ("Skeleton"): //if enemy is skeleton
            {
                if ((Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0 
                        &&(enemyHealth<(RPGEnemy.enemyClass.getHealthPoints()/2)) //and thye are below half health
                        &&(enemyPhaseChange!=true))// and if enemy phase change is not yet true
                {
                    System.out.println(battleEnemy.name+" gets so angry it loses it's head and vows to take you down!"
                            + "\nYou dont think this is a normal skeleton anymore!");
                    battleEnemy.name="Revenant"; //changes enemy name from skeleton to Revenant
                    enemyPhaseChange=true;  //and sets enemyPhaseChange to true
                    break;
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend=true; //sets enemyDefend to true
                    RPGEnemy.enemyClass.addDebuff("Vulnerable", 2); //inflicts 2 stacks of vulnerable to it's own status effect hashmap
                    if ("Revenant".equals(battleEnemy.name)) //if the enemy is called Revenant, it triggeres a different description
                    {
                        System.out.println(battleEnemy.name+" taps into its sheer rage and pulls itself back together."
                                + "\nIt looks easier to damage right now!");
                        RPGEnemy.enemyClass.getAbility(2).set(3, "3"); //sets the ability back on 3 turns of cooldown
                        break;
                    }
                    else //if it is not called a revenant
                    {
                        System.out.println(battleEnemy.name+" taps into its undead nature and begins to reconstruct some of it's body."
                                + "\nIt looks easier to damage right now!");
                        RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets the ability back on 4 turns of cooldown
                        break;
                    }
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    if ("Revenant".equals(battleEnemy.name)) //if enemy is revenant triggers a more powerful version of the ability
                    {
                        System.out.println(battleEnemy.name+" rips off one of its ribs and throws it at you in anger.\nIt seems to hurt itself when it does this!");
                        enemyHealth=enemyHealth-(int)(RPGEnemy.enemyClass.getHealthPoints()*0.08); // deals damage to itself equal to 8% of its max health
                        System.out.println(battleEnemy.name+" took "+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.08)+" Damage!");
                        directDamage = (int) ((Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2)))*1.5); //dealts 1.5 times the usual damage of the ability
                        
                        hitDamage = calculateDamageDirect(directDamage);
                        damagePlayer(hitDamage, battlePlayer,RPGPlayer.playerClass.getDefense());
                        RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets cooldown to 2 turns
                        break;
                    }
                    else //if not a revenant trigger the normal version of the ability
                    {
                        System.out.println(battleEnemy.name+" takes one of it's bones and throws it at you.\nIt seems to hurt itself when it does this!");
                        enemyHealth=enemyHealth-(int)(RPGEnemy.enemyClass.getHealthPoints()*0.1); //loses 10% of its health
                        System.out.println(battleEnemy.name+" took "+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.1)+" Damage!");
                        directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2))); // sets directDamage to the damage value of the ability
                        hitDamage = calculateDamageDirect(directDamage);
                        damagePlayer(hitDamage, battlePlayer,RPGPlayer.playerClass.getDefense());
                        RPGEnemy.enemyClass.getAbility(1).set(3, "2"); //sets cooldown to 2 turns
                        break;
                    }
                }
                else //otherwise it attacks if no abilities are avalible
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
            case ("Ghost"):  //enemy is ghost
            {
                if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyCharge = true; //sets enemy charge to true
                    System.out.println(battleEnemy.name+" spends it's turn charging up a bolt of ghostly electricity.\nYou don't think you can get out of the way of this one!");
                    RPGEnemy.enemyClass.getAbility(3).set(3, "6"); //sets cooldown to 6 turns
                    break;
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(2).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    enemyDefend=true; //sets enemy defend to true
                    enemyDodgeModifier=21; //sets enemy dodge modifier to 21 giving it at least a 110% to dodge all attacks for next round
                    System.out.println(battleEnemy.name+" becomes translucent.\nAny weak attacks will go right through it.");
                    RPGEnemy.enemyClass.getAbility(2).set(3, "4"); //sets cooldown to 4 turns
                    break;
                }
                else if (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(3)) <= 0) //if ability's cooldown timer is 0
                {
                    System.out.println(battleEnemy.name+" shoots a bolt of ghostly energy.\nIt goes straight through your defense!\nYou feel more vulnerable now.");
                    RPGPlayer.playerClass.addDebuff("Vulnerable", 3); //gives player 3 stacks of vulnerable on their status effect HashMap
                    //this will only last 2 turns as the first stack will be lost at the end of the turn
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(1).get(2)));
                    hitDamage = calculateDamageDirect(directDamage);
                    damagePlayer(hitDamage, battlePlayer,0);
                    RPGEnemy.enemyClass.getAbility(1).set(3, "3");//sets cooldown to 4 turns
                    break;
                }
                else //otherwise it attacks if no abilities are avalible
                {
                    EnemyAttack(); //enemy simply attacks using enemyAttack Method
                    break;
                }
            }
        }
    }
    
    
    //method for resolving enemy charge abilities that take multiple turns to cast
    public void enemyChargeAbility()
    {
        switch (battleEnemy.name)  //switch case for type of enemy
        {
            case ("Slime"):  //if slime
            {
                int EnemyHits = (int) (Math.random() * (4) + 1); //sets enemy hits to random amount from 4 to 1
                for (int i = 0; i<=EnemyHits;i++) //loops for number of enemyHits
                {
                    directDamage = (int) (Math.random() * (5) + 4); //sets directDamage to random number from 8-4
                    hitDamage = calculateDamageDirect(directDamage);
                    damagePlayer(hitDamage, battlePlayer,(int)(RPGPlayer.playerClass.getDefense()/3)); //damages player while ignoring 2/3 of their defense
                }
                enemyCharge = false; //sets enemy charge to false
                break; 
            }
            case ("Ghost"): //if ghost
            {
                int EnemyHits = (int) (Math.random() * (7) + 3);  //sets enemy hits to random amount from 9 to 3
                for (int i = 0; i<=EnemyHits;i++)  //loops for number of enemyHits
                {
                    directDamage = (Integer.parseInt(RPGEnemy.enemyClass.getAbility(3).get(2))); //sets directDamage to ability damage value
                    hitDamage = calculateDamageDirect(directDamage); 
                    damagePlayer(hitDamage, battlePlayer,0); //damages player while ignoring their defense
                    RPGPlayer.playerClass.addDebuff("Shock",1); //inflicts 1 stack of shock to player's status effects hashmap
                    System.out.println("Inflicted 1 Shock onto "+RPGPlayer.name+"\n");
                }
                enemyCharge = false; //sets enemy charge to false
                break;
            }
        }
    }

    
    //method for when player attacks enemy with a normal attack, with accuracy calculation
    public void targetEnemy() 
    {
        int HitChance = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number from 20-1
        if (HitChance < (RPGEnemy.enemyClass.getDodge()+enemyDodgeModifier))  //if hitchance is less than the enemy's dodge chance plus dodge modifier player misses
        {
            switch (battleEnemy.name)  //switch depending on enemy type
            {
                case ("Slime"):  //if slime
                {
                    System.out.println("You Missed!\nThe Slime morphs itself so your attack passes through.");
                    break;
                }
                case ("Skeleton"): //if skeleton
                {
                    System.out.println("You Missed!\nYour attack passes right through the Skeleton's ribcage.");
                    break;
                }
                case ("Revenant"): //if revenant
                {
                    System.out.println("You Missed?\nYour attack connected with the Revenant but its too angry to care.");
                    break;
                }
                case ("Ghost"): //if ghost
                {
                    if (enemyDodgeModifier>20) //if ghost's second ability is active
                    {
                        System.out.println("You Missed!\nYour attack phases right through it as you expected.");
                    }
                    else //otherwise
                    {
                        System.out.println("You Missed! The Ghost slips right out of your range as you swing.");
                    }
                }
            }
        } 
        else //if player hits the enemy
        {
            hitDamage = calculateDamage(RPGPlayer.playerClass.getAttackPoints()); //call the calculateDamage function which uses the player's class attack power
            damageEnemy(hitDamage, battleEnemy, RPGEnemy.enemyClass.getDefense()); //damage the enemy using the calculated damage, taking into account the enemy's defense
        }
    }

    //method for when enemy attacks the player with a normal attack, with accuracy calculation
    public void targetPlayer()
    {
        int HitChance = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number from 20-1
        if (HitChance < (RPGPlayer.playerClass.getDodge()+playerDodgeModifier))  //if hitchance is less than the player's dodge chance plus dodge modifier enemy misses
        {
            switch (RPGPlayer.className)  //switch depending on player class
            {
                case ("warrior"):  //warrior
                {
                    System.out.println(battleEnemy.name+" Missed! You blocked their attack using your heavy armour.\n");
                    break;
                } 
                case ("mage"):  //mage
                {
                    System.out.println(battleEnemy.name+" Missed! You put up a magical barrier at the last second.\n");
                    break;
                } 
                case ("monk"):  //monk
                {
                    System.out.println(battleEnemy.name+" Missed! You dodged out of the way of their blow.\n");
                    break;
                } 
            }
        }
        else 
        {
            if (enemyPhaseChange==true) //if the enemy has changed phase
            {
                enemyAttackModifier=6; //add 6 to the enemy's attack modifier
            }
            //call the calculateDamage function which uses the enemy's class attack power plus the enemy attack modifier
            hitDamage = calculateDamage(RPGEnemy.enemyClass.getAttackPoints()+enemyAttackModifier);
            //damage the player using the calculated damage, taking into account the player's defense and defense modifier
            damagePlayer(hitDamage, battlePlayer, (RPGPlayer.playerClass.getDefense()+playerDefenseModifier));
        }
    }

    //method to calculate hit damage using either player or enemy's attack power
    public int calculateDamage(int dmgStat) 
    {
        int CriticalHit = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number between 20 and 1 inclusive
        if (CriticalHit > 18)  //if the number is greater than 18
        {
            critical = true; //critical boolean is set to true
        }
        int Damage = (int) (Math.random() * ((dmgStat+(dmgStat/2)) - (dmgStat-(dmgStat/2)) + 1) + (dmgStat-(dmgStat/2)));
        //random number between 1.5x attack power, and 0.5x attack power
        if (critical == true)  // if critical boolean is true
        {
            Damage = (Damage * 2); //double the damage for a critical hit
            critical = false;
            System.out.println("Critical Hit!!(2X DMG)");
        }
        return Damage; //return the final damage
    }
    
    //method to calculate hit damage using input number instead of attack power
    public int calculateDamageDirect(int directDamage) 
    {
        int CriticalHit = (int) (Math.random() * (hitMax - hitMin + 1) + hitMin); //random number between 20 and 1 inclusive
        if (CriticalHit >= 18)  //if the number is greater than 18
        {
            critical = true; //critical boolean is set to true
        }
        int Damage = directDamage; //base damage is set to input damage
        if (critical == true)  // if critical boolean is true
        {
            Damage = (Damage * 2); //double the damage for a critical hit
            critical = false;
            System.out.println("Critical Hit!!(2X DMG)");
        }
        return Damage;  //return the final damage
    }
    
    //method for resolving damage against enemies
    //takes into account status effects the enemy may have
    //and any on hit relics the player may have
    public void damageEnemy(int damage, RPGEnemy enemy, int mitigation) 
    {
        if (RPGEnemy.enemyClass.getDebuff("Shock")>0) //if enemy has more than 0 shock in their status effect hashmap
        {
            shockDamage =(RPGEnemy.enemyClass.getDebuff("Shock")); //assigns shockDamage as the number of shock the enemy has
        }
        int mitigateddamage = damage - mitigation; //reduces provided hit damage by the enemies defense(mitigation)
        if (RPGEnemy.enemyClass.getDebuff("Vulnerable")>0) //if enemy has more than 0 vulnerable in their status effect hashmap
        {
            mitigateddamage = (mitigateddamage * 2); //double hit damage for a vulnerable hit
            System.out.println("Vulnerable Hit!!(2X DMG)"); 
        }
        if ((mitigateddamage+shockDamage) <=0) //if hit damage and shock damage combined is less than or equal to 0
        {
            System.out.println("You failed to deal any damage through enemy's defense!");
            return; //return without dealing damage
        }
        enemyHealth = enemyHealth - (mitigateddamage+shockDamage); //deal damage to enemyHealth equal to hit damage and shock damage
        if (RPGEnemy.enemyClass.getDebuff("Shock")!=0) //if the enemy had more than 0 shock
        {
            //print the damage dealt as well as shock damage dealt
            System.out.println("you deal "+mitigateddamage+" damage + "+shockDamage+" shock damage to "+battleEnemy.name+"!");
        }
        else //if enemy had no shock
        {
            //only prints the damage dealt
            System.out.println("you deal "+mitigateddamage+" damage to "+battleEnemy.name+"!");
        }
        //adds the damage dealt to the turnPlayerDamage variable that keeps track of damage dealt by player each round
        turnPlayerDamage=turnPlayerDamage+mitigateddamage; 
        if ("Hit".equals(RPGPlayer.playerRelic.getTrigger())) //if the player's relic trigger condition is on "Hit"   
        {
            //triggers the relic using the relicTriggerEnemy method from the relic class
            RPGPlayer.playerRelic.relicTriggerEnemy(RPGEnemy.enemyClass); 
        }
    }

    //method for resolving damage against the player
    //takes into account status effects the player may have
    //and any on "get hit" relics the player may have
    public void damagePlayer(int damage, RPGPlayer player, int mitigation) 
    {
        if (RPGPlayer.playerClass.getDebuff("Shock")>0) //if player has more than 0 shock in their status effect hashmap
        {
            shockDamage = (RPGPlayer.playerClass.getDebuff("Shock")); //assigns shockDamage as the number of shock the player has
        }
        int mitigateddamage = damage - mitigation; //reduces provided hit damage by the player's defense(mitigation)
        if (RPGPlayer.playerClass.getDebuff("Vulnerable")>0) //if player has more than 0 vulnerable in their status effect hashmap
        {
            mitigateddamage = (mitigateddamage * 2); //double hit damage for a vulnerable hit
            System.out.println("Vulnerable Hit!!(2X DMG)");
        }
        if ((mitigateddamage+shockDamage) <=0) //if hit damage and shock damage combined is less than or equal to 0
        {
            System.out.println(battleEnemy.name+" failed to deal any damage through your defense!");
            return; //return without dealing damage
        }
        playerHealth = playerHealth - (mitigateddamage + shockDamage); //deal damage to enemyHealth equal to hit damage and shock damage
        if (RPGPlayer.playerClass.getDebuff("Shock")>0) //if the enemy had more than 0 shock
        {
            //print the damage dealt as well as shock damage dealt
            System.out.println(battleEnemy.name+" deals "+mitigateddamage+" damage + "+shockDamage+" shock damage to you!");
        }
        else  //if enemy had no shock
        {
            //only prints the damage dealt
            System.out.println(battleEnemy.name+" deals "+mitigateddamage+" damage to you!");
        }
        if ("GetHit".equals(RPGPlayer.playerRelic.getTrigger()))  //if the player's relic trigger condition is on "GetHit"   
        {
            //triggers the relic using the relicTriggerEnemy method from the relic class and does damage based on return value
            enemyHealth = enemyHealth - (RPGPlayer.playerRelic.relicTriggerEnemy(RPGEnemy.enemyClass));
        }
        if (playerParry==true) //if playerParry is currently true
        {
            switch (RPGPlayer.className) //switch depending on class used
            {
                case ("warrior"): //if warrior
                {
                    System.out.println("You counterattack using Swift Counter!");
                    //damage enemy using enemy's damage value, and accounting for their defense
                    damageEnemy(mitigateddamage, battleEnemy, RPGEnemy.enemyClass.getDefense());
                    break;
                }
                case ("mage"):  //if mage
                {
                    System.out.println("Your Mage Armour lashes out!");
                    //damage enemy using damage of 4, and accounting for their defense
                    damageEnemy(4, battleEnemy, RPGEnemy.enemyClass.getDefense());
                    break;
                }
            } 
        }
    }
    
    //method to resolve and reduce status effects at the end of the turn
    public void resolveStatusEffects()
    {
        if (RPGEnemy.enemyClass.getDebuff("Flame")>0) //if enemy has 1 or more flame
        {
            enemyHealth = enemyHealth - (RPGEnemy.enemyClass.getDebuff("Flame")); //deal damage equal to the number of flame enemy has
            System.out.println("\n"+battleEnemy.name+" takes "+RPGEnemy.enemyClass.getDebuff("Flame")+" damage from Burn!");
            RPGEnemy.enemyClass.removeDebuff("Flame",1); //removes 1 stack of flame using the removeDebuff method from enemyClass
        }
        if (RPGEnemy.enemyClass.getDebuff("Shock")>0)  //if enemy has 1 or more shock
        {
            RPGEnemy.enemyClass.removeDebuff("Shock",1); //removes 1 stack of shock using the removeDebuff method from enemyClass
        }
        if (RPGEnemy.enemyClass.getDebuff("Vulnerable")>0) //if enemy has 1 or more vulnerable
        {
            RPGEnemy.enemyClass.removeDebuff("Vulnerable",1); //remove 1 stack of vulnerable
            if (RPGEnemy.enemyClass.getDebuff("Vulnerable")==0)  //if the enemy now has 0 stacks of vulnerable
            {
                System.out.println(battleEnemy.name+" no longer looks vulnerable!");   //prints message indicating this
            }
        }
        
        if (RPGPlayer.playerClass.getDebuff("Flame")>0) //if enemy has 1 or more flame
        {
            playerHealth = playerHealth - (RPGPlayer.playerClass.getDebuff("Flame")); //deal damage equal to the number of flame player has
            System.out.println("\nYou takes "+RPGPlayer.playerClass.getDebuff("Flame")+" damage from Burn!");
            RPGPlayer.playerClass.removeDebuff("Flame",1); //removes 1 stack of flame using the removeDebuff method from playerClass
        }
        if (RPGPlayer.playerClass.getDebuff("Shock")>0)  //if player has 1 or more shock
        {
            RPGPlayer.playerClass.removeDebuff("Shock",1); //removes 1 stack of shock using the removeDebuff method from playerClass
        }
        if (RPGPlayer.playerClass.getDebuff("Vulnerable")>0) //if player has 1 or more vulnerable
        {
            RPGPlayer.playerClass.removeDebuff("Vulnerable",1);  //remove 1 stack of vulnerable
            if (RPGPlayer.playerClass.getDebuff(("Vulnerable"))==0)  //if the player now has 0 stacks of vulnerable
            {
                System.out.println("You no longer feel vulnerable!");    //prints message indicating this
            }
        }
    }
    
    //method for resolving all end of turn effects
    //and any things that take place between turns
    public void turnEnd()
    {
        System.out.println("Turn End:");
        playerDefenseModifier = 0;  // sets all stat and attack modifiers to 0
        playerDodgeModifier=0;
        enemyDodgeModifier=0;
        enemyAttackModifier=0;
        playerParry=false; //sets playerParry to false
        if ("EndTurn".equals(RPGPlayer.playerRelic.getTrigger())) //if player's relic trigger condition is "EndTurn"
        {
            //heals player based on the damage dealt that turn (turnPlayerDamage) and sets turnPlayerDamage back to 0 for next turn
            playerHealth=RPGPlayer.playerRelic.relicTriggerSelf(playerHealth, turnPlayerDamage,RPGPlayer.playerClass.getHealthPoints());
            turnPlayerDamage=0;
        }
        if (enemyPhaseChange==true)  //if enemy has changed phase
        {
            System.out.println(battleEnemy.name+" is slowly falling apart!");
            enemyHealth=enemyHealth-(int)(RPGEnemy.enemyClass.getHealthPoints()*0.05); //enemy loses 5% of health
            System.out.println(battleEnemy.name+" took "+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.05)+" Damage!");
        }
        //if player is not charging an attack and has less than maximum mana
        if ((playerCharge != true) && (playerMana<RPGPlayer.playerClass.getManaPoints())) 
        {
            playerMana=(playerMana+RPGPlayer.playerClass.getIntellect()); //restore playerMana by the player class's intellect stat
            if (playerMana>RPGPlayer.playerClass.getManaPoints()) //if playerMana is more than max mana
            {
                playerMana=(RPGPlayer.playerClass.getManaPoints()); //set to exactly max mana
            }
        }
        if (playerFlurry==true) //if playerFlurry is true
        {
            playerTurnsCharged++; //increment number of playerTurnsCharged by 1
            if (playerTurnsCharged>=3) //if player has been charging for 3 turns
            {
                playerFlurry=false; //set playerFlurry to false
                System.out.println("The energy in your fists subsides.");
            }
        }
        for (int i = 1;i<=3;i++) //loops 3 times with values 1,2,and 3 to reduce cooldown of enemy abilities
        {
            int currentCooldown = Integer.parseInt(RPGEnemy.enemyClass.getAbility(i).get(3));
            //gets the current cooldown of the corresponding enemy ability at key "i" in the enemyAbility hashmap
            if (currentCooldown !=0) //if the cooldown is not 0
            {
                currentCooldown= currentCooldown-1; //reduces the cooldown by 1
                RPGEnemy.enemyClass.getAbility(i).set(3, Integer.toString(currentCooldown)); 
                // and set the cooldown in the hashmap to the reduced value
            }
        }
        if (enemyDefend==true) //if enemyDefend is true
        {
            switch (battleEnemy.name)  //switch based on enemy type
            {
                case ("Slime"):  //if slime
                {
                    enemyDodgeModifier=RPGEnemy.enemyClass.getDodge(); 
                    //gets the dodge stat of the enemy and assigns it to enemy dodge modifier
                    enemyDefend=false;  //sets enemyDefend to false
                    break;
                }
                case ("Revenant"):  //if Revenant
                {
                    enemyHealth=enemyHealth+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.12); //restore 12% of its health
                    System.out.println(battleEnemy.name+" is pulling itself back together!");
                    System.out.println(battleEnemy.name+" regained "+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.12)+" Health!");
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged>=2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend=false; //set enemyDefend to false
                    }
                    break;
                }
                case ("Skeleton"):  //if skeleton
                {
                    enemyHealth=enemyHealth+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.08); //restore 8% of its health
                    System.out.println(battleEnemy.name+" is reconstructing itself!");
                    System.out.println(battleEnemy.name+" regained "+(int)(RPGEnemy.enemyClass.getHealthPoints()*0.08)+" Health!");
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged>=2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend=false;  //set enemyDefend to false
                    }
                    break;
                }
                case ("Ghost"): //if ghost
                {
                    enemyTurnsCharged++; //increment enemyTurnsCharged by 1
                    if (enemyTurnsCharged>=2) //if enemy has charged for 2 or more turns
                    {
                        enemyDefend=false; //set enemyDefend to false 
                    }
                    break;
                }
            }
        }
        resolveStatusEffects(); //calls resolveStatusEffects method to trigger and reduce all status effects
        if ((enemyHealth <=0) && (playerHealth >0)) 
        //if enemy has less than or is equal to 0 health and player has more than 0 health
        {
            victory = true; //victory boolean is set to true
        }
        else if (playerHealth <=0) //if player has less than or is equal to 0 health
        {
            loss = true;   //loss boolean is set to true
        }
        System.out.println("Press enter to continue to next turn");
        userInput.nextLine();  //waits for user input to continue to next turn
    }

}
