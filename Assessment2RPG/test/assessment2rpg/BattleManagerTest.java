/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assessment2rpg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sahil
 */
public class BattleManagerTest {
    
    public BattleManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    RPGPlayer testPlayer = new RPGPlayer("kirm","warrior","flame blade");
    RPGEnemy testEnemy = new RPGEnemy("slime");
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of defend method, of class BattleManager.
     */
    @Test
    public void testDefend() {
        System.out.println("defend");
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        String expResult = "You brace for the enemy's attack doubling your defense for the turn";
        String result = instance.defend();
        assertEquals(expResult, result);
    }

    /**
     * Test of ability method, of class BattleManager.
     */
    @Test
    public void testAbilityEnoughMana() {
        System.out.println("ability (with enough mana)");
        int index = 1;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerMana=30;
        instance.ability(index);
    }
    
    @Test
    public void testAbilityNotEnoughMana() {
        System.out.println("ability (with enough mana)");
        int index = 1;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerMana=0;
        instance.ability(index);
    }

    /**
     * Test of targetEnemy method, of class BattleManager.
     */
    @Test
    public void testTargetEnemy() {
        System.out.println("targetEnemy");
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.targetEnemy();
    }

    /**
     * Test of targetPlayer method, of class BattleManager.
     */
    @Test
    public void testTargetPlayer() {
        System.out.println("targetPlayer");
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.targetPlayer();
    }

    /**
     * Test of calculateDamage method, of class BattleManager.
     */
    @Test
    public void testCalculateDamage() {
        System.out.println("calculateDamage based on default damage stat without a crit");
        int dmgStat = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.critical=false;
        int result = instance.calculateDamage(dmgStat);
        assert result >= 4:" out of expected range";
        assert result <= 15:" out of expected range";
        System.out.println("value is " + result);
    }
    
    @Test
    public void testCalculateDamageCritical() {
        System.out.println("calculateDamage based on default damage stat with a crit");
        int dmgStat = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.critical=true;
        int result = instance.calculateDamage(dmgStat);
        System.out.println("value is " + result);
        assert result >= 10:" out of expected range";
        assert result <= 30:" out of expected range";
    }

    
    /**
     * Test of calculateDamageDirect method, of class BattleManager.
     */
    @Test
    public void testCalculateDamageDirect() {
        System.out.println("calculateDamageDirect based on default damage stat without a crit");
        int directDamage = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.critical=false;
        int expResult = 10;
        int result = instance.calculateDamageDirect(directDamage);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalculateDamageDirectCritical() {
        System.out.println("calculateDamageDirect based on default damage stat with a crit");
        int directDamage = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.critical=true;
        int expResult = 20;
        int result = instance.calculateDamageDirect(directDamage);
        assertEquals(expResult, result);
    }

    /**
     * Test of damageEnemy method, of class BattleManager.
     */
    @Test
    public void testDamageEnemyNormal() {
        System.out.println("damageEnemy normal with 10 damage");
        int damage = 10;
        int mitigation = 0;
        int expResult = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNoDamage() {
        System.out.println("damageEnemy with no damage");
        int damage = 0;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNormalWithMitigation() {
        System.out.println("damageEnemy normal with 10 damage");
        int damage = 10;
        int mitigation = 5;
        int expResult = 15;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNoDamageWithMitigation() {
        System.out.println("damageEnemy");
        int damage = 0;
        int mitigation = 5;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNormalVulnerable() {
        System.out.println("damageEnemy");
        int damage = 10;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 40;
        RPGEnemy.enemyClass.addDebuff("Vulnerable", 1);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    
    @Test
    public void testDamageEnemyNoDamageVulnerable() {
        System.out.println("damageEnemy");
        int damage = 0;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        RPGEnemy.enemyClass.addDebuff("Vulnerable", 1);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
        public void testDamageEnemyNormalWithShock() {
        System.out.println("damageEnemy");
        int damage = 10;
        int mitigation = 0;
        int expResult = 5;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        RPGEnemy.enemyClass.addDebuff("Shock", 5);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNoDamageWithShock() {
        System.out.println("damageEnemy");
        int damage = 0;
        int mitigation = 0;
        int expResult = 15;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 20;
        RPGEnemy.enemyClass.addDebuff("Shock", 5);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    @Test
    public void testDamageEnemyNormalVulnerableWithShock() {
        System.out.println("damageEnemy");
        int damage = 10;
        int mitigation = 0;
        int expResult = 25;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 50;
        RPGEnemy.enemyClass.addDebuff("Vulnerable", 1);
        RPGEnemy.enemyClass.addDebuff("Shock", 5);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }
    
    
    @Test
    public void testDamageEnemyNoDamageVulnerableWithShock() {
        System.out.println("damageEnemy");
        int damage = 0;
        int mitigation = 0;
        int expResult = 45;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.enemyHealth = 50;
        RPGEnemy.enemyClass.addDebuff("Vulnerable", 1);
        RPGEnemy.enemyClass.addDebuff("Shock", 5);
        instance.damageEnemy(damage, testEnemy, mitigation);
        assertEquals(expResult,instance.enemyHealth);
    }

    /**
     * Test of damagePlayer method, of class BattleManager.
     */
    @Test
    public void testDamagePlayerNormal() {
        System.out.println("damagePlayer normal with 10 damage");
        int damage = 10;
        int mitigation = 0;
        int expResult = 10;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNoDamage() {
        System.out.println("damagePlayer with no damage");
        int damage = 0;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNormalWithMitigation() {
        System.out.println("damagePlayer normal with 10 damage");
        int damage = 10;
        int mitigation = 5;
        int expResult = 15;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNoDamageWithMitigation() {
        System.out.println("damagePlayer");
        int damage = 0;
        int mitigation = 5;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNormalVulnerable() {
        System.out.println("damagePlayer");
        int damage = 10;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 40;
        RPGPlayer.playerClass.addDebuff("Vulnerable", 1);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    
    @Test
    public void testDamagePlayerNoDamageVulnerable() {
        System.out.println("damagePlayer");
        int damage = 0;
        int mitigation = 0;
        int expResult = 20;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        RPGPlayer.playerClass.addDebuff("Vulnerable", 1);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
        public void testDamagePlayerNormalWithShock() {
        System.out.println("damagePlayer");
        int damage = 10;
        int mitigation = 0;
        int expResult = 5;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        RPGPlayer.playerClass.addDebuff("Shock", 5);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNoDamageWithShock() {
        System.out.println("damagePlayer");
        int damage = 0;
        int mitigation = 0;
        int expResult = 15;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 20;
        RPGPlayer.playerClass.addDebuff("Shock", 5);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    @Test
    public void testDamagePlayerNormalVulnerableWithShock() {
        System.out.println("damagePlayer");
        int damage = 10;
        int mitigation = 0;
        int expResult = 25;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 50;
        RPGPlayer.playerClass.addDebuff("Vulnerable", 1);
        RPGPlayer.playerClass.addDebuff("Shock", 5);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
    
    
    @Test
    public void testDamagePlayerNoDamageVulnerableWithShock() {
        System.out.println("damagePlayer");
        int damage = 0;
        int mitigation = 0;
        int expResult = 45;
        BattleManager instance = new BattleManager(testPlayer,testEnemy);
        instance.playerHealth = 50;
        RPGPlayer.playerClass.addDebuff("Vulnerable", 1);
        RPGPlayer.playerClass.addDebuff("Shock", 5);
        instance.damagePlayer(damage, testPlayer, mitigation);
        assertEquals(expResult,instance.playerHealth);
    }
}
