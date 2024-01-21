import java.util.Scanner;

public class Room {
    static int dragonsKilled;
    private int totalDragons;
    static int roomNum;

    private final boolean hasHealthPot;
    private boolean isSearched;
    private final Character[] enemyList;
    private final Character p;
    private Character dragon1;
    private Character dragon2;
    private Character dragon3;

    public Room(String name, Character p) {
        this.p = p;
        hasHealthPot = (Math.random() > 0.5);
        isSearched = false;
        dragonsKilled = 0;
        totalDragons = (int) (Math.random() * 3) + 1;
        dragon1 = createDragon();
        dragon2 = createDragon();
        dragon3 = createDragon();
        enemyList = new Character[] {dragon1, dragon2, dragon3};
        System.out.println("You have stepped into the " + name + "!");
    }

    public Character createDragon() {
        String[] dragonNames = new String[] {"Emberclaw", "Frostbite", "Shadowspike", "Thunderwing", "Blazeheart", "Frostfang", "Infernoth", "Dreadwind"};
        String randomName = dragonNames[(int)(Math.random() * dragonNames.length)];
        Weapon w = new Weapon("_DragonAttackName_", 1, 0, 10, .2);
        return new Character(randomName + " dragon", 100, w);
    }

    public void attack() {
        Character e = enemyList[0];
        for (Character c : enemyList) {
            if (c == null) {
                break;
            } else if (c.isAlive()) {
                e = c;
                break;
            }
        }
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
            dragonsKilled++;
        }
        p.printHP();
        e.printHP();
    }

    public void search() {
        if (isSearched) {
            System.out.println("This room has already been searched");
            return;
        }
        System.out.print("You searched this room and you...");
        if (hasHealthPot) {
            System.out.println("found a health potion!");
            Character.healthPot++;
        } else {
            System.out.println("found dust.");
        }
        isSearched = true;
    }


//    public void checkIsClear() {
//        for (Character dragon : enemyList) {
//            if (dragon == null) {
//                continue;
//            }
//            if (dragon.isAlive()) {
//                isClear = false;
//            }
//        }
//    }

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
        return dragon1;
    }

    public int getTotalDragons() {
        return totalDragons;
    }
}
