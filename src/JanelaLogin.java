import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Senha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin frame = new JanelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//JANELA DE LOGIN
	public JanelaLogin() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//TEXTO USERNAME
		JLabel lblLogin = new JLabel("Usuario:");
		lblLogin.setBounds(64, 105, 59, 14);
		contentPane.add(lblLogin);

		//TEXTO SENHA
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(64, 133, 68, 14);
		contentPane.add(lblSenha);

		//CAMPO USERNAME
		Usuario = new JTextField();
		Usuario.setBounds(142, 102, 223, 20);
		contentPane.add(Usuario);
		Usuario.setColumns(10);

		//CAMPO SENHA
		Senha = new JPasswordField();
		Senha.setBounds(142, 133, 223, 20);
		contentPane.add(Senha);

		//BOTÃO ENTRAR
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String user = Usuario.getText();
				String senha = Senha.getText();

				//LER ARQUIVO
				Scanner scanner;
				try {
					scanner = new Scanner(new FileReader("Arquivo.txt"))
							.useDelimiter("\\||\\n");
					int igual = 0;
					while (scanner.hasNext()&&igual==0) {
						String nome = scanner.next();
						String email = scanner.next();
						String numero = scanner.next();
						String senha1 = scanner.next();
						if(nome.equals(user)&&senha1.equals(senha)) {
							igual=1;
						}
					}

					//SE VALIDO
					if(igual==1)
					{
						JanelaPrincipal janelaprincipal = new JanelaPrincipal();
						janelaprincipal.setVisible(true);
						dispose();	
					}

					//SE DADOS INCORRETOS
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!", "Erro no login",JOptionPane.WARNING_MESSAGE);

					}}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
				);
		btnEntrar.setBounds(229, 179, 126, 23);
		contentPane.add(btnEntrar);

		//TEXTO TITULO
		JLabel lblFazerLogin = new JLabel("Fazer Login");
		lblFazerLogin.setBounds(193, 27, 89, 14);
		contentPane.add(lblFazerLogin);

		//BOTÃO VOLTAR
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaInicial janela = new JanelaInicial();
				janela.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(75, 179, 126, 23);
		contentPane.add(btnNewButton);

		//TEXTO SUBTITULO
		JLabel lblDigiteSeuUsuario = new JLabel("Digite seu usuario e senha !");
		lblDigiteSeuUsuario.setBounds(152, 52, 200, 14);
		contentPane.add(lblDigiteSeuUsuario);
	}
}
