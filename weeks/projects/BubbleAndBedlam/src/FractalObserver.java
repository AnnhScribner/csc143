/**
 * The {@code FractalObserver} interface represents the observer in the
 * observer design pattern, specifically for fractal visualization systems.
 * Classes implementing this interface are notified when the fractal
 * data in the subject changes, allowing them to update accordingly.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
public interface FractalObserver {

    /**
     * Notifies the observer that the subject's fractal data has changed.
     * Implementers of this method should update their state or view
     * to reflect the latest changes in the fractal data.
     */
    public void update();
}
