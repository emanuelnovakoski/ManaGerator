package classes;
//BIBLIOTECAS
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//MENU INICIAL
	public MenuInicial() {	
		janela();
		textos();
		botoes();
	}

	//FORMATA OS BOTÕES
	private void botoes() {
		
		//BOTÃO ENTRAR
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnEntrar.setBounds(126, 120, 202, 23);
		contentPane.add(btnEntrar);

		//BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				cadastro();
			}
		});
		btnCadastrar.setBounds(126, 158, 202, 23);
		contentPane.add(btnCadastrar);
	}

	// FORMATA OS TEXTOS
	private void textos() {
		
		//TEXTO TITULO
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao MANAGERATOR !!!!");
		lblBemVindoAo.setBounds(149, 54, 189, 14);
		contentPane.add(lblBemVindoAo);

		//TEXTO SUBTITULO
		JLabel lblFaaSeuLogin = new JLabel("Fa\u00E7a seu login ou cadastre-se  para acessar o sistema");
		lblFaaSeuLogin.setBounds(94, 79, 277, 14);
		contentPane.add(lblFaaSeuLogin);
	}

	// FORMATA A JANELA
	private void janela() {
		setTitle("INTERFACE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	//LOGIN
	private void login() {
		Login Login = new Login();
		Login.setVisible(true);
		dispose();
	}
	
	//CADASTRO
	private void cadastro() {
		//ABRE JANELA CADASTRO
		Cadastros Cadastros = new Cadastros();
		Cadastros.setVisible(true);
		dispose();
	}

}
