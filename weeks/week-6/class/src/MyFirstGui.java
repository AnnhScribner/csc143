import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// JPanel we can draw graphics on it
// We don't want to work directly with JFrame, instead we will create JPanel as middle level

public class MyFirstGui extends JFrame {

    public static void main(String[] args) {
        new MyFirstGui();
    }

    public MyFirstGui() {

        // We don't need to do this.methodName() because it is implicit.

        // Frame stuff -> what???
        setSize(300, 200);
        setLocation(200, 200); // investigate Toolkit
        setTitle("My First GUI");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // I can nest JPanel and add more things in it -> have a JPanel in a JPanel
        JPanel mainPanel = new JPanel(null); // instantiate JPanel -> adding null
        // for the layout, it means I am  not going to have all the help that
        // JPanel can provide. It is good for now because I need to learn too much
        // stuff to understand how to use the layout manager
        getContentPane().add(mainPanel);
//        mainPanel.setBackground(Color.PINK);

        JButton sayHello = new JButton("Hello"); // make what i want
        sayHello.setBounds(25, 25, 80, 30); // set the bounds
        mainPanel.add(sayHello); // throw on the panel

        JButton clear = new JButton("Clear"); // make what i want
        clear.setBounds(125, 25, 80, 30); // set the bounds
        mainPanel.add(clear); // throw it on the panel

        JTextField output = new JTextField(); // make what i want
        output.setBounds(25, 75, 175, 30); // set bounds
        mainPanel.add(output); // throw it on the panel

//        sayHello.addActionListener(new HelloListener()); // I can create a private class to use
        // addActionListener().




        // my JPanel in the previous JPanel that now I can draw on
        DrawArea drawArea = new DrawArea();
        drawArea.setBounds(225, 85, 50, 50);
        drawArea.setBackground(Color.WHITE);
        mainPanel.add(drawArea);




        // creating a private inner class
        sayHello.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("Hello world!");
                drawArea.wantCircle = true;
                drawArea.repaint(); // pretty please, can you call paintComponent?
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                drawArea.wantCircle = false;
                drawArea.repaint(); // pretty please, can you call paintComponent?
            }
        });


        setVisible(true); // make it visible for last
    }

    // we need to create our own class to make it easy to use Jpanel to draw
    private class DrawArea extends JPanel {
        // varriable to decide when i want to use my red circle
        public boolean wantCircle = false;

        // control + O -> to find what I can override
        @Override
        protected void paintComponent(Graphics g) { // all drawing must originate in this method
            super.paintComponent(g); // it already clears the area to start fresh every time

            // If we don't interfere, the drawing in paintComponent method in DrawArea class
            // will be drawn automatically. So I need to create an if statement to decide when
            // to draw
            if (wantCircle) {
                g.setColor(Color.RED);
                g.fillOval(0, 0, 50, 50);
            } else {
                // I don't need to do anything in the else because I already have
                // the call of the method `super.paintComponent(g);`
                // in the beginning of the method.
            }
        }
    }


    // Private class to use addActionListener() in the constructor
//    private class HelloListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e){
//
//        }
}


