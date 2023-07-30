package ViewBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import UsuarioDTO.Usuariodto;
import UsuarioDão.Usuario;

//import  usuario.Usuario;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frameL;
	private JTextField idLog;
	private JPasswordField idSen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frameL.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameL = new JFrame();
		frameL.setBounds(100, 100, 450, 300);
		frameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Login");
		
		idLog = new JTextField();
		idLog.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		
		idSen = new JPasswordField();
		idSen.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton IdEntrar = new JButton("Entrar");
		IdEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String UsuarioC,Senha;
					UsuarioC=idLog.getText();
					Senha=idSen.getText();
					Usuariodto usuariodto=new Usuariodto();
					usuariodto.setUsuario(UsuarioC);
					usuariodto.setSenha(Senha);
					
				Usuario objUsu=new Usuario();
				ResultSet rstusuario=objUsu.Login(usuariodto);
				if(rstusuario.next()) {
					ViewClienteBD objviewclientebd=new ViewClienteBD();
					objviewclientebd.setVisible(true);
					frameL.dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Usuario ou Senha invalida");
				}
				}catch(SQLException e){
				JOptionPane.showMessageDialog(null,"Erro view: "+e);
				
			}
				}
		});
		IdEntrar.setBackground(Color.GREEN);
		IdEntrar.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout groupLayout = new GroupLayout(frameL.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(idSen, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(idLog, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(IdEntrar)))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(idSen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(IdEntrar)
					.addGap(68))
		);
		frameL.getContentPane().setLayout(groupLayout);
	}
}

