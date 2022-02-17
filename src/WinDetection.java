import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// checking for wins

public class WinDetection {
	
	JButton[][] b;
	String p;
	
	public WinDetection(JButton[][] b, String p) {
		this.b = b;
		this.p = p;
	}
	
	public boolean cont() {
		// checks different scenarios
		boolean isFull = checkIsFull();
		boolean rows = checkRowWins();
		boolean cols = checkColWins();
		boolean diag = checkDiagWins();
		if (isFull == true || rows == true || cols == true || diag == true) {
			JLabel label = new JLabel("Game Over :(");
    		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    		label.setHorizontalAlignment(SwingConstants.CENTER);
    		
    		if (rows == true || cols == true || diag == true) {
    			label.setText("Player " + p + " has won!");
    		} else {
    			label.setText("Board is full :(");
    		}

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
        	return false;
		} else {
			return true;
		}
	}
	
	// checking if the board is full
	public boolean checkIsFull() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (b[i][j].getText().equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	
	// checks if there's 3 in a row
	public boolean checkRowWins() {
		for(int i = 0; i < 3; i++) {
			if (b[i][0].getText().equals("o") && b[i][1].getText().equals("o") && b[i][2].getText().equals("o")) {
				return true;
			} else if (b[i][0].getText().equals("x") && b[i][1].getText().equals("x") && b[i][2].getText().equals("x")) {
				return true;
			}
		}
		return false;
	}
	
	// checks if there's 3 in a column
	public boolean checkColWins() {
		for(int i = 0; i < 3; i++) {
			if (b[0][i].getText().equals("o") && b[1][i].getText().equals("o") && b[2][i].getText().equals("o")) {
				return true;
			} else if (b[0][i].getText().equals("x") && b[1][i].getText().equals("x") && b[2][i].getText().equals("x")) {
				return true;
			}
		}
		return false;
	}
	
	// checks if there's 3 in a diagonal (accounts for both left and right diags)
	public boolean checkDiagWins() {
		if (b[0][0].getText().equals("o") && b[1][1].getText().equals("o") && b[2][2].getText().equals("o")) {
			return true;
		} else if (b[0][0].getText().equals("x") && b[1][1].getText().equals("x") && b[2][2].getText().equals("x")) {
			return true;
		} else if (b[2][0].getText().equals("o") && b[1][1].getText().equals("o") && b[0][2].getText().equals("o")) {
			return true;
		} else if (b[2][0].getText().equals("x") && b[1][1].getText().equals("x") && b[0][2].getText().equals("x")) {
			return true;
		}
		return false;
	}
	
	
}
