public class Dragon {
    private int level;
    private int health;
    private int atkPower;
    private boolean alive;
    private Sword sword;

    public Dragon() { // sets the stats of the dragon
        sword = new Sword();
        level = (int) Math.ceil(Room.getRoomNumber() / 2.0);
        alive = true;
        if (level == 1) {
            health = 30;
            atkPower = 5 + (int) (Math.random() * Room.getRoomNumber());
        } else if (level == 2) {
            health = 45;
            atkPower = 5 + (int) (Math.random() * Room.getRoomNumber() * 1.5);
        } else {
            health = 60;
            atkPower = 5 + (int) (Math.random() * Room.getRoomNumber() * 2);
        }
    }

    public boolean getAlive() {
        return alive;
    }

    public int attack() { // Calculates if the attack will hit or not
        int chance = (int) (Math.random() * 100) + 1;
        if (chance < sword.getDodgeRating()) {
            return 0;
        }
        return atkPower + (int) ((Math.random() * 2) + 1);
    }

    public void takeAttack(int damage) { // Deals damage to the dragon and checks if it is alive or not
        health -= damage;
        System.out.println("You dealt " + damage + " damage");
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }
    public String dragonInfo() { // Displays the dragon's stats
        String str = "Dragon Stats";
        str += "\nLevel: " + level;
        str += "\nHealth: " + health;
        str += "\n ATK Power: " + atkPower;
        return str;
    }
}
