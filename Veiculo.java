/**
 * Blibliotecas importadas para classe
 */

import javax.swing.*;

/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 * A classe veiculo molda um objeto carro de forma gen�rica.
 */

public class Veiculo { 
	private String Cor; /** Atributo da classe */
	private String Ano; /** Atributo da classe */
	private String Modelo; /** Atributo da classe */
	private String Tipo; /** Atributo da classe */
	private boolean CarroLigado=false; /** Atributo da classe */
	private boolean CarroAndando=false; /** Atributo da classe */
	
	
	/**
	 * M�todo construtor da classe que inicia os atributos do carro como padr�es.
	 */
	public Veiculo(){ 
		Cor = "Vermelho"; /** Defini��o padr�o de atributos*/
		Ano = "2017"; /** Defini��o padr�o de atributos*/
		Modelo = "Ferrari"; /** Defini��o padr�o de atributos*/
		Tipo = "Passeio"; /** Defini��o padr�o de atributos*/
	}
	
	/** M�todo p�blico para ligar o carro */
	public boolean ligarCarro(){ 
		if(!getCarroLigado()){/** Condicional para garantir que o carro n�o esteja ligado*/
			//System.out.println("Ligando o carro"); /** Mensagem de sucesso na condi��o*/
			JOptionPane.showMessageDialog(null, "Ligando o carro"); /** Mensagem de sucesso na condi��o*/
			setCarroLigado(true); /** Passando a informa��o para o m�todo set do carroLigado*/
			setCarroAndando(false); /** Passando a informa��o para o m�todo set do carroAndando*/
			 return true; /**  Retorno de sucesso da fun��o*/
		}
		/** Se n�o*/
		else{
			JOptionPane.showMessageDialog(null, "Seu carro ja est� ligado"); /** Mensagem de erro na condi��o*/
			//System.out.println("Seu carro ja est� ligado");
			}
		return false; /** Retorno da fun��o*/
	}
	
	/** 
	 * M�todo p�blico para desligar o carro. 
	 */
	public boolean desligarCarro(){
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Desligando o carro");
			JOptionPane.showMessageDialog(null, "Desligando o carro");/** Mensagem de sucesso na condi��o*/
			setCarroLigado(false);/** Passando a informa��o para o m�todo set do carroLigado*/
			setCarroAndando(false); /** Passando a informa��o para o m�todo set do carroAndando*/
			return true;  /** @return Retorno de sucesso da fun��o*/
		}else{
		//	System.out.println("Seu carro ja est� desligado");
			JOptionPane.showMessageDialog(null, "Seu carro ja est� desligado"); /** Mensagem de erro na condi��o*/
			}
		return false; /** Retorno da fun��o*/
	}
	
	/** M�todo p�blico para o carro andar para frente*/
	public void andarFrente(){ 
		if(getCarroLigado()){ /** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Andando para frente");
			JOptionPane.showMessageDialog(null, "Andando para frente");/** Mensagem de sucesso na condi��o*/
			setCarroAndando(true);/** Passando a informa��o para o m�todo set do carroAndando*/
		}
	}
	
	/** M�todo p�blico para r�*/
	public void deR�(){ 
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("R� engatada");
			JOptionPane.showMessageDialog(null, "R� engatada"); /** Mensagem de sucesso na condi��o*/
			setCarroAndando(true);/** Passando a informa��o para o m�todo set do carroAndando*/
		}	
	}
	
	/** M�todo p�blico para virar a direita*/
	public void virarDireita(){ 
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Espero que sua seta esteja ligada, virando para direita");
			JOptionPane.showMessageDialog(null, "Espero que sua seta esteja ligada, virando para direita");/** Mensagem de sucesso na condi��o*/
			setCarroAndando(true);/** Passando a informa��o para o m�todo set do carroAndando*/
		}
	}
	
	/** M�todo p�blico para virar a esquerda*/
	public void virarEsquerda(){
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Espero que sua seta esteja ligada, virando para esquerda");
			JOptionPane.showMessageDialog(null, "Espero que sua seta esteja ligada, virando para esquerda");/** Mensagem de sucesso na condi��o*/
			setCarroAndando(true);/** Passando a informa��o para o m�todo set do carroAndando*/
		}
	}
	
	/** M�todo set privado do Carro Andando para alterar o atributo carroAndando*/
	private void setCarroAndando(boolean cond) { 
		CarroAndando=cond; /** Alterando o atributo*/
	}
	
	/** M�todo get protegido do Carro Andando para retornar o atributo carroAndando*/
	protected boolean getCarroAndando(){ 
		return CarroAndando; /** Retornando o atributo*/
	}
	
	/** M�todo set privado do Carro Ligado para alterar o atributo carroLigado*/
	private void setCarroLigado(boolean cond) {
		CarroLigado = cond; /** Alterando o atributo*/
	}
	
	/** M�todo get protegido do Carro Ligado para retornar o atributo carroLigado*/
	protected boolean getCarroLigado(){
		return CarroLigado; /** Retornando o atributo*/
	}
}