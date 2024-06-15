package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import dao.FuncionarioDAO;
	
public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	private static final Font LABEL_FONT = new Font("Liberation Sans", Font.BOLD, 16);
	private static final Font BUTTON_FONT = new Font("Liberation Sans", Font.BOLD, 16);
	private static final Color BUTTON_COLOR = new Color(127, 127, 127);
	private static final Color PANEL_BACKGROUND_COLOR = new Color(47, 45, 98);
	private static final Color TEXT_COLOR = Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FormLogin frame = new FormLogin();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 312);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addLogoLabel();
		addLoginPanel();
	}

	private void addLogoLabel() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FormLogin.class.getResource("/imagens/logoEsq.png")));
		lblNewLabel.setBounds(162, 0, 308, 276);
		contentPane.add(lblNewLabel);
	}

	private void addLoginPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(PANEL_BACKGROUND_COLOR);
		panel.setBounds(0, 0, 164, 276);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("E-mail:");
		lblUsuario.setFont(LABEL_FONT);
		lblUsuario.setForeground(TEXT_COLOR);
		lblUsuario.setBounds(12, 60, 67, 15);
		panel.add(lblUsuario);

		txtEmail = new JTextField();
		txtEmail.setBounds(12, 80, 140, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(TEXT_COLOR);
		lblSenha.setFont(LABEL_FONT);
		lblSenha.setBounds(12, 111, 55, 15);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 131, 140, 19);
		panel.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this::handleLogin);
		btnEntrar.setForeground(TEXT_COLOR);
		btnEntrar.setBackground(BUTTON_COLOR);
		btnEntrar.setFont(BUTTON_FONT);
		btnEntrar.setBounds(22, 172, 118, 19);
		panel.add(btnEntrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> dispose());
		btnCancelar.setForeground(TEXT_COLOR);
		btnCancelar.setFont(BUTTON_FONT);
		btnCancelar.setBackground(BUTTON_COLOR);
		btnCancelar.setBounds(22, 203, 118, 19);
		panel.add(btnCancelar);
	}

	private void handleLogin(ActionEvent event) {
		try {
			String email = txtEmail.getText();
			String senha = new String(txtSenha.getPassword());
			if (email.isEmpty() || senha.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
				return;
			}
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.efetuarLogin(email, senha);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
		}
	}
	
}
