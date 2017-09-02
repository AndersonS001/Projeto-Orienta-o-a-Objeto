import javax.swing.JOptionPane;


public class Usuario extends CriaVeiculo{
	private String Nome;
	private int Idade;
	private boolean User;
	
	public Usuario(String nome, int idade){
		if(nome == ""){
			setNome("Padrão");
			setIdade(18);
			setUser(true);
		}else if(idade == 0){
			setNome(nome);
			setIdade(18);
			setUser(true);
		}else {
			setIdade(idade);
			setUser(false);
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
			JOptionPane.showMessageDialog(null, "Desculpe, mas você não possui 18 anos para poder dirigir", null, JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void setUser(boolean x) {
		this.User = x;
	}
	
	public String getNome(){
		return this.Nome;
	}
	public int getIdade(){
		return this.Idade;
	}
	public boolean getUser() {
		return User;
	}
}
