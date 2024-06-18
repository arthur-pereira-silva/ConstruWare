package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.ItemPedidoDAO;
import dao.PedidoDAO;
import model.ItemPedido;
import model.Pedido;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class FormHistorico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFinal;
	private JTable tabela;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHistorico frame = new FormHistorico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormHistorico() {
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 713, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(3, 52, 124));
		panel.setBounds(0, 0, 697, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HISTÓRICO DE VENDAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(218, 11, 250, 55);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Consulta por Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 81, 697, 161);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Data Início:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(22, 65, 77, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Final:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(259, 65, 77, 14);
		panel_1.add(lblNewLabel_1_1);
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			txtDataInicio = new JFormattedTextField(mask);
			txtDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDataInicio.setHorizontalAlignment(SwingConstants.CENTER);
			txtDataInicio.setBounds(100, 62, 86, 20);
			panel_1.add(txtDataInicio);
			txtDataInicio.setColumns(10);
			
			txtDataFinal = new JFormattedTextField(mask);
			txtDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDataFinal.setHorizontalAlignment(SwingConstants.CENTER);
			txtDataFinal.setColumns(10);
			txtDataFinal.setBounds(337, 62, 86, 20);
			panel_1.add(txtDataFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JButton btnPesquisarVenda = new JButton("Pesquisar");
		btnPesquisarVenda.setBackground(new Color(3, 52, 124));
		btnPesquisarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate data_inicio  = LocalDate.parse(txtDataInicio.getText(), formato);
				LocalDate data_final  = LocalDate.parse(txtDataFinal.getText(), formato);
				
				PedidoDAO pdao = new PedidoDAO();
				List<Pedido>lista = pdao.historicoPedido(data_inicio, data_final);
				DefaultTableModel historico = (DefaultTableModel) tabela.getModel();
				historico.setNumRows(0);
				for(Pedido p : lista) {
					historico.addRow(new Object[] {
						p.getId(),
						p.getCliente().getNome(),
						p.getData(),
						p.getTotal(),
						
					});
						
					
				}
				}
		});
		btnPesquisarVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisarVenda.setBounds(498, 56, 119, 32);
		panel_1.add(btnPesquisarVenda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 677, 199);
		contentPane.add(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    FormDetalheVenda fdv = new FormDetalheVenda();
			    fdv.txtId.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
			    fdv.txtCliente.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
			    fdv.txtTotalVenda.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
			    fdv.txtDataVenda.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
			    int venda_id = Integer.valueOf(fdv.txtId.getText());
			    ItemPedidoDAO dao = new ItemPedidoDAO();
			    List<ItemPedido> lista = dao.listaItens(venda_id);
			    DefaultTableModel dados = (DefaultTableModel) fdv.tabela.getModel();
			    for (ItemPedido i : lista) {
			        dados.addRow(new Object[] {
			            i.getProduto().getId(),   
			            i.getProduto().getNome(),
			            i.getQtd(),               
			            i.getProduto().getPreco(),
			            i.getSubtotal()           
			        });
			    }
			    fdv.setVisible(true);
			    dispose();
			}
		});
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cliente", "Data Venda", "Total Venda"
			}
		));
		scrollPane.setViewportView(tabela);
	}
}
