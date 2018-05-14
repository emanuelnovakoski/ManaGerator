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

public class JanelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField CadastroNome;
	private JTextField CadastroEmail;
	private JTextField CadastroTelefone;
	private JTextField CadastroSenha;
	private JTextField CadastroConfirmacaoSenha;
	private JButton btnNewButton;
	private JButton btnVoltar;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//JANELA DE CADASTRO
	public JanelaCadastro() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//TEXTO TITULO
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setBounds(188, 11, 127, 19);
		contentPane.add(lblCadastro);

		//CAMPO USERNAME
		CadastroNome = new JTextField();
		CadastroNome.setBounds(157, 67, 243, 20);
		contentPane.add(CadastroNome);
		CadastroNome.setColumns(10);

		//CAMPO EMAIL
		CadastroEmail = new JTextField();
		CadastroEmail.setBounds(157, 93, 243, 20);
		contentPane.add(CadastroEmail);
		CadastroEmail.setColumns(10);

		//CAMPO TELEFONE
		CadastroTelefone = new JTextField();
		CadastroTelefone.setBounds(157, 124, 243, 20);
		contentPane.add(CadastroTelefone);
		CadastroTelefone.setColumns(10);

		//CAMPO SENHA
		CadastroSenha = new JTextField();
		CadastroSenha.setBounds(157, 155, 243, 20);
		contentPane.add(CadastroSenha);
		CadastroSenha.setColumns(10);

		//TEXTO USERNAME
		JLabel lblNome = new JLabel("Username: ");
		lblNome.setBounds(41, 67, 106, 14);
		contentPane.add(lblNome);

		//TEXTO EMAIL
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(41, 93, 106, 14);
		contentPane.add(lblEmail);

		//TEXTO TELEFONE
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(41, 124, 106, 14);
		contentPane.add(lblTelefone);

		//TEXTO SENHA
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(41, 155, 106, 14);
		contentPane.add(lblSenha);

		//CAMPO CONFIRMACAO DE SENHA
		CadastroConfirmacaoSenha = new JTextField();
		CadastroConfirmacaoSenha.setBounds(157, 183, 243, 20);
		contentPane.add(CadastroConfirmacaoSenha);
		CadastroConfirmacaoSenha.setColumns(10);

		//TEXTO CONFIRMACAO DE SENHA
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(41, 186, 106, 14);
		contentPane.add(lblConfirmarSenha);

		//BOTÃO CADASTRAR
		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = CadastroNome.getText();
				String email = CadastroEmail.getText();
				String telefone = CadastroTelefone.getText();
				String senha = CadastroSenha.getText();
				String confirmacaosenha = CadastroConfirmacaoSenha.getText();
				int jaexiste=0;

				//LER ARQUIVO
				Scanner scanner;
				try {
					scanner = new Scanner(new FileReader("Arquivo.txt"))
							.useDelimiter("\\||\\n");
					while (scanner.hasNext()&&jaexiste==0) {
						String nome1 = scanner.next();
						String email1 = scanner.next();
						String telefone1 = scanner.next();
						String senha1 = scanner.next();
						if(nome1.equals(nome)) {
							jaexiste=1;
						}
					}
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				//SE TEM CAMPO EM BRANCO
				if(nome.equals("")||email.equals("")||telefone.equals("")||senha.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Preencha todos os espaços!", "Erro no cadastro",JOptionPane.WARNING_MESSAGE);
				}

				//SE USERNAME JA EXISTE
				else if(jaexiste==1)
				{
					JOptionPane.showMessageDialog(null, "Username ja existe!", "Erro no cadastro",JOptionPane.WARNING_MESSAGE);
				}

				//SE SENHAS INCOMPATIVEIS
				else if(!(senha.equals(confirmacaosenha))){
					JOptionPane.showMessageDialog(null, "Senhas incompativeis!", "Erro no cadastro",JOptionPane.WARNING_MESSAGE);
				}

				else {

					//ESCREVER NO ARQUIVO
					try {
						FileWriter arquivo = new FileWriter("Arquivo.txt",true);
						arquivo.write(nome+"\n");
						arquivo.write(email+"\n");
						arquivo.write(telefone+"\n");
						arquivo.write(senha+"\n");
						arquivo.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					//ABRI JANELA INICIAL
					JanelaInicial janela = new JanelaInicial();
					janela.setVisible(true);
					dispose();	
				}}
		});
		btnNewButton.setBounds(233, 227, 167, 23);
		contentPane.add(btnNewButton);

		//BOTÃO VOLTAR
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//ABRE JANELA INICIAL
				JanelaInicial janela = new JanelaInicial();
				janela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(41, 227, 167, 23);
		contentPane.add(btnVoltar);

		//TEXTO SUBTITULO
		lblNewLabel_1 = new JLabel("Preencha os campos e clique em cadastrar para realizar o cadastro!");
		lblNewLabel_1.setBounds(58, 35, 342, 14);
		contentPane.add(lblNewLabel_1);
	}
}

