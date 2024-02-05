package CS2400.projtwo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import Swing package for GUI
import javax.swing.*;
import javax.swing.border.Border;

public class Painter {

    Draw whiteboard;
    JButton black, blue, red, green, orange, clearButton, saveButton;
    JPanel drawArea;

    ActionListener actionListener = new ActionListener() {
        
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

    
    public void createAndShowGUI() {
        
        //Frame
        JFrame frame = new JFrame("PAINTER!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(165,232,255));
        frame.setLayout(new BorderLayout());
        
        Border border = BorderFactory.createLineBorder(Color.black);
        Border insideBorder = BorderFactory.createLineBorder(Color.lightGray, 10);

        // Panel
        JPanel drawArea = new JPanel(new BorderLayout());
        drawArea.setBorder(insideBorder);
        whiteboard = new Draw();
        drawArea.add(whiteboard, BorderLayout.CENTER);
        frame.add(drawArea, BorderLayout.CENTER);
        
        JPanel colorPanel = new JPanel(new GridLayout(1,5));
        colorPanel.setPreferredSize(new Dimension(100,100));
        colorPanel.setBorder(border);
        frame.add(colorPanel, BorderLayout.NORTH);
        
        JPanel functionPanel = new JPanel(new GridLayout(1,2));
        functionPanel.setPreferredSize(new Dimension(100,50));
        functionPanel.setBorder(border);
        frame.add(functionPanel, BorderLayout.SOUTH);
        
        //Button
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
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Painter().createAndShowGUI();
    }
}

