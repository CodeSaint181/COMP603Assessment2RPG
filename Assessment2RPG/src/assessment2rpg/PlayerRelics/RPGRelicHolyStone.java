/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.PlayerRelics;

import assessment2rpg.EnemyClasses.RPGEnemyClass;

/**
 * ********************
 * Group 75 COMP603/52A Project 2 Sahil Dhanda 20122024
 *
 * @author sahil
 *********************
 */

//Class extending abstract superclass RPGRelic with actual code and variables.
public class RPGRelicHolyStone extends RPGRelic {
    public String triggerCondition="EndTurn";  //setting triggerCondition string as end turn
    public int healed=0;
    
    //constructor to provide name and "debuff" to superconstructor
    //debuff is none as this relic does not inflict debuffs
    public RPGRelicHolyStone() {
        super("HolyStone","None");
    }

    //Overriding method that prints relic description
    @Override
    public String printRelic() {
        String relicString = ("Holy Stone - Heal half the damage you deal at end of turn");
        return relicString;
    }

    //Overriding method that does not actually trigger as this relic cannot trigger on enemies
    //thus you cannot trigger this method with this relic
    @Override
    public int relicTriggerEnemy(RPGEnemyClass e) {
        System.out.println("Invalid Target");
        return 0;
    }
    
    //Overriding method that takes 3 integers, current health, damage dealt, and max health
    //and adds half of the damage dealt to the current health, up to the limit of max health
    @Override
    public int relicTriggerSelf(int health, int damageDealt, int max) 
    {
        healed=damageDealt/2;
        health=health+healed;
        if (health>max)
        {
            health=max;
        }
        System.out.println("Your Relic healed "+healed+" health to you!\n");
        return health;
    }
    
    //Overriding method that returns the triggerCondition string when called
    @Override
    public String getTrigger()
    {
        return triggerCondition;
    }
    
    @Override
    public String printRelicLogEnemy(RPGEnemyClass e) {
        return ("Invalid Target");
    }

    @Override
    public String printRelicLogSelf() {
        return ("Your Relic healed "+healed+" health to you!\n");
    }
}
