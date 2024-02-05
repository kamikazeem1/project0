/*
 * Painter.java
 * @author Michael O'Neill
 * Driver, creates and shows GUI
 */

//Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Painter {

    //Declarations
    Draw whiteboard;
    JButton black, blue, red, green, orange, clearButton, saveButton;
    JPanel drawArea;
    ActionListener actionListener = new ActionListener() {
        // calls Draw functions when buttons are clicked
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                whiteboard.clear();
              } else if (e.getSource() == saveButton) {
                whiteboard.save();
              } else if (e.getSource() == black) {
                whiteboard.paintBlack();
              } else if (e.getSource() == blue) {
                whiteboard.paintBlue();
              } else if (e.getSource() == red) {
                whiteboard.paintRed();
              } else if (e.getSource() == green) {
                whiteboard.paintGreen();
              } else if (e.getSource() == orange) {
                whiteboard.paintOrange();
              }
        }
    };

    // Creates GUI
    public void createAndShowGUI() {

        //Borders
        Border border = BorderFactory.createLineBorder(Color.black);
        Border insideBorder = BorderFactory.createLineBorder(Color.lightGray, 10);
        
        //Frame
        JFrame frame = new JFrame("PAINTER!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); //Layout manager - BorderLayout
        
        // Panels
        // Main drawing panel
        JPanel drawArea = new JPanel(new BorderLayout());
        drawArea.setBorder(insideBorder);
        whiteboard = new Draw();
        drawArea.add(whiteboard);
        frame.add(drawArea, BorderLayout.CENTER); // places drawArea panel in the center
        
        // Top panel that holds the color options
        JPanel colorPanel = new JPanel(new GridLayout(1,5));
        colorPanel.setPreferredSize(new Dimension(100,100));
        colorPanel.setBorder(border);
        frame.add(colorPanel, BorderLayout.NORTH); // places colorPanel at the top
        
        // Bottom panel that holds 'clear' and 'save' options
        JPanel functionPanel = new JPanel(new GridLayout(1,2));
        functionPanel.setPreferredSize(new Dimension(100,50));
        functionPanel.setBorder(border);
        frame.add(functionPanel, BorderLayout.SOUTH); // places functionPanel at the bottom
        
        //Buttons
        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionListener);
        functionPanel.add(clearButton);
        
        saveButton = new JButton("Save");
        saveButton.addActionListener(actionListener);
        functionPanel.add(saveButton);
        
        black = new JButton();
        black.setBackground(Color.BLACK);
        black.addActionListener(actionListener);
        colorPanel.add(black);
        
        blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.addActionListener(actionListener);
        colorPanel.add(blue);
        
        red = new JButton();
        red.setBackground(Color.RED);
        red.addActionListener(actionListener);
        colorPanel.add(red);
        
        green = new JButton();
        green.setBackground(Color.GREEN);
        green.addActionListener(actionListener);
        colorPanel.add(green);
        
        orange = new JButton();
        orange.setBackground(Color.ORANGE);
        orange.addActionListener(actionListener);
        colorPanel.add(orange);
        
        frame.setSize(700,710);
        frame.setLocationRelativeTo(null); //Places window in center of screen
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    // Main method
    public static void main(String[] args) {
        new Painter().createAndShowGUI();
    }
}

