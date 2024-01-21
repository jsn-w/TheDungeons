public class Menu {

    private Menu () { }

    public static void printIntro (String playerName) {
        System.out.println("\nWelcome, " +  playerName + ".");
        System.out.println("The highest score currently is " + Logic.highScore + ". Can you beat it?!");
        System.out.println("In this game, your goal is to go through 5 rooms and kill all the dragons.");
        System.out.println("ALl the dragons ");
    }

    public static void printOptions () {
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