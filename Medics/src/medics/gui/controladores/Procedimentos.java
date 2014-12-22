package medics.gui.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import medics.gui.cadastros.CadastroPaciente;
import medics.gui.cadastros.CadastroProcedimento;
import medics.gui.editar.EditarPaciente;
import medics.gui.exibir.ExibirPaciente;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Procedimento;

public class Procedimentos extends JPanel {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JFrame atualFrame;

	public Procedimentos() {
		setVisible(true);
		setLayout(null);
		modelo.setNumRows(0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 11, 152, 382);

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		modelo.addColumn("Nome");

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
		carregarTabela(modelo);
		add(scrollPane);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroProcedimento(modelo);
			}
		});
		btCadastrar.setBounds(0, 67, 105, 23);
		add(btCadastrar);

		JButton btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum procedimento selecionado!");
				} else {

					int result = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir ? ", "Excluir",
							JOptionPane.YES_NO_CANCEL_OPTION);
					int linha_selecionada = table.getSelectedRow();
					String nome = null;

					if (result == JOptionPane.YES_OPTION) {
						nome = table.getValueAt(linha_selecionada, 0)
								.toString();
						((DefaultTableModel) table.getModel()).removeRow(table
								.getSelectedRow());

						fachada.removerProcedimento(nome);

					}
				}
			}
		});
		btRemover.setBounds(0, 101, 105, 23);
		add(btRemover);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualFrame.setVisible(false);
				TelaSecretario telaAnterior = new TelaSecretario();
				telaAnterior.setAtualFrame(telaAnterior);

			}
		});
		btVoltar.setBounds(0, 135, 105, 23);
		add(btVoltar);

		JLabel lblPacientes = new JLabel("Procedimento");
		lblPacientes.setBounds(18, 42, 103, 14);
		add(lblPacientes);

	}

	public static void carregarTabela(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Procedimento> procedimentos = fachada
				.retornarListaProcedimento();

		if (procedimentos != null) {
			for (Procedimento p : procedimentos) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] { p.getNome() });
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
