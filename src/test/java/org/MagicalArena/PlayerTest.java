package org.MagicalArena;

import org.MagicalArena.model.Player;
import org.MagicalArena.service.CombatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    private Player playerA;
    private Player playerB;

    @BeforeEach
    public void setUp() {
        playerA = new Player("Player A", 1000, 10, 20);
        playerB = new Player("Player B", 500, 5, 10);
    }

    @Test
    public void playerInitialization() {
        assertEquals("Player A", playerA.getName());
        assertEquals(1000, playerA.getHealth());
        assertEquals(10, playerA.getStrength());
        assertEquals(20, playerA.getAttack());
    }

    @Test
    public void playerAttack() {
        CombatService combatService = new CombatService(playerA, playerB);
        combatService.startFight();
        assertTrue(playerA.getHealth() < 1000);
        assertTrue(playerB.getHealth() < 500);
    }

    @Test
    public void anyPlayerAlive() {
        CombatService combatService = new CombatService(playerA, playerB);
        combatService.startFight();
        assertTrue(playerA.isAlive()|| playerB.isAlive());
    }
}
