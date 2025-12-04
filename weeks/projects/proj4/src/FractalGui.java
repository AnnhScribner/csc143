import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Random;

/**
 * The FractalGui class provides a graphical user interface (GUI) for configuring
 * and visualizing fractal settings. It allows users to adjust parameters such as
 * recursion depth, child-to-parent ratio, angles, trunk dimensions, and colors of
 * the fractal design.
 * <p>
 * This class extends JFrame and acts as a primary entry point for GUI interaction,
 * offering sliders for parameter manipulation, buttons for randomizing settings,
 * and options to customize colors for the trunk and leaves.
 *
 * @author Anna Scribner
 * @version May 31, 2025
 */
public class FractalGui extends JFrame {
    /**
     * The horizontal position of the sliders in the graphical user interface.
     */
    static final int X_POSITION_SLIDERS = 30;
    /**
     * Defines the horizontal position (x-coordinate) for the labels of sliders
     */
    static final int X_POSITION_LABELS = 70;
    /**
     * Represents the vertical starting position (Y-coordinate) for the first slider
     */
    static final int Y_FIRST_SLIDER = 45;
    /**
     * Represents the width of a slider component in the graphical user interface.
     */
    static final int SLIDER_WIDTH = 240;
    /**
     * Represents the height of sliders used in the graphical user interface.
     */
    static final int SLIDER_HEIGHT = 75;
    /**
     * Represents the fixed width for buttons in the GUI of the fractal generation application.
     */
    static final int BUTTON_WIDTH = 100;
    /**
     * Represents the height of a button used in the graphical user interface of the
     * FractalGui class.
     */
    static final int BUTTON_HEIGHT = 30;

    /**
     * A slider component that allows the user to adjust the recursion depth
     * for the fractal generation. This slider is part of the GUI and is used
     * to control the depth of the fractal tree.
     * <p>
     * The recursion depth determines how many levels the fractal generator
     * will iterate, impacting both the complexity and rendering time of the
     * fractal.
     * <p>
     * This slider is initialized and displayed as part of the GUI layout in
     * the {@code createAndDisplaySlider} method, where it is configured with
     * major and minor tick spacings and added to the appropriate panel.
     */
    private final JSlider sliderDepth;
    /**
     * A slider component used to adjust the proportion between child branches
     * and the parent branch
     */
    private final JSlider sliderChildToParentRatio;
    /**
     * Represents a slider used to control the angle of the left child branch in the fractal tree.
     * This slider adjusts the degree by which the left child branch deviates from the trunk or parent branch.
     * It allows the user to modify the visual structure of the fractal by changing this parameter.
     */
    private final JSlider leftChildAngle;
    /**
     * A slider component used to control the angle of the right child branches in the fractal tree generation.
     * This variable represents a GUI element that allows users to dynamically adjust the right angle
     * parameter of the fractal generation algorithm, affecting the structure of the tree.
     */
    private final JSlider rightChildAngle;
    /**
     * Slider component that allows the user to adjust the length of the main trunk in the fractal
     */
    private final JSlider trunkLength;
    /**
     * JSlider component to control the width of the trunk in the fractal generation.
     */
    private final JSlider trunkWidth;
    /**
     * Represents the color of the leaves in the fractal tree visualization.
     */
    private Color leafColor;
    /**
     * Represents the color of the trunk in the fractal drawing.
     */
    private Color trunckColor;

    /**
     * Represents the fractal subject that this GUI interacts with to define and render fractal data.
     */
    private final FractalSubject subj;

