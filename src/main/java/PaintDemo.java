import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintDemo {
    JFrame frame;
    PaintDemoDrawingPanel dPanel;

    // This is the constructor which sets up the JFrame
    // and all other components and containers
    public PaintDemo() {
        // Set up JFrame
        frame = new JFrame("Paint Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add DrawingPanel to CENTER
        dPanel = new PaintDemoDrawingPanel();
        frame.add(dPanel);

        // Set the size and set the visibility
        frame.pack();
        frame.setVisible(true);
    }

    // Main method just creates a PaintDemo object
    public static void main(String[] args) {
        PaintDemo x = new PaintDemo();
    }


}
