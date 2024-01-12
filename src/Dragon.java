public class Dragon {
    private int level;
    private int health;
    private int atkPower;
    private boolean alive;
    private Room room;
    private Sword sword;

    public Dragon() {
        level = (int) Math.ceil(room.getRoomNumber() / 2);
        alive = true;
        if (level == 1) {
            health = 30;
            atkPower = 8 + (int) (Math.random() * room.getRoomNumber());
        } else if (level == 2) {
            health = 65;
            atkPower = 11 + (int) (Math.random() * room.getRoomNumber() * 2);
        } else {
            health = 100;
            atkPower = 15 + (int) (Math.random() * room.getRoomNumber() * 3);
        }
    }

    public boolean getAlive() {
        return alive;
    }

    public int attack() {
        int chance = (int) (Math.random() * 100) + 1;
        if (chance < sword.getDodgeRating()) {
            return 0;
        }
        return atkPower;
    }

    public void takeAttack(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }
}
