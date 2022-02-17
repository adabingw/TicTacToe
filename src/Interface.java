// implementing the GUI of the game

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame{

	private static final long serialVersionUID = 7384123718787721671L;
    
    public Interface(String p) {
        super("TicTacToe");
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("PLAYER X");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		this.add(panel, BorderLayout.NORTH);
        
        Board board = new Board(3, 3, p, label);
        this.add(board, BorderLayout.CENTER);
        
        this.setPreferredSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(450, 30);
		this.setResizable(false);
        this.setVisible(true);
    }
   	
}
