import javax.swing.*;
import java.awt.*;

class PaintDemoDrawingPanel extends JPanel {
    // Constructor sets up DrawingPanel
    public PaintDemoDrawingPanel() {
        setBackground(Color.WHITE);
    }

    // Sets the size of the DrawingPanel, so frame.pack() considers
    // its preferred size when sizing the JFrame
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    // This is the method that draws everything
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawRect(50, 50, 100, 50);
        g.drawOval(200, 300, 50, 50);

        g.setColor(Color.RED);
        g.fillRect(50, 300, 50, 50);
        g.fillOval(200, 50, 50, 100);
    }
}