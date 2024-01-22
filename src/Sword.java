public class Sword {
    private int atkPower;
    private int dodgeRating;
    private int upgrades;

    public Sword() {
        atkPower = 10;
        dodgeRating = 20;
        upgrades = 1;
    }

    public int getAtkPower() {
        return atkPower;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }

    public int upgradeCost() {
        return upgrades * 5;
    }

    public void upgradeSword() {
        atkPower += 6;
        dodgeRating += 5;
        upgrades += 1;
    }
}
