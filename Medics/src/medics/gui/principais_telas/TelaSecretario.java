package medics.gui.principais_telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import medics.gui.cadastros.CadastroConsulta;
import medics.gui.controladores.Medicos;
import medics.gui.controladores.Pacientes;
import medics.gui.controladores.Procedimentos;
import medics.gui.editar.EditarConsulta;
import medics.gui.editar.EditarMedico;
import medics.gui.login.Login;
import medics.gui.primeira_tela.PrimeiraTela;
import medics.gui.sobre.Sobre;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;

public class TelaSecretario extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTable table;
	private JFrame atualFrame;

	public TelaSecretario() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setTitle("Medics");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 470);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSairDaConta = new JMenuItem("Sair da conta");
		mntmSairDaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PrimeiraTela.main(null);
			}
		});
		mnArquivo.add(mntmSairDaConta);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
			}
		});
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);

		table = new JTable(modelo);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		modelo.addColumn("Data");
		modelo.addColumn("Hora");
		modelo.addColumn("Paciente");
		modelo.addColumn("Procedimento");
		modelo.addColumn("Medico");
		modelo.addColumn("Codigo");

		carregarTabela(modelo);
		contentPane.add(scrollPane);

		JButton btMedicos = new JButton("Medicos");
		btMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				Medicos medicos = new Medicos();
				medicos.setAtualFrame(atualFrame);
				setContentPane(medicos);
				contentPane.setLayout(null);
				validate();
			}
		});
		btMedicos.setBounds(-6, 230, 110, 23);
		contentPane.add(btMedicos);

		JButton btPacientes = new JButton("Pacientes");
		btPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				Pacientes pacientes = new Pacientes();
				pacientes.setAtualFrame(atualFrame);
				setContentPane(pacientes);
				contentPane.setLayout(null);
				validate();
			}
		});
		btPacientes.setBounds(-21, 264, 126, 23);
		contentPane.add(btPacientes);

		JButton btnNewButton_2 = new JButton("Procedimentos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				Procedimentos procedimentos = new Procedimentos();
				procedimentos.setAtualFrame(atualFrame);
				setContentPane(procedimentos);
				contentPane.setLayout(null);
				validate();
			}
		});
		btnNewButton_2.setBounds(-21, 298, 126, 23);
		contentPane.add(btnNewButton_2);

		JButton btAddConsulta = new JButton("Nova Consulta");
		btAddConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroConsulta(modelo);
			}
		});
		btAddConsulta.setBounds(-21, 128, 126, 23);
		contentPane.add(btAddConsulta);

		JButton btRemoverConsulta = new JButton("Excluir");
		btRemoverConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma consulta selecionada!");
				} else {

					int result = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir ? ", "Excluir",
							JOptionPane.YES_NO_CANCEL_OPTION);
					int linha_selecionada = table.getSelectedRow();
					String codigo = null;

					if (result == JOptionPane.YES_OPTION) {
						codigo = table.getValueAt(linha_selecionada, 5)
								.toString();
						((DefaultTableModel) table.getModel()).removeRow(table
								.getSelectedRow());

						fachada.removerConsulta(codigo);

					}
				}
			}
		});
		btRemoverConsulta.setBounds(-6, 162, 110, 23);
		contentPane.add(btRemoverConsulta);

		JButton btEditarConsulta = new JButton("Remarcar");
		btEditarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha_selecionada = table.getSelectedRow();

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma consulta selecionada!");
				} else {
					new EditarConsulta(table.getValueAt(table.getSelectedRow(), 5)
							.toString(), modelo);
				}
	
			}
		});
		btEditarConsulta.setBounds(-6, 196, 110, 23);
		contentPane.add(btEditarConsulta);

		JLabel lblConsultas = new JLabel("Consultas:");
		lblConsultas.setBounds(10, 103, 87, 14);
		contentPane.add(lblConsultas);
	}

	public static void carregarTabela(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Consulta> consultas = fachada.retornarListaConsulta();

		if (consultas != null) {
			for (Consulta p : consultas) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] {
							p.getDia() + "/" + p.getMes() + "/" + p.getAno(),
							p.getHora()+":"+"00",
							p.getPaciente().getPrimeiroNome() + " "
									+ p.getPaciente().getSegundoNome(),
							p.getProcedimento().getNome(),
							p.getMedico().getPrimeiroNome() + " "
									+ p.getMedico().getSegundoNome(),
							p.getCodigo() });
				}
			}

		}

	}

	public JFrame getAtualFrame() {
		return atualFrame;
	}

	public void setAtualFrame(JFrame atualFrame) {
		this.atualFrame = atualFrame;
	}

}
