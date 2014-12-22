package medics.gui.editar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import medics.gui.controladores.Medicos;
import medics.gui.controladores.Pacientes;
import medics.negocio.classes_basicas.Medico;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarMedico extends JFrame {
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTextField especialidade;
	private JTextField login;
	private JTextField senha;
	private JTextField telefone;
	private JTextField email;
	private JTextField cidade;
	private JTextField bairro;
	private JTextField rua;

	public EditarMedico(boolean medico, Medico antigoMedico, DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setTitle("Medics");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(33, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel sobreno = new JLabel("Sobrenome:");
		sobreno.setBounds(224, 44, 97, 14);
		contentPane.add(sobreno);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(33, 69, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de nasc.:");
		lblNewLabel_3.setBounds(166, 69, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rua:");
		lblNewLabel_4.setBounds(33, 94, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Bairro:");
		lblNewLabel_5.setBounds(33, 119, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(10, 144, 69, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Login:");
		lblNewLabel_7.setBounds(33, 169, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Especialidade:");
		lblNewLabel_8.setBounds(10, 195, 97, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cidade:");
		lblNewLabel_9.setBounds(224, 119, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email:");
		lblNewLabel_10.setBounds(224, 144, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Senha:");
		lblNewLabel_11.setBounds(209, 169, 86, 14);
		contentPane.add(lblNewLabel_11);
		
		especialidade = new JTextField();
		especialidade.setText(antigoMedico.getEspecialidade());
		especialidade.setBounds(101, 192, 154, 20);
		contentPane.add(especialidade);
		especialidade.setColumns(10);
		
		login = new JTextField();
		login.setText(antigoMedico.getLogin());
		login.setBounds(101, 166, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setText(antigoMedico.getSenha());
		senha.setBounds(290, 166, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		telefone = new JTextField();
		telefone.setText(antigoMedico.getTelefone());
		telefone.setBounds(101, 141, 86, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		email = new JTextField();
		email.setText(antigoMedico.getEmail());
		email.setBounds(290, 141, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		cidade = new JTextField();
		cidade.setText(antigoMedico.getCidade());
		cidade.setBounds(290, 116, 86, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		bairro = new JTextField();
		bairro.setText(antigoMedico.getBairro());
		bairro.setBounds(101, 116, 86, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);
		
		rua = new JTextField();
		rua.setText(antigoMedico.getRua());
		rua.setBounds(101, 91, 86, 20);
		contentPane.add(rua);
		rua.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(305, 223, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel nome = new JLabel("");
		nome.setText(antigoMedico.getPrimeiroNome());
		nome.setBounds(94, 44, 93, 14);
		contentPane.add(nome);
		
		JLabel sobrenome = new JLabel("");
		sobrenome.setText(antigoMedico.getSegundoNome());
		sobrenome.setBounds(322, 44, 104, 14);
		contentPane.add(sobrenome);
		
		JLabel cpf = new JLabel("");
		cpf.setText(antigoMedico.getCpf());
		cpf.setBounds(80, 69, 76, 14);
		contentPane.add(cpf);
		
		JLabel ano = new JLabel("");
		ano.setText(antigoMedico.getAno());
		ano.setBounds(370, 69, 46, 14);
		contentPane.add(ano);
		
		JLabel lblNewLabel_15 = new JLabel("/");
		lblNewLabel_15.setBounds(361, 69, 15, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel mes = new JLabel("");
	    mes.setText(antigoMedico.getMes());
		mes.setBounds(318, 69, 46, 14);
		contentPane.add(mes);
		
		JLabel lblNewLabel_16 = new JLabel("/");
		lblNewLabel_16.setBounds(306, 69, 15, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel dia = new JLabel("");
		dia.setText(antigoMedico.getDia());
		dia.setBounds(275, 69, 46, 14);
		contentPane.add(dia);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				antigoMedico.setRua(rua.getText());
				antigoMedico.setBairro(bairro.getText());
				antigoMedico.setCidade(cidade.getText());
				antigoMedico.setTelefone(telefone.getText());
				antigoMedico.setEmail(email.getText());
				antigoMedico.setLogin(login.getText());
				antigoMedico.setSenha(senha.getText());
				antigoMedico.setEspecialidade(especialidade.getText());

				
					JOptionPane.showMessageDialog(null,
							"Editado com sucesso !");
					Medicos tela = new Medicos();
					tela.carregarTabela(modelo);
					setVisible(false);
	
			}
		});
		btnNewButton.setBounds(206, 223, 89, 23);
		contentPane.add(btnNewButton);
	}
}
