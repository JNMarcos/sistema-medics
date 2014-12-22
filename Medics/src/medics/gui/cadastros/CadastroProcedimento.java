package medics.gui.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import medics.gui.controladores.Pacientes;
import medics.gui.controladores.Procedimentos;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Procedimento;
import medics.negocio.exceptions.CpfExistenteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProcedimento extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTextField tfProcedimento;

	public CadastroProcedimento(DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfProcedimento = new JTextField();
		tfProcedimento.setBounds(140, 27, 132, 20);
		contentPane.add(tfProcedimento);
		tfProcedimento.setColumns(10);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfProcedimento.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Procedimento inválido !", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else {

					Procedimento procedimento = new Procedimento();
					procedimento.setNome(tfProcedimento.getText());
					fachada.cadastrarProcedimento(procedimento);
					JOptionPane.showMessageDialog(null,
							"Cadastrado com sucesso !");
					Procedimentos procedimentos = new Procedimentos();
					procedimentos.carregarTabela(modelo);
					setVisible(false);
				}
			}
		});
		btCadastrar.setBounds(74, 58, 99, 23);
		contentPane.add(btCadastrar);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(183, 58, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(34, 30, 139, 14);
		contentPane.add(lblProcedimento);
	}
}
