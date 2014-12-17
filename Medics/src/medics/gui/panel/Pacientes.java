package medics.gui.panel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import medics.gui.frames.CadastroPaciente;
import medics.gui.frames.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Paciente;

import javax.swing.JTextField;

public class Pacientes extends JPanel {
	public static IFachada fachada = Fachada.getInstance();
	private static DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	public static boolean construirColuna = false;

	/**
	 * Create the panel.
	 */
	public Pacientes() {
		setLayout(null);
		modelo.setNumRows(0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);

		// modelo.addRow(new Object[]{"Ola","Ola","Ola","Ola","OLA"});
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		carregarTabela();
		try{
		modelo.removeRow(5);
		}catch(java.lang.ArrayIndexOutOfBoundsException e1){
			
		}
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data de nascimento");
		modelo.addColumn("Bairro");
		modelo.addColumn("Cidade");

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(scrollPane);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroPaciente();
			}
		});
		btCadastrar.setBounds(0, 67, 105, 23);
		add(btCadastrar);

		JButton btRemover = new JButton("Remover");
		btRemover.setBounds(0, 101, 105, 23);
		add(btRemover);

		JButton brEditrar = new JButton("Editar");
		brEditrar.setBounds(0, 135, 105, 23);
		add(brEditrar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaSecretario();
			}
		});
		btVoltar.setBounds(0, 169, 105, 23);
		add(btVoltar);

	}

	public static void carregarTabela() {

		ArrayList<Paciente> pacientes = fachada.retornarListaPaciente();

		if (pacientes != null) {
			for (Paciente p : pacientes) {
				if (p == null) {
					break;
				} else {
					System.out.println( p.getPrimeiroNome()+" "+p.getSegundoNome()+" "+ p.getCpf()+" "+ p.getBairro()+" "+ p.getCidade());
					modelo.addRow(new Object[] { p.getPrimeiroNome(),
 							p.getSegundoNome(), p.getCpf(), p.getBairro(),
							p.getCidade()});
				}
			}

		}

	}
	
	
}
