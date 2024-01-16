import java.util.Scanner;

public class Logic {
    private final Scanner s;
    private Weapon playerWeapon;
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
        combat();
    }

    public void createCharacters() {
        // Create player instances
        playerWeapon = new Weapon("Wooden Sword", 1, 0, 40, .2);
        p = new Character(playerName, 100, playerWeapon);
        Menu.printIntro(playerName);
    }

    public void combat() {
        while (p.isAlive() && r.getEnemy().isAlive()) {
            System.out.println("Current weapon: " + p.getWeapon().getName() + ", level " + p.getWeapon().getLevel());
            Menu.printOptions();
            String option = s.nextLine();
            while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4"))) {
                System.out.print("Enter a valid option >> ");
                option = s.nextLine();
            }
            switch (option) {
                case "1" -> r.attack();
                case "2" -> r.search();
                case "3" -> r.usePotion();
                default -> {
                }
            }
            System.out.print("Press [Enter] to continue >> ");
            s.nextLine();
        }
        if (!p.isAlive()) {
            System.out.println("You have been defeated...");
        } else if (!r.getEnemy().isAlive()) {
            System.out.println("You have defeated " + r.getEnemy().getName());
            Room.dragonsKilled++;
        }
    }


}
