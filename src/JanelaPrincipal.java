import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JANELA PRINCIPAL
	public JanelaPrincipal() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TEXTO TITULO
		JLabel lblJanelaPricipal = new JLabel("Menu principal");
		lblJanelaPricipal.setBounds(185, 33, 125, 14);
		contentPane.add(lblJanelaPricipal);

		// BOTÃO INSERIR
		JButton btnNewButton = new JButton("INSERIR ALIMENTO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRE JANELA INSERE
				JanelaInsere janela = new JanelaInsere();
				janela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(96, 103, 240, 23);
		contentPane.add(btnNewButton);

		// BOTÃO TIRAR FOTO
		JButton btnNewButton_1 = new JButton("TIRAR FOTO DAS PRATELEIRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// NOTIFICA QUE FOI TIRADO FOTO
				JOptionPane.showMessageDialog(null, "Foto das prateleiras enviadas com sucesso", "Foto!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(96, 137, 240, 23);
		contentPane.add(btnNewButton_1);

		// BOTÃO SAIR
		JButton btnNewButton_2 = new JButton("SAIR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRE JANELA INICIAL
				JanelaInicial janela = new JanelaInicial();
				janela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(96, 193, 240, 23);
		contentPane.add(btnNewButton_2);

		// TEXTO SUBTITULO
		JLabel lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada!");
		lblSelecioneAOpo.setBounds(149, 58, 180, 14);
		contentPane.add(lblSelecioneAOpo);
	}
}
