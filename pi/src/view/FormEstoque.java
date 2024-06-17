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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		
				JButton btnPesquisar_1 = new JButton("PESQUISAR");
				btnPesquisar_1.setBounds(327, 45, 165, 27);
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
							
				    		txtCodigo.setEnabled(false);


						} else{
							JOptionPane.showMessageDialog(null, "produto não encontrado!");
						}
					}
				});
								dadosProdutos.setLayout(null);
						
								JLabel lblCodigo = new JLabel("Código:");
								lblCodigo.setBounds(7, 11, 54, 19);
								lblCodigo.setForeground(new Color(0, 0, 0));
								lblCodigo.setFont(new Font("Liberation Sans", Font.BOLD, 14));
								GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
								gbc_lblCodigo.anchor = GridBagConstraints.WEST;
								gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
								gbc_lblCodigo.gridx = 0;
								gbc_lblCodigo.gridy = 0;
								dadosProdutos.add(lblCodigo, gbc_lblCodigo);
				
						txtCodigo = new JTextField();
						txtCodigo.setBounds(81, 8, 116, 25);
						txtCodigo.setEnabled(false);
						txtCodigo.setEditable(false);
						txtCodigo.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
						GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
						gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtCodigo.insets = new Insets(0, 0, 5, 5);
						gbc_txtCodigo.gridx = 1;
						gbc_txtCodigo.gridy = 0;
						dadosProdutos.add(txtCodigo, gbc_txtCodigo);
						txtCodigo.setColumns(10);
				btnPesquisar_1.setIcon(new ImageIcon(FormEstoque.class.getResource("/imagens/pesquisar.png")));
				btnPesquisar_1.setForeground(Color.BLACK);
				btnPesquisar_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
				btnPesquisar_1.setBackground(new Color(47, 45, 98));
				GridBagConstraints gbc_btnPesquisar_1 = new GridBagConstraints();
				gbc_btnPesquisar_1.anchor = GridBagConstraints.WEST;
				gbc_btnPesquisar_1.fill = GridBagConstraints.VERTICAL;
				gbc_btnPesquisar_1.insets = new Insets(0, 0, 5, 0);
				gbc_btnPesquisar_1.gridwidth = 3;
				gbc_btnPesquisar_1.gridx = 4;
				gbc_btnPesquisar_1.gridy = 0;
				dadosProdutos.add(btnPesquisar_1, gbc_btnPesquisar_1);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(415, 110, 118, 27);
		btnAdicionar.setBackground(new Color(0, 255, 128));
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
		
				JLabel lblNome = new JLabel("Nome:");
				lblNome.setBounds(17, 49, 44, 19);
				lblNome.setForeground(new Color(0, 0, 0));
				lblNome.setFont(new Font("Liberation Sans", Font.BOLD, 14));
				GridBagConstraints gbc_lblNome = new GridBagConstraints();
				gbc_lblNome.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNome.insets = new Insets(0, 0, 5, 5);
				gbc_lblNome.gridx = 0;
				gbc_lblNome.gridy = 1;
				dadosProdutos.add(lblNome, gbc_lblNome);
				
						txtNome = new JTextField();
						txtNome.setBounds(81, 46, 236, 25);
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

										txtNome.setEnabled(false);

									} else{
										JOptionPane.showMessageDialog(null, "produto não encontrado!");
									}
								}
							}
							@Override
							public void keyReleased(KeyEvent e) {
								String nome = "%"+txtNome.getText()+"%";
								ProdutoDAO dao = new ProdutoDAO();
								List<Produto> lista = dao.Filtrar(nome);
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
						});
						
								txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
								txtNome.setText("\n");
								txtNome.setColumns(10);
								GridBagConstraints gbc_txtNome = new GridBagConstraints();
								gbc_txtNome.anchor = GridBagConstraints.NORTH;
								gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtNome.insets = new Insets(0, 0, 5, 5);
								gbc_txtNome.gridwidth = 3;
								gbc_txtNome.gridx = 1;
								gbc_txtNome.gridy = 1;
								dadosProdutos.add(txtNome, gbc_txtNome);
				
				JButton btnLimpar = new JButton("LIMPAR");
				btnLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Util util = new Util();
			    		util.LimpaTela(dadosProdutos);
			    		txtNome.setEnabled(true);
			    		txtNome.requestFocus();
			    		
					}
				});
				btnLimpar.setBounds(509, 45, 165, 27);
				btnLimpar.setForeground(Color.BLACK);
				btnLimpar.setFont(new Font("Dialog", Font.BOLD, 14));
				btnLimpar.setBackground(new Color(47, 45, 98));
				GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
				gbc_btnLimpar.anchor = GridBagConstraints.SOUTH;
				gbc_btnLimpar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnLimpar.insets = new Insets(0, 0, 5, 0);
				gbc_btnLimpar.gridwidth = 2;
				gbc_btnLimpar.gridx = 4;
				gbc_btnLimpar.gridy = 1;
				dadosProdutos.add(btnLimpar, gbc_btnLimpar);
		
				JLabel lblQtdEstoque = new JLabel("QTD.Atual:");
				lblQtdEstoque.setBounds(227, 11, 76, 19);
				lblQtdEstoque.setForeground(Color.BLACK);
				lblQtdEstoque.setFont(new Font("Dialog", Font.BOLD, 14));
				GridBagConstraints gbc_lblQtdEstoque = new GridBagConstraints();
				gbc_lblQtdEstoque.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblQtdEstoque.insets = new Insets(0, 0, 5, 5);
				gbc_lblQtdEstoque.gridx = 0;
				gbc_lblQtdEstoque.gridy = 2;
				dadosProdutos.add(lblQtdEstoque, gbc_lblQtdEstoque);
		
				txtQtdAtual = new JTextField();
				txtQtdAtual.setBounds(314, 8, 116, 25);
				txtQtdAtual.setFont(new Font("Dialog", Font.PLAIN, 14));
				txtQtdAtual.setColumns(10);
				txtQtdAtual.setEnabled(false);
				txtQtdAtual.setEditable(false);
				GridBagConstraints gbc_txtQtdAtual = new GridBagConstraints();
				gbc_txtQtdAtual.fill = GridBagConstraints.BOTH;
				gbc_txtQtdAtual.insets = new Insets(0, 0, 5, 5);
				gbc_txtQtdAtual.gridwidth = 3;
				gbc_txtQtdAtual.gridx = 1;
				gbc_txtQtdAtual.gridy = 2;
				dadosProdutos.add(txtQtdAtual, gbc_txtQtdAtual);
		
		JLabel lblQtd = new JLabel("QTD.:");
		lblQtd.setBounds(227, 113, 37, 19);
		lblQtd.setForeground(Color.BLACK);
		lblQtd.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblQtd = new GridBagConstraints();
		gbc_lblQtd.anchor = GridBagConstraints.WEST;
		gbc_lblQtd.insets = new Insets(0, 0, 0, 5);
		gbc_lblQtd.gridwidth = 2;
		gbc_lblQtd.gridx = 3;
		gbc_lblQtd.gridy = 3;
		dadosProdutos.add(lblQtd, gbc_lblQtd);
		
		txtQtdAdc = new JTextField();
		txtQtdAdc.setBounds(274, 110, 116, 25);
		txtQtdAdc.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtQtdAdc.setColumns(10);
		GridBagConstraints gbc_txtQtdAdc = new GridBagConstraints();
		gbc_txtQtdAdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtdAdc.insets = new Insets(0, 0, 0, 5);
		gbc_txtQtdAdc.gridx = 5;
		gbc_txtQtdAdc.gridy = 3;
		dadosProdutos.add(txtQtdAdc, gbc_txtQtdAdc);
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.fill = GridBagConstraints.BOTH;
		gbc_btnAdicionar.gridx = 6;
		gbc_btnAdicionar.gridy = 3;
		dadosProdutos.add(btnAdicionar, gbc_btnAdicionar);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double qtdAtual;
					Double qtd_nova;
					qtdAtual = Double.valueOf(txtQtdAtual.getText());
					qtd_nova = Double.valueOf(txtQtdAdc.getText());
					qtd_atualizada = (int) (qtdAtual - qtd_nova);
					ProdutoDAO daop = new ProdutoDAO();
					
					new Util().LimpaTela(dadosProdutos);
					daop.adicionarEstoque(idProduto, qtd_atualizada);
					}catch(Exception  e1){
						JOptionPane.showMessageDialog(null, "Erro:"+ e1);
					}
			}
		});
		btnRemover.setForeground(Color.BLACK);
		btnRemover.setFont(new Font("Dialog", Font.BOLD, 13));
		btnRemover.setBackground(new Color(255, 128, 128));
		btnRemover.setBounds(543, 110, 118, 27);
		dadosProdutos.add(btnRemover);


		JScrollPane painelDados = new JScrollPane();
		painelDados.setBounds(12, 238, 689, 150);
		contentPane.add(painelDados);
		
		tabelaProduto = new JTable();
		tabelaProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idProduto = Integer.parseInt(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),0).toString());
				txtNome.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),1).toString());
				txtCodigo.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),0).toString());
				txtQtdAtual.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(),3).toString());
				
	    		txtNome.setEnabled(false);
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
	}
}
