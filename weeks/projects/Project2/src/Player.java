/**
 * @author Anna Scribner
 * @version May 4, 2025
 * <p>
 * Represents a player in a game, with a name and a score.
 * <p>
 * This class allows tracking the player's name and their current score.
 * It supports getting the player's name and score, as well as adding
 * to the player's score.
 */

public class Player {
    /**
     * The name of the player.
     */
    private final String name;
    /**
     * The current score of the player in the game.
     */
    private int score;

    /**
     * Constructs a new Player with the specified name and initializes the score to 0.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        score = 0;
    }

    /**
     * Retrieves the name of the player.
     *
     * @return the player's name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the current score of the player.
     *
     * @return the player's score as an integer
     */
    public int getScore() {
        return score;
    }

    /**
     * Adds the specified score to the player's current score.
     *
     * @param score the value to be added to the player's current score
     */
    public void addScore(int score) {
        this.score += score;
    }
}
