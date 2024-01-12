public class Room {
    private static int roomNumber = 0;
    private boolean searched;
    private String roomName;
    private int dragonCount;
    private Player player;

    public Room() {
        searched = false;
        roomNumber++;
        generateName();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void searchRoom() {
        if (!searched) {
            int chance = (int) (Math.random() * 2);
            if (chance == 1) {
                player.addPotion();
            } searched = true;
        }
    }

    private void generateName() {
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
