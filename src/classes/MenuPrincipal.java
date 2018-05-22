package classes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controle.ControlePaginas;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ControlePaginas controle;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// MenuPrincipal
	public MenuPrincipal() {
		pagina();
		textos();
		botoes();
	}

	// FORMATA A PAGINA
	private void pagina() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		controle = new ControlePaginas();
	}

	// FORMATA OS TEXTOS
	private void textos() {

		// TEXTO TITULO
		JLabel lblJanelaPricipal = new JLabel("Menu principal");
		lblJanelaPricipal.setBounds(185, 33, 125, 14);
		contentPane.add(lblJanelaPricipal);

		// TEXTO SUBTITULO
		JLabel lblSelecioneAOpo = new JLabel("Selecione a opcao desejada!");
		lblSelecioneAOpo.setBounds(149, 58, 180, 14);
		contentPane.add(lblSelecioneAOpo);
	}

	// FORMATA OS BOTÕES NA PAGINA
	private void botoes() {

		// BOTÃO INSERIR
		JButton btnNewButton = new JButton("INSERIR ALIMENTO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.inserir();
			}
		});
		btnNewButton.setBounds(96, 103, 240, 23);
		contentPane.add(btnNewButton);

		// BOTÃO TIRAR FOTO
		JButton btnNewButton_1 = new JButton("TIRAR FOTO DAS PRATELEIRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foto();
			}
		});
		btnNewButton_1.setBounds(96, 137, 240, 23);
		contentPane.add(btnNewButton_1);

		// BOTÃO SAIR
		JButton btnNewButton_2 = new JButton("SAIR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.inicio();
			}
		});
		btnNewButton_2.setBounds(96, 193, 240, 23);
		contentPane.add(btnNewButton_2);
	}


	// NOTIFICA QUE FOI TIRADO FOTO
	private void foto() {
		JOptionPane.showMessageDialog(null, "Foto das prateleiras enviadas com sucesso", "Foto!",
				JOptionPane.INFORMATION_MESSAGE);
	}


}
