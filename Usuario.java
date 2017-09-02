import javax.swing.JOptionPane;


public class Usuario extends CriaVeiculo{
	private String Nome;
	private int Idade;
		
	public Usuario(String nome, int idade){
		if(nome == ""){
			setNome("Padrão");
			setIdade(18);
		}else{
			setNome(nome);
			setIdade(idade);
		}
	} 
	
	private void setNome(String nome){
		this.Nome =  nome;
	}
	private void setIdade(int idade){
		if(idade >= 18)
			this.Idade =  idade;
		else
			//System.out.println("Você não possui 18 anos para poder dirigir");
			JOptionPane.showMessageDialog(null, "Você não possui 18 anos para poder dirigir", null, JOptionPane.ERROR_MESSAGE);
		
	}
	
	public String getNome(){
		return this.Nome;
	}
	public int getIdade(){
		return this.Idade;
	}
}
