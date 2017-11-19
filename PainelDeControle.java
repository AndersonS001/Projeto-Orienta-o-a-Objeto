package controlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import classes.*;

public class PainelDeControle extends JFrame {

	/**
	 * Classe que gerencia as condi��es do usu�rio.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static List<String> lista;
	private User pessoa;//new Usuario(nome, ar, janela, porta);
	private JTextField txtRadio;
	private int Index;
	
	/**
	 * Lista de controle com as informações do usuário.
	 * @param nome
	 * @param index
	 * @throws IOException
	 */
	private static void PreencheUsuario(String nome, int index) throws IOException {
		lista = Arquivo.UsuarioLogado(nome, index);
	}
	
	/**
	 * Cria um usuário com as informações do arquivo.
	 * @throws IOException
	 */
	private void setarUsuario() throws IOException {
		boolean auxAr, auxJanela, auxPorta;
		auxAr = Boolean.parseBoolean(lista.get(2).substring(5));
		auxJanela = Boolean.parseBoolean(lista.get(3).substring(9));
		auxPorta = Boolean.parseBoolean(lista.get(4).substring(8));
		//nome, cnh, ar, janela, porta, radio
		
		pessoa = new User(lista.get(0).substring(7), 
				lista.get(1).substring(6), 
				auxAr, auxJanela, auxPorta, 
				lista.get(5).substring(8));
	}

