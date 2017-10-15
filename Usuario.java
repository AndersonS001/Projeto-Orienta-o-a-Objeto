import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
/**
 * 
 * @author unifasouza
 * Classe que cria um usuário para controlar o veículo.
 */
public class Usuario extends CriaVeiculo{
	/**Atributos usuários*/
	private String Nome;
	private int Idade;
	private boolean User;
	private JTextField txtGetNome;
	private static ArrayList<String> user = new ArrayList<String>();
	
	
	
	
	
	public int Size() {
		return user.size();
	}

	 
	/**Construtor da classe
	 * @param String nome
	 * @param int idade
	 */
	
	public Usuario(String nome, int idade) {
		CriaUsuario(nome, idade);
	}
	
	public Usuario() {}
	
	public void CriaUsuario(String nome, int idade){	
		/**Condicional de criação*/
		if(nome.equals("") && idade == 0){
			setNome("Padrão"); /** Alterando o atributo via método set*/
			setIdade(18);/** Alterando o atributo via método set*/
			setUser(true);/** Alterando o atributo via método set*/
		}else if(idade == 0){ /**Else*/
			setNome(nome); /** Alterando o atributo via método set*/
			setIdade(18);/** Alterando o atributo via método set*/
			setUser(true);/** Alterando o atributo via método set*/
		}else {
			setIdade(idade);/** Alterando o atributo via método set*/
			setUser(false);/** Alterando o atributo via método set*/
		}
	}
	
	public static void Salvar(String nome) {
		user.add(nome);
	}
	
	public void Nomes() {
		
        Arrays.toString( user.toArray() );

	}
	
	public ArrayList<String> getArray(){
		return user;
	}
	
	public void MostraNome() {
		Nomes();
	}
	
	 /**Método set para Nome
	  * @param String nome - Nome do usuário
	  */
	private void setNome(String nome){
		//this.Nome =  nome; /** Alterando o atributo*/
		Salvar(nome);
	}
	
	/**Método set para Idade
	 * @param  int idade - Idade do usuário
     */
	private void setIdade(int idade){
		if(idade >= 18)
			this.Idade =  idade; /** Alterando o atributo*/
		else
			JOptionPane.showMessageDialog(null, 
					"Desculpe, mas você não pode dirigir", 
					null, JOptionPane.ERROR_MESSAGE);
	}
	
	/**Método set para Usuário
     * @param  boolean - Nome para o usuário
     */
	private void setUser(boolean x) {
		this.User = x;
	}
	
	/**Método get para o Nome
	 * @return String - Retorna o nome do usuário.
     */
	public String getNome(){
		return Nome;  /**@return Nome*/
	}

	/**Método get para Idade
	 * @return int - Retorna a idade do usuário.
     */
	public int getIdade(){
		return this.Idade; /**@return Idade*/
	}
	
	/**Método get para o Usuario
	 * @return boolean - Retorna positivo se usuário existe, negativo se não.
     */
	public boolean getUser() {
		return User; 
	}
		
	
	
	
	
	/**Inicio tela*/
	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void Tela() {
		ButtonGroup bg = new ButtonGroup();
		JFrame x = new JFrame("Usuário");
		x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		x.setVisible(true);
		x.setBounds(new Rectangle(0, 0, 400, 250));
		x.getContentPane().setLayout(null);
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome:");
		lblDigiteSeuNome.setBounds(10, 24, 110, 14);
		x.getContentPane().add(lblDigiteSeuNome);
		
		txtGetNome = new JTextField();
		txtGetNome.setBounds(106, 21, 235, 20);
		x.getContentPane().add(txtGetNome);
		txtGetNome.setColumns(10);
		
		JRadioButton rdnSim = new JRadioButton("Sim");
		rdnSim.setSelected(true);
		rdnSim.setBounds(10, 81, 109, 23);
		x.getContentPane().add(rdnSim);
		
		JRadioButton rdnNao = new JRadioButton("N\u00E3o");
		rdnNao.setBounds(10, 113, 109, 23);
		x.getContentPane().add(rdnNao);
		
		bg.add(rdnNao);
		bg.add(rdnSim);
		JLabel lblVocTemMais = new JLabel("Voc\u00EA j\u00E1 \u00E9 habilitado?");
		lblVocTemMais.setBounds(10, 60, 172, 14);
		x.getContentPane().add(lblVocTemMais);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdnSim.isSelected())
					CriaUsuario(txtGetNome.getText().toString(),0);
				else
					CriaUsuario(txtGetNome.getText().toString(),1);
				
				x.dispose();
			}
		});
		btnEnviar.setBounds(10, 143, 89, 23);
		x.getContentPane().add(btnEnviar);
		
		JMenuBar menuBar = new JMenuBar();
		x.setJMenuBar(menuBar);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x.dispose();
			}
		});
		menuBar.add(mnSair);
	}
}
