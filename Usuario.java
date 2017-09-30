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
	 
	/**Construtor da classe
	 * @param String nome
	 * @param int idade
	 */
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
	
	 /**Método set para Nome
	  * @param String nome - Nome do usuário
	  */
	private void setNome(String nome){
		this.Nome =  nome; /** Alterando o atributo*/
	}
	
	/**Método set para Idade
	 * @param  int idade - Idade do usuário
     */
	private void setIdade(int idade){
		if(idade >= 18)
			this.Idade =  idade; /** Alterando o atributo*/
		else
			JOptionPane.showMessageDialog(null, 
					"Desculpe, mas você não possui 18 anos para poder dirigir", 
					null, JOptionPane.ERROR_MESSAGE);
	}
	
	/**Método set para Usuário
     * @param  boolean - Nome para o usuário
     */
	private void setUser(boolean x) {
		this.User = x;
	}
	
	/**Método get para o Nome
	 * @return String - Retorna o nome do usuário.
     */
	public String getNome(){
		return this.Nome;  /**@return Nome*/
	}

	/**Método get para Idade
	 * @return int - Retorna a idade do usuário.
     */
	public int getIdade(){
		return this.Idade; /**@return Idade*/
	}
	
	/**Método get para o Usuario
	 * @return boolean - Retorna positivo se usuário existe, negativo se não.
     */
	public boolean getUser() {
		return User; 
	}
}



/**Método para calculo do valor da bonificação baseada na
 * seguinte faixa de valores: Para vendas menores de
 * 25.000,00, o percentual de comissão aplicado será de 5%, e * para valores iguais ou maiores de 25.000,00, o percentual
 * será de 10%
 * @author Manoel Pimentel
 * @param  valorVendas - Valor total das vendas do mês
 * @return Double - Valor do resultado do cálculo conforme a faixa de comissões.
 */
