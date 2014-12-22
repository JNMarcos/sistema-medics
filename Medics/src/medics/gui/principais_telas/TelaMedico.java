package medics.gui.principais_telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import medics.gui.editar.EditarMedico;
import medics.gui.exibir.ExibirMedico;
import medics.gui.primeira_tela.PrimeiraTela;
import medics.gui.sobre.Sobre;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Consulta;
import medics.negocio.classes_basicas.Medico;

public class TelaMedico extends JFrame {
	public static IFachada fachada = Fachada.getInstance();
	private JPanel contentPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JFrame atualFrame;

	public TelaMedico(Medico medico ,String senha, String login) {
		Medico medicoInstance = fachada.exibirMedicoPorLogin(senha, login);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setTitle("Medics");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSairDaConta = new JMenuItem("Sair da conta");
		mntmSairDaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PrimeiraTela.main(null);
			}
		});
		mnArquivo.add(mntmSairDaConta);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
			}
		});
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 11, 651, 382);
		
		table = new JTable(modelo);
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("Data");
		modelo.addColumn("Hora");
		modelo.addColumn("Paciente");
		modelo.addColumn("Procedimento");
		modelo.addColumn("Codigo");

		carregarTabela(modelo, medicoInstance);
		contentPane.add(scrollPane);
		
		JButton btEditarConsulta = new JButton("Alterar Dados");
		btEditarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarMedico(true, medicoInstance, modelo);
			}
		});
		btEditarConsulta.setBounds(-18, 162, 123, 23);
		contentPane.add(btEditarConsulta);
		
		JLabel lblConsultas = new JLabel("Consultas:");
		lblConsultas.setBounds(10, 103, 87, 14);
		contentPane.add(lblConsultas);
		
		JButton exibirDados = new JButton("Exibir Dados");
		exibirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExibirMedico(medicoInstance);
			}
		});
		exibirDados.setBounds(-5, 191, 110, 23);
		contentPane.add(exibirDados);
		
		JButton btnNewButton = new JButton("Sair da conta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PrimeiraTela sair = new PrimeiraTela();
				sair.main(null);
			}
		});
		btnNewButton.setBounds(-18, 219, 121, 23);
		contentPane.add(btnNewButton);
	}
	
	public static void carregarTabela(DefaultTableModel modelo, Medico medico) {
		modelo.setNumRows(0);
		ArrayList<Consulta> consultas = fachada.agendaMedico(medico);

		if (consultas != null) {
			for (Consulta p : consultas) {
				if (p == null) {
					break;
				} else {
					modelo.addRow(new Object[] {
							p.getDia() + "/" + p.getMes() + "/" + p.getAno(),
							p.getHora()+":"+"00",
							p.getPaciente().getPrimeiroNome() + " "
									+ p.getPaciente().getSegundoNome(),
							p.getProcedimento().getNome(),
							p.getCodigo() });
				}
			}

		}

	}

	public JFrame getAtualFrame() {
		return atualFrame;
	}

	public void setAtualFrame(JFrame atualFrame) {
		this.atualFrame = atualFrame;
	}

}
