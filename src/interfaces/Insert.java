package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.FileControl;

public class Insert extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField RegFood;
	private JTextField RegMinValue;
	Notifications notifications;
	WindowManager WindowManager;
	FileControl FileControl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Insert() {
		window();
		texts();
		fields();
		buttons();
	}

	private void window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		WindowManager = new WindowManager();
		notifications = new Notifications();
		FileControl = new FileControl();
	}

	private void texts() {
		JLabel lblTitulo = new JLabel("CADASTRO DE ALIMENTO");
		lblTitulo.setBounds(153, 29, 182, 19);
		contentPane.add(lblTitulo);

		JLabel lblFoodName = new JLabel("Tipo de food:");
		lblFoodName.setBounds(41, 85, 148, 14);
		contentPane.add(lblFoodName);

		JLabel lblMinValue = new JLabel("Valor m\u00EDnimo ( g, qtd, ml )");
		lblMinValue.setBounds(41, 128, 148, 14);
		contentPane.add(lblMinValue);
	}

	private void fields() {		
		RegFood = new JTextField();
		RegFood.setBounds(199, 82, 201, 20);
		contentPane.add(RegFood);
		RegFood.setColumns(10);

		RegMinValue = new JTextField();
		RegMinValue.setBounds(199, 125, 201, 20);
		contentPane.add(RegMinValue);
		RegMinValue.setColumns(10);
	}

	private void buttons() {
		JButton btnRegister = new JButton("CADASTRAR ALIMENTO");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodRegister();
			}
		});
		btnRegister.setBounds(233, 203, 167, 23);
		contentPane.add(btnRegister);

		JButton btnGoBack = new JButton("VOLTAR");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManager.homeMenu();
				dispose();
			}
		});
		btnGoBack.setBounds(41, 203, 167, 23);
		contentPane.add(btnGoBack);
	}

	private void foodRegister() {
		String food = RegFood.getText();
		String minValue = RegMinValue.getText();
		if (food.equals("") || minValue.equals("")) {
			notifications.empty();
		} else if (FileControl.checkFoodFile(food)) {
			notifications.foodExist();
		} else {
			FileControl.saveFoodFile(food, minValue);
			WindowManager.homeMenu();
			dispose();
		}
	}
}