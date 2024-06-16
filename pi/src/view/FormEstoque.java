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
import javax.swing.JFormattedTextField;
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

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import model.Fornecedor;
import model.Produto;
import utilitarios.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class FormEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtQtdAtual;
	private JTable tabelaProduto;
	private JTextField txtQtdAdc;
	
	int idProduto, qtd_atualizada;
	

	private void atualizarTabela() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listarProdutos();
		DefaultTableModel modelo = (DefaultTableModel) tabelaProduto.getModel();
		modelo.setRowCount(0); 
		for (Produto produto : lista) {
			modelo.addRow(new Object[]{
					produto.getId(),
					produto.getNome(),
					produto.getPreco(),
					produto.getQtd(),
					produto.getFornecedores()
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
					FormEstoque frame = new FormEstoque();
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
	public FormEstoque() throws ParseException {
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

		JLabel lblCadastroDeProdutos = new JLabel("ESTOQUE");
		lblCadastroDeProdutos.setBackground(new Color(0, 0, 0));
		lblCadastroDeProdutos.setFont(new Font("Liberation Sans", Font.BOLD, 25));
		lblCadastroDeProdutos.setForeground(new Color(0, 0, 0));
		panel.add(lblCadastroDeProdutos);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(47, 45, 98));
		tabbedPane.setBounds(10, 39, 689, 188);
		contentPane.add(tabbedPane);

		JPanel dadosProdutos = new JPanel();
		dadosProdutos.setBorder(null);
		dadosProdutos.setBackground(new Color(119, 118, 123));
		tabbedPane.addTab("Dados do Produto", null, dadosProdutos, null);
		tabbedPane.setEnabledAt(0, true);

		txtNome = new JTextField();
		txtNome.setBounds(111, 51, 342, 23);
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String nome = txtNome.getText();
					Produto obj = new Produto();
					ProdutoDAO dao = new ProdutoDAO();
					Fornecedor f = new Fornecedor();
					FornecedorDAO daof = new FornecedorDAO();

					obj = dao.Pesquisar(nome);
					if(obj != null && obj.getNome() != null) {
						txtCodigo.setText(String.valueOf(obj.getId()));
						txtNome.setText(obj.getNome());
						txtQtdAtual.setText(String.valueOf(obj.getQtd()));

						f = daof.Pesquisar(obj.getFornecedores().getNome());


					} else{
						JOptionPane.showMessageDialog(null, "produto não encontrado!");
					}
				}
			}
		});
		dadosProdutos.setLayout(null);

		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtNome.setText("\n");
		txtNome.setColumns(10);
		dadosProdutos.add(txtNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(43, 55, 60, 15);
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		dadosProdutos.add(lblNome);

		JLabel lblCodigo = new JLabel("CÓDIGO:");
		lblCodigo.setBounds(22, 16, 70, 15);
		lblCodigo.setForeground(new Color(0, 0, 0));
		lblCodigo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		dadosProdutos.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(111, 12, 70, 23);
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		dadosProdutos.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnPesquisar_1 = new JButton("PESQUISAR");
		btnPesquisar_1.setBounds(518, 50, 156, 29);
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				Produto obj = new Produto();
				ProdutoDAO dao = new ProdutoDAO();
				Fornecedor f = new Fornecedor();
				FornecedorDAO daof = new FornecedorDAO();

				obj = dao.Pesquisar(nome);
				if(obj != null && obj.getNome() != null) {
					txtCodigo.setText(String.valueOf(obj.getId()));
					txtNome.setText(obj.getNome());
					txtQtdAtual.setText(String.valueOf(obj.getQtd()));

					f = daof.Pesquisar(obj.getFornecedores().getNome());


				} else{
					JOptionPane.showMessageDialog(null, "produto não encontrado!");
				}
			}
		});
		btnPesquisar_1.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/pesquisar.png")));
		btnPesquisar_1.setForeground(Color.BLACK);
		btnPesquisar_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		btnPesquisar_1.setBackground(new Color(47, 45, 98));
		dadosProdutos.add(btnPesquisar_1);

		txtQtdAtual = new JTextField();
		txtQtdAtual.setBounds(111, 113, 70, 25);
		txtQtdAtual.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtQtdAtual.setColumns(10);
		dadosProdutos.add(txtQtdAtual);

		JLabel lblQtdEstoque = new JLabel("QTD.Atual:");
		lblQtdEstoque.setBounds(22, 118, 81, 15);
		lblQtdEstoque.setForeground(Color.BLACK);
		lblQtdEstoque.setFont(new Font("Dialog", Font.BOLD, 14));
		dadosProdutos.add(lblQtdEstoque);
		
		JLabel lblQtd = new JLabel("QTD.:");
		lblQtd.setForeground(Color.BLACK);
		lblQtd.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQtd.setBounds(211, 118, 52, 15);
		dadosProdutos.add(lblQtd);
		
		txtQtdAdc = new JTextField();
		txtQtdAdc.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtQtdAdc.setColumns(10);
		txtQtdAdc.setBounds(266, 114, 60, 24);
		dadosProdutos.add(txtQtdAdc);
		
		JButton btnAdicionar = new JButton("ADD");
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setForeground(new Color(0, 0, 0));
		btnAdicionar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAdicionar.setIcon(new ImageIcon("C:\\PI\\ConstruWare\\pi\\src\\imagens\\add.png"));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Double qtdAtual;
				Double qtd_nova;
				qtdAtual = Double.valueOf(txtQtdAtual.getText());
				qtd_nova = Double.valueOf(txtQtdAdc.getText());
				qtd_atualizada = (int) (qtdAtual + qtd_nova);
				ProdutoDAO daop = new ProdutoDAO();
				
				new Util().LimpaTela(dadosProdutos);
				daop.adicionarEstoque(idProduto, qtd_atualizada);
				}catch(Exception  e1){
					JOptionPane.showMessageDialog(null, "Erro:"+ e1);
				}
			}
		});
		btnAdicionar.setBounds(336, 108, 118, 30);
		dadosProdutos.add(btnAdicionar);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setBounds(56, 353, 129, 35);
		contentPane.add(btnNovo);
		btnNovo.setForeground(new Color(0, 0, 0));
		btnNovo.setBackground(new Color(47, 45, 98));
		btnNovo.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/add.png")));
		btnNovo.setFont(new Font("Liberation Sans", Font.BOLD, 14));



		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(205, 353, 129, 35);
		contentPane.add(btnSalvar);
		btnSalvar.setBackground(new Color(47, 45, 98));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/salvar.png")));
		btnSalvar.setFont(new Font("Liberation Sans", Font.BOLD, 14));

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(363, 353, 129, 35);
		contentPane.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto obj = new Produto();
				obj.setId(Integer.valueOf(txtCodigo.getText()));
				obj.setNome(txtNome.getText());
				obj.setQtd(Double.valueOf(txtQtdAtual.getText()));
				Fornecedor f = new Fornecedor();
				obj.setFornecedores(f);
				ProdutoDAO daop = new ProdutoDAO();
				daop.Editar(obj);
				Util util = new Util();
				util.LimpaTela(dadosProdutos);
			}
		});
		btnEditar.setBackground(new Color(47, 45, 98));
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/editar.png")));
		btnEditar.setFont(new Font("Liberation Sans", Font.BOLD, 14));

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(520, 353, 129, 35);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto obj = new Produto();
				obj.setId(Integer.valueOf(txtCodigo.getText()));
				ProdutoDAO dao = new ProdutoDAO();
				dao.Excluir(obj);
				Util util = new Util();
				util.LimpaTela(dadosProdutos);
			}
		});
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBackground(new Color(47, 45, 98));
		btnExcluir.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/excluir.png")));
		btnExcluir.setFont(new Font("Liberation Sans", Font.BOLD, 14));

		JScrollPane painelDados = new JScrollPane();
		painelDados.setBounds(12, 238, 689, 113);
		contentPane.add(painelDados);
		
		tabelaProduto = new JTable();
		tabelaProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idProduto = Integer.parseInt(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),0).toString());
				txtNome.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),1).toString());
				txtCodigo.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),2).toString());
				txtQtdAtual.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),3).toString());
				
		
			}
		});
		tabelaProduto.setBorder(UIManager.getBorder("Button.border"));
		tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdProduto", "Nome", "Preco", "QTD.Estoque", "Fornecedor"
			}
		));
		painelDados.setViewportView(tabelaProduto);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Produto obj = new Produto();
				obj.setNome(txtNome.getText());
				obj.setQtd(Double.valueOf(txtQtdAtual.getText()));



				ProdutoDAO dao = new ProdutoDAO();	
				dao.Salvar(obj);
				Util util = new Util();
				util.LimpaTela(dadosProdutos);

			}
		});
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util util = new Util();
				util.LimpaTela(dadosProdutos);
			}
		});
	}
	
}
