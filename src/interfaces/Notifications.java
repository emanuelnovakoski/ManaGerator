package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Notifications extends JFrame {
	private static final long serialVersionUID = 1L;

	public void picture() {
		JOptionPane.showMessageDialog(null, "Foto das prateleiras enviada com sucesso", "Foto!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void incorrectData() {
		JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!", "Erro no login",
				JOptionPane.WARNING_MESSAGE);
	}

	public void empty() {
		JOptionPane.showMessageDialog(null, "Preencha todos os espaços!", "Erro no cadastro",
				JOptionPane.WARNING_MESSAGE);
	}

	public void missingIten(String foodName) {
		JOptionPane.showMessageDialog(null, "Produto \"" + foodName + "\" faltando!", "Erro no cadastro",
				JOptionPane.WARNING_MESSAGE);
	}

	public void lowLevels(String foodName) {
		JOptionPane.showMessageDialog(null, "Niveis do produto \"" + foodName + "\" baixos!", "Erro no cadastro",
				JOptionPane.WARNING_MESSAGE);
	}

	public void improperConsumption(String foodName) {
		JOptionPane.showMessageDialog(null, "Produto \"" + foodName + "\" improprio para consumo", "Erro no cadastro",
				JOptionPane.WARNING_MESSAGE);
	}

	public void selectFood() {
		JOptionPane.showMessageDialog(null, "Selecione um alimento", "Erro ao checar", JOptionPane.WARNING_MESSAGE);
	}

	public void usernameExist() {
		JOptionPane.showMessageDialog(null, "Username ja existe!", "Erro no cadastro", JOptionPane.WARNING_MESSAGE);
	}

	public void incompatiblePasswords() {
		JOptionPane.showMessageDialog(null, "Senhas incompativeis!", "Erro no cadastro", JOptionPane.WARNING_MESSAGE);
	}

	public void foodExist() {
		JOptionPane.showMessageDialog(null, "Alimento inserido ja existe!", "Erro no cadastro",
				JOptionPane.WARNING_MESSAGE);
	}
}
