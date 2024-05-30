package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class AreaTrabalho extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaTrabalho frame = new AreaTrabalho();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public AreaTrabalho() {
		setTitle("Área de Trabalho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 419);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setHorizontalAlignment(SwingConstants.CENTER);
		mnClientes.setBackground(new Color(47, 45, 98));
		mnClientes.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnClientes.setForeground(new Color(0, 0, 0));
		mnClientes.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Cliente.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmFormulrioDeClientes = new JMenuItem("Formulário de Clientes");
		mntmFormulrioDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		mntmFormulrioDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCliente fc;
				try {
					fc = new FormCliente();
					fc.setVisible(true);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		mntmFormulrioDeClientes.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mntmFormulrioDeClientes.setForeground(new Color(0, 0, 0));
		mnClientes.add(mntmFormulrioDeClientes);
		
		JMenu mnFuncionrios = new JMenu("Funcionários");
		mnFuncionrios.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnFuncionrios.setForeground(new Color(0, 0, 0));
		mnFuncionrios.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Funcionarios.png")));
		menuBar.add(mnFuncionrios);
		
		JMenuItem mntmFormulrioDeFuncionrios = new JMenuItem("Formulário de Funcionários");
		mntmFormulrioDeFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						FormFuncionarios ff;
						try {
							ff = new FormFuncionarios();
							ff.setVisible(true);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				});
		mntmFormulrioDeFuncionrios.setForeground(new Color(0, 0, 0));
		mntmFormulrioDeFuncionrios.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnFuncionrios.add(mntmFormulrioDeFuncionrios);
		
		JMenu mnFornecedores = new JMenu("Fornecedores");
		mnFornecedores.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnFornecedores.setForeground(new Color(0, 0, 0));
		mnFornecedores.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Fornecedores.png")));
		menuBar.add(mnFornecedores);
		
		JMenuItem mntmFormulrioDeFornecedores = new JMenuItem("Formulário de Fornecedores");
		mntmFormulrioDeFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormFornecedores fn;
				try {
					fn = new FormFornecedores();
					fn.setVisible(true);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		mntmFormulrioDeFornecedores.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mntmFormulrioDeFornecedores.setForeground(new Color(0, 0, 0));
		mnFornecedores.add(mntmFormulrioDeFornecedores);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnProdutos.setForeground(new Color(0, 0, 0));
		mnProdutos.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Produtos.png")));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmConsultaDeProdutos = new JMenuItem("Formulário de Produtos");
		mntmConsultaDeProdutos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FormProdutos fp;
					try {
						fp = new FormProdutos();
						fp.setVisible(true);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
		mntmConsultaDeProdutos.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnProdutos.add(mntmConsultaDeProdutos);
		
		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnVendas.setForeground(new Color(0, 0, 0));
		mnVendas.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Venda.png")));
		menuBar.add(mnVendas);
		
		JMenuItem mntmAbrirPdv = new JMenuItem("Abrir PDV ");
		mntmAbrirPdv.setForeground(new Color(0, 0, 0));
		mntmAbrirPdv.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnVendas.add(mntmAbrirPdv);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setForeground(new Color(0, 0, 0));
		mnSair.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mnSair.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Sair.png")));
		menuBar.add(mnSair);
		
		JMenuItem mntmSairDoSistema = new JMenuItem("Sair do Sistema");
		mntmSairDoSistema.setFont(new Font("Liberation Sans", Font.BOLD, 14));
		mntmSairDoSistema.setForeground(new Color(0, 0, 0));
		mnSair.add(mntmSairDoSistema);
	}

}
