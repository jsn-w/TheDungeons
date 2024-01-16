import java.util.Scanner;

public class Room {
    static int dragonsKilled;
    static int totalDragons;

    private final Scanner s;
    private final boolean hasHealthPot;
    private boolean isSearched;
    private boolean isClear;
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

    public void usePotion() {
        if (Character.healthPot > 0) {
            if (p.getHP() == 100) {
                System.out.println("You already have max health!");
            } else {
                int hpGained = (100 - p.getHP()) / 2;
                p.changeHP(hpGained);
                Character.healthPot--;
                System.out.println("You have successfully used the health potion and gained " + hpGained + "HP");
            }
        } else {
            System.out.println("You do not have any health potions.");
        }
    }

    public Character getEnemy() {
        return e;
    }
}
