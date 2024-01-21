public class Weapon {
    private String name;
    private int level;
    private int XP;
    private final int attackPower;
    private double dodgeRate;

    public Weapon(String name, int level, int XP, int attackPower, double dodgeRate) {
        this.name = name;
        this.level = level;
        this.XP = XP;
        this.attackPower = attackPower;
        this.dodgeRate = dodgeRate;
    }

    public int getStrength() {
        return (int) ((attackPower + (Math.random() * 11 - 5)) * Math.pow(1.2, level - 1));
    }

    public int getLevel() {
        return level;
    }

    public double getDodgeRate() {
        return dodgeRate;
    }

    // states the weapon name based on it's level
    public String getPlayerWeaponName() {
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

    // currently not in use; for when the dragon attacks
    public String getEnemyWeaponName() {
        if (level == 1) {
            name = "name 1";
        } else if (level == 2) {
            name = "name 2";
        } else if (level == 3) {
            name = "name 3";
        } else if (level == 4) {
            name = "name 4";
        } else if (level == 5) {
            name = "name 5";
        }
        return name;
    }

    // adds xp to user and updates the level of the weapon
    public void addXP(int XP) {
        this.XP += XP;
        updateLevel();
    }

    // adds xp to the weapon
    public void updateLevel() {
        int XPToLevelUp = level * 100;
        if (XP >= XPToLevelUp) {
            level++;
            XP -= XPToLevelUp;
        }
    }
}
