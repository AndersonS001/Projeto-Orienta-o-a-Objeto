import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
	
public class Arquivo {
	
		static String pathUsuarios = "Dados/Usuarios.txt";
		static String pathConfiguracoes = "Dados/Config.txt";
		
		private static void ArquivoExiste(String path) throws IOException {
			File arquivo = new File(path);
			
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
		}
		
	    public static ArrayList<String> getUser() throws IOException {
	    	ArquivoExiste(pathUsuarios);
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
			ArrayList<String> user = new ArrayList<>();

	        String linha = "";
	        while (true) {
	        	linha = buffRead.readLine();
	            if (linha != null) {
	            	user.add(linha);
	            } else
	                break;
	        }
	        buffRead.close();
	        
			return user;
	    }
	    
	    public static boolean UsuarioNExiste(String nome) throws IOException {
	    	ArquivoExiste(pathUsuarios);	
	        BufferedReader buffRead = new BufferedReader(new FileReader(pathUsuarios));
			
	        String linha = "";
	        while (true) {
	        	linha = buffRead.readLine();
	            if (nome.equals(linha)) {
	    	        buffRead.close();
	            	return false;
	            } else
	                break;
	        }
	        
	        buffRead.close();
			return true;
	    }
	    
	    
	    public static void CadastraUsuario(String texto) throws IOException {
	    	ArquivoExiste(pathUsuarios);
	    	
	        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathUsuarios,true));
	        
	        buffWrite.write(texto);
	        buffWrite.newLine();
	        buffWrite.flush();
	        buffWrite.close();
	    }
	    
	    
	    
	    
	}