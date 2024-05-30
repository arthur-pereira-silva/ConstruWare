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
import java.awt.event.WindowAdapter;
import java.text.ParseException;
import java.util.List;

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

import dao.FornDAO;
import dao.ProdDAO;
import model.Fornecedores;
import model.Produto;
import utilitarios.Util;

public class FormProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtQTD;
	private JTextField txtId;
	private JComboBox<String> txtForn; 
	private JTextField txtPesquisaProduto;
	private JTable tabela;
	private JTextField textField;
	
	private void atualizarTabela() {
	    ProdDAO dao = new ProdDAO();
	    List<Produto> lista = dao.Listar();
	    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
	    modelo.setRowCount(0); 
	    for (Produto p : lista) {
	        modelo.addRow(new Object[]{
	            p.getId(),
	            p.getNome(),
	            p.getPreco(),
	            p.getQtd(),
	            p.getFornecedores().getNome(),
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
					FormProdutos frame = new FormProdutos();
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
	public FormProdutos() throws ParseException {
		addWindowListener(new WindowAdapter() {
		});
		setResizable(false);
		setTitle("Formulário de Produtos");
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
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE PRODUTOS");
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
		tabbedPane.addTab("Dados do Produto", null, dadosPessoais, null);
		tabbedPane.setEnabledAt(0, true);
		dadosPessoais.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					Produto obj = new Produto();
					ProdDAO dao = new ProdDAO();
					Fornecedores f = new Fornecedores();
					FornDAO daof = new FornDAO();
					
					obj = dao.PesquisarProd(nome);
					if(obj.getNome() != null) {
						txtId.setText(String.valueOf(obj.getId()));
						txtNome.setText(obj.getNome());
						txtQTD.setText(String.valueOf(obj.getPreco()));
						txtPreco.setText(String.valueOf(obj.getPreco()));
						
						f = daof.PesquisarForn(obj.getFornecedores().getNome());
						txtForn.getModel().setSelectedItem(f);
						} else{
							JOptionPane.showMessageDialog(null, "Produto não encontrado!");
						}
				}
			}
		});
		
		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNome.setText("\n");
		txtNome.setColumns(10);
		txtNome.setBounds(145, 65, 256, 19);
		dadosPessoais.add(txtNome);
		
		JLabel lblCpf_1_1 = new JLabel("NOME:");
		lblCpf_1_1.setForeground(new Color(0, 0, 0));
		lblCpf_1_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1.setBounds(86, 67, 53, 15);
		dadosPessoais.add(lblCpf_1_1);
		
		JLabel lblN = new JLabel("PREÇO:");
		lblN.setForeground(new Color(0, 0, 0));
		lblN.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblN.setBounds(79, 103, 60, 15);
		dadosPessoais.add(lblN);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtPreco.setBounds(145, 101, 70, 19);
		dadosPessoais.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblUf = new JLabel("FORNECEDORES:");
		lblUf.setForeground(new Color(0, 0, 0));
		lblUf.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblUf.setBounds(12, 174, 124, 15);
		dadosPessoais.add(lblUf);
		
		JLabel lblEmail = new JLabel("QUANTIDADE:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblEmail.setBounds(39, 136, 97, 19);
		dadosPessoais.add(lblEmail);
		
		txtQTD = new JTextField();
		txtQTD.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtQTD.setBounds(145, 136, 70, 19);
		dadosPessoais.add(txtQTD);
		txtQTD.setColumns(10);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.setForeground(new Color(0, 0, 0));
		btnNovo.setBackground(new Color(47, 45, 98));
		btnNovo.setIcon(new ImageIcon(FormProdutos.class.getResource("/imagens/add.png")));
		btnNovo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnNovo.setBounds(57, 215, 114, 36);
		dadosPessoais.add(btnNovo);
		
		

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBackground(new Color(47, 45, 98));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setIcon(new ImageIcon(FormProdutos.class.getResource("/imagens/salvar.png")));
		btnSalvar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			 Produto obj = new Produto();
			 obj.setId(Integer.valueOf(txtId.getText()));
			 obj.setNome(txtNome.getText());
			 obj.setQtd(Double.valueOf(txtQTD.getText()));
			 obj.setPreco(Double.valueOf(txtPreco.getText()));
			 obj.setFornecedores((Fornecedores)txtForn.getSelectedItem());
			 
			 ProdDAO dao = new ProdDAO();
			 dao.Salvar(obj);
			 atualizarTabela();
			 Util util = new Util();
			 util.LimpaTela(dadosPessoais);
			 
			}
		});
		btnSalvar.setBounds(206, 215, 124, 36);
		dadosPessoais.add(btnSalvar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto obj = new Produto();
				obj.setId(Integer.valueOf(txtId.getText()));
				ProdDAO dao = new ProdDAO();
				atualizarTabela();
				dao.Excluir(obj);
				Util util = new Util();
				util.LimpaTela(dadosPessoais);
			}
		});
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBackground(new Color(47, 45, 98));
		btnExcluir.setIcon(new ImageIcon(FormProdutos.class.getResource("/imagens/excluir.png")));
		btnExcluir.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnExcluir.setBounds(521, 215, 135, 36);
		dadosPessoais.add(btnExcluir);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Produto obj = new Produto();
				 obj.setId(Integer.valueOf(txtId.getText()));
				 obj.setNome(txtNome.getText());
				 obj.setQtd(Double.valueOf(txtQTD.getText()));
				 obj.setPreco(Double.valueOf(txtPreco.getText()));
				 obj.setFornecedores((Fornecedores)txtForn.getSelectedItem());
				 
				 Fornecedores f = new Fornecedores();
				 f = (Fornecedores)txtForn.getSelectedItem();
				 obj.setFornecedores(f);
				 
				 ProdDAO dao = new ProdDAO();
				 dao.Editar(obj);
				 atualizarTabela();
				 Util util = new Util();
				 util.LimpaTela(dadosPessoais);
			}
		});
		btnEditar.setBackground(new Color(47, 45, 98));
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setIcon(new ImageIcon(FormProdutos.class.getResource("/imagens/editar.png")));
		btnEditar.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnEditar.setBounds(364, 215, 122, 36);
		dadosPessoais.add(btnEditar);
		
		JLabel lblCodigo = new JLabel("CÓDIGO:");
		lblCodigo.setForeground(new Color(0, 0, 0));
		lblCodigo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCodigo.setBounds(73, 30, 70, 15);
		dadosPessoais.add(lblCodigo);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtId.setBounds(145, 28, 70, 19);
		dadosPessoais.add(txtId);
		txtId.setColumns(10);
		
		txtForn = new JComboBox<>();
		txtForn.setToolTipText("");
		
		txtForn.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		txtForn.setBounds(145, 173, 148, 17);
		dadosPessoais.add(txtForn);
		
		JButton btnPesquisar_1 = new JButton("PESQUISAR");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				Produto obj = new Produto();
				ProdDAO dao = new ProdDAO();
				Fornecedores f = new Fornecedores();
				FornDAO daof = new FornDAO();
				
				obj = dao.PesquisarProd(nome);
				if(obj.getNome() != null) {
					txtId.setText(String.valueOf(obj.getId()));
					txtNome.setText(obj.getNome());
					txtQTD.setText(String.valueOf(obj.getPreco()));
					txtPreco.setText(String.valueOf(obj.getPreco()));
					
					f = daof.PesquisarForn(obj.getFornecedores().getNome());
					txtForn.getModel().setSelectedItem(f);
				} else{
					JOptionPane.showMessageDialog(null, "cliente não encontrado!");
				}
			}
		});
		btnPesquisar_1.setIcon(new ImageIcon(FormProdutos.class.getResource("/imagens/pesquisar.png")));
		btnPesquisar_1.setForeground(Color.BLACK);
		btnPesquisar_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnPesquisar_1.setBackground(new Color(47, 45, 98));
		btnPesquisar_1.setBounds(416, 62, 156, 24);
		dadosPessoais.add(btnPesquisar_1);
		
		textField.setBounds(145, 172, 114, 19);
		dadosPessoais.add(textField);
		textField.setColumns(10);
		
		JPanel consultaClientes = new JPanel();
		consultaClientes.setBorder(null);
		consultaClientes.setForeground(new Color(0, 0, 0));
		consultaClientes.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Consulta de Produtos", null, consultaClientes, null);
		consultaClientes.setLayout(null);
		
		JLabel lblCpf_1_1_2 = new JLabel("NOME DO PRODUTO: ");
		lblCpf_1_1_2.setForeground(new Color(0, 0, 0));
		lblCpf_1_1_2.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		lblCpf_1_1_2.setBounds(97, 14, 154, 15);
		consultaClientes.add(lblCpf_1_1_2);
		
		txtPesquisaProduto = new JTextField();
		txtPesquisaProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = "%"+txtPesquisaProduto.getText()+"%";
			    ProdDAO dao = new ProdDAO();
			    List<Produto> lista = dao.Filtrar(nome);
			    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			    modelo.setRowCount(0); 
			    for (Produto p : lista) {
			        modelo.addRow(new Object[]{
			            p.getId(),
			            p.getNome(),
			            p.getPreco(),
			            p.getQtd(),
			            p.getFornecedores().getNome(),
			        });
			    }
				
			}
		});
		txtPesquisaProduto.setText("\n");
		txtPesquisaProduto.setColumns(10);
		txtPesquisaProduto.setBounds(265, 12, 373, 19);
		consultaClientes.add(txtPesquisaProduto);
		
		JScrollPane painelDados = new JScrollPane();
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
					int selectedRow = tabela.getSelectedRow();
		            txtId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
		            txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
		            txtQTD.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());		   
		            txtPreco.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
		            txtForn.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
		            tabbedPane.setSelectedIndex(0);
		        }
		});		
		tabela.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		tabela.setBorder(null);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Preco", "Quantidade", "Fornecedor"
			}
		));
		painelDados.setViewportView(tabela);
		painelDados.setBounds(0, 40, 714, 219);
		consultaClientes.add(painelDados);
	}
}
