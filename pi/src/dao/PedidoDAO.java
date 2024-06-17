package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Pedido;

public class PedidoDAO {
	private Connection conn;

	public PedidoDAO() {
		this.conn = new Conn().pegarConexao();
	}
	public void salvar(Pedido pedido) {
		try {
			String sql = "INSERT INTO pedido (IdCliente, DataPedido, Total) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Exemplo de formatação da data
			Date agora = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataFormatada = formatador.format(agora);
			stmt.setInt(1, pedido.getCliente().getId());
			stmt.setString(2, dataFormatada);
			stmt.setDouble(3, pedido.getTotal());
			stmt.executeUpdate();

			stmt.close();
			JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar pedido: " + e.getMessage(), e);
		}
	}
	public int retornaUltimoIdVenda() {
		int ultimoId = 0;
		String sql = "SELECT MAX(IdPedido) IdPedido from Pedido";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pedido v =new Pedido();
				v.setId(rs.getInt("IdPedido"));
				ultimoId = v.getId();
			}
			return ultimoId;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao retornar último Id da Venda!"+e);
		}

	}
}
