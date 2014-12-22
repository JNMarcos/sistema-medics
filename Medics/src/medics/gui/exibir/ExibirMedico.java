package medics.gui.exibir;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import medics.negocio.classes_basicas.Medico;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExibirMedico extends JFrame {

	private JPanel contentPane;

	public ExibirMedico(Medico medico) {
		setResizable(false);
		setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(43, 47, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(213, 47, 72, 14);
		contentPane.add(lblSobrenome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(43, 72, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblDataDeNasc = new JLabel("Data de nasc.:");
		lblDataDeNasc.setBounds(167, 72, 89, 14);
		contentPane.add(lblDataDeNasc);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(43, 101, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(43, 129, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidae = new JLabel("Cidade:");
		lblCidae.setBounds(199, 129, 46, 14);
		contentPane.add(lblCidae);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 154, 79, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(183, 154, 46, 14);
		contentPane.add(lblEmail);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btOk.setBounds(265, 213, 89, 23);
		contentPane.add(btOk);
		
		JLabel nome = new JLabel("");
		nome.setText(medico.getPrimeiroNome());
		nome.setBounds(81, 47, 111, 14);
		contentPane.add(nome);
		
		JLabel sobrenome = new JLabel("");
		sobrenome.setText(medico.getSegundoNome());
		sobrenome.setBounds(295, 47, 122, 14);
		contentPane.add(sobrenome);
		
		JLabel cpf = new JLabel("");
		cpf.setText(medico.getCpf());
		cpf.setBounds(81, 72, 92, 14);
		contentPane.add(cpf);
		
		JLabel dia = new JLabel("");
		dia.setText(medico.getDia());
		dia.setBounds(252, 72, 46, 14);
		contentPane.add(dia);
		
		JLabel lblNewLabelBarra = new JLabel("/");
		lblNewLabelBarra.setBounds(351, 72, 46, 14);
		contentPane.add(lblNewLabelBarra);
		
		JLabel lblNewLabelBarra_2 = new JLabel("/");
		lblNewLabelBarra_2.setBounds(295, 72, 46, 14);
		contentPane.add(lblNewLabelBarra_2);
		
		JLabel ano = new JLabel("");
		ano.setText(medico.getAno());
		ano.setBounds(371, 72, 46, 14);
		contentPane.add(ano);
		
		JLabel mes = new JLabel("");
		mes.setText(medico.getMes());
		mes.setBounds(308, 72, 46, 14);
		contentPane.add(mes);
		
		JLabel rua = new JLabel("");
		rua.setText(medico.getRua());
		rua.setBounds(81, 101, 246, 14);
		contentPane.add(rua);
		
		JLabel bairro = new JLabel("");
		bairro.setText(medico.getBairro());
		bairro.setBounds(100, 129, 89, 14);
		contentPane.add(bairro);
		
		JLabel cidade = new JLabel("");
		cidade.setText(medico.getCidade());
		cidade.setBounds(262, 129, 115, 14);
		contentPane.add(cidade);
		
		JLabel telefone = new JLabel("");
		telefone.setText(medico.getTelefone());
		telefone.setBounds(81, 154, 72, 14);
		contentPane.add(telefone);
		
		JLabel email = new JLabel("");
		email.setText(medico.getEmail());
		email.setBounds(239, 154, 178, 14);
		contentPane.add(email);
		
		JLabel lblNewLabel = new JLabel("Especialidade:");
		lblNewLabel.setBounds(10, 204, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(43, 179, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(183, 179, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel login = new JLabel("");
		login.setText(medico.getLogin());
		login.setBounds(81, 179, 92, 14);
		contentPane.add(login);
		
		JLabel senha = new JLabel("");
		senha.setText(medico.getSenha());
		senha.setBounds(239, 179, 127, 14);
		contentPane.add(senha);
		
		JLabel especialidade = new JLabel("");
		especialidade.setText(medico.getEspecialidade());
		especialidade.setBounds(127, 204, 111, 14);
		contentPane.add(especialidade);
	}

}
