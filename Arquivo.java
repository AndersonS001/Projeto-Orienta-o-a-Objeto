package controlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.*;

/**
 * Classe que gerencia todo Arquivo do programa
 * @author 
 */
public final class Arquivo {
		static String pathUsuarios = "Dados/Usuarios.txt";
		static String pathConfiguracoes = "Dados/Config.txt";
		private static ArrayList<String> user = new ArrayList<>();
		
		/**
		 * Garante que o arquivo sempre exista
		 * @param path (localização)
		 * @throws IOException
		 */
		private static void ArquivoExiste(String path) throws IOException {
			File arquivo = new File(path);
			
			if(!arquivo.exists()) 
				arquivo.createNewFile();
		}
		
		
		/**
		 * Método que retorna os usuários e seus dados caso necessário.
		 * @param full
		 * @return Se full = false, retorna apenas os nomes de usuários, caso contrário, retorna todos os dados do usuário.
		 * @throws IOException
		 */
	    public static ArrayList<String> getUser(boolean full) throws IOException {
	    	/*Se full = false, retorna apenas os nomes de usuários.
			 * Caso contr�rio, retorna todos os dados do usuário:
			 * Nome, Ar, Porta, Janela e Esta��o de R�dio
			 */ 
	    	ArquivoExiste(pathUsuarios);
	    	user.clear();
	    	
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
	        while (true) {
	        	String  linha = buffRead.readLine();
	        	
	        	if (!full && linha != null) {
	        		if(linha.startsWith("Nome ="))
	        			user.add(linha.substring(7));
		        } else if(full && linha != null) {
		        	user.add(linha);
	        	}else {
	        		break;
	        	}
	        }
	        buffRead.close();
	        
			return user;
	    }
	    
	    /**
	     *  Verifica os nomes do usuário no arquivo.
	     * @param full
	     * @return True ou false
	     * @throws IOException
	     */
	    public static boolean Verificar(boolean full) throws IOException {
	    	ArquivoExiste(pathUsuarios);
	    	user.clear();
	    	
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
	        while (true) {
	        	String  linha = buffRead.readLine();
	        	
	        	if (!full && linha != null) {
	        		if(linha.startsWith("Nome ="))
	        			user.add(linha.substring(7));
	        	}else {
	        		break;
	        	}
	        }
	        buffRead.close();
	        
	        if(user.isEmpty())
	        	return false;
	        
	        return true;
	    }
	    
	    /*retorna as senhas de cada usuário caso full = false
	     * caso contr�rio, retornar� uma array vazia
	     */
	  /**
	   * 
	   * @param full
	   * @return Retorna as senhas de cada usuário caso full = false, caso contrário, retornará uma array vazia
	   * @throws IOException
	   */
	    public static ArrayList<String> getSenhas(boolean full) throws IOException {
	    	ArquivoExiste(pathUsuarios);
	    	user.clear();
	    	
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
	        while (true) {
	        	String  linha = buffRead.readLine();
	        	
	        	if (!full && linha != null) {
	        		if(linha.startsWith("CNH = "))
	        			user.add(linha.substring(6));
	        		else if(linha.startsWith(" "))
	        			user.add(linha.substring(1));
	        	}else 
	        		break;
	        }
	        buffRead.close();
	        
			return user;
	    }
	    
	    /**
	     * Garante que não haja usuários iguais.
	     * @param nome
	     * @return True ou false
	     * @throws IOException
	     */
	    public static boolean UsuarioNExiste(String nome) throws IOException {
	    	user = getUser(false);
	    	
	    	for(String s : user) {
	    		if(nome.equals(s))
	    			return false;
	    	}
	    	
	    	return true;
	    }
	    
	    /**
	     * Método de escrita no arquivo
	     * @param userN
	     * @throws IOException
	     */
	    private static void Manipulacao(ArrayList<String> userN) throws IOException {
	    	ArquivoExiste(pathUsuarios);
	    	
	        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathUsuarios));
	        
	        for(String s : userN) {
	        	buffWrite.write(s);	
	        	buffWrite.newLine();
		        buffWrite.flush();
	        }
	        buffWrite.close();
	    }
	    
	    /**
	     * Método que prepara uma array para ser guardada no arquivo.
	     * @param x
	     * @throws IOException
	     */
	    public static void Cadastrar(User x) throws IOException {
	    	user = getUser(true);
	    	user.add("Nome = " + x.getNome()); //nome do usuario comeca a ser escrito a partir do 7th bit
	    	user.add("CNH = " +x.getCNH()); //cnh 6th bit
	    	user.add("Ar = "+x.carro.isArCondicionado()); //ar 5th bit
	    	user.add("Janela = "+x.carro.isJanela()); //9th bit
	    	user.add("Porta = "+x.carro.isPorta());//8th bit
	    	user.add("Radio = "+x.carro.getEstacaoRadio()); //8th bit
	    	user.add(" "+x.getSenha());
	    	Manipulacao(user);
	    }
	    
	    /**
	     * Remove o usuário do arquivo.
	     * @param u
	     * @param index
	     */
	    public static void RemoveUsuario(String u, int index){
	    	try {
				user = getUser(true);
				user.subList(index*7, index*7+7).clear();
		    	Manipulacao(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    /**
	     * Retorna as informações do usuário logado
	     * @param u
	     * @param index
	     * @return Sublista do usuário requisitado
	     * @throws IOException
	     */
	    public static List<String> UsuarioLogado(String u, int index) throws IOException {
	    	user = getUser(true);
	    	return user.subList(index*7, index*7+7);
	    }
	    
	    /**
	     * Altera informações de um usuário específico
	     * @param var
	     * @param index
	     * @throws IOException
	     */
	    public static void Alterar(String var, int index) throws IOException {
	    	user = getUser(true);
	    	user.set(index, var);
	    	Manipulacao(user);
	    }
	}
