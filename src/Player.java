class Player {
    private final String name;
    private final int totalHP;
    private int HP;
    private int speed = 5;
    private int strength;
    private int floor;
    private int level;
    private int XP;

    public Player(String name, int totalHP, int HP, int speed, int strength, int floor, int level, int XP) {
        this.name = name;
        this.totalHP = totalHP;
        this.HP = HP;
        this.speed = speed;
        this.strength = strength;
        this.floor = floor;
        this.level = level;
        this.XP = XP;
    }

    public void printLevel() {
        int XPToLevelUp = level * 100;
        if (XP >= XPToLevelUp) {
            level++;
            XP -= XPToLevelUp;
        }
        System.out.println("Level: " + level);
        System.out.println("XP: " + XP + "/" + XPToLevelUp);
    }

    public void printXP() {
        System.out.println(name + "'s XP: " + XP);
    }

    public void changeXP(int amount) {
        XP += amount;
    }

    public void printHP() {
        if (HP < 0) {
            HP = 0;
        }
        System.out.println(name + "'s HP: " + HP + "/" + totalHP);
    }

    public void changeHP(int amount, String enemyName) {
        HP += amount;
        System.out.println(enemyName + " deals " + (amount * -1) + " damage to " + name);
    }

    public void defend() {
        System.out.println(name + " defends, reducing incoming damage.");
    }

    public void updateFloor(int newfloor) {
        floor = newfloor;
    }

    public int getHP() {
        return HP;
    }

    public int getTotalHP() {
        return totalHP;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isAlive() {
        return HP > 0;
    }
}
