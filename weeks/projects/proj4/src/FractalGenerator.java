import java.awt.*;
import java.util.ArrayList;

/**
 * The FractalGenerator class is responsible for generating fractal tree structures and notifying
 * its observers whenever the fractal data or configuration options are updated. It implements the
 * FractalSubject interface allowing observers to register and receive updates about changes. Fractal
 * trees are generated using recursive calculations based on specified parameters.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
class FractalGenerator implements FractalSubject {
    /**
     * Represents the maximum depth of recursion for generating the fractal structure.
     */
    int recursionDepth;
    /**
     * Represents the ratio between the length of a child branch and its parent branch
     * in the fractal tree generation process.
     */
    int childToParentRatio;
    /**
     * The angle in degrees used to determine the leftward branching direction
     * when generating the fractal structure.
     */
    int leftAngle;
    /**
     * The right angle, in degrees, at which child branches diverge from the trunk or parent branch
     * during fractal generation.
     */
    int rightAngle;
    /**
     * Represents the length of the trunk in the fractal tree structure.
     */
    int trunkLength;
    /**
     * Represents the width of the trunk (or primary branch) in the generated fractal tree structure.
     */
    int thunkWidth;
    /**
     * Represents the color of the trunk for the fractal tree being generated.
     */
    Color trunkColor;
    /**
     * Represents the color of the leaves drawn in the fractal representation.
     */
    Color leafColor;

    /**
     * A list of observers that are registered to monitor changes in the fractal generator.
     */
    private final ArrayList<FractalObserver> observers;
    /**
     * A collection of FractalElement instances representing the data structure used
     * to store the elements of the fractal being generated. Each FractalElement in
     * this list corresponds to a graphical component, such as a branch, which is
     * rendered as part of the fractal.
     */
    private final ArrayList<FractalElement> fractalData;

    /**
     * Constructs a new instance of the FractalGenerator class.
     * This constructor initializes the necessary structures for storing
     * observers and fractal data. The class is used for generating and
     * managing fractal structures and notifying observers of changes in
     * its fractal data.
     */
    public FractalGenerator() {
        observers = new ArrayList<>();
        fractalData = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attach(FractalObserver obs) {
        if (obs == null) {
            throw new IllegalArgumentException("obs cannot be null");
        }
        observers.add(obs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void detach(FractalObserver obs) {
        observers.remove(obs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {
        for (FractalObserver obs : observers) {
            obs.update();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<FractalElement> getFractalData() {
        fractalData.clear();
        generateTree(fractalData, 0, 350, 700, 90, trunkLength, thunkWidth);
        return fractalData;
    }

    /**
     * Recursively generates a tree structure of branches, represented as fractal elements,
     * and adds them to the provided list. Each branch is defined by its start and end points,
     * color, thickness, and recursively calculated child branches.
     *
     * @param arr                   The list of FractalElement objects where generated branches are added.
     * @param recursionDepthCurrent The current depth of recursion during the tree generation process.
     * @param x1                    The starting x-coordinate of the current branch.
     * @param y1                    The starting y-coordinate of the current branch.
     * @param startAngle            The angle at which the current branch is oriented.
     * @param trunkLenghCurrent     The length of the current branch being generated.
     * @param trunkWidthCurrent     The thickness (width) of the current branch being generated.
     */
    private void generateTree(ArrayList<FractalElement> arr, int recursionDepthCurrent, int x1,
                              int y1, double startAngle, int trunkLenghCurrent, int trunkWidthCurrent) {

        int x2 = (int) (trunkLenghCurrent * Math.cos(Math.toRadians(startAngle)) + x1);
        int y2 = (int) (y1 - trunkLenghCurrent * Math.sin(Math.toRadians(startAngle)));

        Color treeColor = lerpColor(leafColor, trunkColor, (double) recursionDepthCurrent / recursionDepth);

        if (recursionDepth > recursionDepthCurrent) {
            Branch branch = new Branch(x1, y1, x2, y2, treeColor, trunkWidthCurrent);
            arr.add(branch);
            generateTree(arr, recursionDepthCurrent + 1, x2, y2,
                    startAngle - rightAngle,
                    (int) (trunkLenghCurrent * (childToParentRatio / 100.0)),
                    (int) (trunkWidthCurrent * (childToParentRatio / 100.0))); // right
            generateTree(arr, recursionDepthCurrent + 1, x2, y2,
                    startAngle + leftAngle,
                    (int) (trunkLenghCurrent * (childToParentRatio / 100.0)),
                    (int) (trunkWidthCurrent * (childToParentRatio / 100.0))); // left
        }
    }

    /**
     * Interpolates between two colors based on the given progress value.
     * The method linearly blends the RGB components of the start and end colors
     * according to the progress factor, producing a new interpolated color.
     *
     * @param end      The target color to interpolate towards.
     * @param start    The starting color to interpolate from.
     * @param progress The interpolation factor, ranging from 0.0 to 1.0, where
     *                 0.0 corresponds to the start color and 1.0 corresponds to the end color.
     *
     * @return A newly created Color object representing the interpolated color.
     */
    private Color lerpColor(Color end, Color start, double progress) {
        int redEnd = end.getRed();
        int greenEnd = end.getGreen();
        int blueEnd = end.getBlue();

        int redStart = start.getRed();
        int greenStart = start.getGreen();
        int blueStart = start.getBlue();

        int redNewColor = (int) ((redEnd - redStart) * progress + redStart);
        int greenNewColor = (int) ((greenEnd - greenStart) * progress + greenStart);
        int blueNewColor = (int) ((blueEnd - blueStart) * progress + blueStart);

        return new Color(redNewColor, greenNewColor, blueNewColor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOptions(int recursionDepth, int childToParentRatio, int leftAngle,
                           int rightAngle, int trunkLength, int thunkWidth, Color trunkColor, Color leaf) {
        this.recursionDepth = recursionDepth;
        this.childToParentRatio = childToParentRatio;
        this.leftAngle = leftAngle;
        this.rightAngle = rightAngle;
        this.trunkLength = trunkLength;
        this.thunkWidth = thunkWidth;
        this.trunkColor = trunkColor;
        this.leafColor = leaf;

        notifyObservers();
    }
}
