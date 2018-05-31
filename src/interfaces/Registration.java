package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.FileControl;

public class Registration extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField InfoName;
	private JTextField InfoEmail;
	private JTextField InfoTell;
	private JPasswordField InfoPassword;
	private JPasswordField InfoPasswordConfirmation;
	Notifications notifications;
	WindowManager windowManager;
	FileControl control;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Registration() {
		window();
		fields();
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
		control = new FileControl();
	}

	private void fields() {
		InfoName = new JTextField();
		InfoName.setBounds(157, 67, 243, 20);
		contentPane.add(InfoName);
		InfoName.setColumns(10);

		InfoEmail = new JTextField();
		InfoEmail.setBounds(157, 93, 243, 20);
		contentPane.add(InfoEmail);
		InfoEmail.setColumns(10);

		InfoTell = new JTextField();
		InfoTell.setBounds(157, 124, 243, 20);
		contentPane.add(InfoTell);
		InfoTell.setColumns(10);

		InfoPassword = new JPasswordField();
		InfoPassword.setBounds(157, 155, 243, 20);
		contentPane.add(InfoPassword);
		InfoPassword.setColumns(10);

		InfoPasswordConfirmation = new JPasswordField();
		InfoPasswordConfirmation.setBounds(157, 183, 243, 20);
		contentPane.add(InfoPasswordConfirmation);
		InfoPasswordConfirmation.setColumns(10);
	}

	private void texts() {
		JLabel lblName = new JLabel("Username: ");
		lblName.setBounds(41, 67, 106, 14);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(41, 93, 106, 14);
		contentPane.add(lblEmail);

		JLabel lblTell = new JLabel("Telefone:");
		lblTell.setBounds(41, 124, 106, 14);
		contentPane.add(lblTell);

		JLabel lblPassword = new JLabel("Senha: ");
		lblPassword.setBounds(41, 155, 106, 14);
		contentPane.add(lblPassword);

		JLabel lblPasswordConfirmation = new JLabel("Confirmar password:");
		lblPasswordConfirmation.setBounds(41, 186, 106, 14);
		contentPane.add(lblPasswordConfirmation);

		JLabel lblSubtitle = new JLabel("Preencha os fields e clique em register para realizar o cadastro!");
		lblSubtitle.setBounds(58, 35, 342, 14);
		contentPane.add(lblSubtitle);

		JLabel lblTitle = new JLabel("CADASTRO");
		lblTitle.setBounds(188, 11, 127, 19);
		contentPane.add(lblTitle);
	}

	private void buttons() {
		JButton btnRegister = new JButton("CADASTRAR");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegister.setBounds(233, 227, 167, 23);
		contentPane.add(btnRegister);

		JButton btnGoBack = new JButton("VOLTAR");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.startMenu();
				dispose();
			}
		});
		btnGoBack.setBounds(41, 227, 167, 23);
		contentPane.add(btnGoBack);
	}

	private void register() {
		String name = InfoName.getText();
		String email = InfoEmail.getText();
		String tell = InfoTell.getText();
		@SuppressWarnings("deprecation")
		String password = InfoPassword.getText();
		@SuppressWarnings("deprecation")
		String passwordConfirmation = InfoPasswordConfirmation.getText();
		decideTratamentoCadastro(name, email, tell, password, passwordConfirmation);
	}

	private void decideTratamentoCadastro(String name, String email, String tell, String password,
			String passwordConfirmation) {
		if (name.equals("") || email.equals("") || tell.equals("") || password.equals("")) {
			notifications.empty();
		}
		else if (control.checkUserFile(name)) {
			notifications.usernameExist();
		}
		else if (!(password.equals(passwordConfirmation))) {
			notifications.incompatiblePasswords();
		} else {
			control.saveUserFile(name, email, tell, password);
			windowManager.startMenu();
			dispose();
		}
	}

}
