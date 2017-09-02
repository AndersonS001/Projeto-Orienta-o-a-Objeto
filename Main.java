import javax.swing.JOptionPane;
/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 *Classe principal da função
 */
public class Main {
	/**Método principal da função*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Veiculo v1 =  new Veiculo();
		//CriaVeiculo v2 = new CriaVeiculo();
		/**Declarando um objeto usuário*/
		Usuario u2 = new Usuario(JOptionPane.showInputDialog("Por favor, digite seu nome: "), 
				JOptionPane.showConfirmDialog(null,"Você possui mais de 18 anos? ",null, JOptionPane.YES_NO_OPTION));

		if(u2.getUser()) {
			/**Fazendo testes dos métodos*/
			u2.ligarCarro();
			u2.virarDireita();
			u2.ligaAr();
			u2.ligarCarro();
			u2.ligaAr();
			u2.fecharJanela();
			u2.ligaAr();
			u2.travaPorta();
			u2.desligarCarro();
		}
	}
}
