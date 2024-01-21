public class Character {
    static int healthPot;

    private final String name;
    private int HP;
    private Weapon w;

    public Character(String name, int HP, Weapon w) {
        this.name = name;
        this.HP = HP;
        this.w = w;
    }

    public int getHP () {
        return HP;
    }

    public String getName () {
        return name;
    }

    public boolean isAlive () {
        return HP > 0;
    }

    public int getStrength() {
        return w.getStrength();
    }

    public Weapon getWeapon() {
        return w;
    }

    // prints the user's or dragon's health points
    public void printHP () {
        if (HP < 0) {
            HP = 0;
        }
        System.out.println(name + "'s HP: " + HP + "/100");
    }

    // prints damage dealt
    public void changeHP (Character c, int amount) {
        HP += amount;
        System.out.println(c.name + " deals " + (amount * -1) + " damage to " + name);
    }

    // changes health points gained
    public void changeHP (int amount) {
        HP += amount;
    }
}