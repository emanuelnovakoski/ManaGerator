package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.FileControl;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField User;
	private JPasswordField Password;
	Notifications notifications;
	WindowManager windowManager;
	FileControl fileControl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		window();
		texts();
		fields();
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
		fileControl = new FileControl();
	}

	private void texts() {

		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(64, 105, 59, 14);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(64, 133, 68, 14);
		contentPane.add(lblPassword);

		JLabel lblTitle = new JLabel("Fazer Login");
		lblTitle.setBounds(193, 27, 89, 14);
		contentPane.add(lblTitle);
		
		JLabel lblSubtitle = new JLabel("Digite seu usuario e password !");
		lblSubtitle.setBounds(152, 52, 200, 14);
		contentPane.add(lblSubtitle);
	}

	private void fields() {

		User = new JTextField();
		User.setBounds(142, 102, 223, 20);
		contentPane.add(User);
		User.setColumns(10);

		Password = new JPasswordField();
		Password.setBounds(142, 133, 223, 20);
		contentPane.add(Password);
	}

	private void buttons() {
		JButton btnStart = new JButton("ENTRAR");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnStart.setBounds(226, 190, 126, 23);
		contentPane.add(btnStart);
	
		JButton btnGoBack = new JButton("VOLTAR");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.startMenu();
				dispose();
			}
		});
		btnGoBack.setBounds(75, 190, 126, 23);
		contentPane.add(btnGoBack);
	}

	private void start() {
		String user = User.getText();
		@SuppressWarnings("deprecation")
		String password = Password.getText();
		if (fileControl.checkLogin(user, password)) {
			windowManager.homeMenu();
			dispose();
		} else {
			notifications.incorrectData();
		}
	}
}
