package medics.gui.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import medics.gui.primeira_tela.PrimeiraTela;
import medics.gui.principais_telas.TelaMedico;
import medics.gui.principais_telas.TelaSecretario;
import medics.negocio.Fachada;
import medics.negocio.IFachada;
import medics.negocio.classes_basicas.Medico;
import medics.negocio.exceptions.NaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField tfLogin;
	private JPasswordField pwSenha;
	public static IFachada fachada = Fachada.getInstance();
	private JFrame atualFrame;

	/**
	 * Create the panel.
	 */
	public Login(boolean medico, JFrame frame) {
		setLayout(null);
		JLabel invalido = new JLabel("");

		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = tfLogin.getText();
				String senha = pwSenha.getText();

				if (medico == false) {
					try {
						fachada.verificarLogin(login, senha);
						frame.setVisible(false);
						TelaSecretario proximaTela = new TelaSecretario();
						proximaTela.setAtualFrame(proximaTela);
					} catch (NaoEncontradoException e1) {
                         invalido.setText("Usuário ou senha inválido.");
                         tfLogin.setText("");
                         pwSenha.setText("");
					}
				}else{
					try {
						Medico medico = fachada.verificarLoginMedico(login, senha);
						frame.setVisible(false);
						TelaMedico proximaTela = new TelaMedico(medico, senha, login);
					} catch (NaoEncontradoException e2) {
	                     invalido.setText("Usuário ou senha inválido.");
                         tfLogin.setText("");
                         pwSenha.setText("");
					}
				}
			}
		});
		btEntrar.setBounds(20, 126, 101, 23);
		add(btEntrar);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualFrame.setVisible(false);
				PrimeiraTela.main(null);
			}
		});
		btCancelar.setBounds(146, 126, 89, 23);
		add(btCancelar);

		tfLogin = new JTextField();
		tfLogin.setBounds(94, 64, 86, 20);
		add(tfLogin);
		tfLogin.setColumns(10);

		pwSenha = new JPasswordField();
		pwSenha.setBounds(94, 95, 89, 20);
		super.add(pwSenha);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(38, 67, 46, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(38, 101, 46, 14);
		add(lblNewLabel_1);

		invalido.setBounds(49, 39, 218, 14);
		add(invalido);

		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Medics !");
		lblBemVindoAo.setBounds(78, 171, 172, 14);
		super.add(lblBemVindoAo);

	}
	
	public JFrame getAtualFrame() {
		return atualFrame;
	}

	public void setAtualFrame(JFrame atualFrame) {
		this.atualFrame = atualFrame;
	}
}
