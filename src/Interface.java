// implementing the GUI of the game

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame{

	private static final long serialVersionUID = 7384123718787721671L;
	private int width = 500, height = 500;
    
    public Interface(String p) {
        super("TicTacToe");
        
        Board board = new Board(3, 3, p);
        this.add(board, BorderLayout.CENTER);
        
        this.setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(450, 30);
		this.setResizable(false);
        this.setVisible(true);
    }
   	
}
