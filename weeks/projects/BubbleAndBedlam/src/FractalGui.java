import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FractalGui extends JFrame {

    private final JSlider sliderDepth;
//    private final JSlider childToParentRatio;
//    private final JSlider childCount;
//    private final JSlider bedlamLevel;

    private final FractalSubject subj;

    public FractalGui(FractalSubject subj) {
        subj = fractalSubject;

        setSize(400, 600);
        setLocation(100, 100);
        setTitle("Bubbles and Bedlam Fractal Settings");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(null);
        getContentPane().add(mainPanel);

        sliderDepth = new JSlider(2, 8);
        JLabel label = new JLabel("Slider Depth");
        label.setBounds(10, 10, 380, 20);
        mainPanel.add(label);

        sliderDepth.setMajorTickSpacing(1);
        sliderDepth.setMinorTickSpacing(0);
        sliderDepth.setPaintTicks(true);
        sliderDepth.setPaintLabels(true);
        sliderDepth.setAlignmentX(Component.CENTER_ALIGNMENT);

        sliderDepth.setBounds(10, 15, 380, 20);

//        childToParentRatio = new JSlider(20, 70);
////        createAndDisplaySlider("Child to parent ratio", 10,
////                5, sliderDepth, mainPanel, 2);
//
//        childCount = new JSlider(1, 11);
////        createAndDisplaySlider("child count", 2,
////                1, sliderDepth, mainPanel, 3);
//
//        bedlamLevel = new JSlider(0, 4);
////        createAndDisplaySlider("Bedlam level", 1,
////                0, sliderDepth, mainPanel, 4);
//

        new SliderListener(sliderDepth);

        setOptions();



        setVisible(true);
    }

    private void setOptions() {
        subj.setOptions(sliderDepth.getValue());
    }


//    private void createAndDisplaySlider(String sliderLabel, int majorSpacing, int minorSpacing,
//                                        JSlider slider, JPanel panel, int order) {
//        JLabel label = new JLabel(sliderLabel);
//        label.setBounds(X_POSITION_LABELS, yPositionSlider(order) - 5, SLIDER_WIDTH, 20);
//        panel.add(label);
//
//        slider.setMajorTickSpacing(majorSpacing);
//        slider.setMinorTickSpacing(minorSpacing);
//        slider.setPaintTicks(true);
//        slider.setPaintLabels(true);
//        slider.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        slider.setBounds(X_POSITION_SLIDERS, yPositionSlider(order), SLIDER_WIDTH, SLIDER_HEIGHT);
//        panel.add(slider);
//    }

//    private int yPositionSlider(int order) {
//        return Y_FIRST_SLIDER + (SLIDER_HEIGHT * order);
//    }




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
                System.out.println(slider.getValue());
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
