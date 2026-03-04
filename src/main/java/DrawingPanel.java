import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
    // DrawingPanel has the following instance variables:

    // A 2D array which stores whether or not
    // each pixel should be painted
    // ** To be used in Part B **
    private boolean[][] isPainted;

    // A 2D array which stores the Java Colors
    // of each pixel
    // ** To be used in Part C **
    private Color[][] colors;

    // The mode is a String that we can use to keep track of
    // what should happen if the user presses the mouse
    // ** To be used in Part B **
    private String mode;

    // This keeps track of the current selected color
    // ** To be used in Part C **
    private Color color;

    // These are constant values
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    // Constructor sets up DrawingPanel
    // ** You should never need to edit this code **
    public DrawingPanel() {
        // Set background color
        setBackground(Color.WHITE);

        // Add mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);

        // Initialize instance variables
        isPainted = new boolean[WIDTH][HEIGHT];
        colors = new Color[WIDTH][HEIGHT];
        mode = "Pencil";
        color = Color.BLACK;
    }

    // Can be called to change the current mode
    // of the drawing panel
    // ** You should never need to edit this code **
    public void setMode(String mode) {
        this.mode = mode;
    }

    // Can be called to change the current color
    // of the drawing panel
    // ** You should never need to edit this code **
    public void setColor(Color color) {
        this.color = color;
    }

    // Sets the size of the DrawingPanel, so frame.pack() considers
    // its preferred size when sizing the JFrame
    // ** You should never need to edit this code **
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    // This is the method that draws everything
    // ** Code to be edited in Part C **
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Loop through the 2D array and draw a 1x1 rectangle
        // on each pixel that is currently painted
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (isPainted[x][y]) {
                    g.drawRect(x, y, 1, 1);
                }
            }
        }
    }

    // Update the canvas in the place the user clicked/dragged,
    // based on the currently selected tool.
    public void updateCanvas(MouseEvent e) {
        // Check the current mode
        // * If "pencil" mode, we should mark the current
        //   pixel as painted
        if (mode.equals("Pencil")) {
            // Check that mouse is in bounds of panel
            if (e.getX() >= 0 && e.getX() < WIDTH &&
                    e.getY() >= 0 && e.getY() < HEIGHT) {
                // Set current pixel as painted
                isPainted[e.getX()][e.getY()] = true;
            }
        }

        // We need to manually tell the panel to repaint
        // and call the paintComponent method
        repaint();
    }

    // MouseListener methods
    // This is the method that is called when the mouse
    // is pressed. This is where most of your code will go
    // ** Code to be edited in Part B **
    public void mousePressed(MouseEvent e) {
        updateCanvas(e);
    }

    // This is a MouseMotionListener method
    // We have this method so that we don't need to click each
    // pixel that we want to draw
    // ** You should never need to edit this code **
    public void mouseDragged(MouseEvent e) {
        updateCanvas(e);
    }

    // The remaining MouseListener and MouseMotionLister
    // methods are left blank
    // ** You should never need to edit this code **
    public void mouseReleased(MouseEvent e) {
        // This method is intentionally blank
    }

    // ** You should never need to edit this code **
    public void mouseEntered(MouseEvent e) {
        // This method is intentionally blank
    }

    // ** You should never need to edit this code **
    public void mouseExited(MouseEvent e) {
        // This method is intentionally blank
    }

    // ** You should never need to edit this code **
    public void mouseClicked(MouseEvent e) {
        // This method is intentionally blank
    }

    // ** You should never need to edit this code **
    public void mouseMoved(MouseEvent e) {
        // This method is intentionally blank
    }
}