import javax.swing.JOptionPane;
/**
 * 
 * @author unifasouza
 * Classe que cria um usuário para controlar o veículo.
 */
public class Usuario extends CriaVeiculo{
	/**Atributos usuários*/
	private String Nome;
	private int Idade;
	private boolean User;
	 
	/**Construtor da classe*/
	public Usuario(String nome, int idade){
		/**Condicional de criação*/
		if(nome == ""){
			setNome("Padrão"); /** Alterando o atributo via método set*/
			setIdade(18);/** Alterando o atributo via método set*/
			setUser(true);/** Alterando o atributo via método set*/
		}else if(idade == 0){ /**Else*/
			setNome(nome); /** Alterando o atributo via método set*/
			setIdade(18);/** Alterando o atributo via método set*/
			setUser(true);/** Alterando o atributo via método set*/
		}else {
			setIdade(idade);/** Alterando o atributo via método set*/
			setUser(false);/** Alterando o atributo via método set*/
		}
	}
	
	 /**Método set para Nome*/
	private void setNome(String nome){
		this.Nome =  nome; /** Alterando o atributo*/
	}
	
	/**Método set para Idade*/
	private void setIdade(int idade){
		if(idade >= 18)
			this.Idade =  idade; /** Alterando o atributo*/
		else
			JOptionPane.showMessageDialog(null, 
					"Desculpe, mas você não possui 18 anos para poder dirigir", 
					null, JOptionPane.ERROR_MESSAGE); /**Retorno erro*/
	}
	
	/**Método set para Usuário*/
	private void setUser(boolean x) {
		this.User = x; /** Alterando o atributo*/
	}
	
	/**Método get para o Nome*/
	public String getNome(){
		return this.Nome;  /**@return Retornando o atributo*/
	}

	/**Método get para Idade*/
	public int getIdade(){
		return this.Idade; /**@return Retornando o atributo*/
	}
	
	/**Método get para o Usuario*/
	public boolean getUser() {
		return User; /**@return Retornando o atributo*/
	}
}
