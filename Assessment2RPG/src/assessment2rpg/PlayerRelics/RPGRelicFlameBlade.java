/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.PlayerRelics;

import assessment2rpg.EnemyClasses.RPGEnemyClass;
import assessment2rpg.RPGEnemy;

/**
 * ********************
 * Group 75 COMP603/52A Project 2 Sahil Dhanda 20122024
 *
 * @author sahil
 *********************
 */
//Class extending abstract superclass RPGRelic with actual code and variables.
public class RPGRelicFlameBlade extends RPGRelic {
    public String flame="Flame";             //setting debuff as flame
    public String triggerCondition="Hit";    //setting triggerCondition string as Hit
    

    //constructor to provide name and debuff to superconstructor
    public RPGRelicFlameBlade() {
        super("FlameBlade","Flame");
    }

    //Overriding method that prints relic description
    @Override
    public String printRelic() {
        String relicString = ("Flame Blade - Inflict 1 Burn stack on every hit. \n[Burn] - Deal 1 damage per stack and reduce stack by 1 at end of turn.");
        return relicString;
    }

    //Overriding method that takes a RPGEnemyClass or any extentions 
    //and calls their addDebuff method from the EnemyClass to inflict them with the flame debuff
    @Override
    public int relicTriggerEnemy(RPGEnemyClass e) {
        e.addDebuff(flame, 2);
        System.out.println("Your Relic Inflicted 2 Burn onto "+e.name+"\n");
        return 0;
    }
    
    //Overriding method that does not actually trigger as this relic cannot trigger on yourself
    //thus you cannot trigger this method with this relic
    @Override
    public int relicTriggerSelf(int health, int damageDealt, int max) 
    {
        System.out.println("Invalid Target");
        return 0;
    }

    //Overriding method that returns the triggerCondition string when called
    @Override
    public String getTrigger()
    {
        return triggerCondition;
    }

    @Override
    public String printRelicLogEnemy(RPGEnemyClass e) {
        return ("Your Relic Inflicted 2 Burn onto "+e.name+"\n");
    }

    @Override
    public String printRelicLogSelf() {
        return "Invalid Target";
    }
    
}
