import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Veiculo v1 =  new Veiculo();
		CriaVeiculo v2 = new CriaVeiculo();
		
		Usuario u2 = new Usuario(JOptionPane.showInputDialog("Por favor, digite seu nome: "), 
				Integer.parseInt(JOptionPane.showInputDialog("Por favor, digite sua idade: ")));
		
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
