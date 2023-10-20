/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.EnemyClasses;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

//Class extending abstract superclass RPGEnemyClass with actual code and variables.
public class RPGSlimeClass extends RPGEnemyClass {
    public final String name = "Slime";
    int strength = 5;                 //Setting Enemy Stats
    int agility = 25;
    int intellect = 5;
    int healthPoints = 100;
    int manaPoints = intellect * 5;
    int attackPoints = (int)(agility/2);
    int dodge = (int)(agility / 4);
    int defense = 0;
    
    //ArrayLists to contain enemy Abilities for easy access to different values of each ability
    ArrayList<String> enemyAbility1 = new ArrayList<>();
    ArrayList<String> enemyAbility2 = new ArrayList<>();
    ArrayList<String> enemyAbility3 = new ArrayList<>();
    
    //HashMaps to store Abilities and Status effects in a simple manner
    //enemyAbilities is a map of an Integer key and an ArrayList<String> value to allow for multiple navigable ordered values inside a single key
    //for example this allows for access to key 1, value 3 which is the damage value for ability 1
    Map<Integer, ArrayList<String>> enemyAbilities = new HashMap<>();
    //enemyAbilities is a map of a String key and an Integer value
    //this allows for a status effect name as the key and the number of stacks of that effect as the value
    Map<String, Integer> enemyStatusEffects = new HashMap<>();
    
    //Method to initialize the enemyAbility Arraylists with the ability values in an ordered fashion
    //It also allows for easy editing of the values without changing multiple sets of text
    public void initializeEnemyAbilities(){
        enemyAbility1.add("Splash");     //each of these add statements adds the specified text at the next index in the arraylist
        enemyAbility1.add("Throws a glob of acidic slime.\n"
                + "Deals 8 Base Damage. Ignores Defense.");
        enemyAbility1.add("8");
        enemyAbility1.add("2");
        enemyAbility2.add("Flatten");
        enemyAbility2.add("Flattens itself Out.\n "
                + "Doubles dodge chance for turn.");
        enemyAbility2.add("0");
        enemyAbility2.add("3");
        enemyAbility3.add("Slime Barrage");
        enemyAbility3.add("Charges for a turn swallowing random objects and throws them at you next turn.\n"
                + "Deals 4-8*3 Base Damage. Ignores 2/3 Defense.");
        enemyAbility3.add("0");
        enemyAbility3.add("4");
    }
    
    //contructor to provide name to super constructor
    public RPGSlimeClass() {
        super("Slime");
    }
    
    //overriding loadEnemyAbilities method from superclass with actual ability values
    @Override
    public void loadEnemyAbilities() {
        initializeEnemyAbilities();     //calls initializeEnemyAbilities method to initialize the ability values into the arraylists.
        this.enemyAbilities.put(1,enemyAbility1);   //puts enemyAbility Arraylists into the hashmap at certain keys 
        this.enemyAbilities.put(2,enemyAbility2);
        this.enemyAbilities.put(3,enemyAbility3);
    }
    
    //method to print out the enemy stats in a presentable fashion
    @Override
    public void printEnemyStats() {
        System.out.println("Enemy: "+this.name);
        System.out.println("===============");
        System.out.println("Strength: "+this.strength);
        System.out.println("Agility: "+this.agility);
        System.out.println("Intellect: "+this.intellect);
        System.out.println("===============");
        System.out.println("Attack Points: "+this.attackPoints);
        System.out.println("Dodge Chance: "+this.dodge*5+"%");
        System.out.println("Defense: "+this.defense);
        System.out.println("===============");
        for (Map.Entry<Integer, ArrayList<String>> m : enemyAbilities.entrySet()) {
            System.out.println((m.getValue().get(0))+" - "+(m.getValue().get(1))+" Cooldown: "+(m.getValue().get(3))+" turns\n");
        }
        System.out.println("===============");
    }
    
    //basic overriding getters to access variables outside of this class
    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getAgility() {
        return this.agility;
    }

    @Override
    public int getIntellect() {
        return this.intellect;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public int getManaPoints() {
        return this.manaPoints;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }
    
    @Override
    public int getDodge() {
        return this.dodge;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    //overriding method that returns the Arraylist at the specified key of the enemyAbilities hashmap
    //you can then access a position on that arraylist to get the ability value you want
    @Override
    public ArrayList<String> getAbility(int key) {
        return (enemyAbilities.get(key));
    }
    
    //Overriding method that checks the enemyStatusEffects hashmap for a specific status effect "key"
    //it will then return the number of stacks of that status effect, the "value"
    @Override
    public int getDebuff(String key) 
    {
        if (this.enemyStatusEffects.containsKey(key))
        {
            return (this.enemyStatusEffects.get(key));
        }
        return 0;
    }
    
    //Overriding method that checks the enemyStatusEffects hashmap for a specific status effect "key"
    //if the hashmap contains that key it will invoke the hashmap.merge method to add the provided value to the current value at the key
    //if it does not contain that key yet, it will add it to the hashmap with the provided value
    @Override
    public void addDebuff(String key, int value) {
        
        if (this.enemyStatusEffects.containsKey(key))
        {
            this.enemyStatusEffects.merge(key, value, Integer::sum);
        }
        else
        {
            this.enemyStatusEffects.put(key, value);
        }
    }
    
    //Overriding method that checks the enemyStatusEffects hashmap for a specific status effect "key"
    //if it contains that key it will reduce the current value at the key by the provided value
    @Override
    public void removeDebuff(String key, int value) {
        
        if (this.enemyStatusEffects.containsKey(key))
        {
            int current = this.enemyStatusEffects.get(key);
            this.enemyStatusEffects.put(key,current-value);
        }    
    }

}
