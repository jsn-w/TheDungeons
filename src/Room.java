public class Room {
    private static int roomNum;
    private boolean hasHealthPot;
    private boolean isSearched;
    private boolean isClear;
    private String name;
    private int dragonsKilled;
    private int totalDragons;

    public Room(String name, boolean isClear, int dragonsKilled, int totalDragons) {
        this.name = name;
        this.isClear = isClear;
        this.dragonsKilled = dragonsKilled;
        this.totalDragons = totalDragons;

        hasHealthPot = (Math.random() > 0.5);
        isSearched = false;
    }

    public void search() {
        if (isSearched) {
            System.out.println("This room has already been searched");
            return;
        }
        for (int i = 0; i < Character.inventory[i].length; i++) {
            if (Character.inventory[i][0].equals("Health Potion")) {
                Character.inventory[i][1] += 1;
            }
        }
        isSearched = true;
    }
}
