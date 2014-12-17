package medics.gui.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import medics.gui.panel.Login;
import medics.gui.panel.Pacientes;

public class TelaSecretario extends JFrame {

	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;

	public TelaSecretario() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setTitle("Medics");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSairDaConta = new JMenuItem("Sair da conta");
		mnArquivo.add(mntmSairDaConta);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Data", "Hora", "Procedimento", "Medico", "Paciente"
			}
		));
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		contentPane.add(scrollPane);
		
		JButton btMedicos = new JButton("Medicos");
		btMedicos.setBounds(-6, 230, 110, 23);
		contentPane.add(btMedicos);
		
		JButton btPacientes = new JButton("Pacientes");
		btPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	       	    repaint();
	      		Pacientes pacientes = new Pacientes();
	      		setContentPane(pacientes);
	    		contentPane.setLayout(null);
	            validate();
			}
		});
		btPacientes.setBounds(-21, 264, 126, 23);
		contentPane.add(btPacientes);
		
		JButton btnNewButton_2 = new JButton("Procedimentos");
		btnNewButton_2.setBounds(-11, 298, 116, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btAddConsulta = new JButton("Cadastrar");
		btAddConsulta.setBounds(-21, 128, 126, 23);
		contentPane.add(btAddConsulta);
		
		JButton btRemoverConsulta = new JButton("Remover");
		btRemoverConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btRemoverConsulta.setBounds(-6, 162, 110, 23);
		contentPane.add(btRemoverConsulta);
		
		JButton btEditarConsulta = new JButton("Editar");
		btEditarConsulta.setBounds(-6, 196, 110, 23);
		contentPane.add(btEditarConsulta);
		
		JLabel lblConsultas = new JLabel("Consultas:");
		lblConsultas.setBounds(10, 103, 87, 14);
		contentPane.add(lblConsultas);
	}
}
