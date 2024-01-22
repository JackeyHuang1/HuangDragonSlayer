public class Player {
    private int score;
    private static int topScore = 0;
    private int health;
    private int gold;
    private boolean hasPotion;
    private int slain;


    public Player() {
        health = 100;
        gold = 0;
        hasPotion = false;
        score = 0;
        slain = 0;
    }

    public String getStats() { // Displays the stats of the player
        String stats = "Your Stats";
        stats += "\nHealth: " + health + "/100";
        stats += "\nGold: " + gold;
        stats += "\nHas Potion: " + hasPotion;
        stats += "\nDragons slain: " + slain;
        return stats;
    }

    public int getSlain(){
        return slain;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getScore() {
        return score;
    }

    public static int getTopScore() {
        return topScore;
    }

    public void setGold(int upgradeCost) {
        gold -= upgradeCost;
    }

    public void addPotion() {
        hasPotion = true;
    }

    public void setSlain() {
        slain++;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public int attack(int atkPower) {
        return atkPower + (int) ((Math.random() * 2) + 1);
    }

    public void takeAttack(int damage) {// Calculates the damage a player takes from the dragon
        health -= damage;
        if (damage == 0) {
            System.out.println("You evaded the attack.");
        } else {
            System.out.println("You took " + damage + " damage");
        }
        if (health <= 0) {
            health = 0;
        }
    }
    public void heal() { // Uses a potion to heal
        if (hasPotion) {
            health += 50;
            hasPotion = false;
            if (health > 100) {
                health = 100;
            }
            System.out.println("You used your potion.");
        } else {
            System.out.println("You do not have a potion");
        }
    }

    public void calculateScore() {
        score += Room.getRoomNumber() * 10;
        score += gold;
        score += health;
        if (score > topScore) {
            topScore = score;
        }
    }
}
