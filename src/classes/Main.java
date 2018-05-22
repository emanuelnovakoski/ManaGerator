package classes;

public class Main {
	
	public static void main(String[] args) {
		
		//ABRE JANELA INICIAL
		MenuInicial janela = new MenuInicial();
		janela.setVisible(true);
		
	    //ABRE JANELA DE CONTROLE
		ControleSensores ControleSensores = new ControleSensores();
		ControleSensores.setVisible(true);
	    ControleSensores.setLocation(600,100);
	}
}
