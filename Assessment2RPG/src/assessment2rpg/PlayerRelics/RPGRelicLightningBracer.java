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

//Class extending abstract superclass RPGRelic with actual code and variables.
public class RPGRelicLightningBracer extends RPGRelic {
    public String shock="Shock";                //setting debuff as shock
    public String triggerCondition="GetHit"; //setting triggerCondition string as GetHit
    public int damage=0;
    
    //constructor to provide name and debuff to superconstructor
    public RPGRelicLightningBracer() {
        super("LightningBracer","Shock");
    }

    //Overriding method that prints relic description
    @Override
    public String printRelic() {
        String relicString = ("Lightning Bracer - Deal 2-5 damage to enemies when they attack you and inflict 2 shock. \n[Shock] - take 1 extra damage for each stack and reduce stack by 1 at end of turn");
        return relicString;
    }

    //Overriding method that takes a RPGEnemyClass or any extentions 
    //and calls their addDebuff method from the EnemyClass to inflict them with the shock debuff
    //then does a random amount of damage from 2-5
    @Override
    public int relicTriggerEnemy(RPGEnemyClass e) {
        e.addDebuff(shock, 2);
        System.out.println("Your Relic Inflicted 2 Shock onto "+e.name+"!");
        damage = (int) (Math.random() * (4) + 2);  //random number generator between 6 (exclusive) and 2 (inclusive)
        System.out.println("Your Relic Dealt "+damage+" damage to "+e.name+".\n");
        return damage;
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
}
