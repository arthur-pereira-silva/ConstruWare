package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conn;
import model.Produto;

public class ProdutoDAO {
	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = new Conn().pegarConexao();

	}

	// Method to add a product
	public void adicionarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO Produto (IdProduto, Nome, QTD, Preço) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setDouble(3, produto.getQtd());
			stmt.setDouble(4, produto.getPreco());
			stmt.executeUpdate();
		}
	}

	// Method to get a product by ID
	public Produto buscarProdutoPorId(int id) throws SQLException {
		String sql = "SELECT * FROM Produto WHERE IdProduto = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Produto(
							rs.getInt("IdProduto"),
							rs.getString("Nome"),
							rs.getDouble("QTD"),
							rs.getDouble("Preço")
							);
				}
			}
		}
		return null;
	}

	// Method to update a product
	public void atualizarProduto(Produto produto) throws SQLException {
		String sql = "UPDATE Produto SET Nome = ?, QTD = ?, Preço = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getQtd());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getId());
			stmt.executeUpdate();
		}
	}

	// Method to delete a product
	public void deletarProduto(int id) throws SQLException {
		String sql = "DELETE FROM Produto WHERE IdProduto = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

	// Method to get all products
	public List<Produto> listarProdutos() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM Produto";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("IdProduto"),
						rs.getString("Nome"),
						rs.getDouble("QTD"),
						rs.getDouble("Preço")
						);
				produtos.add(produto);
			}
		}
		return produtos;
	}
}

