import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
	
public abstract class Arquivo {
	
		static String pathUsuarios = "Dados/Usuarios.txt";
		static String pathConfiguracoes = "Dados/Config.txt";
		private static ArrayList<String> user = new ArrayList<>();
		
		private static void ArquivoExiste(String path) throws IOException {
			File arquivo = new File(path);
			
			if(!arquivo.exists()) 
				arquivo.createNewFile();
		}
		
	    public static ArrayList<String> getUser() throws IOException {
	    	ArquivoExiste(pathUsuarios);
	    	user.clear();
	    	
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
	        while (true) {
	        	String  linha = buffRead.readLine();
	            if (linha != null) {
	            	user.add(linha);
	            } else
	                break;
	        }
	        buffRead.close();
	        
			return user;
	    }
	    
	    public static boolean UsuarioNExiste(String nome) throws IOException {
	    	user = getUser();
	    	
	    	for(String s : user) {
	    		if(nome.equals(s))
	    			return false;
	    	}
	    	
	    	return true;
	    }
	    
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
	    
	    public static void CadastraUsuario(String texto) throws IOException {
	    	user = getUser();
	    	user.add(texto);
	    	Manipulacao(user);
	    }
	    
	    public static void RemoveUsuario(String nome) throws IOException {
	    	user = getUser();
	    	user.remove(nome);
	    	Manipulacao(user); 
	    }
	}
