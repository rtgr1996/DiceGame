package org.Game;

import org.Game.model.Player;
import org.Game.service.GameService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceTest {


    @Test
    public void combatPlayerAWins(){
        Player playerA = new Player("Player A", 1000, 10, 10);
        Player playerB = new Player("Player B", 500, 5, 5);

        GameService gameService = new GameService(playerA, playerB);
        gameService.startFight();

        assertTrue(playerA.isAlive());
        assertFalse(playerB.isAlive());
    }

    @Test
    public void combatPlayerBWins(){
        Player playerA = new Player("Player A", 100, 5, 5);
        Player playerB = new Player("Player B", 500, 5, 5);

        GameService gameService = new GameService(playerA, playerB);
        gameService.startFight();

        assertTrue(playerB.isAlive());
        assertFalse(playerA.isAlive());
    }


}
