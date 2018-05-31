package control;

import javax.swing.JFrame;
import interfaces.WindowManager;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		WindowManager windowManager;
		windowManager = new WindowManager();
		windowManager.startMenu();
		windowManager.sensorSimulator();
	}
}
