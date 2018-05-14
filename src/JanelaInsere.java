import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JanelaInsere extends JFrame {
	private JPanel contentPane;
	private JTextField CadastroAlimento;
	private JTextField CadastroValorMinimo;
	private JButton btnNewButton;
	private JButton btnVoltar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInsere frame = new JanelaInsere();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JANELA INSERE
	public JanelaInsere() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TEXTO TITULO
		JLabel lblCadastro = new JLabel("CADASTRO DE ALIMENTO");
		lblCadastro.setBounds(153, 29, 182, 19);
		contentPane.add(lblCadastro);

		/// CAMPO ALIMENTO
		CadastroAlimento = new JTextField();
		CadastroAlimento.setBounds(199, 82, 201, 20);
		contentPane.add(CadastroAlimento);
		CadastroAlimento.setColumns(10);

		// CAMPO VALOR MINIMO
		CadastroValorMinimo = new JTextField();
		CadastroValorMinimo.setBounds(199, 125, 201, 20);
		contentPane.add(CadastroValorMinimo);
		CadastroValorMinimo.setColumns(10);

		// TEXTO ALIMENTO
		JLabel lblAlimento = new JLabel("Tipo de alimento:");
		lblAlimento.setBounds(41, 85, 148, 14);
		contentPane.add(lblAlimento);

		// TEXTO VALOR MINIMO
		JLabel lblValorMinimo = new JLabel("Valor m\u00EDnimo ( g, qnt, ml )");
		lblValorMinimo.setBounds(41, 128, 148, 14);
		contentPane.add(lblValorMinimo);

		// BOTAO CADASTRAR ALIMENTO
		btnNewButton = new JButton("CADASTRAR ALIMENTO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alimento = CadastroAlimento.getText();
				String valorminimo = CadastroValorMinimo.getText();

				// LER ARQUIVO
				Scanner scanner;
				try {
					scanner = new Scanner(new FileReader("ArquivoAlimentos.txt")).useDelimiter("\\||\\n");
					while (scanner.hasNext()) {
						String alimento1 = scanner.next();
						String valorminimo1 = scanner.next();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				// SE TIVER CAMPO VAZIO
				if (alimento.equals("") || valorminimo.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os espaços!", "Erro no cadastro",
							JOptionPane.WARNING_MESSAGE);
				}

				else {

					// ESCREVER NO ARQUIVO
					try {
						FileWriter arquivo = new FileWriter("ArquivoAlimentos.txt", true);
						arquivo.write(alimento + "\n");
						arquivo.write(valorminimo + "\n");
						arquivo.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					// ABRE JANELA PRINCIPAL
					JanelaPrincipal janela = new JanelaPrincipal();
					janela.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(233, 203, 167, 23);
		contentPane.add(btnNewButton);

		// BOTÃO VOLTAR
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ABRE JANELA PRINCIPAL
				JanelaPrincipal janela = new JanelaPrincipal();
				janela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(41, 203, 167, 23);
		contentPane.add(btnVoltar);
	}
}