package medics.gui.sobre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Sobre() {
	    setVisible(true);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEsseProgrmaFoi = new JLabel("Esse programa foi desenvolvido por :");
		lblEsseProgrmaFoi.setBounds(43, 32, 249, 14);
		contentPane.add(lblEsseProgrmaFoi);
		
		JLabel lblKallebeFelipeE = new JLabel("Kallebe Felipe e Jo\u00E3o Marcos.");
		lblKallebeFelipeE.setBounds(73, 57, 182, 14);
		contentPane.add(lblKallebeFelipeE);
		
		JLabel lblComoProjetoDe = new JLabel("Como projeto de disciplina da UFRPE.");
		lblComoProjetoDe.setBounds(62, 82, 254, 14);
		contentPane.add(lblComoProjetoDe);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(166, 107, 89, 23);
		contentPane.add(btnOk);
	}
}
