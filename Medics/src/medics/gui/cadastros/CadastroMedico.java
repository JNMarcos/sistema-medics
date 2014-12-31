package medics.gui.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import medics.gui.controladores.Medicos;
import medics.gui.controladores.Pacientes;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.classes_basicas.Paciente;
import medics.negocio.exceptions.CpfExistenteException;
import medics.negocio.exceptions.LoginExistenteException;
import medics.negocio.exceptions.SenhaExistenteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class CadastroMedico extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;
	private JTextField nome;
	private JTextField sobrenome;
	private JTextField rua;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField email;
	private JTextField login;
	private JTextField senha;
	private JTextField especialidade;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;

	public CadastroMedico(DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(33, 29, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setBounds(185, 29, 89, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cpf:");
		lblNewLabel_2.setBounds(33, 54, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Data de nas.:");
		lblNewLabel_3.setBounds(185, 54, 89, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rua:");
		lblNewLabel_4.setBounds(33, 79, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bairro:");
		lblNewLabel_5.setBounds(33, 104, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cidade:");
		lblNewLabel_6.setBounds(185, 104, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Telefone:");
		lblNewLabel_7.setBounds(10, 129, 69, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(185, 129, 46, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Login:");
		lblNewLabel_9.setBounds(33, 154, 46, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Senha:");
		lblNewLabel_10.setBounds(185, 154, 46, 14);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Especialidade:");
		lblNewLabel_11.setBounds(0, 184, 106, 14);
		contentPane.add(lblNewLabel_11);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(284, 215, 89, 23);
		contentPane.add(btnNewButton_1);

		nome = new JTextField();
		nome.setBounds(88, 26, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		sobrenome = new JTextField();
		sobrenome.setBounds(287, 26, 106, 20);
		contentPane.add(sobrenome);
		sobrenome.setColumns(10);

		rua = new JTextField();
		rua.setBounds(88, 76, 143, 20);
		contentPane.add(rua);
		rua.setColumns(10);

		bairro = new JTextField();
		bairro.setBounds(89, 101, 86, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);

		cidade = new JTextField();
		cidade.setBounds(241, 101, 86, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);

		email = new JTextField();
		email.setBounds(241, 127, 152, 20);
		contentPane.add(email);
		email.setColumns(10);

		login = new JTextField();
		login.setBounds(89, 151, 86, 20);
		contentPane.add(login);
		login.setColumns(10);

		senha = new JTextField();
		senha.setBounds(241, 151, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		especialidade = new JTextField();
		especialidade.setBounds(88, 181, 123, 20);
		contentPane.add(especialidade);
		especialidade.setColumns(10);

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
		dia.setBounds(268, 54, 46, 20);
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
		mes.setBounds(319, 54, 46, 20);
		contentPane.add(mes);

		JComboBox ano = new JComboBox();
		ano.setBounds(365, 54, 59, 20);
		ano.addItem("2014");
		ano.addItem("2013");
		ano.addItem("2012");
		ano.addItem("2011");
		ano.addItem("2010");
		ano.addItem("2009");
		ano.addItem("2008");
		ano.addItem("2007");
		ano.addItem("2006");
		ano.addItem("2005");
		ano.addItem("2004");
		ano.addItem("2003");
		ano.addItem("2002");
		ano.addItem("2001");
		ano.addItem("2000");
		ano.addItem("1999");
		ano.addItem("1998");
		ano.addItem("1997");
		ano.addItem("1996");
		ano.addItem("1995");
		ano.addItem("1994");
		ano.addItem("1993");
		ano.addItem("1992");
		ano.addItem("1991");
		ano.addItem("1990");
		ano.addItem("1989");
		ano.addItem("1988");
		ano.addItem("1987");
		ano.addItem("1986");
		ano.addItem("1985");
		ano.addItem("1984");
		ano.addItem("1983");
		ano.addItem("1982");
		ano.addItem("1981");
		ano.addItem("1980");
		ano.addItem("1979");
		ano.addItem("1978");
		ano.addItem("1977");
		ano.addItem("1976");
		ano.addItem("1975");
		ano.addItem("1974");
		ano.addItem("1973");
		ano.addItem("1972");
		ano.addItem("1971");
		ano.addItem("1970");
		ano.addItem("1969");
		ano.addItem("1968");
		ano.addItem("1967");
		ano.addItem("1966");
		ano.addItem("1965");
		ano.addItem("1964");
		ano.addItem("1963");
		ano.addItem("1962");
		ano.addItem("1961");
		ano.addItem("1960");
		ano.addItem("1959");
		ano.addItem("1958");
		ano.addItem("1957");
		ano.addItem("1956");
		ano.addItem("1955");
		ano.addItem("1954");
		ano.addItem("1953");
		ano.addItem("1952");
		ano.addItem("1951");
		ano.addItem("1950");
		ano.addItem("1949");
		ano.addItem("1948");
		ano.addItem("1947");
		ano.addItem("1946");
		ano.addItem("1945");
		ano.addItem("1944");
		ano.addItem("1943");
		ano.addItem("1942");
		ano.addItem("1941");
		ano.addItem("1940");
		ano.addItem("1939");
		ano.addItem("1938");
		ano.addItem("1937");
		ano.addItem("1936");
		ano.addItem("1935");
		ano.addItem("1934");
		ano.addItem("1933");
		ano.addItem("1932");
		ano.addItem("1931");
		ano.addItem("1930");
		ano.addItem("1929");
		ano.addItem("1928");
		ano.addItem("1927");
		ano.addItem("1926");
		ano.addItem("1925");
		ano.addItem("1924");
		ano.addItem("1923");
		ano.addItem("1922");
		ano.addItem("1921");
		ano.addItem("1920");
		ano.addItem("1919");
		ano.addItem("1918");
		ano.addItem("1917");
		ano.addItem("1916");
		ano.addItem("1915");
		ano.addItem("1914");
		ano.addItem("1913");
		ano.addItem("1912");
		ano.addItem("1911");
		ano.addItem("1910");
		ano.addItem("1909");
		ano.addItem("1908");
		ano.addItem("1907");
		ano.addItem("1906");
		ano.addItem("1905");
		ano.addItem("1904");
		ano.addItem("1903");
		ano.addItem("1902");
		ano.addItem("1901");
		ano.addItem("1900");
		ano.addItem("1899");
		ano.addItem("1898");
		ano.addItem("1897");
		ano.addItem("1896");
		ano.addItem("1895");
		ano.addItem("1894");
		ano.addItem("1893");
		ano.addItem("1892");
		ano.addItem("1891");
		ano.addItem("1890");
		ano.addItem("1889");
		ano.addItem("1888");
		ano.addItem("1887");
		ano.addItem("1886");
		ano.addItem("1885");
		ano.addItem("1884");
		ano.addItem("1883");
		ano.addItem("1882");
		ano.addItem("1881");
		contentPane.add(ano);
		
		try {
			cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e4) {
			cpf.setText("");
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		cpf.setBounds(89, 51, 86, 20);
		contentPane.add(cpf);
		
		try {
			telefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e4) {
			telefone.setText("");
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		telefone.setBounds(89, 126, 86, 20);
		contentPane.add(telefone);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nome.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Nome inválido ! ", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else if (sobrenome.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Sobrenome inválido !", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else if (senha.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Senha inválida ! ", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else if (login.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Login inválido ! ", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else if (especialidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Especialidade inválida ! ", "Medics",
							JOptionPane.ERROR_MESSAGE);
				} else if (cpf.getText().equals("") || cpf.getText().length() < 7) {
					JOptionPane.showMessageDialog(null, "CPF inválido !",
							"Medics", JOptionPane.ERROR_MESSAGE);
				} else {
					Medico medico = new Medico();

					medico.setPrimeiroNome(nome.getText());
					medico.setSegundoNome(sobrenome.getText());
					medico.setCpf(cpf.getText());
					medico.setRua(rua.getText());
					medico.setBairro(bairro.getText());
					medico.setCidade(cidade.getText());
					medico.setTelefone(telefone.getText());
					medico.setEmail(email.getText());
					medico.setEspecialidade(especialidade.getText());
					medico.setSenha(senha.getText());
					medico.setLogin(login.getText());
					medico.setDia((String) dia.getSelectedItem());
					medico.setMes((String) mes.getSelectedItem());
					medico.setAno((String) ano.getSelectedItem());
					try {
						fachada.cadastrarMedico(medico);
						JOptionPane.showMessageDialog(null,
								"Cadastrado com sucesso !");
						Medicos tela = new Medicos();
						tela.carregarTabela(modelo);
						setVisible(false);
					} catch (CpfExistenteException e1) {
						JOptionPane.showMessageDialog(null, e1, "Medics",
								JOptionPane.ERROR_MESSAGE);
					} catch (LoginExistenteException e2) {
						JOptionPane.showMessageDialog(null, e2, "Medics",
								JOptionPane.ERROR_MESSAGE);
					} catch (SenhaExistenteException e3) {
						JOptionPane.showMessageDialog(null, e3, "Medics",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnNewButton.setBounds(168, 215, 106, 23);
		contentPane.add(btnNewButton);

	}
}
