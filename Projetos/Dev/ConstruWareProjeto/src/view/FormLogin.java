package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FuncDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 312);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(47, 45, 98));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FormLogin.class.getResource("/imagens/logoEsq.png")));
		lblNewLabel.setBounds(162, 0, 308, 276);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 45, 98));
		panel.setForeground(new Color(127, 127, 127));
		panel.setBounds(0, 0, 164, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsurio = new JLabel("E-mail:");
		lblUsurio.setFont(new Font("Liberation Sans", Font.BOLD, 16));
		lblUsurio.setForeground(new Color(0, 0, 0));
		lblUsurio.setBounds(12, 60, 67, 15);
		panel.add(lblUsurio);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(12, 80, 140, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Liberation Sans", Font.BOLD, 16));
		lblSenha.setBounds(12, 111, 55, 15);
		panel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 131, 140, 19);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String email, senha;
					email = txtEmail.getText();
					senha = txtSenha.getText();
					FuncDAO dao = new FuncDAO();
					dao.efetuarLogin(email, senha);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "erro:"+ e);
				}
			}
		});
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(127, 127, 127));
		btnEntrar.setFont(new Font("Liberation Sans", Font.BOLD, 16));
		btnEntrar.setBounds(22, 172, 118, 19);
		panel.add(btnEntrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Liberation Sans", Font.BOLD, 16));
		btnCancelar.setBackground(new Color(127, 127, 127));
		btnCancelar.setBounds(22, 203, 118, 19);
		panel.add(btnCancelar);
	}
}
