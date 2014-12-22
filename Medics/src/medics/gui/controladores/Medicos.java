package medics.gui.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import medics.gui.cadastros.CadastroMedico;
import medics.gui.cadastros.CadastroPaciente;
import medics.gui.editar.EditarMedico;
import medics.gui.editar.EditarPaciente;
import medics.gui.exibir.ExibirMedico;
import medics.gui.exibir.ExibirPaciente;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;

import javax.swing.JLabel;

public class Medicos extends JPanel {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JFrame atualFrame;

	/**
	 * Create the panel.
	 */
	public Medicos() {
		setLayout(null);
		modelo.setNumRows(0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data de nascimento");
		modelo.addColumn("Especialidade");
		modelo.addColumn("Login");
		modelo.addColumn("Senha");

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
		carregarTabela(modelo);
		add(scrollPane);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroMedico(modelo);
			}
		});
		btCadastrar.setBounds(0, 67, 105, 23);
		add(btCadastrar);

		JButton btRemover = new JButton("Excluir");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum medico selecionado!");
				}else{

					int result = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir ? ", "Excluir",
							JOptionPane.YES_NO_CANCEL_OPTION);
					int linha_selecionada = table.getSelectedRow();
					String cpf = null;

					if (result == JOptionPane.YES_OPTION) {
						cpf = table.getValueAt(linha_selecionada, 1).toString();
						((DefaultTableModel) table.getModel()).removeRow(table
								.getSelectedRow());

						fachada.removerMedico(cpf);

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
							"Nenhum medico selecionado!");
				} else {
					cpf = table.getValueAt(linha_selecionada, 1).toString();

					Medico medico = fachada.exibirMedico(cpf);
					new EditarMedico(false, medico, modelo);

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

		JButton btnNewButton = new JButton("Exibir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha_selecionada = table.getSelectedRow();
				String cpf = null;

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum medico selecionado!");
				} else {
					cpf = table.getValueAt(linha_selecionada, 1).toString();

					Medico medico = fachada.exibirMedico(cpf);
					new ExibirMedico(medico);

				}

			}
		});
		btnNewButton.setBounds(0, 169, 105, 23);
		add(btnNewButton);

		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setBounds(23, 42, 74, 14);
		add(lblMedicos);

	}

	public static void carregarTabela(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Medico> medicos = fachada.retornarListaMedico();

		if (medicos != null) {

			for (Medico p : medicos) {
				if (p == null) {
					break;
				} else { 
					modelo.addRow(new Object[] {
							p.getPrimeiroNome() + " " + p.getSegundoNome(),
							p.getCpf(),
							p.getDia() + "/" + p.getMes() + "/" + p.getAno(),
							p.getEspecialidade(), p.getLogin(), p.getSenha() });
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