    /**
     * Creates and initializes the FractalGui window, which allows users to adjust
     * various settings for fractal generation. The GUI includes sliders for
     * controlling recursion depth, child-to-parent ratio, left and right child angles,
     * trunk length, and trunk width. Additionally, it provides buttons for
     * customizing trunk and leaf colors, as well as a randomization option.
     *
     * @param fractalSubject the subject that the GUI observes and interacts with
     *                       to set fractal generation options.
     */
    public FractalGui(FractalSubject fractalSubject) {
        leafColor = Color.GREEN;
        trunckColor = new Color(139, 69, 19); // brown color
        subj = fractalSubject;

        setSize(300, 700);
        setLocation(100, 100);
        setTitle("Fractal Settings");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(null);
        getContentPane().add(mainPanel);

        sliderDepth = new JSlider(4, 20);
        createAndDisplaySlider("Recursion Depth", 2, 1,
                sliderDepth, mainPanel, 0);
        sliderChildToParentRatio = new JSlider(40, 80);
        createAndDisplaySlider("Child to Parent Ratio", 10, 5,
                sliderChildToParentRatio, mainPanel, 1);
        leftChildAngle = new JSlider(0, 90);
        createAndDisplaySlider("Left Child Angle", 10, 5,
                leftChildAngle, mainPanel, 2);
        rightChildAngle = new JSlider(0, 90);
        createAndDisplaySlider("Right Child Angle", 10, 5,
                rightChildAngle, mainPanel, 3);
        trunkLength = new JSlider(100, 400);
        createAndDisplaySlider("Trunk Length", 100, 25,
                trunkLength, mainPanel, 4);
        trunkWidth = new JSlider(10, 50);
        createAndDisplaySlider("Trunk Width", 10, 5,
                trunkWidth, mainPanel, 5);

        new SliderListener(sliderDepth, sliderChildToParentRatio, leftChildAngle,
                rightChildAngle, trunkLength, trunkWidth);
        setOptions();

        JButton trunkColorButton = new JButton("Trunk Color");
        trunkColorButton.addActionListener(e -> {
            Color savePreviusColor = trunckColor;
            trunckColor = JColorChooser.showDialog(trunkColorButton, "Choose a Color", trunckColor);
            if (trunckColor == null) {
                trunckColor = savePreviusColor;
            }
            setOptions();
        });
        JButton leafColorButton = new JButton("Leaf Color");
        leafColorButton.addActionListener(e -> {
            Color savePreviusColor = leafColor;
            leafColor = JColorChooser.showDialog(leafColorButton, "Choose a Color", leafColor);
            if (leafColor == null) {
                leafColor = savePreviusColor;
            }
            setOptions();
        });

        JButton randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(e -> {
            randomize(sliderDepth, sliderChildToParentRatio, leftChildAngle,
                    rightChildAngle, trunkLength, trunkWidth);
            setOptions();
        });

        createAndDisplayButton(trunkColorButton, mainPanel, 1);
        createAndDisplayButton(leafColorButton, mainPanel, 2);
        createAndDisplayButton(randomizeButton, mainPanel, 3);

        setVisible(true);
    }

    /**
     * Calculates the vertical starting position for a slider based on the order of the slider.
     * This method ensures proper spacing between multiple sliders in the GUI layout.
     *
     * @param order the placement order of the slider, where 0 represents the first slider.
     *
     * @return the calculated y-coordinate for the slider's position.
     */
    private int yPositionSlider(int order) {
        return Y_FIRST_SLIDER + (SLIDER_HEIGHT * order);
    }

    /**
     * Calculates the vertical position of a button based on its order in the GUI layout.
     * The position is determined relative to the slider positions and ensures consistent
     * spacing between components.
     *
     * @param order the placement order of the button, where 0 represents the first button.
     *
     * @return the calculated y-coordinate for the button's position.
     */
    private int yPositionButton(int order) {
        return yPositionSlider(6) + (BUTTON_HEIGHT * order);
    }

