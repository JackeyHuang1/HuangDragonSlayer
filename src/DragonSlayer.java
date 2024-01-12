import java.util.Scanner;

public class DragonSlayer {
    private static int maxScore = 0;
    private int score;
    private Room room;
    private boolean lose;
    Scanner scan;

    public DragonSlayer() {
        scan = new Scanner(System.in);
        score = 0;
    }

    public void setLose() {
        lose = true;
    }

    public void play() {

    }
}
