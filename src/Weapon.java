public class Weapon {
    private String name;
    private int level;
    private int XP;
    private int attackPower;
    private double dodgeRate;

    public Weapon(String name, int level, int XP, int attackPower, double dodgeRate) {
        this.name = name;
        this.level = level;
        this.XP = XP;
        this.attackPower = attackPower;
        this.dodgeRate = dodgeRate;
    }

    public String getName() {
        if (level == 1) {
            name = "Wooden Sword";
        } else if (level == 2) {
            name = "Iron Sword";
        } else if (level == 3) {
            name = "Golden Sword";
        } else if (level == 4) {
            name = "Obsidian Sword";
        } else if (level == 5) {
            name = "Unbreakable Sword";
        }
        return name;
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

    public int getStrength() {
        return attackPower;
    }

    public int getLevel() {
        return level;
    }

    public double getDodgeRate() {
        return dodgeRate;
    }


}
