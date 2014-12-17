package medics.gui.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CadastroProcedimento extends JFrame {

	private JPanel contentPane;
	private JTextField tfProcedimento;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CadastroProcedimento() {
		CadastroProcedimento frame = new CadastroProcedimento();
		frame.setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btCadastrar.setBounds(84, 58, 89, 23);
		contentPane.add(btCadastrar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(183, 58, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(34, 30, 139, 14);
		contentPane.add(lblProcedimento);
	}
}
