package classes;
/**
 * Blibliotecas importadas para classe
 */

/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 * A classe veiculo molda um objeto carro de forma gen�rica.
 */

public abstract class Veiculo { 
	/** Atributos da classe */
	protected boolean CarroLigado=false; 
	protected boolean Janela = false;
	protected boolean Porta =false;
	
	/**
	 * Método construtor da classe que inicia os atributos do carro como padr�es.
	 */
	public Veiculo(){}
	
	/** Método público para ligar o carro 
	 * 
	 * @return boolean
	 */
	public abstract void ligarCarro(); 
	protected void setCarroLigado(boolean cond) {
		this.CarroLigado = cond;
	}
	
	/** Método get protegido do Carro Ligado para retornar o atributo carroLigado
	 * 
	 * @return boolean CarroLigado
	 */
	public boolean getCarroLigado(){
		return CarroLigado; /** Retornando o atributo*/
	}
	protected void setPorta(boolean cond){ // Usando como referencia ela travada
		Porta = cond;
	}
	
	/**Método get do atributo Porta*/
	public boolean isPorta() {
		/**Retorno da função é a situação booleana da Porta*/
		return Porta; 
	}
	
	/**Método set do atributo Janela aberta*/
	protected void setJanela(boolean cond){
		Janela = cond;
	}
	public boolean isJanela() {
		/**Retorno da função é a situação booleana da Janela*/
		return Janela;
	}

	protected abstract void abrirJanela();
	protected abstract void fecharJanela();
}
