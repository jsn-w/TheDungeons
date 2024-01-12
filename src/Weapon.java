public class Weapon {
    private String name;
    private int attackPower;
    private int dodgeRate;
    public Weapon(String name, int attackPower, int dodgeRate) {
        this.name = name;
        this.attackPower = attackPower;
        this.dodgeRate = dodgeRate;
    }

    public Weapon() {
        this.attackPower = 10;
        this.dodgeRate = 5;
    }

    public String getName() {
        return name;
    }


}
