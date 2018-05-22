package classes;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class JanelaImportantes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaImportantes frame = new JanelaImportantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaImportantes() {
		
		
		
		String array[] = new String[5];
		
		
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		Scanner scanner;

		try {

		
			scanner = new Scanner(new FileReader("ArquivoAlimentos.txt"))
			           .useDelimiter("\\||\\n");
int x=0;
		while (scanner.hasNext()) {
		  String alimento = scanner.next();
		  String valor = scanner.next();
		  String tipo = scanner.next();

				array[x] = alimento;
			    System.out.println(array[x]);
		   x++;
		}}
		 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		JLabel lblNewLabel = new JLabel("Produtos importantes");
		lblNewLabel.setBounds(168, 11, 158, 14);
		contentPane.add(lblNewLabel);
		

		
		
		
		JButton btnSelecionar = new JButton("VOLTAR");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

					
				  
				//System.out.println(chckbxNewCheckBox.isSelected());
				
					
					
				   
				
				
				MenuPrincipal janela = new MenuPrincipal();
				janela.setVisible(true);
				dispose();
				
			}
		});
		

		btnSelecionar.setBounds(118, 227, 195, 23);
		contentPane.add(btnSelecionar);
		
		JLabel lblSelecioneOsProdutos = new JLabel("Selecione os produtos que deseja ser notificado!");
		lblSelecioneOsProdutos.setBounds(93, 32, 312, 14);
		contentPane.add(lblSelecioneOsProdutos);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(array[1]);
		chckbxNewCheckBox.setBounds(29, 53, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox(array[0]);
		checkBox.setBounds(29, 79, 97, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox(array[1]);
		checkBox_1.setBounds(29, 105, 97, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_5 = new JCheckBox(array[2]);
		checkBox_5.setBounds(29, 183, 97, 23);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox(array[3]);
		checkBox_6.setBounds(29, 157, 97, 23);
		contentPane.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox(array[4]);
		checkBox_7.setBounds(29, 131, 97, 23);
		contentPane.add(checkBox_7);
		
		JCheckBox checkBox_2 = new JCheckBox(array[5]);
		checkBox_2.setBounds(162, 53, 97, 23);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox(array[6]);
		checkBox_3.setBounds(162, 79, 97, 23);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox(array[7]);
		checkBox_4.setBounds(162, 105, 97, 23);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_8 = new JCheckBox(array[8]);
		checkBox_8.setBounds(162, 131, 97, 23);
		contentPane.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox(array[9]);
		checkBox_9.setBounds(162, 157, 97, 23);
		contentPane.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox(array[10]);
		checkBox_10.setBounds(162, 183, 97, 23);
		contentPane.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox(array[11]);
		checkBox_11.setBounds(308, 53, 97, 23);
		contentPane.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox(array[12]);
		checkBox_12.setBounds(308, 79, 97, 23);
		contentPane.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox(array[13]);
		checkBox_13.setBounds(308, 105, 97, 23);
		contentPane.add(checkBox_13);
		
		JCheckBox checkBox_14 = new JCheckBox(array[14]);
		checkBox_14.setBounds(308, 131, 97, 23);
		contentPane.add(checkBox_14);
		
		JCheckBox checkBox_15 = new JCheckBox(array[15]);
		checkBox_15.setBounds(308, 157, 97, 23);
		contentPane.add(checkBox_15);
		
		JCheckBox checkBox_16 = new JCheckBox(array[16]);
		checkBox_16.setBounds(308, 183, 97, 23);
		contentPane.add(checkBox_16);
		


		
		
		
		}
	
}
