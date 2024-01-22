import java.util.Scanner;

public class DragonSlayer {
    private Player player;
    private Room room;
    private Sword sword;
    private Scanner scan;

    public DragonSlayer() {
        player = new Player();
        room = new Room();
        sword = new Sword();
        scan = new Scanner(System.in);
    }


    public void play() {
        System.out.println("Welcome to the Dragon Game!");
        boolean running = true;
        while (running) {
            System.out.println("----------------------");
            System.out.println("Main Menu");
            System.out.println("1. New Game");
            System.out.println("2. Quit");
            System.out.println("3. View Top Score");
            System.out.println("----------------------");
            System.out.print("Enter your choice (number): ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                Room room = new Room();
                while (Room.getRoomNumber() < 6) {
                    int dragonCount = (int) (Math.random() * 3) + 1;
                    System.out.println("You are currently in " + room.getRoomName());
                    System.out.println("You can upgrade your weapon if you have enough coins. It will cost " + sword.upgradeCost());
                    System.out.print("Upgrade? (Y/N) ");
                    String upgrade = scan.nextLine().toLowerCase();
                    if (upgrade.equals("y")) {
                        if (player.getGold() > sword.upgradeCost()) {
                            player.setGold(sword.upgradeCost());
                            sword.upgradeSword();
                            System.out.println("Your sword has been upgraded.");
                        } else {
                            System.out.println("You didn't have enough money.");
                        }
                    } else {
                        System.out.println("You decided to not upgrade.");
                    }
                    for (int i = 0; i < dragonCount; i++) {
                        System.out.println("There are " + (dragonCount - i) + " dragons remaining.");
                        Dragon dragon = new Dragon();
                        while (dragon.getAlive() && player.getHealth() > 0) {
                            System.out.println("----------------");
                            System.out.println(dragon.dragonInfo());
                            System.out.println("----------------");
                            System.out.println(player.getStats());
                            System.out.println("----------------");
                            System.out.println("Sword Stats ");
                            System.out.println("Sword Attack: " + sword.getAtkPower());
                            System.out.println("Sword Dodge: " + sword.getDodgeRating());
                            System.out.println("----------------");
                            System.out.println("(S)earch the room | (A)ttack the Dragon | (H)eal with Potion ");
                            System.out.print("Enter your choice: ");
                            String move = scan.nextLine().toLowerCase();
                            if (move.equals("s")) {
                                boolean search = room.searchRoom();
                                if (search) {
                                    player.addPotion();
                                }
                            } else if (move.equals("a")) {
                                dragon.takeAttack(player.attack(sword.getAtkPower()));
                            } else if (move.equals("h")) {
                                player.heal();
                            } else {
                                System.out.println("Congrats, you wasted your turn!");
                            }
                            player.takeAttack(dragon.attack());
                        } if (!dragon.getAlive()) {
                            System.out.println("You have slain a dragon!");
                            player.addGold(3);
                            player.setSlain();
                        } else {
                            player.calculateScore();
                            running = false;
                            System.out.println("Unfortunately, you died. Your final score is " + player.getScore());
                        }
                    }
                    room = new Room();
                }
                if (Room.getRoomNumber() == 6) {
                    running = false;
                    player.calculateScore();
                    System.out.println("Your score was " + player.getScore());
                    System.out.print("You won! Play again? (Y/N) ");
                    String restart = scan.nextLine();
                    if (restart.equals("y")) {
                        play();
                    }
                }
            } else if (choice == 2) {
                running = false;
                System.out.println("Goodbye!");
            } else if (choice == 3) {
                System.out.println("The top score is: " + Player.getTopScore());
            } else {
                System.out.println("Invalid Option");
            }
        }
    }
}
