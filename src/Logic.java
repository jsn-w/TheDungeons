import java.util.Scanner;

public class Logic {
    static int highScore = 0;

    private final Scanner s;
    private final String playerName;
    private Weapon playerWeapon;
    private Character p;
    private Room r;

    public Logic() {
        Character.healthPot = 0;
        s = new Scanner(System.in);
        System.out.println("Welcome to the realm of Ashyn!");
        System.out.print("What do you call yourself?\n>> ");
        playerName = s.nextLine();

        createCharacters();
        startRoom("Sun Temple");
        startRoom("Overflow");
        startRoom("Liquid Breakout");
        startRoom("Ignis Peaks");
        startRoom("Agitato");
        gameEnding();
    }

    // starting a room if the player is alive
    private void startRoom(String name) {
        if (p.isAlive()) {
            r = new Room(name, p);
        }
        while (p.isAlive() && Room.dragonsKilled < r.getTotalDragons()) {
            combat();
        }
    }

    // creates the player character
    private void createCharacters() {
        // Create player instances
        playerWeapon = new Weapon("Wooden Sword", 1, 0, 20, .2);
        p = new Character(playerName, 100, playerWeapon);
        Menu.printIntro(playerName);
    }

    private void combat() {
        while (p.isAlive() && r.getEnemy().isAlive()) {
            System.out.println("Current weapon: " + p.getWeapon().getPlayerWeaponName() + ", level " + p.getWeapon().getLevel());
            Menu.printOptions();
            String option = s.nextLine();
            while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4"))) {
                System.out.print("Enter a valid option\n>> ");
                option = s.nextLine();
            }
            switch (option) {
                case "1" -> r.attack();
                case "2" -> r.search();
                case "3" -> r.usePotion();
                default -> {
                }
            }
            Menu.delay(1000);
            System.out.print("Press [Enter] to continue >> ");
            Menu.clearScreen();
            s.nextLine();
        }
        if (!p.isAlive()) {
            System.out.println("You have been defeated...");
        } else if (!r.getEnemy().isAlive()) {
            Room.dragonsKilled++;
            playerWeapon.addXP(100);
        }
    }

    private void gameEnding() {
        int finalScore = p.getHP() / 5 + Character.healthPot * 2 + Room.roomNum * 5;
        System.out.println("You have gotten a grand total of " + finalScore + " points!");
        if (finalScore > highScore) {
            highScore = finalScore;
            System.out.println("Congrats! You have beaten the high score!");
        }
        System.out.println("\nWould you like to play again?");
        if (s.nextLine().equals("y")) {
            new Logic();
        }
    }
}
