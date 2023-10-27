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
public class BattleStartTest {
    
    public BattleStartTest() {
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
     * Test of defend method, of class BattleStart.
     */
    @Test
    public void testDefend() {
        System.out.println("defend");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "You brace for the enemy's attack doubling your defense for the turn";
        String result = instance.defend();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of ability method, of class BattleStart.
     */
    @Test
    public void testAbility() {
        System.out.println("ability");
        int index = 0;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.ability(index);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of playerChargeAbility method, of class BattleStart.
     */
    @Test
    public void testPlayerChargeAbility() {
        System.out.println("playerChargeAbility");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.playerChargeAbility();
    }

    /**
     * Test of enemyTurn method, of class BattleStart.
     */
    @Test
    public void testEnemyTurn() {
        System.out.println("enemyTurn");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.enemyTurn();
    }

    /**
     * Test of EnemyAttack method, of class BattleStart.
     */
    @Test
    public void testEnemyAttack() {
        System.out.println("EnemyAttack");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.EnemyAttack();
    }

    /**
     * Test of EnemyAbility method, of class BattleStart.
     */
    @Test
    public void testEnemyAbility() {
        System.out.println("EnemyAbility");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.EnemyAbility();
    }

    /**
     * Test of enemyChargeAbility method, of class BattleStart.
     */
    @Test
    public void testEnemyChargeAbility() {
        System.out.println("enemyChargeAbility");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.enemyChargeAbility();
    }

    /**
     * Test of targetEnemy method, of class BattleStart.
     */
    @Test
    public void testTargetEnemy() {
        System.out.println("targetEnemy");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.targetEnemy();
    }

    /**
     * Test of targetPlayer method, of class BattleStart.
     */
    @Test
    public void testTargetPlayer() {
        System.out.println("targetPlayer");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.targetPlayer();
    }

    /**
     * Test of calculateDamage method, of class BattleStart.
     */
    @Test
    public void testCalculateDamage() {
        System.out.println("calculateDamage");
        int dmgStat = 10;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        int result = instance.calculateDamage(dmgStat);
        assert result >= 4:" out of expected range";
        assert result <= 15:" out of expected range";
        System.out.println("value is " + result);
    }
    
        /**
     * Test of calculateDamage method, of class BattleStart.
     */
    @Test
    public void testCalculateDamageCritical() {
        System.out.println("calculateDamageCritical");
        int dmgStat = 10;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.critical=true;
        int result = instance.calculateDamage(dmgStat);
        System.out.println("value is " + result);
        assert result >= 10:" out of expected range";
        assert result <= 30:" out of expected range";
    }

    /**
     * Test of calculateDamageDirect method, of class BattleStart.
     */
    @Test
    public void testCalculateDamageDirect() {
        System.out.println("calculateDamageDirect");
        int directDamage = 10;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        int expResult = 10;
        int result = instance.calculateDamageDirect(directDamage);
        assertEquals(expResult, result);
    }

    /**
     * Test of damageEnemy method, of class BattleStart.
     */
    @Test
    public void testDamageEnemy() {
        System.out.println("damageEnemy");
        int damage = 0;
        RPGEnemy enemy = null;
        int mitigation = 0;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.damageEnemy(damage, enemy, mitigation);
    }

    /**
     * Test of damagePlayer method, of class BattleStart.
     */
    @Test
    public void testDamagePlayer() {
        System.out.println("damagePlayer");
        int damage = 0;
        RPGPlayer player = null;
        int mitigation = 0;
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        instance.damagePlayer(damage, player, mitigation);
    }

    /**
     * Test of resolveStatusEffects method, of class BattleStart.
     */
    @Test
    public void testResolveStatusEffects() {
        System.out.println("resolveStatusEffects");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "";
        String result = instance.resolveStatusEffects();
        assertEquals(expResult, result);
    }

    /**
     * Test of statusCounter method, of class BattleStart.
     */
    @Test
    public void testStatusCounter() {
        System.out.println("statusCounter");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "Debuff Stacks: \n";
        String result = instance.statusCounter();
        assertEquals(expResult, result);
    }

    /**
     * Test of playerTurnEnd method, of class BattleStart.
     */
    @Test
    public void testPlayerTurnEnd() {
        System.out.println("playerTurnEnd");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "";
        String result = instance.playerTurnEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of enemyTurnEnd method, of class BattleStart.
     */
    @Test
    public void testEnemyTurnEnd() {
        System.out.println("enemyTurnEnd");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "";
        String result = instance.enemyTurnEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of turnEnd method, of class BattleStart.
     */
    @Test
    public void testTurnEnd() {
        System.out.println("turnEnd");
        BattleStart instance = new BattleStart(testPlayer,testEnemy);
        String expResult = "\nTurn End:\n";
        String result = instance.turnEnd();
        assertEquals(expResult, result);
    }
}
