package org.MagicalArena;

import org.MagicalArena.model.Player;
import org.MagicalArena.service.CombatService;

import java.util.Scanner;

public class GameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Player A:");
        System.out.print("Name: ");
        String nameA = scanner.nextLine();
        System.out.print("Health: ");
        int healthA = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthA = scanner.nextInt();
        System.out.print("Attack: ");
        int attackA = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.println("Enter details for Player B:");
        System.out.print("Name: ");
        String nameB = scanner.nextLine();
        System.out.print("Health: ");
        int healthB = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthB = scanner.nextInt();
        System.out.print("Attack: ");
        int attackB = scanner.nextInt();

        Player playerA = new Player(nameA, healthA, strengthA, attackA);
        Player playerB = new Player(nameB, healthB, strengthB, attackB);
        scanner.close();

        CombatService combatService = new CombatService(playerA, playerB);

        combatService.startFight();
    }
}