import java.util.Scanner;

public class Room {
    private final Scanner s;
    private final boolean hasHealthPot;
    private boolean isSearched;
    private boolean isClear;
    private int dragonsKilled;
    private int totalDragons;
    private final Character[] enemyList;
    private final Character p;
    private Character e;
    private Character dragon2;
    private Character dragon3;

    public Room(String name, Character p) {
        this.p = p;
        isClear = false;
        s = new Scanner(System.in);
        hasHealthPot = (Math.random() > 0.5);
        isSearched = false;
        totalDragons = (int) (Math.random() * 3) + 1;
        e = createDragon();
        dragon2 = createDragon();
        dragon3 = createDragon();
        enemyList = new Character[] {e, dragon2, dragon3};
        System.out.println("You have stepped into the " + name + "!");
    }

    public Character createDragon() {
        String[] dragonNames = new String[] {"Emberclaw", "Frostbite", "Shadowspike", "Thunderwing", "Blazeheart", "Frostfang", "Infernoth", "Dreadwind"};
        String randomName = dragonNames[(int)(Math.random() * dragonNames.length)];
        Weapon w1 = new Weapon("_DragonAttackName_", 1, 0, 5, .2);
        return new Character(randomName + " dragon", 100, w1);
    }

    public void combat() {
        while (p.isAlive() && e.isAlive()) {
            System.out.println("Current weapon: " + p.getWeapon().getName() + ", level " + p.getWeapon().getLevel());
            Menu.printOptions();
            String option = s.nextLine();
            while (!(option.equals("1") || option.equals("2") || option.equals("3"))) {
                System.out.print("Enter a valid option >> ");
                option = s.nextLine();
            }
            if (option.equals("1")) {
                attack();
            } else if (option.equals("2")){
                search();
            } else {
                break;
            }
            System.out.print("Press [Enter] to continue >> ");
            s.nextLine();
        }
        if (!p.isAlive()) {
            System.out.println("You have been defeated...");
        } else if (!e.isAlive()) {
            System.out.println("You have defeated " + e.getName());
        }
    }

    public void attack() {
        if (e.getWeapon().getDodgeRate() < Math.random()) {
            e.changeHP(p, p.getStrength() * -1);
        } else {
            System.out.println("The dragon dodged your attack!");
        }

        // Check if the enemy is still alive
        if (e.isAlive()) {
            if (p.getWeapon().getDodgeRate() < Math.random()) {
                p.changeHP(e, e.getStrength() * -1);
            } else {
                System.out.println("You have dodged the dragon's attack!");
            }
        } else {
            System.out.println(e.getName() + " has been defeated!");
        }
        p.printHP();
        e.printHP();
    }

    public void search() {
        if (isSearched) {
            System.out.println("This room has already been searched");
            return;
        }
        if (hasHealthPot) {
            System.out.println("You have found a health potion!");
            Character.healthPot++;
        } else {
            System.out.println("You found dust.");
        }
        isSearched = true;
    }

    public void checkIsClear() {
        for (Character dragon : enemyList) {
            if (dragon == null) {
                continue;
            }
            if (dragon.isAlive()) {
                isClear = false;
            }
        }
    }
}
