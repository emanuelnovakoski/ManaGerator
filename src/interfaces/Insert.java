package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.FileControl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insert extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField RegFood;
	private JTextField RegMinValue;
	private JTextField RegCategory;
	private JFormattedTextField RegDate;
	
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

		JLabel lblFoodName = new JLabel("Nome do alimento:");
		lblFoodName.setBounds(41, 80, 148, 14);
		contentPane.add(lblFoodName);

		JLabel lblMinValue = new JLabel("Valor m\u00EDnimo ( g, qtd, ml )");
		lblMinValue.setBounds(41, 115, 148, 14);
		contentPane.add(lblMinValue);
		
		JLabel lblCategory = new JLabel("Categoria do alimento:");
		lblCategory.setBounds(41, 145, 148, 14);
		contentPane.add(lblCategory);
		
		JLabel lblDate = new JLabel("Data de Adição:");
		lblDate.setBounds(41, 173, 148, 14);
		contentPane.add(lblDate);
	
	}

	private void fields() {		
		RegFood = new JTextField();
		RegFood.setBounds(199, 80, 201, 20);
		contentPane.add(RegFood);
		RegFood.setColumns(10);

		RegMinValue = new JTextField();
		RegMinValue.setBounds(199, 110, 201, 20);
		contentPane.add(RegMinValue);
		RegMinValue.setColumns(10);
		
		RegCategory = new JTextField();
		RegCategory.setBounds(199, 140, 201, 20);
		contentPane.add(RegCategory);
		RegCategory.setColumns(10);
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		RegDate = new JFormattedTextField(format);
		RegDate.setBounds(199, 170, 201, 20);
		contentPane.add(RegDate);
		RegDate.setColumns(10);
		
		Date data = new Date();
		RegDate.setText(format.format(data));	
	}

	private void buttons() {
		JButton btnRegister = new JButton("CADASTRAR ALIMENTO");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodRegister();
			}
		});
		btnRegister.setBounds(233, 230, 167, 23);
		contentPane.add(btnRegister);

		JButton btnGoBack = new JButton("VOLTAR");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowManager.homeMenu();
				dispose();
			}
		});
		btnGoBack.setBounds(41, 230, 167, 23);
		contentPane.add(btnGoBack);
	}

	private void foodRegister() {
		
		String food = RegFood.getText();
		String minValue = RegMinValue.getText();
		String category = RegCategory.getText();
		String date = RegDate.getText();
		
		if (food.equals("") || minValue.equals("")) {
			notifications.empty();
		} else if (FileControl.checkFoodFile(food)) {
			notifications.foodExist();
		} else {
			FileControl.saveFoodFile(food, minValue, category, date);
			WindowManager.homeMenu();
			dispose();
		}
	}
}