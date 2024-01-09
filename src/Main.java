import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int currency = 0;
        int floor = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the world!");
        System.out.print("What do you call yourself?\n>> ");
        String playerName = scan.nextLine();
        Menu menu = new Menu(playerName);
        menu.printIntro();

        // Create player and enemy instances
        Player p = new Player(playerName, 100, 100, 10, 20, floor, 1, 0);
        Enemy e = new Enemy("Ogre", 50, 50, 10, 10, floor);

        p.printHP();
        e.printHP();

        // Combat loop
        while (p.isAlive() && e.isAlive()) {
            System.out.print("Press [Enter] to continue >> ");
            scan.nextLine();
            menu.printOptions();
            String option = scan.nextLine();

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
            } else if (option.equalsIgnoreCase("defend")) {
                p.defend();
                e.changeHP((int)(e.getStrength() * -0.5), e.getName());
                p.printHP();
                e.printHP();
            }

        }

        if (!p.isAlive()) {
            System.out.println("You have been defeated...");
        } else {
            System.out.println("You have defeated " + e.getName());
        }
    }
}
