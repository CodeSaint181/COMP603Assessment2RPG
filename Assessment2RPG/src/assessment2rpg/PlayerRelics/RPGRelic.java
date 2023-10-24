/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.PlayerRelics;

import assessment2rpg.EnemyClasses.RPGEnemyClass;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

//Abstract Class that contains all the abstract methods that will be extended
//to fill out the Relic's statistics and abilities
public abstract class RPGRelic {
    String relicDescription = "";
    
    public RPGRelic(String name, String debuff) {   //super constructor to get the name of the relic and any debuff it causes
    }
    
    //abstracted methods that will be overridden in extended relic classes
    public abstract String printRelic();

    public abstract int relicTriggerEnemy(RPGEnemyClass e);
    
    public abstract int relicTriggerSelf(int health, int damagedealt, int max);
    
    public abstract String getTrigger();
    
}
