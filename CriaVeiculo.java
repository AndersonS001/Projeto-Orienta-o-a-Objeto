package classes;
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
	private boolean ArCondicionado;
	private String estacaoRadio;
	
	/**
	 * Construtor da classe.
	 * @param ar
	 * @param janela
	 * @param porta
	 * @param estacao
	 */
	public CriaVeiculo(boolean ar, boolean janela, boolean porta, String estacao){
		setArCondicionado(ar);
		setJanela(janela);
		setPorta(porta);
		setEstacaoRadio(estacao);
	}
	
	/**
	 * Método público para ligar ou desligar o Ar condicionado
	 */
	public void ligdesAr(){
		if(!isArCondicionado() && !isJanela()){ 							/* Condicional para liga��o do ar*/
			JOptionPane.showMessageDialog(null, "Ligando ar condicionado"); /* Mensagem de sucesso na condição*/
			setArCondicionado(true); 										/* Chamando Método set que seta o ar em ligado.*/
		}
		else if(!isArCondicionado() && isJanela()) {  //Fecha a Janela e liga o Ar condicionado
			fecharJanela();
			JOptionPane.showMessageDialog(null, "Ligando ar condicionado");
			setArCondicionado(true);
		}
		else { // Desliga o ar
			JOptionPane.showMessageDialog(null, "Desligando ar condicionado");
			setArCondicionado(false);
		}
	}

	public void travaPorta(){
		JOptionPane.showMessageDialog(null, "Porta travada");
		setPorta(true);
	}
	
	/** Método público que destrava a porta do carro. */
	public void destravaPorta() {										/*Condicional para destravar a porta*/
			JOptionPane.showMessageDialog(null, "Porta destravada");
			setPorta(false);
	}
	
	/**Método público que abre a janela do carro.*/
	public void abrirJanela() { /*Condicional para abrir a janela*/
		if(!isJanela() && isArCondicionado()) {
			setJanela(true);
			JOptionPane.showMessageDialog(null, "Abrindo a janela");
		}else if(!isJanela() && !isArCondicionado()) {
			setJanela(true);
			JOptionPane.showMessageDialog(null, "Abrindo a janela");
		}
	}
	
	
	/** Método p�blico para fechar a janela */
	public void fecharJanela() {	/* Condicional para fechar a janela*/
		if(isJanela()) {			/*Setando o atributo da janela como aberta*/
			setJanela(false);
			JOptionPane.showMessageDialog(null, "Fechando a janela");
		}
	}
	
	/**Método set privado do atributo ArCondicionado*/
	private void setArCondicionado(boolean cond){
		ArCondicionado = cond;
	}
	
	/**Método get do atributo ArCondicionado*/
	public boolean isArCondicionado() {
		/**Retorno da fun��o*/
		return ArCondicionado;
	}
	
	/**Método get da estação de Rádio*/
	public String getEstacaoRadio() {
		return estacaoRadio;
	}
	
	/**Método set da estação de Rádio*/
	public void setEstacaoRadio(String estacaoRadio) {
		this.estacaoRadio = estacaoRadio;
	}

	@Override
	public void ligarCarro() {
		if(!getCarroLigado()){										/* Condicional para garantir que o carro n�o esteja ligado*/
			JOptionPane.showMessageDialog(null, "Ligando o carro"); /* Mensagem de sucesso na condição*/
			setCarroLigado(true); 									/* Passando a informação para o Método set do carroLigado*/
		}
		/** Se n�o*/
		else{
			JOptionPane.showMessageDialog(null, "Desligando o carro"); /* Desliga o carro*/
			setCarroLigado(false);
		}
		
	}
}
