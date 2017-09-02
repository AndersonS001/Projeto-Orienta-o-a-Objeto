/**
 * Blibliotecas importadas para classe
 */

import javax.swing.*;

/**
 * 
 * @author Anderson Aguiar de Souza 22216001-2
 * A classe veiculo molda um objeto carro de forma genérica.
 */

public class Veiculo { 
	private String Cor; /** Atributo da classe */
	private String Ano; /** Atributo da classe */
	private String Modelo; /** Atributo da classe */
	private String Tipo; /** Atributo da classe */
	private boolean CarroLigado=false; /** Atributo da classe */
	private boolean CarroAndando=false; /** Atributo da classe */
	
	
	/**
	 * Método construtor da classe que inicia os atributos do carro como padrões.
	 */
	public Veiculo(){ 
		Cor = "Vermelho"; /** Definição padrão de atributos*/
		Ano = "2017"; /** Definição padrão de atributos*/
		Modelo = "Ferrari"; /** Definição padrão de atributos*/
		Tipo = "Passeio"; /** Definição padrão de atributos*/
	}
	
	/** Método público para ligar o carro */
	public boolean ligarCarro(){ 
		if(!getCarroLigado()){/** Condicional para garantir que o carro não esteja ligado*/
			//System.out.println("Ligando o carro"); /** Mensagem de sucesso na condição*/
			JOptionPane.showMessageDialog(null, "Ligando o carro"); /** Mensagem de sucesso na condição*/
			setCarroLigado(true); /** Passando a informação para o método set do carroLigado*/
			setCarroAndando(false); /** Passando a informação para o método set do carroAndando*/
			 return true; /**  Retorno de sucesso da função*/
		}
		/** Se não*/
		else{
			JOptionPane.showMessageDialog(null, "Seu carro ja está ligado"); /** Mensagem de erro na condição*/
			//System.out.println("Seu carro ja está ligado");
			}
		return false; /** Retorno da função*/
	}
	
	/** 
	 * Método público para desligar o carro. 
	 */
	public boolean desligarCarro(){
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Desligando o carro");
			JOptionPane.showMessageDialog(null, "Desligando o carro");/** Mensagem de sucesso na condição*/
			setCarroLigado(false);/** Passando a informação para o método set do carroLigado*/
			setCarroAndando(false); /** Passando a informação para o método set do carroAndando*/
			return true;  /** @return Retorno de sucesso da função*/
		}else{
		//	System.out.println("Seu carro ja está desligado");
			JOptionPane.showMessageDialog(null, "Seu carro ja está desligado"); /** Mensagem de erro na condição*/
			}
		return false; /** Retorno da função*/
	}
	
	/** Método público para o carro andar para frente*/
	public void andarFrente(){ 
		if(getCarroLigado()){ /** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Andando para frente");
			JOptionPane.showMessageDialog(null, "Andando para frente");/** Mensagem de sucesso na condição*/
			setCarroAndando(true);/** Passando a informação para o método set do carroAndando*/
		}
	}
	
	/** Método público para ré*/
	public void deRé(){ 
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Ré engatada");
			JOptionPane.showMessageDialog(null, "Ré engatada"); /** Mensagem de sucesso na condição*/
			setCarroAndando(true);/** Passando a informação para o método set do carroAndando*/
		}	
	}
	
	/** Método público para virar a direita*/
	public void virarDireita(){ 
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Espero que sua seta esteja ligada, virando para direita");
			JOptionPane.showMessageDialog(null, "Espero que sua seta esteja ligada, virando para direita");/** Mensagem de sucesso na condição*/
			setCarroAndando(true);/** Passando a informação para o método set do carroAndando*/
		}
	}
	
	/** Método público para virar a esquerda*/
	public void virarEsquerda(){
		if(getCarroLigado()){/** Condicional para garantir que o carro esteja ligado*/
			//System.out.println("Espero que sua seta esteja ligada, virando para esquerda");
			JOptionPane.showMessageDialog(null, "Espero que sua seta esteja ligada, virando para esquerda");/** Mensagem de sucesso na condição*/
			setCarroAndando(true);/** Passando a informação para o método set do carroAndando*/
		}
	}
	
	/** Método set privado do Carro Andando para alterar o atributo carroAndando*/
	private void setCarroAndando(boolean cond) { 
		CarroAndando=cond; /** Alterando o atributo*/
	}
	
	/** Método get protegido do Carro Andando para retornar o atributo carroAndando*/
	protected boolean getCarroAndando(){ 
		return CarroAndando; /** Retornando o atributo*/
	}
	
	/** Método set privado do Carro Ligado para alterar o atributo carroLigado*/
	private void setCarroLigado(boolean cond) {
		CarroLigado = cond; /** Alterando o atributo*/
	}
	
	/** Método get protegido do Carro Ligado para retornar o atributo carroLigado*/
	protected boolean getCarroLigado(){
		return CarroLigado; /** Retornando o atributo*/
	}
}