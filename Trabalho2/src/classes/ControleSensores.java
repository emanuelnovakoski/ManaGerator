package classes;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ControleSensores extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleSensores frame = new ControleSensores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JANELA DE CONTROLE
	@SuppressWarnings("unchecked")
	public ControleSensores() {
		setTitle("CONTROLE");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LISTA DE ALIMENTOS

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Alimentos:");

		leArquivo(comboBox);
		comboBox.setBounds(49, 70, 330, 20);
		contentPane.add(comboBox);

		// SPINNER NIVEIS DE GASES
		JSpinner Qualidade = new JSpinner();
		Qualidade.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		Qualidade.setBounds(298, 148, 81, 20);
		contentPane.add(Qualidade);

		// SPINNER QUANTIDADE
		JSpinner Itens = new JSpinner();
		Itens.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		Itens.setBounds(298, 98, 80, 20);
		contentPane.add(Itens);

		// SPINNER NIVEIS DE NOTIFICAÇÃO
		JSpinner Informacao = new JSpinner();
		Informacao.setBounds(298, 123, 81, 20);
		contentPane.add(Informacao);

		// BOTÃO ATUALIZAR
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaSensores(comboBox, Qualidade, Itens, Informacao);
			}

			
		});
		btnAtualizar.setBounds(91, 196, 243, 23);
		contentPane.add(btnAtualizar);

		// TEXTO VALOR LIMITE
		JLabel lblQuantidade = new JLabel("Valor limite para notifica\u00E7\u00E3o:");
		lblQuantidade.setBounds(49, 126, 231, 14);
		contentPane.add(lblQuantidade);

		// TEXTO QUANTIDADE
		JLabel lblNewLabel = new JLabel("Quantidade de itens:");
		lblNewLabel.setBounds(49, 101, 202, 14);
		contentPane.add(lblNewLabel);

		// TEXTO NIVEIS DOS GASES
		JLabel lblNewLabel_1 = new JLabel("Niveis de gases indicativos no ar:");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(49, 151, 202, 14);
		contentPane.add(lblNewLabel_1);

		// TEXTO TITULO
		JLabel lblNewLabel_2 = new JLabel("Tela de controle (simula\u00E7\u00E3o)");
		lblNewLabel_2.setBounds(147, 11, 187, 14);
		contentPane.add(lblNewLabel_2);

		// TEXTO SUBTITULO
		JLabel lblNewLabel_3 = new JLabel("Preencha os campos com os valores dos sensores!");
		lblNewLabel_3.setBounds(88, 36, 307, 14);
		contentPane.add(lblNewLabel_3);
	}
	
	@SuppressWarnings("rawtypes")
	private void atualizaSensores(JComboBox comboBox, JSpinner Qualidade, JSpinner Itens, JSpinner Informacao) {
		String tipoComida = comboBox.getSelectedItem() + "";
		int valorAr = (Integer) Qualidade.getValue();
		int valorItem = (Integer) Itens.getValue();
		int valorInfo = (Integer) Informacao.getValue();

		// SE NÃO SELECIONOU ALIMENTO
		if (tipoComida.equals("Alimentos:")) {
			JOptionPane.showMessageDialog(null, "Selecione um alimento", "Erro ao checar",
					JOptionPane.WARNING_MESSAGE);
		}

		else {
			int notifica = 0;

			notifica = leArquivoAlimentos(tipoComida, valorAr, valorItem, valorInfo, notifica);

			exibeNotificacao(tipoComida, notifica);
		}
		
		//ABRE JANELA CONTROLE
		ControleSensores ControleSensores = new ControleSensores();
		ControleSensores.setVisible(true);
	    ControleSensores.setLocation(600,100);
	    dispose();
	}

	private void exibeNotificacao(String tipoComida, int notifica) {
		// MENSAGEM ESTA SEM ITENS NA GELADEIRA
		if (notifica == 1) {
			JOptionPane.showMessageDialog(null, "Produto \"" + tipoComida + "\" faltando!",
					"Erro no cadastro", JOptionPane.WARNING_MESSAGE);
		}

		// MENSAGEM OS VALOREIS ESTÃO ABAIXO DO LIMITE DE NOTIFICAÇÃO
		else if (notifica == 2) {
			JOptionPane.showMessageDialog(null, "Niveis do produto \"" + tipoComida + "\" baixos!",
					"Erro no cadastro", JOptionPane.WARNING_MESSAGE);
		}

		// MENSAGEM PRODUTO IMPROPRIO PARA CONSUMO
		else if (notifica == 3) {
			JOptionPane.showMessageDialog(null, "Produto \"" + tipoComida + "\" improprio para consumo",
					"Erro no cadastro", JOptionPane.WARNING_MESSAGE);
		}
	}

	@SuppressWarnings("resource")
	private int leArquivoAlimentos(String tipoComida, int valorAr, int valorItem, int valorInfo, int notifica) {
		// LE ARQUIVO
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader("ArquivoAlimentos.txt")).useDelimiter("\\||\\n");

			while (scanner.hasNext() && notifica == 0) {
				String ali = scanner.next();
				System.out.println(ali);
				String lim = scanner.next();

				notifica = testaSensores(tipoComida, valorAr, valorItem, valorInfo, notifica, ali, lim);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return notifica;
	}
	

	private int testaSensores(String tipoComida, int valorAr, int valorItem, int valorInfo, int notifica, String ali,
			String lim) {
		// SE ENCONTROU A COMIDA REFERENTE
		if (tipoComida.equals(ali)) {

			// SE ESTA SEM ITENS NA GELADEIRA
			if (valorItem <= 0) {
				notifica = 1;
			}

			// SE OS VALOREIS ESTÃO ABAIXO DO LIMITE DE NOTIFICAÇÃO
			else if (Integer.parseInt(lim) > valorInfo) {

				notifica = 2;
			}

			// SE OS NIVEIS DOS GASES ESTÃO ACIMA
			else if (valorAr > 500) {
				notifica = 3;
			}
		}
		return notifica;
	}
	@SuppressWarnings({ "rawtypes", "resource", "unchecked" })
	private void leArquivo(JComboBox comboBox) {
		// LER ARQUIVO
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader("ArquivoAlimentos.txt")).useDelimiter("\\||\\n");
			while (scanner.hasNext()) {
				String alimento = scanner.next();
				scanner.next();
				comboBox.addItem(alimento);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
