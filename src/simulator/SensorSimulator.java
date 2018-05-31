package simulator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import control.FileControl;
import control.Sensor;
import interfaces.Notifications;
import interfaces.WindowManager;

public class SensorSimulator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Notifications notifications;
	WindowManager windowManager;
	FileControl fileControl;
	Sensor sensor;
	JSpinner gasValue = new JSpinner();
	JSpinner amountValue = new JSpinner();
	JSpinner  weightValue = new JSpinner();
	JComboBox<String> comboBox = new JComboBox<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorSimulator frame = new SensorSimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SensorSimulator() {
		window();
		spiners(gasValue, amountValue, weightValue);
		texts();
		comboBox();
		buttons(comboBox);
	}

	private void window() {
		setTitle("CONTROLE");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		windowManager = new WindowManager();
		notifications = new Notifications();
		fileControl = new FileControl();
		sensor = new Sensor();
	}

	private void spiners(JSpinner gasValue, JSpinner amountValue, JSpinner weightValue) {
		gasValue.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		gasValue.setBounds(339, 150, 81, 20);
		contentPane.add(gasValue);

		amountValue.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		amountValue.setBounds(340, 100, 80, 20);
		contentPane.add(amountValue);
		
		weightValue.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		weightValue.setBounds(339, 125, 81, 20);
		contentPane.add(weightValue);
	}

	private void texts() {
		JLabel lblweight = new JLabel("Valor limite para notificação: (Balança)");
		lblweight.setBounds(20, 128, 307, 14);
		contentPane.add(lblweight);

		JLabel lblamount = new JLabel("Quantidade de itens: (Sensor Ultrassonico)");
		lblamount.setBounds(20, 105, 360, 14);
		contentPane.add(lblamount);

		JLabel lblgas = new JLabel("Niveis de gases indicativos no ar: (Detector de gases)");
		lblgas.setToolTipText("");
		lblgas.setBounds(20, 155, 360, 14);
		contentPane.add(lblgas);
		
		JLabel lbldefault = new JLabel("\"Obs: Usamos 500 por defalut\"");
		lbldefault.setBounds(20, 174, 177, 14);
		contentPane.add(lbldefault);

		JLabel lbltitle = new JLabel("Tela de controle (simulação)");
		lbltitle.setBounds(147, 11, 187, 14);
		contentPane.add(lbltitle);

		JLabel lblsubtitle = new JLabel("Preencha os campos com os valores dos sensores!");
		lblsubtitle.setBounds(88, 36, 307, 14);
		contentPane.add(lblsubtitle);
	}

	private void comboBox() {
		comboBox.addItem("Alimentos:");
		comboBox.setBounds(20, 72, 400, 20);
		contentPane.add(comboBox);
		String[] foodsName = fileControl.getFoodsName();
		for(int i = 0; i<foodsName.length; i++) {
			if(fileControl.isFavoriteFood(foodsName[i])) {
				comboBox.addItem(foodsName[i]);
			}	
		}
	}

	private void buttons(JComboBox<String> comboBox) {
		JButton btnUpdate = new JButton("ATUALIZAR");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sensor.updateSensors(comboBox, gasValue, amountValue, weightValue);
				comboBox.removeAllItems();
				comboBox();
			}
		});
		btnUpdate.setBounds(100, 211, 238, 23);
		contentPane.add(btnUpdate);
	}
}
