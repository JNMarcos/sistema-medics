package medics.gui.controladores;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import medics.gui.cadastros.CadastroPaciente;
import medics.gui.editar.EditarPaciente;
import medics.gui.exibir.ExibirPaciente;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Paciente;

import javax.swing.JTextField;

public class Pacientes extends JPanel {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JFrame atualFrame;

	public Pacientes() {
		setLayout(null);
		modelo.setNumRows(0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data de nascimento");
		modelo.addColumn("Bairro");
		modelo.addColumn("Cidade");

		carregarTabela(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(scrollPane);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroPaciente(modelo);
			}
		});
		btCadastrar.setBounds(0, 67, 105, 23);
		add(btCadastrar);

		JButton btRemover = new JButton("Excluir");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum paciente selecionado!");
				} else {

					int result = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir ? ", "Excluir",
							JOptionPane.YES_NO_CANCEL_OPTION);
					int linha_selecionada = table.getSelectedRow();
					String cpf = null;

					if (result == JOptionPane.YES_OPTION) {
						cpf = table.getValueAt(linha_selecionada, 1).toString();
						((DefaultTableModel) table.getModel()).removeRow(table
								.getSelectedRow());

						fachada.removerPaciente(cpf);

					}
				}
			}
		});
		btRemover.setBounds(0, 101, 105, 23);
		add(btRemover);

		JButton brEditrar = new JButton("Editar");
		brEditrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha_selecionada = table.getSelectedRow();
				String cpf = null;

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum paciente selecionado!");
				} else {
					cpf = table.getValueAt(linha_selecionada, 1).toString();

					Paciente paciente = fachada.exibirPaciente(cpf);
					new EditarPaciente(paciente, modelo);

				}
			}
		});
		brEditrar.setBounds(0, 135, 105, 23);
		add(brEditrar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualFrame.setVisible(false);
				TelaSecretario telaAnterior = new TelaSecretario();
				telaAnterior.setAtualFrame(telaAnterior);

			}
		});
		btVoltar.setBounds(0, 203, 105, 23);
		add(btVoltar);

		JButton exibir = new JButton("Exibir");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = null;

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum paciente selecionado!");
				} else {
					cpf = table.getValueAt(table.getSelectedRow(), 1).toString();

					Paciente paciente = fachada.exibirPaciente(cpf);
					new ExibirPaciente(paciente);

				}
			}
		});
		exibir.setBounds(0, 169, 105, 23);
		add(exibir);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(20, 42, 77, 14);
		add(lblPacientes);

	}

	public static void carregarTabela(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Paciente> pacientes = fachada.retornarListaPaciente();

		if (pacientes != null) {
			for (Paciente p : pacientes) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] {
							p.getPrimeiroNome() + " " + p.getSegundoNome(),
							p.getCpf(),
							p.getDia() + "/" + p.getMes() + "/" + p.getAno(),
							p.getBairro(), p.getCidade() });
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
