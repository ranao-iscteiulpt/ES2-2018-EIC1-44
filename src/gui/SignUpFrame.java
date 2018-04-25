/*package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SignUpFrame {

	private JFrame frame;
	private RegisterPanelold registerPanel;

	public SignUpFrame() {
		frame = new JFrame();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void openLogin() {
		frame.setSize(320, 250);
		frame.setTitle("Register");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		registerPanel = new RegisterPanelold();
		registerPanel.signUp();

		frame.add(registerPanel.getRegister());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}*/
