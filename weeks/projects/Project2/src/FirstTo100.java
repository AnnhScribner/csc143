/**
 * @author Anna Scribner
 * @version May 4, 2025
 * <p>
 * The FirstTo100 class represents a simple dice game in which players
 * take turns rolling two dices to accumulate a total score. The first
 * player to reach or exceed a total score of 100 is declared the winner.
 */

import java.util.Iterator;
import java.util.Random;

public class FirstTo100 {

    public static void main(String[] args) {
        Random dice = new Random();

        CircularLinkedList<Player> players = new CircularLinkedList<>(new Player("Anna"),
                new Player("Bruno"), new Player("Rocne"), new Player("Rose"));

        Iterator<Player> iterator = players.iterator();
        int num = dice.nextInt(players.size());
        for (int i = 0; i < num; i++){
            iterator.next();
        }
        Player firstPlayer = null;

        int highest = 0;
        int totalScore = 0;
        Player player;
        System.out.println("LET THE GAME BEGIN!");
        Sound.AIRHORN.play();

        do {
            player = iterator.next();
            if (firstPlayer == null){
                firstPlayer = player;
            }

            if (player == firstPlayer) {
                System.out.println();
                System.out.println("New Round Starting");
                Sound.SHOOT_ARROW.play();
            }

            int dice1 = dice.nextInt(1, 7);
            int dice2 = dice.nextInt(1, 7);
            int sumOfDices = dice1 + dice2;

            player.addScore(sumOfDices);
            totalScore = player.getScore();

            Sound.DICE.play();
            System.out.printf("%s rolls a %d and a %d, score now totaling %d", player.getName(), dice1, dice2, totalScore);

            if (highest < totalScore) {
                highest = totalScore;
                System.out.print("...new high score!\n");
            } else {
                System.out.print("\n");
            }

        } while (totalScore <= 100);

        System.out.printf("\nThe winner is %s with a score of %d!", player.getName(), totalScore);
        Sound.TADA.play();
    }

}
