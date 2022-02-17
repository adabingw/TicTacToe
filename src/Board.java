import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates Board and Board functions

public class Board extends JPanel {
	
	private static final long serialVersionUID = 9217694211427196982L;
	JButton [][] buttons;
	String p;

	public Board(int length, int height, String p) {
        super();
		this.p = p;
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
                System.out.println("Supposedly added?");
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
                WinDetection win = new WinDetection(buttons);
                boolean cont = win.cont();
                
                // If we're allowed to continue, we swap the players
                if (cont == true) {
                	p = swap(p);
                } else if (cont == false) {
                	// I wanted to customize the JOptionpane :)
                	JLabel label = new JLabel("Game Over :(");
            		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            		label.setHorizontalAlignment(SwingConstants.CENTER);

                    final JButton okay = new JButton("Ok");
                    okay.setBackground(Color.WHITE);
                    okay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
                    okay.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    
                    Object[] message = {
                    	label
                    };
                	
                	int result = JOptionPane.showOptionDialog(null,
		                            message,
		                            " ",
		                            JOptionPane.YES_NO_CANCEL_OPTION,
		                            JOptionPane.PLAIN_MESSAGE,
		                            null,
		                            new Object[]{okay},
		                            null);
                	if (result == JOptionPane.YES_OPTION) {
                		System.exit(0);
                	} else {
                		System.exit(0);
                	}
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