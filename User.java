package classes;

import java.io.IOException;

import javax.swing.JOptionPane;

import controlers.Arquivo;

/**
 * Cria um usuário
 * @author ander
 */
public class User {
	private String nome, senha, cnh;
	public CriaVeiculo carro;
	
	/**
	 * Contrutor da Classe 
	 * @param _nome
	 * @param _cnh
	 */
	public User(String _nome, String _cnh){
		carro = new CriaVeiculo(false, false, true, "");
		setNome(_nome);
		setCNH(_cnh);
	}
	
	/**
	 * Construtor usado no Painel de controle
	 * @param nome
	 * @param cnh
	 * @param ar
	 * @param janela
	 * @param porta
	 * @param radio
	 */
	public User(String nome, String cnh, boolean ar, boolean janela, boolean porta, String radio) {
		carro = new CriaVeiculo(ar, janela, porta, radio);
		setNome(nome);
		setCNH(cnh);
	}
	
	/**
	 * Construtor padrão
	 */
	public User(){
		carro = new CriaVeiculo(false, false, true, "");
	}
	
	/**
	 * Função que garanta que o usuário não exista
	 * @param nome
	 * @return True ou false
	 * @throws IOException
	 */
	public boolean Verificar(String nome) throws IOException {
		boolean existe = Arquivo.UsuarioNExiste(nome);
		return existe;
	}
	/**
	 * Método set do Usuario
	 * @param nome
	 * @param password
	 * @param cnh
	 */
	public void setUsuario(String nome, String password, String cnh) {
		setNome(nome);
		setSenha(password);
		setCNH(cnh);
	}
	
	public String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNH() {
		return cnh;
	}
	private void setCNH(String cnh) {
		this.cnh = cnh;
	}
	private void setSenha(String _senha) {
		this.senha = _senha;
	}
	public String getSenha() {
		return this.senha;
	}
	
	/**
	 * Valida Login
	 * @param _senha
	 * @return true ou false
	 */
	public boolean Login(String _senha) {
		if(_senha.equals(getSenha()))
			return true;
		else
			return false;
	}
	
	/**Informações atuais do usuário */
	public void dados() {
		JOptionPane.showMessageDialog(null,"Nome: "+ getNome() + " Idade: " + getCNH());
		JOptionPane.showMessageDialog(null,"Ar condicionado: " + carro.isArCondicionado() + " Janela: " + carro.isJanela()
		+ "Porta: " + carro.isPorta() + " Rádio: " + carro.getEstacaoRadio());
	}
}
