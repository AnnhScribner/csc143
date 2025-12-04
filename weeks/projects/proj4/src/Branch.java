import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Represents a branch element within a fractal structure. The branch is defined
 * by its starting coordinates (x1, y1) and ending coordinates (x2, y2), along
 * with its color and thickness.
 * <p>
 * This class is immutable and implements the {@code FractalElement} interface,
 * allowing it to be rendered on a graphical interface.
 *
 * @param x1        the x-coordinate of the starting point of the branch
 * @param y1        the y-coordinate of the starting point of the branch
 * @param x2        the x-coordinate of the ending point of the branch
 * @param y2        the y-coordinate of the ending point of the branch
 * @param color     the color of the branch
 * @param thickness the thickness of the branch line
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
public record Branch(int x1, int y1, int x2, int y2, Color color, double thickness) implements FractalElement {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        Stroke s = new BasicStroke((float) thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(s);

        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(line);
    }
}
