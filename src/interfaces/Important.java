package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import control.FileControl;

public class Important extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	FileControl fileControl = new FileControl();
	WindowManager windowManager = new WindowManager();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Important frame = new Important();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Important() {
		window();
		texts();
		JCheckBox[] checkbox = checkBox();
		buttons(checkbox);
	}

	private void window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	private JCheckBox[] checkBox() {
		String[] infoFood = fileControl.getFoodsName();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 52, 389, 130);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		String area = "";
		for (int a = 0; a < 40; a++) {
			area = area + "\r\n";
		}
		textArea.setText(area);
		textArea.setCaretPosition(0);
		scrollPane.setViewportView(textArea);

		JCheckBox[] checkbox = new JCheckBox[infoFood.length];
		for(int j = 0; j < checkbox.length; j++) {

			checkbox[j] = new JCheckBox();
			checkbox[j].setText(infoFood[j]);
			checkbox[j].setBounds(15 + (j % 3) * 120, 5 + ((Integer) j/3) * 25, 95, 25);
			textArea.add(checkbox[j]);
			if (fileControl.isFavoriteFood(infoFood[j])) {
				checkbox[j].setSelected(true);
			} else {
				checkbox[j].setSelected(false);
			}
		}
		return checkbox;
	}

	private void texts() {
		contentPane.setLayout(null);
		JLabel lblSubtitle = new JLabel("Selecione os produtos que deseja ser notificado!");
		lblSubtitle.setBounds(98, 32, 312, 14);
		contentPane.add(lblSubtitle);

		JLabel lblTitle = new JLabel("Produtos importantes");
		lblTitle.setBounds(173, 11, 158, 14);
		contentPane.add(lblTitle);
	}

	private void buttons(JCheckBox[] checkbox) {
		String[] infoFood = fileControl.getFoodsName();
		JButton btnSave = new JButton("SALVAR");
		btnSave.setBounds(73, 193, 284, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i<infoFood.length;i++) {
					fileControl.setFavorite(infoFood[i], checkbox[i].isSelected());
					windowManager.homeMenu();
					dispose();
				}
			}
		});
		contentPane.add(btnSave);

		JButton bntGoBack = new JButton("VOLTAR AO MENU PRINCIPAL");
		bntGoBack.setBounds(73, 227, 284, 23);
		bntGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				windowManager.homeMenu();
				dispose();
			}
		});
		contentPane.add(bntGoBack);
	}
}
