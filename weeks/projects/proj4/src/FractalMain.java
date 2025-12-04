/**
 * Entry point for the application that initializes and connects the main parts
 * responsible for generating, displaying, and interacting with fractal visualizations.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
public class FractalMain {
    /**
     * The main method serves as the entry point for the application. It initializes
     * the primary components responsible for fractal generation, drawing, and user interaction.
     *
     * @param args an array of command-line arguments passed to the program;
     *             can be used for specifying configuration or runtime options
     */
    public static void main(String[] args) {
        FractalSubject fractalSubject = new FractalGenerator();
        FractalDrawing fracDrawing = new FractalDrawing(fractalSubject);
        FractalGui fractalGui = new FractalGui(fractalSubject);
    }

    /**
     * Private constructor to prevent the instantiation of the {@code FractalMain} class.
     *
     * This class is designed to serve as the entry point for the fractal visualization
     * application, and all operations are controlled through its static methods.
     */
    private FractalMain(){
    }
}


