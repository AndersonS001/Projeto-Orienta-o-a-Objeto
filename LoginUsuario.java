package view;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.Arquivo;
import controlers.PainelDeControle;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * Classe de Login do usuário.
 * @author 
 */
public class LoginUsuario {

	private JPanel contentPane;
	
	ArrayList<String> v = new ArrayList<String>();
	private JPasswordField senha;
	
	/**
	 * Inicia a aplicação
	 */
	public LoginUsuario() {
		try {
			v = Arquivo.getUser(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Tela() {
		JFrame x = new JFrame();
		x.setTitle("Login");
		x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		x.setVisible(true);
		x.setBounds(100, 100, 377, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		x.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sair");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				x.dispose();
			}
		});
		menuBar.add(mnNewMenu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(v.toArray()));
		comboBox.setBounds(118, 34, 208, 29);
		contentPane.add(comboBox);
		
		JLabel lblQuemVoc = new JLabel("Quem \u00E9 voc\u00EA?");
		lblQuemVoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuemVoc.setBounds(20, 32, 112, 31);
		contentPane.add(lblQuemVoc);
		
		
		
		JLabel lblSenha = new JLabel("Senha/CNH: ");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(20, 91, 100, 21);
		contentPane.add(lblSenha);
		
		senha = new JPasswordField();
		senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senha.setBounds(118, 90, 208, 22);
		contentPane.add(senha);
		
		JButton btnEntrar = new JButton("Entrar");
		if(v.size() == 0) 
			btnEntrar.setVisible(false);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> senhas = new ArrayList<String>();
				
				try {
					senhas = Arquivo.getSenhas(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*Vari�vel respons�vel por pegar a senha digitada
				 * pelo usu�rio
				 */
				String auxSenha = new String(senha.getPassword());
				
				if(auxSenha.equals(senhas.get(comboBox.getSelectedIndex()*2 )) || 
						auxSenha.equals(senhas.get(comboBox.getSelectedIndex()*2+1) )) {
					new PainelDeControle(comboBox.getSelectedItem().toString(), comboBox.getSelectedIndex());
					x.dispose();
				}
				else 
					JOptionPane.showMessageDialog(null,"Senha/CNH incorreta");
				senha.setText(""); //limpar o campo da senha
			}
		});
		btnEntrar.setBounds(20, 147, 101, 38);
		contentPane.add(btnEntrar);		
	}
}
