import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controlers.Arquivo;
import view.LoginUsuario;
import view.RemoverUsuario;
//import classes.Usuario;
import view.UserInterface;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenu;

public class Main {

	private JFrame frmPrincipal;

	/**
	 * Inicia a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a aplicação.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Inicializa os conteudos da tela
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 19);
		frmPrincipal.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usu\u00E1rio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Novo Usu\u00E1rio");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				new UserInterface();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Login");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					boolean usuario = Arquivo.Verificar(false);
				
					if(usuario) {
						LoginUsuario frame = new LoginUsuario();
						frame.Tela();
					}
					else
						JOptionPane.showMessageDialog(null, "Não há nenhum usuário cadastrado.");
				}catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmRemoverUsurio = new JMenuItem("Remover Usu\u00E1rio");
		mntmRemoverUsurio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				boolean usuario;
				try {
					usuario = Arquivo.Verificar(false);
				
					if(usuario) {
						try {
							new RemoverUsuario();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Não há nenhum usuário cadastrado.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmRemoverUsurio);
		
		JMenu mnNewMenu_2 = new JMenu("Sair");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_2);
	}
}
