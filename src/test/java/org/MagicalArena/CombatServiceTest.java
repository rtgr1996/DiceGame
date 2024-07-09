package org.MagicalArena;

import org.MagicalArena.model.Player;
import org.MagicalArena.service.CombatService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombatServiceTest {


    @Test
    public void combatPlayerAWins(){
        Player playerA = new Player("Player A", 1000, 10, 10);
        Player playerB = new Player("Player B", 500, 5, 5);

        CombatService combatService = new CombatService(playerA, playerB);
        combatService.startFight();

        assertTrue(playerA.isAlive());
        assertFalse(playerB.isAlive());
    }

    @Test
    public void combatPlayerBWins(){
        Player playerA = new Player("Player A", 100, 5, 5);
        Player playerB = new Player("Player B", 500, 5, 5);

        CombatService combatService = new CombatService(playerA, playerB);
        combatService.startFight();

        assertTrue(playerB.isAlive());
        assertFalse(playerA.isAlive());
    }


}
