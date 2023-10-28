/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.EnemyClasses;
import java.util.ArrayList;

/**
 * ********************
 * Group 75 COMP603/52A Project 2 Sahil Dhanda 20122024
 *
 * @author sahil
 *********************
 */

//Abstract Class that contains all the abstract methods that will be extended
//to fill out the EnemyClass's statistics and abilities
public abstract class RPGEnemyClass {
    
    public String name="";
    
    public RPGEnemyClass(String name) {   //super constructor to get the name of the enemy
        this.name=name;
    }
    
    //abstracted methods that will be overridden in extended enemy classes
    public abstract int getStrength();   

    public abstract int getAgility();
    
    public abstract int getIntellect();

    public abstract int getHealthPoints();

    public abstract int getManaPoints();

    public abstract int getAttackPoints();
    
    public abstract int getDodge();

    public abstract int getDefense();
    
    public abstract ArrayList<String> getAbility(int key);
    
    public abstract int getDebuff(String key);
    
    public abstract void addDebuff(String key, int value);
    
    public abstract void removeDebuff(String key, int value);

    public abstract void printEnemyStats();
    
    public abstract String printEnemyStatsWithoutSkills();

    public abstract void loadEnemyAbilities();
    
}
