public class Room {
    private static int roomNumber = 0;
    private boolean searched;
    private String roomName;
    private int dragonCount;

    public Room() {
        searched = false;
        roomNumber++;
        generateName();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void searchRoom() {
        searched = true;

    }

    private void generateName() {
        if (roomNumber == 1) {
            roomName = "";
        } else if (roomNumber == 2) {
            roomName = "";
        } else if (roomNumber == 3) {
            roomName = "";
        } else if (roomNumber == 4) {
            roomName = "";
        } else {
            roomName = "";
        }
    }
}
