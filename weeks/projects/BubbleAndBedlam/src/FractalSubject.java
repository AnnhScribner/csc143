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


    public void setOptions(int recursionDepth);

}
