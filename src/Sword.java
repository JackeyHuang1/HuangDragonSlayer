public class Sword {
    private int atkPower;
    private int dodgeRating;

    public Sword() {
        atkPower = 10;
        dodgeRating = 20;
    }

    public int getAtkPower() {
        return atkPower;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }

    public void upgradeSword(int upgrade) {
        atkPower = upgrade;
        dodgeRating = upgrade / 2;
    }
}