    /**
     * Creates a button, sets its bounds within the panel based on its order,
     * and adds it to the specified panel for display in the GUI.
     *
     * @param button the JButton instance to be created and displayed
     * @param panel  the JPanel to which the button is added
     * @param order  the placement order of the button, determining its vertical position
     */
    private void createAndDisplayButton(JButton button, JPanel panel, int order) {
        button.setBounds(X_POSITION_SLIDERS, yPositionButton(order), BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(button);
    }

    /**
     * Creates and displays a slider within the specified panel. The slider is customized with the provided
     * label, major and minor tick spacing, and its position is determined based on the order parameter.
     * The slider is displayed alongside a label describing its purpose.
     *
     * @param sliderLabel  the text to display as the label for the slider
     * @param majorSpacing the spacing between major tick marks on the slider
     * @param minorSpacing the spacing between minor tick marks on the slider
     * @param slider       the JSlider instance to be customized and displayed
     * @param panel        the JPanel to which the slider and its label are added
     * @param order        the vertical placement order of the slider, where 0 represents the first slider
     */
    private void createAndDisplaySlider(String sliderLabel, int majorSpacing, int minorSpacing,
                                        JSlider slider, JPanel panel, int order) {
        JLabel label = new JLabel(sliderLabel);
        label.setBounds(X_POSITION_LABELS, yPositionSlider(order) - 5, SLIDER_WIDTH, 20);
        panel.add(label);

        slider.setMajorTickSpacing(majorSpacing);
        slider.setMinorTickSpacing(minorSpacing);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setAlignmentX(Component.CENTER_ALIGNMENT);

        slider.setBounds(X_POSITION_SLIDERS, yPositionSlider(order), SLIDER_WIDTH, SLIDER_HEIGHT);
        panel.add(slider);
    }

    /**
     * Sets the fractal generation options on the observed fractal subject using the
     * current values of the sliders and color properties defined in the GUI.
     */
    private void setOptions() {
        subj.setOptions(sliderDepth.getValue(), sliderChildToParentRatio.getValue(),
                leftChildAngle.getValue(), rightChildAngle.getValue(), trunkLength.getValue(),
                trunkWidth.getValue(), trunckColor, leafColor);
    }

    /**
     * Randomizes the values of the provided JSlider instances and assigns random colors
     * for the fractal's trunk and leaves. Each slider is set to a random value within
     * its defined minimum and maximum range. The trunk and leaf colors are randomized
     * using RGB values within the 0-255 range.
     *
     * @param sliders the variable-length array of JSlider instances whose values are to be randomized
     */
    private void randomize(JSlider... sliders) {
        Random random = new Random();
        for (JSlider slider : sliders) {
            int randomSlider = random.nextInt(slider.getMinimum(), slider.getMaximum());
            slider.setValue(randomSlider);
        }
        int redRandom = random.nextInt(256);
        int greenRandom = random.nextInt(256);
        int blueRandom = random.nextInt(256);
        trunckColor = new Color(redRandom, greenRandom, blueRandom);

        redRandom = random.nextInt(256);
        greenRandom = random.nextInt(256);
        blueRandom = random.nextInt(256);
        leafColor = new Color(redRandom, greenRandom, blueRandom);
    }

    /**
     * A private inner class for listening to changes in JSlider components.
     * The SliderListener class implements the ChangeListener interface and updates
     * the UI or related settings whenever one of the associated sliders is adjusted.
     * The sliders are dynamically specified during the construction of an instance
     * of this class.
     */
    private class SliderListener implements ChangeListener {
        /**
         * Constructs a SliderListener to listen for changes to the specified JSlider components.
         * The listener is automatically added as a ChangeListener to each provided slider.
         * This allows the implementing class to react to changes in the sliders dynamically.
         *
         * @param sliders the JSlider components to be listened to. Must not be null.
         *                A ChangeListener will be registered to each slider in this array.
         *
         * @throws IllegalArgumentException if the sliders array is null.
         */
        public SliderListener(JSlider... sliders) {
            if (sliders == null) {
                throw new IllegalArgumentException("sliders cannot be null");
            }
            for (JSlider slider : sliders) {
                slider.addChangeListener(this);
            }
        }

        /**
         * Handles changes in the state of a JSlider component and triggers an update
         * of fractal generation options based on the current values of the sliders.
         *
         * @param e the event object containing information about the state change
         *          in the JSlider that triggered this method. Must not be null.
         */
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            setOptions();
        }
    }
}