public class Menu {

    private String playerName;

    public Menu (String playerName) {
        this.playerName = playerName;
    }

    public static void printIntro (String playerName) {
        System.out.println("\nWelcome, " +  playerName + ".");
        System.out.println("Your goal is to go through 5 rooms and kill all the dragons.");
    }

    public static void printOptions () {
//        System.out.print("\033\143");
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. attack");
        System.out.println("2. search for potion");
        System.out.print("3. quit\n>> ");
    }
}