package medics.gui.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfEndereco;
	private JTextField tdCpf;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JTextField tfEspecialidade;

	public CadastroMedico() {
		CadastroMedico frame = new CadastroMedico();
		frame.setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Sem t\u00EDtulo.png"));
		setResizable(false);
		setTitle("Medics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(75, 33, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(247, 33, 86, 20);
		contentPane.add(tfSobrenome);
		tfSobrenome.setColumns(10);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(75, 64, 155, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(345, 64, 28, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(371, 64, 28, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(403, 64, 28, 20);
		contentPane.add(comboBox_2);
		
		tdCpf = new JTextField();
		tdCpf.setBounds(75, 94, 111, 20);
		contentPane.add(tdCpf);
		tdCpf.setColumns(10);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(75, 123, 86, 20);
		contentPane.add(tfBairro);
		tfBairro.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(229, 123, 86, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(75, 163, 86, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(229, 163, 144, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(75, 203, 86, 20);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(209, 203, 86, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(229, 237, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(342, 237, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setBounds(334, 95, 86, 20);
		contentPane.add(tfEspecialidade);
		tfEspecialidade.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(21, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setBounds(171, 36, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setBounds(21, 67, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setBounds(239, 64, 111, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setBounds(19, 97, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Especialidade:");
		lblNewLabel_5.setBounds(249, 97, 84, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Bairro:");
		lblNewLabel_6.setBounds(19, 126, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade:");
		lblNewLabel_7.setBounds(171, 129, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Telefone:");
		lblNewLabel_8.setBounds(21, 166, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Email:");
		lblNewLabel_9.setBounds(173, 166, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Login:");
		lblNewLabel_10.setBounds(19, 206, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Senha:");
		lblNewLabel_11.setBounds(171, 206, 46, 14);
		contentPane.add(lblNewLabel_11);

	
	}
}
