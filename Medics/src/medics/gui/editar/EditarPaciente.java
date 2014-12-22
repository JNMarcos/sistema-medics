package medics.gui.editar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import medics.gui.controladores.Pacientes;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.CpfExistenteException;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarPaciente extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextField rua;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField telefone;
	private JTextField email;
	private JPanel contentPane;

	public EditarPaciente(Paciente paciente, DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setTitle("Medics");
        setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		rua = new JTextField();
		rua.setText(paciente.getRua());
		rua.setBounds(70, 100, 223, 20);
		contentPane.add(rua);
		rua.setColumns(10);

		bairro = new JTextField();
		bairro.setText(paciente.getBairro());
		bairro.setBounds(70, 139, 86, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);

		cidade = new JTextField();
		cidade.setText(paciente.getCidade());
		cidade.setBounds(222, 139, 86, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);

		telefone = new JTextField();
		telefone.setText(paciente.getTelefone());
		telefone.setBounds(70, 170, 86, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);

		email = new JTextField();
		email.setText(paciente.getEmail());
		email.setBounds(222, 170, 150, 20);
		contentPane.add(email);
		email.setColumns(10);

	
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(321, 223, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(14, 41, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setBounds(166, 41, 83, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(14, 72, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Data de Nasci.:");
		lblNewLabel_3.setBounds(166, 75, 127, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rua:");
		lblNewLabel_4.setBounds(14, 103, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bairro:");
		lblNewLabel_5.setBounds(14, 142, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cidade:");
		lblNewLabel_6.setBounds(166, 142, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setBounds(14, 173, 60, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Email:");
		lblNewLabel_8.setBounds(166, 173, 46, 14);
		contentPane.add(lblNewLabel_8);
	
		JButton btCadastrar = new JButton("OK");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paciente.setRua(rua.getText());
				paciente.setBairro(bairro.getText());
				paciente.setCidade(cidade.getText());
				paciente.setTelefone(telefone.getText());
				paciente.setEmail(email.getText());

				
					JOptionPane.showMessageDialog(null,
							"Editado com sucesso !");
					Pacientes tela = new Pacientes();
					tela.carregarTabela(modelo);
					setVisible(false);
	

			}
		});
		btCadastrar.setBounds(198, 223, 95, 23);
		contentPane.add(btCadastrar);
		
		JLabel nome = new JLabel("");
		nome.setText(paciente.getPrimeiroNome());
		nome.setBounds(70, 41, 86, 14);
		contentPane.add(nome);
		
		JLabel sobrenome = new JLabel("");
		sobrenome.setText(paciente.getSegundoNome());
		sobrenome.setBounds(233, 41, 179, 14);
		contentPane.add(sobrenome);
		
		JLabel cpf = new JLabel("");
		cpf.setText(paciente.getCpf());
		cpf.setBounds(50, 72, 118, 14);
		contentPane.add(cpf);
		
		JLabel dia = new JLabel("");
		dia.setText(paciente.getDia());
		dia.setBounds(255, 72, 46, 14);
		contentPane.add(dia);
		
		JLabel lblNewLabel_9 = new JLabel("/");
		lblNewLabel_9.setBounds(300, 72, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel mes = new JLabel("");
		mes.setText(paciente.getMes());
		mes.setBounds(313, 72, 46, 14);
		contentPane.add(mes);
		
		JLabel lblNewLabel_10 = new JLabel("/");
		lblNewLabel_10.setBounds(356, 72, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel ano = new JLabel("");
		ano.setText(paciente.getAno());
		ano.setBounds(369, 72, 65, 14);
		contentPane.add(ano);

	}
}
