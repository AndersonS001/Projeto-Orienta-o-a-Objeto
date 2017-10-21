import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenu;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 19);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usu\u00E1rio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Novo Usu\u00E1rio");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Usuario u = new Usuario();
				u.Tela();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Login");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				LoginUsuario frame = new LoginUsuario();
				frame.Tela();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmRemoverUsurio = new JMenuItem("Remover Usu\u00E1rio");
		mntmRemoverUsurio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				RemoverUsuario r;
				try {
					r = new RemoverUsuario();
					r.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