	/**
	 * Construtor da classe
	 * @param nome
	 * @param index
	 */
	public PainelDeControle(String nome, int index) {
		try {
			PreencheUsuario(nome, index);
			setarUsuario();
			Tela();
			/*O index recebido ser� referente a cada usu�rio salvado no arquivo. Ou seja,
			 * ser� uma sequ�ncia que inicia em 0 e soma +1 para cada usu�rio cadastrado.
			 * Cada "bloco" de usu�rio cont�m 7 vari�veis (nome, idade, ar, janela, porta, radio e senha),
			 * portanto, preciso multiplicar o indice recebido pela qtd de variaveis em cada usuario
			 */
			this.Index = index*7;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Tela() {
		JFrame Tela = new JFrame("Painel de Controle");
		Tela.setVisible(true);
		Tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Tela.setBounds(100, 100, 580, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Tela.setContentPane(contentPane);
		Tela.getContentPane().setLayout(null);
		
		JLabel lblOl = new JLabel("Olá, "+ pessoa.getNome());
		//lblOl.setText("Ol�, " +lista.get(0).substring(7));
		lblOl.setBounds(10, 22, 323, 22);
		contentPane.add(lblOl);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 550, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sair");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Tela.dispose();
			}
		});
		menuBar.add(mnNewMenu);
		
		
		JLabel lblCarro = new JLabel("");
		lblCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarro.setBounds(374, 64, 161, 18);
		contentPane.add(lblCarro);
		
		JLabel lblJanela = new JLabel("");
		lblJanela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJanela.setBounds(374, 95, 161, 18);
		contentPane.add(lblJanela);
	
		JLabel lblArCondicionado = new JLabel("");
		lblArCondicionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArCondicionado.setBounds(374, 126, 176, 18);
		contentPane.add(lblArCondicionado);
		
		JLabel lblPorta = new JLabel("");
		lblPorta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorta.setBounds(374, 157, 161, 18);
		contentPane.add(lblPorta);
		
		JLabel lblRadio = new JLabel("");
		lblRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRadio.setBounds(374, 226, 161, 18);
		contentPane.add(lblRadio);
		lblRadio.setText(pessoa.carro.getEstacaoRadio());
		
		JButton btnLigar = new JButton("Ligar Carro");
		btnLigar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pessoa.carro.ligarCarro();
				if(pessoa.carro.getCarroLigado()) {
					lblCarro.setText("Carro ligado");
					btnLigar.setText("Desligar carro");
				}
				else {
					lblCarro.setText("Carro desligado");
					btnLigar.setText("Ligar Carro");
				}
				
			}
		});
		
		btnLigar.setBounds(10, 43, 161, 70);
		contentPane.add(btnLigar);
		
		JButton btnJanela = new JButton("");
		JButton btnArCondicionado = new JButton("");
		if(pessoa.carro.isJanela())
			btnJanela.setText("Fechar janela");
		else
			btnJanela.setText("Abrir janela");
		
		btnJanela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pessoa.carro.isJanela() && !pessoa.carro.isArCondicionado()) {
					pessoa.carro.abrirJanela();
					lblJanela.setText("Janela aberta");
					btnJanela.setText("Fechar janela");
				}
					
				else if(!pessoa.carro.isJanela() && pessoa.carro.isArCondicionado()) {
					pessoa.carro.ligdesAr();
					pessoa.carro.abrirJanela();
					lblArCondicionado.setText("Ar condicionado desligado");
					lblJanela.setText("Janela aberta");
					btnJanela.setText("Fechar janela");
					btnArCondicionado.setText("Ligar Ar condicionado");
					try {
						Arquivo.Alterar("Ar = "+pessoa.carro.isArCondicionado(), Index+2);
					}catch(IOException e) {
						e.printStackTrace();
					}
				} else {
					pessoa.carro.fecharJanela();
					lblJanela.setText("Janela fechada");
					btnJanela.setText("Abrir janela");
				}
				//Salvar estado no arquivo
				try {
					Arquivo.Alterar("Janela = "+ pessoa.carro.isJanela(), Index+3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnJanela.setBounds(170, 43, 161, 70);
		contentPane.add(btnJanela);
		
		JButton btnPorta = new JButton("");
		if(pessoa.carro.isPorta())
			btnPorta.setText("Destravar Porta");
		else
			btnPorta.setText("Travar Porta");
		btnPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!pessoa.carro.isPorta()) {
					pessoa.carro.travaPorta();
					lblPorta.setText("Porta travada");
					btnPorta.setText("Destravar porta");
				}
				else {
					pessoa.carro.destravaPorta();
					lblPorta.setText("Porta destravada");
					btnPorta.setText("Travar Porta");
				}
				
				//Salvar estado no arquivo
				try {
					Arquivo.Alterar("Porta = "+ pessoa.carro.isPorta(), Index+4);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnArCondicionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pessoa.carro.isArCondicionado() && !pessoa.carro.isJanela()) {
					pessoa.carro.ligdesAr();
					lblArCondicionado.setText("Ar condicionado ligado");
					btnArCondicionado.setText("Desligar Ar condicionado");
				}
					
				else if(!pessoa.carro.isArCondicionado() && pessoa.carro.isJanela()) {
					pessoa.carro.ligdesAr();
					lblArCondicionado.setText("Ar condicionado ligado");
					btnArCondicionado.setText("Desligar Ar condicionado");
					lblJanela.setText("Janela fechada");
					btnJanela.setText("Abrir janela");
					try {
						Arquivo.Alterar("Janela = "+pessoa.carro.isJanela(), Index+3);
					} catch(Exception e) {
						e.printStackTrace();
					}
				} else {
					pessoa.carro.ligdesAr();
					lblArCondicionado.setText("Ar condicionado desligado");
					btnArCondicionado.setText("Ligar Ar condicionado");
				}
				//Salvar estado no arquivo
				try {
					Arquivo.Alterar("Ar = "+pessoa.carro.isArCondicionado(), Index+2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnArCondicionado.setBounds(170, 109, 161, 70);
		contentPane.add(btnArCondicionado);
		btnPorta.setBounds(10, 109, 161, 70);
		contentPane.add(btnPorta);
		if(pessoa.carro.isArCondicionado())
			btnArCondicionado.setText("Desligar Ar condicionado");
		else
			btnArCondicionado.setText("Ligar Ar condicionado");
		
		JButton btnRadio = new JButton("Esta\u00E7\u00E3o de R\u00E1dio");
		btnRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String auxRadio = txtRadio.getText();
				if(!auxRadio.equals("")) {
					pessoa.carro.setEstacaoRadio(auxRadio);
					lblRadio.setText(pessoa.carro.getEstacaoRadio());
					try {
						Arquivo.Alterar("Radio = "+pessoa.carro.getEstacaoRadio(), Index+5);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Digite uma estação válida");
				txtRadio.setText("");
			}
		});
		btnRadio.setBounds(10, 177, 161, 70);
		contentPane.add(btnRadio);
		
		txtRadio = new JTextField();
		txtRadio.setBounds(177, 225, 154, 22);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText("Esta��o de r�dio favorita");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(177, 177, 154, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Status do Carro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(374, 24, 161, 16);
		contentPane.add(lblNewLabel_1);
		if(pessoa.carro.getCarroLigado())
			lblCarro.setText("Carro ligado");
		else
			lblCarro.setText("Carro desligado");
		
		if(pessoa.carro.isJanela())
			lblJanela.setText("Janela aberta");
		else
			lblJanela.setText("Janela fechada");
		
		if(pessoa.carro.isArCondicionado())
			lblArCondicionado.setText("Ar condicionado ligado");
		else
			lblArCondicionado.setText("Ar condicionado desligado");
		
		if(pessoa.carro.isPorta())
			lblPorta.setText("Porta travada");
		else
			lblPorta.setText("Porta destravada");
		
		JLabel lblRadioFav = new JLabel("Esta\u00E7\u00E3o de r\u00E1dio favorita");
		lblRadioFav.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRadioFav.setBounds(374, 177, 154, 46);
		contentPane.add(lblRadioFav);
	}
}