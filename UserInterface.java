package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import classes.User;
import controlers.Arquivo;
import javax.swing.JPasswordField;

public class UserInterface {

	private JFrame frmCadastroDeUsurios;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JButton btnCadastrar;
	private User usuario = new User();
	private JPasswordField senha;
	private JButton btnSair;
	
	/**
	 * Create the application.
	 */
	public UserInterface() {
		criaUsuario();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void criaUsuario() {
		frmCadastroDeUsurios = new JFrame();
		frmCadastroDeUsurios.setTitle("Cadastro de usu\u00E1rios");
		frmCadastroDeUsurios.setBounds(100, 100, 273, 246);
		frmCadastroDeUsurios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeUsurios.getContentPane().setLayout(null);
		frmCadastroDeUsurios.setVisible(true);
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(12, 13, 56, 16);
		frmCadastroDeUsurios.getContentPane().add(lblNome);
		
		JLabel lblIdade = new JLabel("CNH: ");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(12, 59, 56, 16);
		frmCadastroDeUsurios.getContentPane().add(lblIdade);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(64, 13, 178, 22);
		frmCadastroDeUsurios.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdade.setColumns(10);
		txtIdade.setBounds(64, 56, 178, 22);
		frmCadastroDeUsurios.getContentPane().add(txtIdade);
		
		senha = new JPasswordField();
		senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senha.setBounds(64, 97, 178, 22);
		frmCadastroDeUsurios.getContentPane().add(senha);
	
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String auxNome = txtNome.getText();
				String auxSenha = new String(senha.getPassword());
				String auxCnh = txtIdade.getText();
				if(auxNome.equals("") || auxCnh.equals("") || auxSenha.equals(""))
					JOptionPane.showMessageDialog(null,"Preencha os campos corretamente!");
				else {
					try {
						if(usuario.Verificar(auxNome)) {
							usuario.setUsuario(auxNome, auxSenha, auxCnh);
							JOptionPane.showMessageDialog(null,"Usuário cadastrado");
							try {
								Arquivo.Cadastrar(usuario);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							frmCadastroDeUsurios.dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "Esse usuário já existe");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//limpar os campos de entrada
				txtNome.setText("");
				senha.setText("");
				txtIdade.setText("");
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(12, 156, 110, 42);
		frmCadastroDeUsurios.getContentPane().add(btnCadastrar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeUsurios.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(132, 156, 110, 42);
		frmCadastroDeUsurios.getContentPane().add(btnSair);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(12, 101, 56, 16);
		frmCadastroDeUsurios.getContentPane().add(lblSenha);		
	}
}