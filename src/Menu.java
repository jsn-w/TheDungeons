public class Menu {

    private Menu () { }

    public static void printIntro (String playerName) {
        System.out.println("\nHey, " +  playerName + ".");
        Menu.delay(1000);
        System.out.println("Welcome to The Dungeon!");
        Menu.delay(1000);
        System.out.println("In this game, your goal is to go through 5 rooms and kill all the dragons in each room.");
        Menu.delay(2000);
        System.out.println("The highest score currently is " + Logic.highScore + ". Can you beat it?!");
        Menu.delay(2000);
    }

    public static void printOptions () {
        Menu.delay(1000);
        System.out.println("What would you like to do?");
        System.out.println("1. attack");
        System.out.println("2. search for potion");
        System.out.println("3. use health potion");
        System.out.print("4. quit\n>> ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}