package medics.gui.primeira_tela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import medics.gui.login.Login;
import medics.gui.sobre.Sobre;
import medics.negocio.Fachada;
import medics.negocio.IFachada;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public  class PrimeiraTela extends JFrame {
    private static PrimeiraTela frame;
	private JPanel contentPane;
	public static boolean instanciar;
	private static PrimeiraTela instance;
	
	public static void main(String[] args) {
		 frame = new PrimeiraTela();
		 frame.setVisible(true);
	}
	
	public PrimeiraTela() {
	    setVisible(true);
		setForeground(Color.YELLOW);
		setBackground(SystemColor.desktop);
		setTitle("Medics");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kalefe\\Desktop\\Medics\\Sem t\u00EDtulo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 306);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Arquivo = new JMenu("Arquivo");
	    menuBar.add(Arquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		Arquivo.add(mntmSair);
		
		JMenu mnSobre = new JMenu("Ajuda");
		menuBar.add(mnSobre);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
			}
		});
		mnSobre.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnMdico = new JButton("M\u00E9dico");
		btnMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	       	    repaint();
	      		Login login = new Login(true, frame);
	      		login.setAtualFrame(frame);
	      		setContentPane(login);
	    		contentPane.setLayout(null);
	            validate();
		
			}
		});
		btnMdico.setBounds(79, 69, 110, 23);
		contentPane.add(btnMdico);
		
		JButton btnSecretria = new JButton("Secret\u00E1ria");
		btnSecretria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	       	    repaint();
	      		Login login = new Login(false, frame);
	      		login.setAtualFrame(frame);
	      		setContentPane(login);
	    		contentPane.setLayout(null);
	            validate();
			}
		});
		//btnSecretria.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSecretria.setBounds(79, 103, 110, 23);
		contentPane.add(btnSecretria);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		btnSair.setBounds(79, 137, 110, 23);
		contentPane.add(btnSair);

	}

}
