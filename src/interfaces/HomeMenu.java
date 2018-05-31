package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	Notifications notifications;
	WindowManager windowManager;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMenu frame = new HomeMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeMenu() {
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
		JLabel lblTitle = new JLabel("Menu principal");
		lblTitle.setBounds(185, 33, 125, 14);
		contentPane.add(lblTitle);
	
		JLabel lblSubtitle = new JLabel("Selecione a opção desejada!");
		lblSubtitle.setBounds(149, 58, 180, 14);
		contentPane.add(lblSubtitle);
	}

	private void buttons() {
		JButton btnInsert = new JButton("INSERIR ALIMENTO");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.insert();
				dispose();
			}
		});
		btnInsert.setBounds(67, 96, 307, 23);
		contentPane.add(btnInsert);

		JButton btnPicture = new JButton("TIRAR FOTO DAS PRATELEIRAS");
		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifications.picture();
			}
		});
		btnPicture.setBounds(67, 164, 307, 23);
		contentPane.add(btnPicture);

		JButton btnExit = new JButton("SAIR");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.startMenu();
				dispose();
			}
		});
		btnExit.setBounds(67, 211, 307, 23);
		contentPane.add(btnExit);

		JButton button = new JButton("ESCOLHER ALIMENTOS IMPORTANTES");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				windowManager.important();
				dispose();
			}
		});
		button.setBounds(67, 130, 307, 23);
		contentPane.add(button);
	}
}
