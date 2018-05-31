package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class StartMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	Notifications notifications;
	WindowManager windowManager;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartMenu() {
		window();
		texts();
		buttons();
	}

	private void window() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		windowManager = new WindowManager();
		notifications = new Notifications();
	}

	private void texts() {
		JLabel lblTitle = new JLabel("Bem vindo ao MANAGERATOR !!!!");
		lblTitle.setBounds(144, 36, 163, 14);
		contentPane.add(lblTitle);

		JLabel lblSubititle = new JLabel("Faça seu login ou cadastre-se  para acessar o sistema");
		lblSubititle.setBounds(67, 70, 330, 14);
		contentPane.add(lblSubititle);
	}

	private void buttons() {
		JButton btnStart = new JButton("ENTRAR");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.login();
				dispose();
			}
		});
		btnStart.setBounds(106, 130, 231, 23);
		contentPane.add(btnStart);

		JButton btnRegistration = new JButton("CADASTRAR");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.registration();
				dispose();
			}
		});
		btnRegistration.setBounds(106, 180, 231, 23);
		contentPane.add(btnRegistration);
	}
}
