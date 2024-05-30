package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.Dialog.ModalExclusionType;

public class FormFuncionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtTelefone;
	private JTextField txtRua;
	private JTextField txtEndCasa;
	private JTextField txtBairro;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTextField txtId;
	private JComboBox<String> cbEstado; 
	private JComboBox<String> cbCargo; 
	private JTextField txtPesquisaNome;
	private JTable tabela;
	private JPasswordField txtSenha;

	
	private void atualizarTabela() {
	    ClienteDAO dao = new ClienteDAO();
	    List<Cliente> lista = dao.Listar();
	    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
	    modelo.setRowCount(0); 
	    for (Cliente cliente : lista) {
	        modelo.addRow(new Object[]{
	            cliente.getId(),
	            cliente.getNome(),
	            cliente.getRg(),
	            cliente.getCpf(),
	            cliente.getEmail(),
	            cliente.getCelular(),
	            cliente.getCep(),
	            cliente.getEndereco(),
	            cliente.getNum_end(),
	            cliente.getBairro(),
	            cliente.getCidade(),
	            cliente.getEstado()
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
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Formulário de Funcionários");
		setBackground(new Color(127, 127, 127));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 127, 127));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(12, 12, 1, 1);
		contentPane.add(desktopPane);
		panel.setBackground(new Color(47, 45, 98));
		panel.setBounds(0, 0, 714, 40);
		contentPane.add(panel);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE FUNCIONÁRIOS");
		lblCadastroDeClientes.setBackground(new Color(0, 0, 0));
		lblCadastroDeClientes.setFont(new Font("Liberation Sans", Font.BOLD, 25));
		lblCadastroDeClientes.setForeground(new Color(0, 0, 0));
		panel.add(lblCadastroDeClientes);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(47, 45, 98));
		tabbedPane.setBounds(-2, 46, 730, 300);
		contentPane.add(tabbedPane);
		
		JPanel dadosPessoais = new JPanel();
		dadosPessoais.setBorder(null);
		dadosPessoais.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Dados Pessoais", null, dadosPessoais, null);
		tabbedPane.setEnabledAt(0, true);
		dadosPessoais.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setForeground(new Color(0, 0, 0));
		lblCpf.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf.setBounds(57, 44, 41, 15);
		dadosPessoais.add(lblCpf);
		
		JLabel lblCpf_1 = new JLabel("RG: ");
		lblCpf_1.setForeground(new Color(0, 0, 0));
		lblCpf_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1.setBounds(249, 44, 35, 15);
		dadosPessoais.add(lblCpf_1);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					Funcionario obj = new Funcionario();
					FuncDAO dao = new FuncDAO();
					
					obj = (Funcionario) dao.PesquisarFunc(nome);
					if(obj.getNome() != null) {
						txtId.setText(String.valueOf(obj.getId()));
						txtNome.setText(obj.getNome());
						txtCPF.setText(obj.getCpf());
						txtRG.setText(obj.getRg());
						txtEmail.setText(obj.getEmail());
						txtSenha.setText(obj.getSenha());
						cbCargo.setSelectedItem(obj.getEstado());
						txtTelefone.setText(obj.getCelular());
						txtCEP.setText(obj.getCep());
						txtRua.setText(obj.getEndereco());
						txtEndCasa.setText(String.valueOf(obj.getNum_end()));
						txtCidade.setText(obj.getBairro());
						txtBairro.setText(obj.getCidade());
						cbEstado.setSelectedItem(obj.getEstado());
					} else{
						JOptionPane.showMessageDialog(null, "funcionario não encontrado!");
					}
				}
			}
		});
		
		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNome.setText("\n");
		txtNome.setColumns(10);
		txtNome.setBounds(101, 74, 410, 19);
		dadosPessoais.add(txtNome);
		
		JLabel lblCpf_1_1 = new JLabel("NOME: ");
		lblCpf_1_1.setForeground(new Color(0, 0, 0));
		lblCpf_1_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1.setBounds(43, 76, 60, 15);
		dadosPessoais.add(lblCpf_1_1);
		
		JLabel lblCpf_1_1_1 = new JLabel("CELULAR: ");
		lblCpf_1_1_1.setForeground(new Color(0, 0, 0));
		lblCpf_1_1_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1_1.setBounds(467, 40, 78, 19);
		dadosPessoais.add(lblCpf_1_1_1);
		
		JLabel lblEndereo = new JLabel("ENDEREÇO:");
		lblEndereo.setForeground(new Color(0, 0, 0));
		lblEndereo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEndereo.setBounds(197, 111, 90, 15);
		dadosPessoais.add(lblEndereo);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtRua.setBounds(289, 108, 389, 19);
		dadosPessoais.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(new Color(0, 0, 0));
		lblCep.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCep.setBounds(58, 111, 35, 15);
		dadosPessoais.add(lblCep);
		
		JLabel lblN = new JLabel("N°:");
		lblN.setForeground(new Color(0, 0, 0));
		lblN.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblN.setBounds(70, 141, 26, 15);
		dadosPessoais.add(lblN);
		
		txtEndCasa = new JTextField();
		txtEndCasa.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtEndCasa.setBounds(101, 140, 41, 19);
		dadosPessoais.add(txtEndCasa);
		txtEndCasa.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setForeground(new Color(0, 0, 0));
		lblBairro.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblBairro.setBounds(161, 144, 61, 15);
		dadosPessoais.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtBairro.setBounds(231, 139, 114, 19);
		dadosPessoais.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("CIDADE: ");
		lblCidade.setForeground(new Color(0, 0, 0));
		lblCidade.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCidade.setBounds(489, 141, 61, 15);
		dadosPessoais.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCidade.setBounds(557, 139, 119, 19);
		dadosPessoais.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("ESTADO:");
		lblUf.setForeground(new Color(0, 0, 0));
		lblUf.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblUf.setBounds(356, 141, 70, 15);
		dadosPessoais.add(lblUf);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEmail.setBounds(38, 177, 60, 15);
		dadosPessoais.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtEmail.setBounds(101, 175, 244, 19);
		dadosPessoais.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.setForeground(new Color(0, 0, 0));
		btnNovo.setBackground(new Color(47, 45, 98));
		btnNovo.setIcon(new ImageIcon(FormCliente.class.getResource("/imagens/add.png")));
		btnNovo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnNovo.setBounds(57, 231, 114, 36);
		dadosPessoais.add(btnNovo);
		
		

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(new Color(47, 45, 98));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setIcon(new ImageIcon(FormCliente.class.getResource("/imagens/salvar.png")));
		btnSalvar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			 Funcionario obj = new Funcionario();
			 obj.setId(Integer.valueOf(txtId.getText()));
			 obj.setNome(txtNome.getText());
			 obj.setCpf(txtCPF.getText());
			 obj.setRg(txtRG.getText());
			 obj.setEmail(txtEmail.getText());
			 obj.setSenha(txtSenha.getText());
			 obj.setCargo(cbCargo.getSelectedItem().toString());
			 obj.setCelular(txtTelefone.getText());
			 obj.setCep(txtCEP.getText());
			 obj.setEndereco(txtRua.getText());
			 obj.setNum_end(Integer.valueOf(txtEndCasa.getText()));
			 obj.setBairro(txtBairro.getText());
			 obj.setCidade(txtCidade.getText());
			 obj.setEstado(cbEstado.getSelectedItem().toString());
			 
			 FuncDAO dao = new FuncDAO();
			 dao.Salvar(obj);
			 Util util = new Util();
			 util.LimpaTela(dadosPessoais);
			 
			}
		});
		btnSalvar.setBounds(206, 231, 124, 36);
		dadosPessoais.add(btnSalvar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
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
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBackground(new Color(47, 45, 98));
		btnExcluir.setIcon(new ImageIcon(FormCliente.class.getResource("/imagens/excluir.png")));
		btnExcluir.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnExcluir.setBounds(521, 231, 135, 36);
		dadosPessoais.add(btnExcluir);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario obj = new Funcionario();
				 obj.setNome(txtNome.getText());
				 obj.setCpf(txtCPF.getText());
				 obj.setRg(txtRG.getText());
				 obj.setEmail(txtEmail.getText());
				 obj.setSenha(txtSenha.getText());
				 obj.setCargo(cbCargo.getSelectedItem().toString());
				 obj.setCelular(txtTelefone.getText());
				 obj.setCep(txtCEP.getText());
				 obj.setEndereco(txtRua.getText());
				 obj.setNum_end(Integer.valueOf(txtEndCasa.getText()));
				 obj.setBairro(txtBairro.getText());
				 obj.setCidade(txtCidade.getText());
				 obj.setEstado(cbEstado.getSelectedItem().toString());
				 obj.setId(Integer.valueOf(txtId.getText()));
				 
				 FuncDAO dao = new FuncDAO();
				 dao.Editar(obj);
				 Util util = new Util();
				 util.LimpaTela(dadosPessoais);
			}
		});
		btnEditar.setBackground(new Color(47, 45, 98));
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setIcon(new ImageIcon(FormCliente.class.getResource("/imagens/editar.png")));
		btnEditar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnEditar.setBounds(364, 231, 122, 36);
		dadosPessoais.add(btnEditar);
		
		JLabel lblCodigo = new JLabel("CÓDIGO:");
		lblCodigo.setForeground(new Color(0, 0, 0));
		lblCodigo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCodigo.setBounds(28, 14, 70, 15);
		dadosPessoais.add(lblCodigo);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtId.setBounds(100, 12, 70, 19);
		dadosPessoais.add(txtId);
		txtId.setColumns(10);
		
		txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCPF.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCPF.setBounds(100, 42, 114, 19);
		dadosPessoais.add(txtCPF);
		
		txtRG = new JFormattedTextField(new MaskFormatter("##.###.###-##"));
		txtRG.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtRG.setBounds(281, 42, 119, 19);
		dadosPessoais.add(txtRG);
		
		txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtTelefone.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtTelefone.setBounds(552, 39, 126, 19);
		dadosPessoais.add(txtTelefone);
		
		txtCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCEP.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCEP.setBounds(101, 109, 90, 19);
		dadosPessoais.add(txtCEP);
		
		cbEstado = new JComboBox<>();
		cbEstado.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbEstado.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		cbEstado.setBounds(423, 140, 50, 17);
		dadosPessoais.add(cbEstado);
		
		JButton btnPesquisar_1 = new JButton("PESQUISAR");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				Funcionario obj = new Funcionario();
				FuncDAO dao = new FuncDAO();
				
				obj = (Funcionario) dao.PesquisarFunc(nome);
				if(obj.getNome() != null) {
					txtId.setText(String.valueOf(obj.getId()));
					txtNome.setText(obj.getNome());
					txtCPF.setText(obj.getCpf());
					txtRG.setText(obj.getRg());
					txtEmail.setText(obj.getEmail());
					txtSenha.setText(obj.getSenha());
					cbCargo.setSelectedItem(obj.getEstado());
					txtTelefone.setText(obj.getCelular());
					txtCEP.setText(obj.getCep());
					txtRua.setText(obj.getEndereco());
					txtEndCasa.setText(String.valueOf(obj.getNum_end()));
					txtCidade.setText(obj.getBairro());
					txtBairro.setText(obj.getCidade());
					cbEstado.setSelectedItem(obj.getEstado());
				} else{
					JOptionPane.showMessageDialog(null, "funcionario não encontrado!");
				}
			}
		});
		btnPesquisar_1.setIcon(new ImageIcon(FormCliente.class.getResource("/imagens/pesquisar.png")));
		btnPesquisar_1.setForeground(Color.BLACK);
		btnPesquisar_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnPesquisar_1.setBackground(new Color(47, 45, 98));
		btnPesquisar_1.setBounds(523, 69, 156, 29);
		dadosPessoais.add(btnPesquisar_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(555, 175, 121, 19);
		dadosPessoais.add(txtSenha);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblSenha.setBounds(491, 177, 53, 15);
		dadosPessoais.add(lblSenha);
		
		cbCargo = new JComboBox<>();
		cbCargo.setModel(new DefaultComboBoxModel<>(new String[] {"Atendente","Gerente"}));
		cbCargo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		cbCargo.setBounds(555, 206, 121, 17);
		dadosPessoais.add(cbCargo);
		
		JPanel consultaClientes = new JPanel();
		consultaClientes.setBorder(null);
		consultaClientes.setForeground(new Color(0, 0, 0));
		consultaClientes.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Consulta de Funcionários", null, consultaClientes, null);
		consultaClientes.setLayout(null);
		
		JLabel lblCpf_1_1_2 = new JLabel("NOME: ");
		lblCpf_1_1_2.setForeground(new Color(0, 0, 0));
		lblCpf_1_1_2.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1_2.setBounds(142, 14, 60, 15);
		consultaClientes.add(lblCpf_1_1_2);
		
		txtPesquisaNome = new JTextField();
		txtPesquisaNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = "%"+txtPesquisaNome.getText()+"%";
			    FuncDAO dao = new FuncDAO();
			    List<Funcionario> lista = dao.Filtrar(nome);
			    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			    modelo.setRowCount(0); 
			    for (Funcionario f : lista) {
			        modelo.addRow(new Object[]{
			            f.getId(),
			            f.getNome(),
			            f.getRg(),
			            f.getCpf(),
			            f.getEmail(),
			            f.getSenha(),
			            f.getCargo(),
			            f.getCelular(),
			            f.getCep(),
			            f.getEndereco(),
			            f.getNum_end(),
			            f.getBairro(),
			            f.getCidade(),
			            f.getEstado()
			        });
			    }
				
			}
		});
		txtPesquisaNome.setText("\n");
		txtPesquisaNome.setColumns(10);
		txtPesquisaNome.setBounds(199, 12, 373, 19);
		consultaClientes.add(txtPesquisaNome);
		
		JScrollPane painelDados = new JScrollPane();
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
					int selectedRow = tabela.getSelectedRow();
		            txtId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
		            txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
		            txtRG.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
		            txtCPF.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
		            txtEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
		            txtSenha.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
		            cbCargo.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 7).toString());		            
		            txtTelefone.setText(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
		            txtCEP.setText(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
		            txtRua.setText(tabela.getValueAt(tabela.getSelectedRow(), 10).toString());
		            txtEndCasa.setText(tabela.getValueAt(tabela.getSelectedRow(), 11).toString());
		            txtBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 12).toString());
		            txtCidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 13).toString());
		            cbEstado.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 14).toString());
		            tabbedPane.setSelectedIndex(1);
		        }
		});		
		tabela.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		tabela.setBorder(null);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "RG", "CPF", "Email", "Senha", "Cargo", "Celular", "CEP", "Endere\u00E7o", "N\u00FAmero", "Bairro", "Cidade", "Estado"
			}
		));
		painelDados.setViewportView(tabela);
		painelDados.setBounds(0, 40, 714, 219);
		consultaClientes.add(painelDados);
		
		
	}
}
