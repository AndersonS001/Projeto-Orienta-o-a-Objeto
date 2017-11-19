package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import classes.Remover;

/**
 * Classe para remo��o do usu�rio
 * @author ander
 *
 */
public class RemoverUsuario extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Remover remove = new Remover();
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RemoverUsuario() throws IOException {
		setTitle("Excluir usu\u00E1rios");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		menuBar.add(mnSair);
		
		JLabel lblQuemVocGostaria = new JLabel("Quem voc\u00EA gostaria de remover?");
		lblQuemVocGostaria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuemVocGostaria.setBounds(20, 32, 263, 33);
		contentPane.add(lblQuemVocGostaria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 76, 263, 33);
		comboBox.setModel(new DefaultComboBoxModel(remove.Dados(false).toArray()));
		contentPane.add(comboBox);
		
		JButton btnRemover = new JButton("Remover");
		if(remove.Dados(false).size() == 0) 
			btnRemover.setVisible(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					remove.Excluir(comboBox.getSelectedItem().toString(), comboBox.getSelectedIndex());
					JOptionPane.showMessageDialog(null,"Usuário removido com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnRemover.setFont(new Font("Arial", Font.BOLD, 12));
		btnRemover.setBounds(91, 120, 113, 33);
		contentPane.add(btnRemover);
	}
}
