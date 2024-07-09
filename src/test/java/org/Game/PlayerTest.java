package org.Game;

import org.Game.model.Player;
import org.Game.service.GameService;
import org.junit.jupiter.api.Assertions;
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
        GameService gameService = new GameService(playerA, playerB);
        gameService.startFight();
        assertTrue(playerA.getHealth() < 1000);
        assertTrue(playerB.getHealth() < 500);
    }

    @Test
    public void anyPlayerAlive() {
        GameService gameService = new GameService(playerA, playerB);
        gameService.startFight();
        assertTrue(playerA.isAlive()|| playerB.isAlive());
    }
}
