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
		setLocationRelativeTo(null);
		
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
		ano.setBounds(181, 18, 56, 20);
		contentPane.add(ano);
		
		JSpinner hora = new JSpinner();
		hora.setModel(new SpinnerNumberModel(8, 8, 18, 1));
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
