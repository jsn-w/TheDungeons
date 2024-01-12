public class Character {
    private final String name;
    private int HP;
    private int speed = 5;
    private int strength;
    private int level;
    private int XP;
    private Weapon w;
    public static String[][] inventory;

    public Character(String name, int HP, int speed, int strength, int level, int XP, Weapon w) {
        this.name = name;
        this.HP = HP;
        this.speed = speed;
        this.strength = strength;
        this.level = level;
        this.XP = XP;
        inventory = new String[][]{
                {"Coins", "2"},
                {"Health Potion", "0"}
        };
    }

    public void printHP () {
        if (HP < 0) {
            HP = 0;
        }
        System.out.println(name + "'s HP: " + HP + "/100");
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

    public void changeHP (int amount, String playerName) {
        HP += amount;
        System.out.println(playerName + " deals " + (amount * -1) + " damage to " + name);
    }

    public int getHP () {
        return HP;
    }

    public String getName () {
        return name;
    }

    public int getSpeed () {
        return speed;
    }

    public int getStrength () {
        return strength;
    }

    public boolean isAlive () {
        return HP > 0;
    }
}