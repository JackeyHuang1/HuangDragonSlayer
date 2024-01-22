public class Room {
    private static int roomNumber = 0;
    private boolean searched;
    private String roomName;

    public Room() {
        searched = false;
        roomNumber++;
        generateName();
    }

    public static int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        generateName();
        return roomName;
    }

    public boolean getSearched() {
        return searched;
    }

    public boolean searchRoom() { // checks if there is a potion in the room
        boolean found = false;
        if (searched) {
            System.out.println("You have already searched the room.");
        } else {
            int chance = (int) (Math.random() * 2);
            if (chance == 1) {
                System.out.println("You found a potion!");
                found = true;
            } else {
                System.out.println("There was no potion in this room.");
            }
            searched = true;
        } return found;
    }

    private void generateName() { // gets the room name that corresponds with the number
        if (roomNumber == 1) {
            roomName = "The Den";
        } else if (roomNumber == 2) {
            roomName = "The Hatchery";
        } else if (roomNumber == 3) {
            roomName = "The Lair";
        } else if (roomNumber == 4) {
            roomName = "The Trials";
        } else {
            roomName = "The Depths";
        }
    }
}
