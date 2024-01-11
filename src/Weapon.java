public class Weapon {
    private int attackPower;
    private int dodgeRate;
    public Weapon(int attackPower, int dodgeRate) {
        this.attackPower = attackPower;
        this.dodgeRate = dodgeRate;
    }

    public Weapon() {
        this.attackPower = 10;
        this.dodgeRate = 5;
    }
}
