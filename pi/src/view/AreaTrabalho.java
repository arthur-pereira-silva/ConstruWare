package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;

 

public class AreaTrabalho extends JFrame {
	public String usuarioLogado;
    private static final long serialVersionUID = 1L;

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

    public AreaTrabalho() {
    	setResizable(true);
        setTitle("Área de Trabalho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1380, 776);

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
                try {
                    FormCliente fc = new FormCliente();
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
                try {
                    FormFuncionario ff = new FormFuncionario();
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
                try {
                    FormFornecedor fn = new FormFornecedor();
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

        JMenuItem mntmEstoque = new JMenuItem("Estoque");
        mntmEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    FormEstoque fe = new FormEstoque();
                    fe.setVisible(true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        mntmEstoque.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        mnProdutos.add(mntmEstoque);

        JMenuItem mntmConsultaDeProdutos_1 = new JMenuItem("Formulário de Produtos");
        mntmConsultaDeProdutos_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    FormProduto fp = new FormProduto();
                    fp.setVisible(true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        mntmConsultaDeProdutos_1.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        mnProdutos.add(mntmConsultaDeProdutos_1);

        JMenu mnVendas = new JMenu("Vendas");
        mnVendas.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        mnVendas.setForeground(new Color(0, 0, 0));
        mnVendas.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/Venda.png")));
        menuBar.add(mnVendas);

        JMenuItem mntmAbrirPdv = new JMenuItem("Abrir PDV ");
        mntmAbrirPdv.setForeground(Color.BLACK);
        mntmAbrirPdv.setFont(new Font("Dialog", Font.BOLD, 14));
        mnVendas.add(mntmAbrirPdv);

        JMenuItem mntmAbrirDetalhe = new JMenuItem("Histórico de Venda");
        mntmAbrirDetalhe.setForeground(new Color(0, 0, 0));
        mntmAbrirDetalhe.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        mnVendas.add(mntmAbrirDetalhe);

        JMenuItem mntmTotalDia = new JMenuItem("Total Diário");
        mntmTotalDia.setForeground(Color.BLACK);
        mntmTotalDia.setFont(new Font("Dialog", Font.BOLD, 14));
        mnVendas.add(mntmTotalDia);

        mntmAbrirPdv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FormVenda fv = new FormVenda();
                    fv.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        mntmAbrirDetalhe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FormHistorico fh = new FormHistorico();
                    fh.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        mntmTotalDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FormTotalDia ft = new FormTotalDia();
                    ft.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        JMenu mnConfiguraes = new JMenu("Configurações");
        mnConfiguraes.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/setting (1).png")));
        mnConfiguraes.setForeground(Color.BLACK);
        mnConfiguraes.setFont(new Font("Dialog", Font.BOLD, 14));
        menuBar.add(mnConfiguraes);
        
        JMenuItem mntmTrocarDeUsuario = new JMenuItem("Trocar de Usuário");
        mntmTrocarDeUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
                dispose();

                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            FormLogin login = new FormLogin();
                            login.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        mntmTrocarDeUsuario.setForeground(Color.BLACK);
        mntmTrocarDeUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
        mnConfiguraes.add(mntmTrocarDeUsuario);

        JMenu mnSair = new JMenu("Sair");
        mnSair.setIcon(new ImageIcon(AreaTrabalho.class.getResource("/imagens/seta.png")));
        mnSair.setForeground(new Color(0, 0, 0));
        mnSair.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        menuBar.add(mnSair);

        JMenuItem mntmSairDoSistema = new JMenuItem("Sair do Sistema");
        mntmSairDoSistema.setFont(new Font("Liberation Sans", Font.BOLD, 14));
        mntmSairDoSistema.setForeground(new Color(0, 0, 0));
        mntmSairDoSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnSair.add(mntmSairDoSistema);
        getContentPane().setLayout(null);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/background.jpg"));
        Image image = icon.getImage();
        JDesktopPane painelDesktop = new JDesktopPane() {
        	public void paintComponent(Graphics g) {
        		g.drawImage(image,0,0,getWidth(), getHeight(),this);
        	}
        };
        painelDesktop.setBounds(0, 0, 1364, 683);
        getContentPane().add(painelDesktop);
    }
}
