import java.awt.Graphics;

/**
 * Represents a graphical element within a fractal structure that can be rendered
 * on a graphical interface.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
interface FractalElement {

    /**
     * Draws the current fractal element using the provided {@code Graphics} object.
     *
     * @param g the {@code Graphics} context in which to render the fractal element.
     */
    public void draw(Graphics g);
}
