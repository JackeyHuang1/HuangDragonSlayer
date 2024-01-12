public class Player {
    private int health;
    private Sword sword;
    private int gold;
    private boolean hasPotion;
    private Dragon dragon;
    private DragonSlayer slayer;

    public Player() {
        health = 100;
        gold = 0;
        hasPotion = false;
    }

    public int getHealth() {
        return health;
    }

    public boolean checkHasPotion() {
        return hasPotion;
    }

    public void addPotion() {
        hasPotion = true;
    }

    public void attack() {
        dragon.takeAttack(sword.getAtkPower());
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void takeAttack() {
        int damage = dragon.attack();
        health -= damage;
        if (health <= 0) {
            health = 0;
            slayer.setLose();
        }
    }
    public String heal() {
        if (hasPotion) {
            health += 50;
            hasPotion = false;
            if (health > 100) {
                health = 100;
            }
            return "You used your potion.";
        } else {
            return "You do not have a potion";
        }
    }
}
