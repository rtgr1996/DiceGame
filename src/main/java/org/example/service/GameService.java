package org.example.service;

import org.example.model.Player;

import java.util.Random;

public class GameService {
    private Player playerA;
    private Player playerB;

    public GameService(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void startFight(){
        boolean playerATurn = true; // counter for turn

        while(playerA.isAlive() && playerB.isAlive()){
            if(playerATurn){
                System.out.println(playerA.getName() + " attacks " + playerB.getName());
                attack(playerA, playerB);
            } else {
                System.out.println(playerB.getName() + " attacks " + playerA.getName());
                attack(playerB, playerA);
            }
            playerATurn = !playerATurn;
        }

        if(playerA.isAlive()){
            System.out.println(playerA.getName() + " wins");
        } else {
            System.out.println(playerB.getName() + " wins");
        }

    }

    private void attack(Player playerA, Player playerB) {
        int attackRollDice = rollDice();
        int defenderRollDice = rollDice();

        System.out.println("attack roll dice number : " + attackRollDice);
        System.out.println("defense roll dice number : " + defenderRollDice);

        int attack = attackRollDice*playerA.getAttack();
        int defend = defenderRollDice*playerB.getStrength();

        System.out.println(playerA.getName() + " attack with " + attack);
        System.out.println(playerB.getName() + " defend with " + defend);

        int damage = attack - defend;
        if(damage <= 0){
            System.out.println("No damage done to " + playerB.getName());
            return;
        }

        System.out.println("damage done to " + playerB.getName() + " is " + damage);

        if(playerB.getHealth()-damage <= 0){
            System.out.println("too much damage " + playerB.getName() + " is dead");
        }
        playerB.setHealth(playerB.getHealth()-damage);
    }

    private int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
