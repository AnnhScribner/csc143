import java.awt.Color;
import java.util.ArrayList;

/**
 * The FractalSubject interface defines methods for managing and notifying observers in response to changes
 * in fractal data or settings. It is intended to be implemented by classes that generate or modify fractal
 * structures and allow observers to react to updates in the fractal state.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
interface FractalSubject {

    /**
     * Attaches a new observer to the fractal subject to receive updates
     * about changes in the fractal's state.
     *
     * @param obs the observer to be attached; must implement the FractalObserver interface
     */
    public void attach(FractalObserver obs);

    /**
     * Detaches an observer from the fractal subject, stopping it from receiving
     * updates about changes in the fractal's state.
     *
     * @param obs the observer to be detached; must be an instance implementing
     *            the FractalObserver interface
     */
    public void detach(FractalObserver obs);

    /**
     * Notifies all attached observers of a change in the fractal's state or data.
     */
    public void notifyObservers();

    /**
     * Retrieves the fractal data represented as a collection of FractalElement objects.
     *
     * @return an ArrayList of FractalElement objects representing the visual components of the fractal
     */
    public ArrayList<FractalElement> getFractalData();

    /**
     * Configures various properties of the fractal, allowing customization of its appearance
     * and structure. These options influence the way the fractal is generated, including its
     * depth, branching characteristics, and visual attributes such as angles, lengths,
     * and colors.
     *
     * @param recursionDepth     the maximum depth of recursion for the fractal generation;
     *                           determines how many levels of branches are created
     * @param childToParentRatio the ratio governing the relative size of child branches
     *                           compared to their parent branch
     * @param leftAngle          the angle at which child branches diverge to the left from
     *                           the parent branch
     * @param rightAngle         the angle at which child branches diverge to the right from
     *                           the parent branch
     * @param trunkLength        the length of the main trunk of the fractal
     * @param thunkWidth         the width of the main trunk of the fractal
     * @param trunkColor         the color of the main trunk
     * @param leaf               the color representing the leaves or endpoints of the fractal
     */
    public void setOptions(int recursionDepth, int childToParentRatio,
                           int leftAngle, int rightAngle, int trunkLength, int thunkWidth, Color trunkColor, Color leaf);

}
