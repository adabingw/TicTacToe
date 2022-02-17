import javax.swing.JButton;

// checking for wins

public class WinDetection {
	
	JButton[][] b;
	
	public WinDetection(JButton[][] b) {
		this.b = b;
	}
	
	public boolean cont() {
		// checks different scenarios
		boolean isFull = checkIsFull();
		boolean rows = checkRowWins();
		boolean cols = checkColWins();
		boolean diag = checkDiagWins();
		if (isFull == true || rows == true || cols == true || diag == true) {
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
