import javax.swing.*;
/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 * A classe Cria Veiculo, herda os dados da classe ve�culo e adiciona propriedades mais espec�ficas.
 */
public class CriaVeiculo extends Veiculo {
	/**
	 * Atributos privados da classe.
	 */
	private boolean ArCondicionado = false;
	private boolean JanelaAberta = false;
	private boolean PortaDestravada = false;
	
	
	/**
	 * Construtor da classe.
	 */
	public CriaVeiculo(){//boolean Janela){
		//JanelaAberta = Janela;
	}
	
	/**
	 * M�todo p�blico para ligar o Ar condicionado
	 */
	public void ligaAr(){
		if(!getArCondicionado() && !getJanelaAberta()){ /** Condicional para liga��o do ar*/
			//System.out.println("Ar condicionado ligado");
			JOptionPane.showMessageDialog(null, "Ar condicionado ligado"); /** Mensagem de sucesso na condi��o*/
			setArCondicionado(true); /** Chamando m�todo set que seta o ar em ligado.*/
		}
		/***
		 * Se n�o
		 */
		else
			//System.out.println("Por favor, feche a janela antes de ligar o ar");
			JOptionPane.showMessageDialog(null, "Por favor, feche a janela antes de ligar o ar"); /** Mensagem de erro na condi��o*/
	}
	/**
	 * M�todo p�blico para desligar o Ar Condicionado.
	 */
	public void desligaAr(){
		/** Condicional para garantir que o Ar esteja ligado.*/
		if(getArCondicionado()){ 
			//System.out.println("Ar desligado");
			/**Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Ar desligado");
			/**M�todo set que altera o atribur ArCondicionado*/
			setArCondicionado(false);
		}
		/**Se n�o*/
		else
			//System.out.println("O Ar ja est� desligado");
			/**Mensagem de erro na condi��o*/
			JOptionPane.showMessageDialog(null, "O Ar ja est� desligado");
	}
	/**
	 * M�todo p�blico que trava a porta do carro.
	 */
	public void travaPorta(){
		/**Condicional para travar a porta*/
		if(getCarroLigado() && getCarroAndando()){
			/**Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Porta travada");
			/**Setando o atributo Porta Destravada em falso*/
			setPortaDestravada(false);
		}else{
			/**Mensagem de erro na condi��o*/
			JOptionPane.showMessageDialog(null, "Seu carro n�o est� em movimento, n�o se preocupe, em breve ser� travado");
			//System.out.println("Seu carro n�o est� em movimento, n�o se preocupe, em breve ser� travado");
		}	
	}
	/**
	 * M�todo p�blico que destrava a porta do carro.
	 */
	public void destravaPorta() {
		/**Condicional para destravar a porta*/
		if(getCarroLigado() && !getCarroAndando()) {
			/**Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Porta destravada");
			/**Setando o atributo Porta Destravada em verdadeiro*/
			setPortaDestravada(true);
		}else{
			/**Mensagem de erro na condi��o*/
			JOptionPane.showMessageDialog(null, "A porta do seu carro j� est� destravada");
			//System.out.println("Seu carro n�o est� em movimento, n�o se preocupe, em breve ser� travado");
		}	
	}
	
	/**
	 * M�todo p�blico que abre a janela do carro.
	 */
	public void abrirJanela() {
		/**Condicional para abrir a janela*/
		if(!getJanelaAberta()) {
			/** Setando o atributo como verdadeiro*/
			setJanelaAberta(true);
			//System.out.println("Abrindo a janela");
			/**Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Abrindo a janela");
		}else {
			//System.out.println("Janela ja aberta");
			/**Mensagem de erro na condi��o*/
			JOptionPane.showMessageDialog(null, "Janela j� aberta");
		}
	}
	/**
	 * M�todo p�blico para fechar a janela
	 */
	public void fecharJanela() {
		/** Condicional para fechar a janela*/
		if(getJanelaAberta()) {
			/**Setando o atributo da janela como aberta*/
			setJanelaAberta(false);
			//System.out.println("Fechando a janela
			/**Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Fechando a janela");
		}else{
			//System.out.println("Janela j� fechada");
			/**Mensagem de erro na condi��o*/
			JOptionPane.showMessageDialog(null, "Janela j� fechada");
		}
	}
		
	/**M�todo set privado do atributo PortaDestravada*/
	private void setPortaDestravada(boolean cond) {
		PortaDestravada = cond;
	}
	/**M�todo get protegido do atributo PortaDestravada*/
	protected boolean getPortaDestravada() {
		/**Retorno da fun��o*/
		return PortaDestravada; 
	}
	/**M�todo set privado do atributo Janela aberta*/
	private void setJanelaAberta(boolean cond){
		JanelaAberta = cond;
	}
	/**M�todo get protegido do atributo Janela aberta*/
	protected boolean getJanelaAberta() {
		/**Retorno da fun��o*/
		return JanelaAberta;
	}
	/**M�todo set privado do atributo ArCondicionado*/
	private void setArCondicionado(boolean cond){
		ArCondicionado = cond;
	}
	/**M�todo get protegido do atributo ArCondicionado*/
	protected boolean getArCondicionado() {
		/**Retorno da fun��o*/
		return ArCondicionado;
	}
}