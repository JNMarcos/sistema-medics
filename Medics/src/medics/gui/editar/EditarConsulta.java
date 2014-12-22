package medics.gui.editar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import medics.gui.controladores.Pacientes;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarConsulta extends JFrame {
	private DefaultTableModel modelo = new DefaultTableModel();
	public static IFachada fachada = Fachada.getInstance();
	private JPanel contentPane;

	public EditarConsulta(String codigo, DefaultTableModel modelo) {
		setResizable(false);
		this.modelo = modelo;
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(321, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNovaHora = new JLabel("Nova hora: ");
		lblNovaHora.setBounds(259, 21, 89, 14);
		contentPane.add(lblNovaHora);
		
		JLabel lblNovaData = new JLabel("Nova Data:");
		lblNovaData.setBounds(10, 21, 80, 14);
		contentPane.add(lblNovaData);
				
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
		dia.setBounds(71, 18, 33, 20);
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
		mes.setBounds(114, 18, 57, 20);
		contentPane.add(mes);
		
		JComboBox ano = new JComboBox();
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
		ano.setBounds(181, 18, 56, 20);
		contentPane.add(ano);
		
		JSpinner hora = new JSpinner();
		hora.setModel(new SpinnerNumberModel(8, 8, 16, 1));
		hora.setBounds(335, 18, 51, 20);
		contentPane.add(hora);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novoDia = dia.getSelectedItem().toString();
				String novoMes = mes.getSelectedItem().toString();;
				String novoAno = ano.getSelectedItem().toString();
				String novaHora = hora.getValue().toString();
		
				fachada.editarConsulta(novoDia, novoMes, novoAno, codigo, novaHora);
				TelaSecretario.carregarTabela(modelo);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(222, 59, 89, 23);
		contentPane.add(btnNewButton);
	}

}
