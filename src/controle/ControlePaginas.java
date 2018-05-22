package controle;

import javax.swing.JFrame;

import classes.Insere;
import classes.MenuInicial;

public class ControlePaginas  extends JFrame{
	
	
	
	// INSERE
	public void inserir() {
		Insere janela = new Insere();
		janela.setVisible(true);
		dispose();
	}

	// INICIO
	public  void inicio() {
		MenuInicial janela = new MenuInicial();
		janela.setVisible(true);
		dispose();
	}
	
	
	
	
	
	
	
	
	
	

}
