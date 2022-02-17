import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates Board and Board functions

public class Board extends JPanel {
	
	private static final long serialVersionUID = 9217694211427196982L;
	JButton [][] buttons;
	String p;
	JLabel label;

	public Board(int length, int height, String p, JLabel label) {
        super();
		this.p = p;
		this.label = label;
        this.setLayout(new GridLayout(length, height));
        buttons = new JButton[length][height];
        
        // Populates the button array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton b = new JButton();
                b.addActionListener(clc);
                b.setText(" ");
                b.setBackground(Color.WHITE);
                buttons[i][j] = b;
                this.add(b);
                b.setFocusPainted(false);
                }
        }
        
    }
	
	// OnClick for buttons
	ActionListener clc = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) { 
            	// Checks which button is clicked
            	for(int i = 0; i < 3; i++){
            		for (int j = 0; j < 3; j++) {
            			if(e.getSource() == buttons[i][j]){
                			buttons[i][j].setText(p);
                			buttons[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 25));
                			// customizing color :)
                			if (buttons[i][j].getText().equals("x")) {
                				buttons[i][j].setBackground(new Color(209, 216, 232));
                			} else if (buttons[i][j].getText().equals("o")) {
                				buttons[i][j].setBackground(new Color(232, 209, 218));
                			}
                			// Disabling further clicks so players can't secretly change a tile
                			buttons[i][j].setEnabled(false);
                		}
            		}
            	}
            	
            	// Detecting win/full after move
                WinDetection win = new WinDetection(buttons, p);
                boolean cont = win.cont();
                
                // If we're allowed to continue, we swap the players
                if (cont == true) {
                	p = swap(p);
                	label.setText("PLAYER " + p.toUpperCase());
                } else if (cont == false) {
                	System.exit(0);
                }
            }
        }
    };

    // for debugging
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    // To toggle between players
    public String swap (String p) {
    	String player = null;
		if (p == "x") {
			player = "o";
		} else if (p == "o") {
			player = "x";
		}
		return player;
	}

}