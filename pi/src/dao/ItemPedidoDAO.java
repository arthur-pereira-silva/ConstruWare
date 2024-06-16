package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conn;
import model.ItemPedido;

public class ItemPedidoDAO {
	private Connection conn;
	
	public ItemPedidoDAO(Connection conn) {
		this.conn = new Conn().pegarConexao();
		
	}	
	
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
			throw new  RuntimeException("Erro ao Salvar Itens da Venda");
		}
	}
}
