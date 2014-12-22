package medics.gui.exibir;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;

import medics.negocio.classes_basicas.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibirPaciente extends JFrame {

	private JPanel contentPane;

	public ExibirPaciente(Paciente paciente) {
		setResizable(false);
		setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 269);
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
		lblDataDeNasc.setBounds(171, 72, 89, 14);
		contentPane.add(lblDataDeNasc);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(43, 101, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(43, 129, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidae = new JLabel("Cidade:");
		lblCidae.setBounds(183, 129, 46, 14);
		contentPane.add(lblCidae);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(33, 154, 79, 14);
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
		btOk.setBounds(265, 190, 89, 23);
		contentPane.add(btOk);
		
		JLabel nome = new JLabel("");
		nome.setText(paciente.getPrimeiroNome());
		nome.setBounds(81, 47, 111, 14);
		contentPane.add(nome);
		
		JLabel sobrenome = new JLabel("");
		sobrenome.setText(paciente.getSegundoNome());
		sobrenome.setBounds(295, 47, 122, 14);
		contentPane.add(sobrenome);
		
		JLabel cpf = new JLabel("");
		cpf.setText(paciente.getCpf());
		cpf.setBounds(81, 72, 92, 14);
		contentPane.add(cpf);
		
		JLabel dia = new JLabel("");
		dia.setText(paciente.getDia());
		dia.setBounds(252, 72, 46, 14);
		contentPane.add(dia);
		
		JLabel lblNewLabelBarra = new JLabel("/");
		lblNewLabelBarra.setBounds(360, 72, 46, 14);
		contentPane.add(lblNewLabelBarra);
		
		JLabel lblNewLabelBarra_2 = new JLabel("/");
		lblNewLabelBarra_2.setBounds(295, 72, 46, 14);
		contentPane.add(lblNewLabelBarra_2);
		
		JLabel ano = new JLabel("");
		ano.setText(paciente.getAno());
		ano.setBounds(371, 72, 46, 14);
		contentPane.add(ano);
		
		JLabel mes = new JLabel("");		
		mes.setText(paciente.getMes());
		mes.setBounds(308, 72, 46, 14);
		contentPane.add(mes);
		
		JLabel rua = new JLabel("");
		rua.setText(paciente.getRua());
		rua.setBounds(81, 101, 246, 14);
		contentPane.add(rua);
		
		JLabel bairro = new JLabel("");
		bairro.setText(paciente.getBairro());
		bairro.setBounds(91, 129, 72, 14);
		contentPane.add(bairro);
		
		JLabel cidade = new JLabel("");
		cidade.setText(paciente.getCidade());
		cidade.setBounds(239, 129, 115, 14);
		contentPane.add(cidade);
		
		JLabel telefone = new JLabel("");
		telefone.setText(paciente.getTelefone());
		telefone.setBounds(99, 154, 74, 14);
		contentPane.add(telefone);
		
		JLabel email = new JLabel("");
		email.setText(paciente.getEmail());
		email.setBounds(239, 154, 167, 14);
		contentPane.add(email);
	}
}
