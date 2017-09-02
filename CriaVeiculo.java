import javax.swing.*;
/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 * A classe Cria Veiculo, herda os dados da classe veículo e adiciona propriedades mais específicas.
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
	 * Método público para ligar o Ar condicionado
	 */
	public void ligaAr(){
		if(!getArCondicionado() && !getJanelaAberta()){ /** Condicional para ligação do ar*/
			//System.out.println("Ar condicionado ligado");
			JOptionPane.showMessageDialog(null, "Ar condicionado ligado"); /** Mensagem de sucesso na condição*/
			setArCondicionado(true); /** Chamando método set que seta o ar em ligado.*/
		}
		/***
		 * Se não
		 */
		else
			//System.out.println("Por favor, feche a janela antes de ligar o ar");
			JOptionPane.showMessageDialog(null, "Por favor, feche a janela antes de ligar o ar"); /** Mensagem de erro na condição*/
	}
	/**
	 * Método público para desligar o Ar Condicionado.
	 */
	public void desligaAr(){
		/** Condicional para garantir que o Ar esteja ligado.*/
		if(getArCondicionado()){ 
			//System.out.println("Ar desligado");
			/**Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Ar desligado");
			/**Método set que altera o atribur ArCondicionado*/
			setArCondicionado(false);
		}
		/**Se não*/
		else
			//System.out.println("O Ar ja está desligado");
			/**Mensagem de erro na condição*/
			JOptionPane.showMessageDialog(null, "O Ar ja está desligado");
	}
	/**
	 * Método público que trava a porta do carro.
	 */
	public void travaPorta(){
		/**Condicional para travar a porta*/
		if(getCarroLigado() && getCarroAndando()){
			/**Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Porta travada");
			/**Setando o atributo Porta Destravada em falso*/
			setPortaDestravada(false);
		}else{
			/**Mensagem de erro na condição*/
			JOptionPane.showMessageDialog(null, "Seu carro não está em movimento, não se preocupe, em breve será travado");
			//System.out.println("Seu carro não está em movimento, não se preocupe, em breve será travado");
		}	
	}
	/**
	 * Método público que destrava a porta do carro.
	 */
	public void destravaPorta() {
		/**Condicional para destravar a porta*/
		if(getCarroLigado() && !getCarroAndando()) {
			/**Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Porta destravada");
			/**Setando o atributo Porta Destravada em verdadeiro*/
			setPortaDestravada(true);
		}else{
			/**Mensagem de erro na condição*/
			JOptionPane.showMessageDialog(null, "A porta do seu carro já está destravada");
			//System.out.println("Seu carro não está em movimento, não se preocupe, em breve será travado");
		}	
	}
	
	/**
	 * Método público que abre a janela do carro.
	 */
	public void abrirJanela() {
		/**Condicional para abrir a janela*/
		if(!getJanelaAberta()) {
			/** Setando o atributo como verdadeiro*/
			setJanelaAberta(true);
			//System.out.println("Abrindo a janela");
			/**Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Abrindo a janela");
		}else {
			//System.out.println("Janela ja aberta");
			/**Mensagem de erro na condição*/
			JOptionPane.showMessageDialog(null, "Janela já aberta");
		}
	}
	/**
	 * Método público para fechar a janela
	 */
	public void fecharJanela() {
		/** Condicional para fechar a janela*/
		if(getJanelaAberta()) {
			/**Setando o atributo da janela como aberta*/
			setJanelaAberta(false);
			//System.out.println("Fechando a janela
			/**Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Fechando a janela");
		}else{
			//System.out.println("Janela já fechada");
			/**Mensagem de erro na condição*/
			JOptionPane.showMessageDialog(null, "Janela já fechada");
		}
	}
		
	/**Método set privado do atributo PortaDestravada*/
	private void setPortaDestravada(boolean cond) {
		PortaDestravada = cond;
	}
	/**Método get protegido do atributo PortaDestravada*/
	protected boolean getPortaDestravada() {
		/**Retorno da função*/
		return PortaDestravada; 
	}
	/**Método set privado do atributo Janela aberta*/
	private void setJanelaAberta(boolean cond){
		JanelaAberta = cond;
	}
	/**Método get protegido do atributo Janela aberta*/
	protected boolean getJanelaAberta() {
		/**Retorno da função*/
		return JanelaAberta;
	}
	/**Método set privado do atributo ArCondicionado*/
	private void setArCondicionado(boolean cond){
		ArCondicionado = cond;
	}
	/**Método get protegido do atributo ArCondicionado*/
	protected boolean getArCondicionado() {
		/**Retorno da função*/
		return ArCondicionado;
	}
}