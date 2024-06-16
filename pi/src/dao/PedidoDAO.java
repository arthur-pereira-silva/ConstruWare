package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Pedido;

public class PedidoDAO {
	private Connection conn;

	public PedidoDAO(Connection conn) {
		this.conn = new Conn().pegarConexao();
	}
	public void salvar(Pedido obj) {
		String sql = "INSERT INTO Pedido (IdCliente,IdFuncionario, DataPedido, Total)"+ "values(?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, obj.getCliente().getId());
			stmt.setInt(2, obj.getFuncionario().getId());
			stmt.setString(3, obj.getData());
			stmt.setDouble(4, obj.getTotal());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Realizar venda"+e);
		}
		
	}
	public int retornaUltimoIdVenda() {
		int ultimoId = 0;
		String sql = "SELECT MAX(Id) Id from tb_vendas";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pedido v =new Pedido();
				v.setId(rs.getInt("Id"));
				ultimoId = v.getId();
			}
			return ultimoId;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao retornar último Id da Venda!"+e);
		}
		
	}
}
