import java.awt.Color;
import javax.swing.UIManager;

// landing page

public class StartScreen {
    public static void main(String[] args) {
    	UIManager.put("OptionPane.background", Color.WHITE);						// customizing JOptionPane
		UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
		UIManager.put("Button.background", Color.white);
    	new Interface("x");
	}
}