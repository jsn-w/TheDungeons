public class Menu {

    private String playerName;

    public Menu (String playerName) {
        this.playerName = playerName;
    }

    public static void printIntro (String playerName) {
        System.out.println("\nWelcome, " +  playerName + ". Your goal is to go through 5 rooms and kill all the dragons.");
        System.out.println("There is yourself, obviously, and there are enemies");
        System.out.println("You simply defeat all the enemies to win the game!\n");
        System.out.println("You will first fight an ogre");
    }

    public static void printOptions () {
//        System.out.print("\033\143");
        System.out.println("\nWhat would you like to do?");
        System.out.print("Options: Attack, Quit\n>> ");
    }
}