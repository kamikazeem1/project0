/*
 * Draw.java
 * @author Michael O'Neill
 * Allows users to draw lines on a graphical surface
 */

//Imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

// Draw class inherits from JComponent
public class Draw extends JComponent {
    
    //Declarations
    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY;

    //Constructor
    public Draw() {
        // Obtains (old) mouse coordinates when mouse is clicked
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        // Obtains (new) mouse coordinates whne mouse is dragged
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                // draws line between old & new coordinates, new coordinates become old
                if (g2 != null) { // to prevent a NullPointerException
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    //Paints
    @Override
    protected void paintComponent(Graphics g) {
        // Creates drawing surface
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        // draws on surface
        g.drawImage(image, 0, 0, null);
    }

    //Clears the drawing area
    public void clear() {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0,0,getSize().width, getSize().height);
        g2.setPaint(Color.BLACK);
        repaint();
    }

    // Save image to PDF (Will work on later)
    public void save() {

    }

    //Changes paint color to black, blue, red, etc.
    public void paintBlack() {
        g2.setPaint(Color.BLACK);
    }

    public void paintBlue() {
        g2.setPaint(Color.BLUE);
    }

    public void paintRed() {
        g2.setPaint(Color.RED);
    }

    public void paintGreen() {
        g2.setPaint(Color.GREEN);
    }

    public void paintOrange() {
        g2.setPaint(Color.ORANGE);
    }

}
