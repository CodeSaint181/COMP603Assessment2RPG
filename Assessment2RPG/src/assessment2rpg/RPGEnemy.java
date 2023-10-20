/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg;

import assessment2rpg.EnemyClasses.RPGEnemyClass;
import assessment2rpg.EnemyClasses.RPGGhostClass;
import assessment2rpg.EnemyClasses.RPGSkeletonClass;
import assessment2rpg.EnemyClasses.RPGSlimeClass;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

// RPGEnemy class - constructs a RPGEnemy object using the provided variable
// to switch between the different enemy classes
public class RPGEnemy {
    static RPGEnemyClass enemyClass=null;   //creates variable of abstract class RPGEnemyClass
    
    String name ="";
    
    public RPGEnemy(String newEnemyClass)
    {
        switch(newEnemyClass){                          //simple switch-case to switch depending on provided variables
            case "slime": {                             //if newEnemyClass string is equal to "slime"
                name="Slime";                           //sets enemy name variable to corresponding enemy class
                enemyClass = new RPGSlimeClass();       //creates RPGSlimeClass object as an extended RPGEnemyClass
                enemyClass.loadEnemyAbilities();        //loads enemy abilities using method from RPGSlimeClass
                break;        //breaks out of switch-case
            }
            case "skeleton": {                          //if newEnemyClass string is equal to "skeleton"
                name="Skeleton";                        //sets enemy name variable to corresponding enemy class
                enemyClass = new RPGSkeletonClass();    //creates RPGSkeletonClass object as an extended RPGEnemyClass
                enemyClass.loadEnemyAbilities();        //loads enemy abilities using method from RPGSkeletonClass
                break;        //breaks out of switch-case
            }
            case "ghost": {                              //if newEnemyClass string is equal to "ghost"
                name="Ghost";                            //sets enemy name variable to corresponding enemy class
                enemyClass = new RPGGhostClass();        //creates RPGSlimeClass object as an extended RPGEnemyClass
                enemyClass.loadEnemyAbilities();         //loads enemy abilities using method from RPGSkeletonClass
                break;        //breaks out of switch-case
            }
        }
    }
    
    //Method to print enemy statistics using method from corresponding extended class
    public static void printEnemyStatus() {
        enemyClass.printEnemyStats();                   //Prints Enemy Statistics from the extended RPGEnemyClass that was selected in the constructor
    }
    
}
