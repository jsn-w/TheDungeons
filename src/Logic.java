import java.util.Scanner;

public class Logic {
    private Scanner s;
    private Weapon playerWeapon;
    private Weapon enemyWeapon;
    private Character p;
    private final String playerName;
    private Room r;

    public Logic() {
        Character.healthPot = 0;
        s = new Scanner(System.in);
        System.out.println("Welcome to the realm of Ashyn!");
        System.out.print("What do you call yourself?\n>> ");
        playerName = s.nextLine();

        createCharacters();
        r = new Room("Sun Temple", p);

        // Combat loop
        r.combat();
    }

    public void createCharacters() {
        // Create player instances
        playerWeapon = new Weapon("Wooden Sword", 1, 0, 10, .2);
        p = new Character(playerName, 100, playerWeapon);
        Menu.printIntro(playerName);
    }


}
