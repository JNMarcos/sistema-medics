package medics.gui.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import medics.gui.controladores.Medicos;
import medics.gui.controladores.Pacientes;
import medics.gui.editar.EditarPaciente;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.CodigoExistenteException;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.MedicoOcupadoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class CadastroConsulta extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTable pacientes;
	private JTable medicos;
	private JTable procedimentos;
	private DefaultTableModel modeloPaciente = new DefaultTableModel();
	private DefaultTableModel modeloMedico = new DefaultTableModel();
	private DefaultTableModel modeloProcedimento = new DefaultTableModel();
	private JFormattedTextField codigo;
	boolean naoCadastrar;

	public CadastroConsulta(DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		pacientes = new JTable(modeloPaciente);
		pacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 322, 432);
		scrollPane.setViewportView(pacientes);

		modeloPaciente.addColumn("Paciente");
		modeloPaciente.addColumn("CPF");

		carregarTabelaPacientes(modeloPaciente);
		getContentPane().add(scrollPane);

		medicos = new JTable(modeloMedico);
		medicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(353, 11, 306, 432);
		scrollPane1.setViewportView(medicos);

		modeloMedico.addColumn("Medico");
		modeloMedico.addColumn("CPF");
		modeloMedico.addColumn("Especialidade");

		carregarTabelaMedicos(modeloMedico);
		getContentPane().add(scrollPane1);

		procedimentos = new JTable(modeloProcedimento);
		procedimentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(680, 11, 193, 432);
		scrollPane2.setViewportView(procedimentos);

		modeloProcedimento.addColumn("Procedimento");

		carregarTabelaProcedimentos(modeloProcedimento);
		getContentPane().add(scrollPane2);

		JSpinner hora = new JSpinner();
		hora.setModel(new SpinnerNumberModel(8, 8, 18, 1));
		hora.setBounds(319, 485, 46, 20);
		contentPane.add(hora);

		JLabel lblHoras = new JLabel("Hora:");
		lblHoras.setBounds(281, 488, 46, 14);
		contentPane.add(lblHoras);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 488, 46, 14);
		contentPane.add(lblData);

		JComboBox dia = new JComboBox();
		dia.addItem("1");
		dia.addItem("2");
		dia.addItem("3");
		dia.addItem("4");
		dia.addItem("5");
		dia.addItem("6");
		dia.addItem("7");
		dia.addItem("8");
		dia.addItem("9");
		dia.addItem("10");
		dia.addItem("11");
		dia.addItem("12");
		dia.addItem("13");
		dia.addItem("14");
		dia.addItem("15");
		dia.addItem("16");
		dia.addItem("17");
		dia.addItem("18");
		dia.addItem("19");
		dia.addItem("20");
		dia.addItem("21");
		dia.addItem("22");
		dia.addItem("23");
		dia.addItem("24");
		dia.addItem("25");
		dia.addItem("26");
		dia.addItem("27");
		dia.addItem("28");
		dia.addItem("29");
		dia.addItem("30");
		dia.addItem("31");
		dia.setBounds(48, 485, 46, 20);
		contentPane.add(dia);

		JComboBox mes = new JComboBox();
		mes.addItem("Jan");
		mes.addItem("Fev");
		mes.addItem("Mar");
		mes.addItem("Abr");
		mes.addItem("Mai");
		mes.addItem("Jun");
		mes.addItem("Jul");
		mes.addItem("Ago");
		mes.addItem("Set");
		mes.addItem("Out");
		mes.addItem("Nov");
		mes.addItem("Dez");
		mes.setBounds(99, 485, 52, 20);
		contentPane.add(mes);

		JComboBox ano = new JComboBox();
		ano.addItem("2020");
		ano.addItem("2019");
		ano.addItem("2018");
		ano.addItem("2017");
		ano.addItem("2016");
		ano.addItem("2015");
		ano.addItem("2014");
		ano.addItem("2013");
		ano.addItem("2012");
		ano.addItem("2011");
		ano.addItem("2010");

		ano.setBounds(161, 485, 59, 20);
		contentPane.add(ano);
		naoCadastrar = false;
		try {
			codigo = new JFormattedTextField(new MaskFormatter("######"));
		} catch (ParseException e3) {
			System.out.println("cheguei");
			naoCadastrar = true;
			codigo.setText("");
			e3.printStackTrace();
		}
		codigo.setBounds(449, 485, 67, 20);
		contentPane.add(codigo);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				int paciente_selecionado = pacientes.getSelectedRow();
				int medico_selecionado = medicos.getSelectedRow();
				int procedimento_selecionado = procedimentos.getSelectedRow();
				String horaEscolhida = null;
				String cpfPaciente = null;
				String cpfMedico = null;
				String procedimento = null;
				String codigoDigitado = null;
				String diaData = null;
				String mesData = null;
				String anoData = null;

				if (pacientes.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum paciente selecionado!");
				} else if (medicos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum medico selecionado!");
				} else if (procedimentos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Nenhum procedimento selecionado!");
				} else if (codigo.getValue() == null) {
					JOptionPane
							.showMessageDialog(null,
									"Código inválido ! Digite um código válido de 6 digitos.");
				} else {
					cpfPaciente = pacientes.getValueAt(paciente_selecionado, 1)
							.toString();
					cpfMedico = medicos.getValueAt(medico_selecionado, 1)
							.toString();
					procedimento = procedimentos.getValueAt(
							procedimento_selecionado, 0).toString();
					horaEscolhida = hora.getValue().toString();
					codigoDigitado = codigo.getText();
					diaData = (String) dia.getSelectedItem();
					mesData = (String) mes.getSelectedItem();
					anoData = (String) ano.getSelectedItem();

					try {

						fachada.cadastrarConsulta(cpfPaciente, cpfMedico,
								procedimento, diaData, mesData, anoData,
								horaEscolhida, codigoDigitado);
						JOptionPane.showMessageDialog(null,
								"Cadastrado com sucesso !");
						setVisible(false);
						TelaSecretario.carregarTabela(modelo);

					} catch (CodigoExistenteException e1) {
						JOptionPane.showMessageDialog(null, e1, "Medics",
								JOptionPane.ERROR_MESSAGE);
					} catch (MedicoOcupadoException e2) {
						JOptionPane.showMessageDialog(null, e2, "Medics",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(666, 484, 110, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(784, 484, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(398, 488, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblDigitos = new JLabel("6 Digitos");
		lblDigitos.setBounds(528, 488, 81, 14);
		contentPane.add(lblDigitos);

	}

	public static void carregarTabelaPacientes(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Paciente> pacientes = fachada.retornarListaPaciente();

		if (pacientes != null) {
			for (Paciente p : pacientes) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] {
							p.getPrimeiroNome() + " " + p.getSegundoNome(),
							p.getCpf() });
				}
			}
		}
	}

	public static void carregarTabelaMedicos(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ArrayList<Medico> medicos = fachada.retornarListaMedico();

		if (medicos != null) {

			for (Medico p : medicos) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] {
							p.getPrimeiroNome() + " " + p.getSegundoNome(),
							p.getCpf(), p.getEspecialidade() });
				}
			}
		}
	}

	public static void carregarTabelaProcedimentos(DefaultTableModel modelo) {
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
}
