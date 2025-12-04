import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The FractalDrawing class is responsible for visualizing fractals in a graphical user interface.
 * It acts as an observer in the observer design pattern, receiving updates about changes in the
 * fractal data from its associated FractalSubject.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
class FractalDrawing extends JFrame implements FractalObserver {

    /**
     * The subj variable represents an instance of the FractalSubject interface, which serves as the
     * subject in the observer design pattern. It is responsible for managing the state of fractals
     * and notifying associated observers about any changes.
     */
    private final FractalSubject subj;

    /**
     * Represents a collection of {@code FractalElement} objects that are used to
     * visualize a fractal structure within the graphical interface of the
     * {@code FractalDrawing} class. Each element in this list corresponds to
     * a graphical component of the fractal, such as a branch or other shape,
     * and is rendered on the drawing panel.
     */
    private ArrayList<FractalElement> fractalElements;

    /**
     * The {@code drawArea} field represents the graphical panel used to render fractal structures.
     * This panel serves as the main drawing area where fractal elements, such as branches, are
     * visualized. It is an instance of {@code JPanel}, customized to support rendering operations
     * and real-time updates as fractal data changes.
     */
    JPanel drawArea;

    /**
     * Constructs a new {@code FractalDrawing} object, which sets up a graphical interface
     * to visualize fractal structures. Acts as an observer for the provided {@code FractalSubject}
     * and renders updated fractal data when notified.
     *
     * @param subj the {@code FractalSubject} instance that this {@code FractalDrawing} observes;
     *             must not be {@code null}
     *
     * @throws IllegalArgumentException if the provided {@code subj} is {@code null}
     */
    public FractalDrawing(FractalSubject subj) {
        if (subj == null) {
            throw new IllegalArgumentException("subj cannot be null");
        }
        fractalElements = new ArrayList<FractalElement>();
        this.subj = subj;
        subj.attach(this);

        setSize(700, 700);
        setLocation(450, 100);
        setTitle("Fractal Drawing Output");
        setBackground(Color.BLACK);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawArea = new DrawArea();
        getContentPane().add(drawArea);

        setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        fractalElements = subj.getFractalData();
        drawArea.repaint();
    }

    /**
     * Represents a custom drawing area within the {@code FractalDrawing} class, used
     * to render fractal elements on a graphical interface. This class extends
     * {@code JPanel} to provide a dedicated surface for drawing the components
     * of a fractal structure.
     */
    private class DrawArea extends JPanel {

        /**
         * Constructs a new {@code DrawArea} object, which provides a custom drawing surface
         * for rendering fractal elements within the application. This constructor initializes
         * the panel and prepares it for graphical operations.
         */
        public DrawArea(){
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);
            for (FractalElement fractalElement : fractalElements) {
                fractalElement.draw(g);
            }
        }
    }
}




