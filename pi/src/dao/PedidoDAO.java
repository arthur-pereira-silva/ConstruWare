package dao;

import java.sql.Connection;

import connection.Conn;

public class PedidoDAO {
	private Connection conn;

	public PedidoDAO(Connection conn) {
		this.conn = new Conn().pegarConexao();
	}
	
}
