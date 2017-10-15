import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JPanel contentPane;
	
	Usuario u = new Usuario();
	ArrayList<String> v = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */

	
	public void Array() {
		v = u.getArray();
	}
	
	public Login() {
		Array();
	}
	
	/**
	 * Create the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Tela() {
		JFrame x = new JFrame();
		x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		x.setVisible(true);
		x.setBounds(100, 100, 353, 188);
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
		comboBox.setModel(new DefaultComboBoxModel(v.toArray()));
		comboBox.setBounds(20, 74, 189, 21);
		contentPane.add(comboBox);
		
		JLabel lblQuemVoc = new JLabel("Quem \u00E9 voc\u00EA?");
		lblQuemVoc.setFont(new Font("Arial", Font.ITALIC, 17));
		lblQuemVoc.setBounds(20, 32, 277, 31);
		contentPane.add(lblQuemVoc);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(20, 115, 89, 23);
		contentPane.add(btnEntrar);		
	}
}
