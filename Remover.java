package classes;

import java.io.IOException;
import java.util.ArrayList;

import controlers.Arquivo;

public class Remover {
	
	/**
	 *Método que remove um usuário do Programa 
	 * @param nome
	 * @param index
	 * @throws IOException
	 */
	public void Excluir(String nome, int index) throws IOException {
		Arquivo.RemoveUsuario(nome,index);
	}
	
	/**
	 * 
	 * @param full
	 * @return Se full igual a true = retorna lista completa, senão apenas a lista de usuários
	 * @throws IOException
	 */
	public ArrayList<String> Dados(boolean full) throws IOException {
		return Arquivo.getUser(full);	//retorna uma arraylist de String com o nome dos usu�rios cadastrados
	}
}
