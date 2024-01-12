import java.util.Scanner;

public class Logic {
    int currency = 0;
    int floor = 1;
    Scanner s;

    public Logic() {
        s = new Scanner(System.in);

        System.out.println("Welcome to the realm of Ashyn!");
        System.out.print("What do you call yourself?\n>> ");
        String playerName = s.nextLine();
        Menu.printIntro(playerName);

        // Create player and enemy instances
        Weapon playerWeapon = new Weapon();
        Weapon enemyWeapon = new Weapon("Fiery Fire", 5, 10);
        Character p = new Character(playerName, 100, 100, 10, 1, 0, playerWeapon);
        Character e = new Character("Dragon", 100, 10, 5, 1, 0, enemyWeapon);
// ephixia

        p.printHP();
        e.printHP();

        // Combat loop
        while (p.isAlive() && e.isAlive()) {
            System.out.println("Current weapon: " + playerWeapon.getName());
            System.out.print("Press [Enter] to continue >> ");
            s.nextLine();
            Menu.printOptions();
            String option = s.nextLine();
            while (!(option.equals("attack") || option.equals("quit"))) {
                System.out.print("Enter a valid option >> ");
                option = s.nextLine();
            }

            if (option.equalsIgnoreCase("attack")) {
                // Player attacks first
                if (p.getSpeed() >= e.getSpeed()) {
                    e.changeHP(p.getStrength() * -1, playerName);
                }

                // Check if the enemy is still alive
                if (e.isAlive()) {
                    p.changeHP(e.getStrength() * -1, e.getName());
                } else {
                    System.out.println(e.getName() + " has been defeated!");
                }
                p.printHP();
                e.printHP();
            } else {
                break;
            }

        }

        if (!p.isAlive()) {
            System.out.println("You have been defeated...");
        } else if (!e.isAlive()) {
            System.out.println("You have defeated " + e.getName());
        }
    }

}
