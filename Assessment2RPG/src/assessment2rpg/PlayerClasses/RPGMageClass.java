/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment2rpg.PlayerClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**********************
 * Group 75 COMP603/52A
 * Project 1
 * Sahil Dhanda 20122024
 * @author sahil
 **********************/

//Class extending abstract superclass RPGPlayerClass with actual code and variables.
public class RPGMageClass extends RPGPlayerClass {
    public final String name = "Mage";
    int strength=5;                 //Setting Player Stats
    int agility = 8;
    int intellect = 20;
    int healthPoints = intellect * 3;
    int manaPoints = intellect * 4;
    int attackPoints = intellect / 2;
    int defense = 2;
    int dodge = (int)(agility / 4);
    
    //ArrayLists to contain player Abilities for easy access to different values of each ability
    ArrayList<String> playerAbility1 = new ArrayList<>();
    ArrayList<String> playerAbility2 = new ArrayList<>();
    ArrayList<String> playerAbility3 = new ArrayList<>();
    
    //HashMaps to store Abilities and Status effects in a simple manner
    //abilities is a map of an Integer key and an ArrayList<String> value to allow for multiple navigable ordered values inside a single key
    //for example this allows for access to key 1, value 3 which is the damage value for ability 1
    Map<Integer, ArrayList<String>> abilities = new HashMap<>();
    
    //playerStatusEffects is a map of a String key and an Integer value
    //this allows for a status effect name as the key and the number of stacks of that effect as the value
    Map<String, Integer> playerStatusEffects = new HashMap<>();

    //Method to initialize the ability Arraylists with the ability values in an ordered fashion
    //It also allows for easy editing of the values without changing multiple sets of text
    public void initializeClassAbilities(){
        this.playerAbility1.add("Fire Bolt");    //each of these add statements adds the specified text at the next index in the arraylist
        this.playerAbility1.add("Shoot up to 5 magical flame bolts at your enemy each costing 8 mana.\n"
                + "Deals 7 Base Damage each and inflicts 2 stack of burn."
                + "[Burn] - Deal 1 damage per stack and reduce stack by 1 at end of turn.");
        this.playerAbility1.add("7");
        this.playerAbility1.add("8");        
        this.playerAbility2.add("Mage Armour");
        this.playerAbility2.add("Summon a set of magical armour around yourself damaging foes that attack you.\n"
                + "Gain 4 defense this round and deal 4 damage to enemies that hit you");
        this.playerAbility2.add("4");
        this.playerAbility2.add("10");
        this.playerAbility3.add("Lightning Storm");
        this.playerAbility3.add("Charge a lightning storm for this turn and next.\n"
                + "Deals 15 Base Damage and inflicts 4 shock each turn."
                + "[Shock] - take 1 extra damage for each stack.");
        this.playerAbility3.add("15");
        this.playerAbility3.add("40");
    }
    
    //contructor to provide name to super constructor
    public RPGMageClass() {
        super("Mage");
    }
    
    //overriding loadClassAbilities method from superclass with actual ability values
    @Override
    public void loadClassAbilities() {
        initializeClassAbilities();     //calls initializeClassAbilities method to initialize the ability values into the arraylists.
        this.abilities.put(1,playerAbility1);   //puts ability Arraylists into the hashmap at certain keys 
        this.abilities.put(2,playerAbility2);
        this.abilities.put(3,playerAbility3);
    }
    
    //method to print out the enemy stats in a presentable fashion
    @Override
    public void printStats() {
        System.out.println("Class: "+this.name);
        System.out.println("=======Stats========");
        System.out.println("Strength: "+this.strength);
        System.out.println("Agility: "+this.agility);
        System.out.println("Intellect: "+this.intellect);
        System.out.println("====================");
        System.out.println("Attack Points: "+this.attackPoints);
        System.out.println("Dodge Chance: "+this.dodge*5+"%");
        System.out.println("Defense: "+this.defense);
        System.out.println("=======Skills=======");
        //for each entry in hashmap abilities, print out the values at arraylist positions 0, 1, and 3 (Name, Desc, and Mana Cost)
        for (Map.Entry<Integer, ArrayList<String>> m : abilities.entrySet()) {    //For loop to iterate through the hashmap to print out the values
            System.out.println((m.getValue().get(0))+" - "+(m.getValue().get(1))+"  Mana Cost: "+(m.getValue().get(3))+"\n");
        }
        System.out.println("=======Relic========");
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
    
    //overriding method that returns the Arraylist at the specified key of the abilities hashmap
    //you can then access a position on that arraylist to get the ability value you want
    @Override
    public ArrayList<String> getAbility(int key) {
        return (abilities.get(key));
    }
    
    //Overriding method that checks the playerStatusEffects hashmap for a specific status effect "key"
    //it will then return the number of stacks of that status effect, the "value"
    @Override
    public int getDebuff(String key) 
    {
        if (this.playerStatusEffects.containsKey(key))
        {
            return (this.playerStatusEffects.get(key));
        }
        return 0;
    }
    
    //Overriding method that checks the playerStatusEffects hashmap for a specific status effect "key"
    //if the hashmap contains that key it will invoke the hashmap.replace method to replace the current value with the provided value
    @Override
    public void setDebuff(String key, int value) 
    {
        if (this.playerStatusEffects.containsKey(key))
        {
            this.playerStatusEffects.replace(key, value);
        }
    }
    
    //Overriding method that checks the playerStatusEffects hashmap for a specific status effect "key"
    //if the hashmap contains that key it will invoke the hashmap.merge method to add the provided value to the current value at the key
    //if it does not contain that key yet, it will add it to the hashmap with the provided value
    @Override
    public void addDebuff(String key, int value) {
        
        if (this.playerStatusEffects.containsKey(key))
        {
            this.playerStatusEffects.merge(key, value, Integer::sum);
        }
        else
        {
            this.playerStatusEffects.put(key, value);
        }
    }
    
    //Overriding method that checks the playerStatusEffects hashmap for a specific status effect "key"
    //if it contains that key it will reduce the current value at the key by the provided value
    @Override
    public void removeDebuff(String key, int value) {
        
        if (this.playerStatusEffects.containsKey(key))
        {
            int current = this.playerStatusEffects.get(key);
            this.playerStatusEffects.put(key,current-value);
        }    
    }
}