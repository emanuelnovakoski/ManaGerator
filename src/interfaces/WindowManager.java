package interfaces;

import javax.swing.JFrame;

import simulator.SensorSimulator;

public class WindowManager  extends JFrame{
	private static final long serialVersionUID = 1L;
	SensorSimulator sensorSimulator; 
	
	public void insert() {
		Insert window = new Insert();
		window.setVisible(true);	
	}
	public void login() {
		Login window = new Login();
		window.setVisible(true);
	}
	public void registration() {
		Registration window = new Registration();
		window.setVisible(true);
	}
	public void sensorSimulator() {
		SensorSimulator window = new SensorSimulator();
		window.setVisible(true);
	    window.setLocation(600,100);
	}
	public void startMenu() {
		StartMenu window = new StartMenu();
		window.setVisible(true);
	}
	public void homeMenu() {
		HomeMenu window = new HomeMenu();
		window.setVisible(true);
	}
	public void important() {
		Important window = new Important();
		window.setVisible(true);
	}

}
