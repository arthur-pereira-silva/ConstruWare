package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conn;
import model.ItemPedido;
import model.Produto;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPedidoDAO.
 */
public class ItemPedidoDAO {
	
	/** The conn. */
	private Connection conn;
	
	/**
	 * Instantiates a new item pedido DAO.
	 */
	public ItemPedidoDAO() {
		this.conn = new Conn().pegarConexao();
		
	}	
	
	/**
	 * Salvar.
	 *
	 * @param obj the obj
	 */
	public void salvar(ItemPedido obj) {
		String sql = "insert into Item_Pedido (IdPedido, IdProduto, Quantidade, Subtotal) values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getPedido().getId());
			stmt.setInt(2, obj.getProduto().getId());
			stmt.setInt(3, obj.getQtd());
			stmt.setDouble(4, obj.getSubtotal());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Salvar Itens da Venda: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Lista itens.
	 *
	 * @param idPedido the id pedido
	 * @return the list
	 */
	public List<ItemPedido> listaItens(int idPedido) {
	    List<ItemPedido> lista = new ArrayList<>();
	    String sql = "SELECT p.IdProduto, p.Nome, i.Quantidade, p.Preco, i.Subtotal " +
	                 "FROM Item_Pedido i " +
	                 "INNER JOIN Produto p ON i.IdProduto = p.IdProduto " +
	                 "WHERE i.IdPedido = ?";
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, idPedido);
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            ItemPedido item = new ItemPedido();
	            Produto p = new Produto();
	            p.setId(rs.getInt("IdProduto"));
	            p.setNome(rs.getString("Nome")); // Assuming Produto has a 'Nome' attribute
	            p.setPreco(rs.getDouble("Preco"));
	            item.setProduto(p);
	            item.setQtd(rs.getInt("Quantidade"));
	            item.setSubtotal(rs.getDouble("Subtotal"));
	            lista.add(item);
	        }
	        
	        rs.close();
	        stmt.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erro ao criar lista de Itens!", e);
	    }
	    
	    return lista;
	}
}
