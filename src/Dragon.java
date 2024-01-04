public class Dragon {
    private int level;
    private int health;
    private int atkPower;
    private boolean alive;
    private Room room;

    public Dragon() {
        level = (int) Math.ceil(room.getRoomNumber() / 2);
        alive = true;
        if (level == 1) {
            health = ;
            atkPower = ;
        } else if (level == 2) {
            health = ;
            atkPower = ;
        } else {
            health = ;
            atkPower = ;
        }
    }

    public boolean getAlive() {
        return alive;
    }

    public void attack() {

    }

    public void takeAttack(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }
}
