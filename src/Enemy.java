class Enemy {
    private String name;
    private int totalHP;
    private int HP;
    private int speed = 5;
    private int strength;
    private int floor;

    public Enemy (String name, int totalHP, int HP, int speed, int strength, int floor) {
        this.name = name;
        this.totalHP = totalHP;
        this.HP = HP;
        this.speed = speed;
        this.strength = strength;
        this.floor = floor;
    }

    public void printHP () {
        if (HP < 0) {
            HP = 0;
        }
        System.out.println(name + "'s HP: " + HP + "/" + totalHP);
    }

    public boolean isAlive () {
        return HP > 0;
    }
    public void changeHP (int amount, String playerName) {
        HP += amount;
        System.out.println(playerName + " deals " + (amount * -1) + " damage to " + name);
    }

    public int getHP () {
        return HP;
    }
    public int getTotalHP () {
        return totalHP;
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
}