package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.ClienteDAO;
import dao.FuncDAO;
import model.Cliente;
import model.Funcionario;
import utilitarios.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class FormFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JComboBox<String> cbCargo;
	private JTextField txtTelefone;
	private JTextField txtRua;
	private JTextField txtNumCasa;
	private JTextField txtBairro;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JComboBox<String> cbEstado;
	private JTextField txtPesquisaNome;
	private JTable tabela;
	private JPasswordField passwordFieldSenha;
	private JTextField txtSalario;
	private JTextField txtCNH;
	private JTextField txtId;
	private void atualizarTabela() throws SQLException {
		FuncDAO dao = new FuncDAO();
		List<Funcionario> lista = null;
		lista = dao.Listar();
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setRowCount(0);
		for (Funcionario funcionario : lista) {
			modelo.addRow(new Object[]{
					funcionario.getId(),
					funcionario.getNome(),
					funcionario.getRg(),
					funcionario.getCpf(),
					funcionario.getCargo(),
					funcionario.getSalario(),
					funcionario.getCnh(),
					funcionario.getTelefone(),
					funcionario.getEmail(),
					funcionario.getCep(),
					funcionario.getEstado(),
					funcionario.getCidade(),
					funcionario.getRua(),
					funcionario.getBairro(),
					funcionario.getNum(),
			});
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncionarios frame = new FormFuncionarios();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.atualizarTabela();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException
	 */
	public FormFuncionarios() throws ParseException {
		setResizable(false);
		setTitle("Formulário de Funcionários");
		setBackground(new Color(127, 127, 127));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 127, 127));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(12, 12, 1, 1);
		contentPane.add(desktopPane);
		panel.setBackground(new Color(47, 45, 98));
		panel.setBounds(0, 0, 808, 40);
		contentPane.add(panel);

		JLabel lblCadastroDeFuncionarios = new JLabel("CADASTRO DE FUNCIONÁRIOS");
		lblCadastroDeFuncionarios.setBackground(new Color(0, 0, 0));
		lblCadastroDeFuncionarios.setFont(new Font("Liberation Sans", Font.BOLD, 25));
		lblCadastroDeFuncionarios.setForeground(new Color(0, 0, 0));
		panel.add(lblCadastroDeFuncionarios);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(47, 45, 98));
		tabbedPane.setBounds(-2, 51, 800, 350);
		contentPane.add(tabbedPane);

		JLabel Salario = new JLabel("SALÁRIO:");

		JPanel dadosPessoais = new JPanel();
		dadosPessoais.setBorder(null);
		dadosPessoais.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Dados Pessoais", null, dadosPessoais, null);
		tabbedPane.setEnabledAt(0, true);
		dadosPessoais.setLayout(null);

		JLabel lblCod = new JLabel("COD: ");
		lblCod.setForeground(new Color(0, 0, 0));
		lblCod.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCod.setBounds(77, 39, 41, 15);
		dadosPessoais.add(lblCod);

		JLabel lblCpf_1 = new JLabel("RG: ");
		lblCpf_1.setForeground(new Color(0, 0, 0));
		lblCpf_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1.setBounds(269, 72, 35, 15);
		dadosPessoais.add(lblCpf_1);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					Funcionario obj = new Funcionario();
					FuncDAO dao = new FuncDAO();

					obj = dao.PesquisarFunc(nome);
					if (obj.getNome() != null) {
						txtId.setText(String.valueOf(obj.getId()));
						txtNome.setText(obj.getNome());
						txtRG.setText(obj.getRg());
						txtCPF.setText(obj.getCpf());
						cbCargo.setSelectedItem(obj.getCargo());
						txtSalario.setText(String.valueOf(obj.getSalario()));
						txtCNH.setText(obj.getCnh());
						txtTelefone.setText(obj.getTelefone());
						txtEmail.setText(obj.getEmail());
						txtCEP.setText(obj.getCep());
						cbEstado.setSelectedItem(obj.getEstado());
						txtCidade.setText(obj.getCidade());
						txtRua.setText(obj.getRua());
						txtNumCasa.setText(String.valueOf(obj.getNum()));
						passwordFieldSenha.setText(nome);
						txtBairro.setText(obj.getSenha());

					} else {
						JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
					}
				}
			}
		});

		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNome.setText("\n");
		txtNome.setColumns(10);
		txtNome.setBounds(121, 102, 410, 19);
		dadosPessoais.add(txtNome);

		JLabel lblCpf_1_1 = new JLabel("NOME: ");
		lblCpf_1_1.setForeground(new Color(0, 0, 0));
		lblCpf_1_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1.setBounds(58, 104, 60, 15);
		dadosPessoais.add(lblCpf_1_1);

		JLabel lblCpf_1_1_1 = new JLabel("CELULAR: ");
		lblCpf_1_1_1.setForeground(new Color(0, 0, 0));
		lblCpf_1_1_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1_1.setBounds(506, 70, 78, 19);
		dadosPessoais.add(lblCpf_1_1_1);

		JLabel lblEndereco = new JLabel("ENDEREÇO:");
		lblEndereco.setForeground(new Color(0, 0, 0));
		lblEndereco.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEndereco.setBounds(241, 139, 90, 15);
		dadosPessoais.add(lblEndereco);

		txtRua = new JTextField();
		txtRua.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtRua.setBounds(341, 137, 412, 19);
		dadosPessoais.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(new Color(0, 0, 0));
		lblCep.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCep.setBounds(71, 139, 35, 15);
		dadosPessoais.add(lblCep);

		JLabel lblN = new JLabel("N°:");
		lblN.setForeground(new Color(0, 0, 0));
		lblN.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblN.setBounds(75, 169, 26, 15);
		dadosPessoais.add(lblN);

		txtNumCasa = new JTextField();
		txtNumCasa.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNumCasa.setColumns(10);
		txtNumCasa.setBounds(121, 167, 74, 19);
		dadosPessoais.add(txtNumCasa);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		txtBairro.setBounds(309, 169, 194, 19);
		dadosPessoais.add(txtBairro);

		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setForeground(new Color(0, 0, 0));
		lblBairro.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblBairro.setBounds(238, 171, 65, 15);
		dadosPessoais.add(lblBairro);

		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCEP.setColumns(10);
		txtCEP.setBounds(121, 136, 89, 19);
		dadosPessoais.add(txtCEP);

		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setForeground(new Color(0, 0, 0));
		lblCidade.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCidade.setBounds(525, 169, 70, 15);
		dadosPessoais.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(605, 167, 148, 19);
		dadosPessoais.add(txtCidade);

		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setForeground(new Color(0, 0, 0));
		lblEstado.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEstado.setBounds(625, 204, 68, 15);
		dadosPessoais.add(lblEstado);

		txtRG = new JTextField();
		txtRG.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtRG.setColumns(10);
		txtRG.setBounds(309, 68, 166, 19);
		dadosPessoais.add(txtRG);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setBounds(121, 70, 138, 19);
		dadosPessoais.add(txtCPF);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(585, 70, 168, 19);
		dadosPessoais.add(txtTelefone);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEmail.setBounds(58, 204, 60, 15);
		dadosPessoais.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(121, 202, 349, 19);
		dadosPessoais.add(txtEmail);

		cbEstado = new JComboBox<>();
		cbEstado.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		cbEstado.setForeground(new Color(0, 0, 0));
		cbEstado.setModel(new DefaultComboBoxModel<>(new String[]{"","AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbEstado.setSelectedIndex(0);
		cbEstado.setBounds(693, 197, 60, 22);
		dadosPessoais.add(cbEstado);

		cbCargo = new JComboBox();
		cbCargo.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		cbCargo.setForeground(new Color(0, 0, 0));
		cbCargo.setModel(new DefaultComboBoxModel<>(new String[]{"","Gerente","Atendente","Motorista"}));
		cbCargo.setSelectedIndex(0);
		cbCargo.setBounds(381, 237, 122, 22);
		dadosPessoais.add(cbCargo);

		JLabel lblSalario = new JLabel("SALÁRIO");
		lblSalario.setForeground(Color.BLACK);
		lblSalario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSalario.setBounds(550, 241, 60, 15);
		dadosPessoais.add(lblSalario);
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBounds(58, 241, 60, 15);
		dadosPessoais.add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(121, 239, 122, 20);
		dadosPessoais.add(passwordFieldSenha);
		lblSalario.setForeground(Color.BLACK);
		lblSalario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSalario.setBounds(552, 241, 78, 15);
		dadosPessoais.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtSalario.setColumns(10);
		txtSalario.setBounds(631, 239, 122, 19);
		dadosPessoais.add(txtSalario);

		JLabel lblCnh = new JLabel("CNH:");
		lblCnh.setForeground(Color.BLACK);
		lblCnh.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCnh.setBounds(566, 104, 35, 15);
		dadosPessoais.add(lblCnh);

		txtCNH = new JTextField();
		txtCNH.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCNH.setColumns(10);
		txtCNH.setBounds(608, 102, 145, 19);
		dadosPessoais.add(txtCNH);

		JLabel lblCargo = new JLabel("CARGO:");
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCargo.setBounds(298, 243, 78, 15);
		dadosPessoais.add(lblCargo);

		JLabel lblCpf_2 = new JLabel("CPF: ");
		lblCpf_2.setForeground(Color.BLACK);
		lblCpf_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCpf_2.setBounds(77, 74, 41, 15);
		dadosPessoais.add(lblCpf_2);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtId.setBounds(121, 37, 70, 19);
		dadosPessoais.add(txtId);
		txtId.setColumns(10);


		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBackground(new Color(119, 118, 123));
		panelPesquisa.setLayout(null);
		panelPesquisa.setBorder(null);
		tabbedPane.addTab("Pesquisar", null, panelPesquisa, null);

		txtPesquisaNome = new JTextField();
		txtPesquisaNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtPesquisaNome.setColumns(10);
		txtPesquisaNome.setBounds(139, 28, 398, 22);
		panelPesquisa.add(txtPesquisaNome);

		JLabel lblPesquisarNome = new JLabel("Nome: ");
		lblPesquisarNome.setForeground(Color.BLACK);
		lblPesquisarNome.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblPesquisarNome.setBounds(78, 30, 51, 16);
		panelPesquisa.add(lblPesquisarNome);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(FormFuncionarios.class.getResource("/imagens/pesquisar.png")));
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnPesquisar.setBounds(549, 22, 141, 34);
		panelPesquisa.add(btnPesquisar);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 795, 245);
		panelPesquisa.add(scrollPane);

		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = tabela.getSelectedRow();
				String id = tabela.getModel().getValueAt(row, 0).toString();
				FuncDAO dao = new FuncDAO();
				Funcionario obj = dao.PesquisarFuncionario(Integer.parseInt(id));
				if (obj != null) {
					txtId.setText(tabela.getValueAt(row, 0) != null ? tabela.getValueAt(row, 0).toString() : "");
					txtNome.setText(tabela.getValueAt(row, 1) != null ? tabela.getValueAt(row, 1).toString() : "");
					txtRG.setText(tabela.getValueAt(row, 2) != null ? tabela.getValueAt(row, 2).toString() : "");
					txtCPF.setText(tabela.getValueAt(row, 3) != null ? tabela.getValueAt(row, 3).toString() : "");
					cbCargo.setSelectedItem(tabela.getValueAt(row, 4) != null ? tabela.getValueAt(row, 4).toString() : "");
					txtSalario.setText(tabela.getValueAt(row, 5) != null ? tabela.getValueAt(row, 5).toString() : "");
					txtCNH.setText(tabela.getValueAt(row, 6) != null ? tabela.getValueAt(row, 6).toString() : "");
					txtTelefone.setText(tabela.getValueAt(row, 7) != null ? tabela.getValueAt(row, 7).toString() : "");
					txtEmail.setText(tabela.getValueAt(row, 8) != null ? tabela.getValueAt(row, 8).toString() : "");
					txtCEP.setText(tabela.getValueAt(row, 9) != null ? tabela.getValueAt(row, 9).toString() : "");
					cbEstado.setSelectedItem(tabela.getValueAt(row, 10) != null ? tabela.getValueAt(row, 10).toString() : "");
					txtCidade.setText(tabela.getValueAt(row, 11) != null ? tabela.getValueAt(row, 11).toString() : "");
					txtRua.setText(tabela.getValueAt(row, 12) != null ? tabela.getValueAt(row, 12).toString() : "");
					txtBairro.setText(tabela.getValueAt(row, 13) != null ? tabela.getValueAt(row, 13).toString() : "");
					txtNumCasa.setText(tabela.getValueAt(row, 14) != null ? tabela.getValueAt(row, 14).toString() : "");
					passwordFieldSenha.setText(tabela.getValueAt(row, 15) != null ? tabela.getValueAt(row, 15).toString() : "");
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"IdFuncionario", "Nome", "RG", "CPF", "Cargo", "Salario", "CNH", "Telefone", "Email", "CEP", "Estado", "Cidade", "Rua", "Bairro", "NumCasa", "Senha"
				}
				));
		tabela.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		tabela.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(tabela);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FuncDAO dao = new FuncDAO();
				List<Funcionario> list = (List<Funcionario>) dao.PesquisarFunc(txtPesquisaNome.getText());
				AtualizarTabela(list);
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(FormFuncionarios.class.getResource("/imagens/excluir.png")));
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnExcluir.setBounds(570, 412, 141, 43);
		contentPane.add(btnExcluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario obj = new Funcionario();
				obj.setNome(txtNome.getText());
				obj.setRg(txtRG.getText());
				obj.setCpf(txtCPF.getText());	
				obj.setTelefone(txtTelefone.getText());
				obj.setEmail(txtEmail.getText());
				obj.setCep(txtCEP.getText());
				obj.setEstado(cbEstado.getSelectedItem().toString());
				obj.setCidade(txtCidade.getText());
				obj.setRua(txtRua.getText());
				obj.setBairro(txtBairro.getText());
				obj.setNum(Integer.parseInt(txtNumCasa.getText()));
				obj.setCnh(txtCNH.getText());
				obj.setCargo(cbCargo.getSelectedItem().toString());
				double salario = Double.parseDouble(txtSalario.getText());
				obj.setSalario(salario);
				obj.setSenha(new String(passwordFieldSenha.getPassword()));



			FuncDAO dao = new FuncDAO();
			dao.Salvar(obj);
			Util util = new Util();
			util.LimpaTela(dadosPessoais);
			}
		});
		btnSalvar.setIcon(new ImageIcon(FormFuncionarios.class.getResource("/imagens/salvar.png")));
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnSalvar.setBounds(333, 412, 141, 43);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(FormFuncionarios.class.getResource("/imagens/editar.png")));
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnEditar.setBounds(96, 412, 141, 43);
		contentPane.add(btnEditar);

		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario obj = new Funcionario();
				obj.setId(Integer.valueOf(txtId.getText()));
				FuncDAO dao = new FuncDAO();
				dao.Excluir(obj);
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Funcionario obj = new Funcionario();
				obj.setNome(txtNome.getText());
				obj.setRg(txtRG.getText());
				obj.setCpf(txtCPF.getText());	
				obj.setTelefone(txtTelefone.getText());
				obj.setEmail(txtEmail.getText());
				obj.setCep(txtCEP.getText());
				obj.setEstado(cbEstado.getSelectedItem().toString());
				obj.setCidade(txtCidade.getText());
				obj.setRua(txtRua.getText());
				obj.setBairro(txtBairro.getText());
				obj.setNum(Integer.parseInt(txtNumCasa.getText()));
				obj.setCnh(txtCNH.getText());
				obj.setCargo(cbCargo.getSelectedItem().toString());
				double salario = Double.parseDouble(txtSalario.getText());
				obj.setSalario(salario);
				obj.setSenha(new String(passwordFieldSenha.getPassword()));

				FuncDAO dao = new FuncDAO();
				dao.Editar(obj);
				LimparCampos();
				AtualizarTabela();
			}
		});

		AtualizarTabela();
	}

	private void AtualizarTabela() {
		FuncDAO dao = new FuncDAO();
		List<Funcionario> list = dao.Listar();
		AtualizarTabela(list);
	}

	private void AtualizarTabela(List<Funcionario> list) {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
		for (Funcionario func : list) {
			model.addRow(new Object[]{
					func.getId(), func.getNome(), func.getRg(), func.getCpf(), func.getTelefone(),
					func.getEmail(), func.getCep(), func.getEstado(), func.getCidade(), func.getRua(),
					func.getBairro(), func.getNum()
			});
		}
	}

	private void LimparCampos() {

	}
}
