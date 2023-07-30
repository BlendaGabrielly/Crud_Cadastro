package ViewBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ClienteConexao.ClienteB;
import ControllerCl.ClienteController;
import ModeloC.Cliente;
import UsuarioDão.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewClienteBD {

	private JFrame frameC;
	/**
	 * @wbp.nonvisual location=241,19
	 */
	private final JLabel Cliente = new JLabel("Cadastro");

	/**
	 * Launch the application.
	 */
	Cliente cliente=new Cliente();
	ClienteController clienteController=new ClienteController();
	
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField idnome;
	private JLabel lblNewLabel_1;
	private JTextField idEnd;
	private JLabel lblNewLabel_2;
	private JTextField idTel;
	private JButton idCad;
	private JButton idAtu;
	private JButton idApg;
	private JLabel ID;
	private JTextField idTB;
	private JButton idPes;
	private JButton limpar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClienteBD window = new ViewClienteBD();
					window.frameC.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public void JTextField(int columns) {
	}
	
	/**
	 * Create the application.
	 */
	public ViewClienteBD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameC = new JFrame();
		frameC.setBounds(100, 100, 629, 462);
		frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 27, 0, 0, 0, 86, 51, 67, 14, 0, 42, 86, 0, 81, 0};
		gridBagLayout.rowHeights = new int[]{23, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frameC.getContentPane().setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frameC.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		idnome = new JTextField();
		GridBagConstraints gbc_idnome = new GridBagConstraints();
		gbc_idnome.gridwidth = 2;
		gbc_idnome.insets = new Insets(0, 0, 5, 5);
		gbc_idnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_idnome.gridx = 2;
		gbc_idnome.gridy = 0;
		frameC.getContentPane().add(idnome, gbc_idnome);
		idnome.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		frameC.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		idEnd = new JTextField();
		GridBagConstraints gbc_idEnd = new GridBagConstraints();
		gbc_idEnd.gridwidth = 3;
		gbc_idEnd.insets = new Insets(0, 0, 5, 5);
		gbc_idEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_idEnd.gridx = 6;
		gbc_idEnd.gridy = 0;
		frameC.getContentPane().add(idEnd, gbc_idEnd);
		idEnd.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 9;
		gbc_lblNewLabel_2.gridy = 0;
		frameC.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		idCad = new JButton("Cadastrar");
		idCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nome,End;
				String Tel;
				//cliente.setId(Integer.parseInt(id.getText()));
				Nome= idnome.getText().toString();
				End=idEnd.getText().toString();
				Tel=idTel.getText().toString();
			
			cliente.setNome(Nome);
			cliente.setEnd(End);
			cliente.setTel(Tel);
			clienteController.executa(cliente,1);
			listar();
			LimparCampos();
			}
		});
		
		idTel = new JTextField();
		GridBagConstraints gbc_idTel = new GridBagConstraints();
		gbc_idTel.gridwidth = 3;
		gbc_idTel.insets = new Insets(0, 0, 5, 5);
		gbc_idTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_idTel.gridx = 10;
		gbc_idTel.gridy = 0;
		frameC.getContentPane().add(idTel, gbc_idTel);
		idTel.setColumns(10);
		
		ID = new JLabel("ID");
		GridBagConstraints gbc_ID = new GridBagConstraints();
		gbc_ID.anchor = GridBagConstraints.EAST;
		gbc_ID.insets = new Insets(0, 0, 5, 5);
		gbc_ID.gridx = 13;
		gbc_ID.gridy = 0;
		frameC.getContentPane().add(ID, gbc_ID);
		
		idTB = new JTextField();
		idTB.setEditable(false);
		GridBagConstraints gbc_idTB = new GridBagConstraints();
		gbc_idTB.insets = new Insets(0, 0, 5, 0);
		gbc_idTB.fill = GridBagConstraints.HORIZONTAL;
		gbc_idTB.gridx = 14;
		gbc_idTB.gridy = 0;
		frameC.getContentPane().add(idTB, gbc_idTB);
		idTB.setColumns(10);
		GridBagConstraints gbc_idCad = new GridBagConstraints();
		gbc_idCad.insets = new Insets(0, 0, 5, 5);
		gbc_idCad.gridx = 2;
		gbc_idCad.gridy = 1;
		frameC.getContentPane().add(idCad, gbc_idCad);
		
		idAtu = new JButton("Atualizar");
		idAtu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
				cliente.setNome(idnome.getText().toString());
				cliente.setEnd(idEnd.getText().toString()); 
				cliente.setTel(idTel.getText().toString());
		    	cliente.setId(Integer.parseInt(idTB.getText()));
				clienteController.executa(cliente,2);
				listar();
				}
			
		});
		GridBagConstraints gbc_idAtu = new GridBagConstraints();
		gbc_idAtu.gridwidth = 4;
		gbc_idAtu.insets = new Insets(0, 0, 5, 5);
		gbc_idAtu.gridx = 5;
		gbc_idAtu.gridy = 1;
		frameC.getContentPane().add(idAtu, gbc_idAtu);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int setar=table.getSelectedRow();
				idTB.setText(table.getModel().getValueAt(setar,0).toString());
				idnome.setText(table.getModel().getValueAt(setar,1).toString());
				idEnd.setText(table.getModel().getValueAt(setar,2).toString());
				idTel.setText(table.getModel().getValueAt(setar,3).toString());
				
			}
		});
		idApg = new JButton("Apagar");
		idApg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setId(Integer.parseInt(idTB.getText()));
				clienteController.executa(cliente,3);
				listar();
				LimparCampos();
			}
		});
		GridBagConstraints gbc_idApg = new GridBagConstraints();
		gbc_idApg.insets = new Insets(0, 0, 5, 5);
		gbc_idApg.gridx = 10;
		gbc_idApg.gridy = 1;
		frameC.getContentPane().add(idApg, gbc_idApg);
		
		idPes = new JButton("Pesquisar");
		idPes.setEnabled(false);
		idPes.setVisible(false);
		idPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setId(Integer.parseInt(idTB.getText()));
				clienteController.executa(cliente,4);
				
				idnome.setText(cliente.getNome());
				idTel.setText(cliente.getTel());
				idEnd.setText(cliente.getEnd());
				idTB.setText(Integer.toString(cliente.getId()));
			}
		});
		
		limpar = new JButton("Limpar Campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		GridBagConstraints gbc_limpar = new GridBagConstraints();
		gbc_limpar.insets = new Insets(0, 0, 5, 5);
		gbc_limpar.gridx = 12;
		gbc_limpar.gridy = 1;
		frameC.getContentPane().add(limpar, gbc_limpar);
		GridBagConstraints gbc_idPes = new GridBagConstraints();
		gbc_idPes.insets = new Insets(0, 0, 5, 5);
		gbc_idPes.gridx = 13;
		gbc_idPes.gridy = 1;
		frameC.getContentPane().add(idPes, gbc_idPes);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nome", "Tel", "End"
			}
		));
	
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 15;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		frameC.getContentPane().add(table, gbc_table);
		listar();
	}
	private void LimparCampos() {
		idnome.setText("");
		idEnd.setText("");
		idTel.setText("");
		idTB.setText("");
		idnome.requestFocus();
		
	}
	
	private void listar() {
		    DefaultTableModel model=(DefaultTableModel)table.getModel();
			ClienteB cli=new ClienteB();
			ArrayList dados=new ArrayList();
			dados=(ArrayList)cli.ListarTd();
			model.setNumRows(0);
			for(Object List:cli.ListarTd())
				model.addRow(new Object[] {
						((Cliente)List).getId(),
						((Cliente)List).getNome(),
						((Cliente)List).getEnd(),
						((Cliente)List).getTel()});
			}
public void setVisible(boolean b) {
			frameC.setVisible(true);
		
	



}}
		
	


