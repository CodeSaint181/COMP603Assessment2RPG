/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import assessment2rpg.PlayerClasses.RPGMageClass;
import assessment2rpg.PlayerClasses.RPGMonkClass;
import assessment2rpg.PlayerClasses.RPGPlayerClass;
import assessment2rpg.PlayerClasses.RPGWarriorClass;
import assessment2rpg.PlayerRelics.RPGRelic;
import assessment2rpg.PlayerRelics.RPGRelicFlameBlade;
import assessment2rpg.PlayerRelics.RPGRelicHolyStone;
import assessment2rpg.PlayerRelics.RPGRelicLightningBracer;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

// RPGPlayer class - constructs a RPGPlayer object using the provided variables
// to switch between the different player classes and relics.
public class RPGPlayer {   
    static String name = "";                        //initializing all variables as empty so they can be filled with the user information
    static RPGPlayerClass playerClass = null;        //creates variable of abstract class RPGPlayerClass
    static String className = "";
    static RPGRelic playerRelic = null;             //creates variable of abstract class RPGRelic
    
    public RPGPlayer(String newName, String newPlayerClass, String newRelic)
    {
        RPGPlayer.name = newName;                       //Sets player name as provided name variable
        switch(newPlayerClass){                         //simple switch-case to switch depending on provided variables
            case "warrior": {                           //if newPlayerClass string is equal to "warrior"
                className="warrior";                    //sets className variable to corresponding PlayerClass
                playerClass = new RPGWarriorClass();    //creates RPGWarriorClass object as an extended RPGPlayerClass
                playerClass.loadClassAbilities();       //loads class abilities using method from RPGWarriorClass
                break;        //breaks out of switch-case
            }
            case "mage": {                              //if newPlayerClass string is equal to "mage"
                className="mage";                       //sets className variable to corresponding PlayerClass
                playerClass = new RPGMageClass();       //creates RPGMageClass object as an extended RPGPlayerClass
                playerClass.loadClassAbilities();       //loads class abilities using method from RPGMageClass
                break;        //breaks out of switch-case
            }
            case "monk": {                              //if newPlayerClass string is equal to "warrior"
                className="monk";                       //sets className variable to corresponding PlayerClass
                playerClass = new RPGMonkClass();       //creates RPGMageClass object as an extended RPGPlayerClass
                playerClass.loadClassAbilities();       //loads class abilities using method from RPGMageClass
                break;        //breaks out of switch-case
            }
        }
        switch(newRelic){                               //simple switch-case to switch depending on provided variables
            case "flame blade": {                       //if newRelic string is equal to "flame blade"
                playerRelic = new RPGRelicFlameBlade();   //creates RPGRelicFlameBlade object as an extended RPGRelic
                break;        //breaks out of switch-case
            }
            case "lightning bracer": {                  //if newRelic string is equal to "flame blade"
                playerRelic = new RPGRelicLightningBracer();   //creates RPGRelicLightningBracer object as an extended RPGRelic
                break;        //breaks out of switch-case
            }
            case "holy stone": {                        //if newRelic string is equal to "flame blade"
                playerRelic = new RPGRelicHolyStone();   //creates RPGRelicHolyStone object as an extended RPGRelic
                break;        //breaks out of switch-case
            }
        }
    }
    
    
    //Method to print stats and relic description using methods from the
    //corresponding extended objects
    public static String printStatus() {
        String statusString="";
        statusString=(playerClass.printStats());        //Prints Class Statistics from the extended RPGPlayerClass that was selected in the constructor
        statusString=statusString+(playerRelic.printRelic());        //Prints Relic Description from the extended RPGRelic that was selected in the constructor
        statusString=(statusString+"\n=======Debuffs======");
        return statusString;
    }
    
    public static String printStatusWithoutSkills() {
        String statusString="";
        statusString=(playerClass.printStatsWithoutSkills());        //Prints Class Statistics from the extended RPGPlayerClass that was selected in the constructor
        statusString=statusString+(playerRelic.printRelic());        //Prints Relic Description from the extended RPGRelic that was selected in the constructor
        return statusString;
    }
}
