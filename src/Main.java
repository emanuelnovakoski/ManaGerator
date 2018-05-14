
public class Main {
	
	public static void main(String[] args) {
		
		//ABRE JANELA INICIAL
		JanelaInicial janela = new JanelaInicial();
		janela.setVisible(true);
		
	    //ABRE JANELA DE CONTROLE
		JanelaControle janelacontrole = new JanelaControle();
		janelacontrole.setVisible(true);
	    janelacontrole.setLocation(600,100);
	}
}
