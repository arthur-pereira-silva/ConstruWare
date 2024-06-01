package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Fornecedores;

public class FornDAO {
	private Connection conn;

	public FornDAO(Connection connection) {
		this.conn = new Conn().pegarConexao();
	}

	public void inserirFornecedor(Fornecedores fornecedor) throws SQLException {
		String sql = "INSERT INTO Fornecedor (IdFornecedor, Nome, CNPJ, Telefone, Email, CEP, Estado, Cidade, Rua, Bairro, NumCasa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

		}
	}

	public Fornecedores buscarFornecedor(int id) throws SQLException {
		String sql = "SELECT * FROM Fornecedor WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Fornecedores(
							rs.getInt("IdFornecedor"),
							rs.getString("Nome"),
							rs.getString("CNPJ"),
							rs.getString("Telefone"),
							rs.getString("Email"),
							rs.getString("CEP"),
							rs.getString("Estado"),
							rs.getString("Cidade"),
							rs.getString("Rua"),
							rs.getString("Bairro"),
							rs.getInt("NumCasa")
							);
				}
			}
		}
		return null;
	}

	public void atualizarFornecedor(Fornecedores fornecedor) throws SQLException {
		String sql = "UPDATE Fornecedor SET IdFornecedor= ?, Nome = ?, Telefone = ?, Email = ?, CEP = ?, Estado = ?,Cidade = ?, Rua = ?, Bairro = ?  NumCasa = ?  WHERE CNPJ = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, fornecedor.getId());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getEmail());
			stmt.setString(5, fornecedor.getCep());
			stmt.setString(6, fornecedor.getEstado());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getRua());
			stmt.setString(9, fornecedor.getBairro());
			stmt.setInt(10, fornecedor.getNum());
			stmt.executeUpdate();
		}
	}

	public void deletarFornecedor(int id) throws SQLException {
		String sql = "DELETE FROM Fornecedor WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

	public List<Fornecedores> listarFornecedores() throws SQLException {
		List<Fornecedores> fornecedores = new ArrayList<>();
		String sql = "SELECT * FROM Fornecedor";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Fornecedores fornecedor = new Fornecedores(
							rs.getInt("IdFornecedor"),
							rs.getString("Nome"),
							rs.getString("CNPJ"),
							rs.getString("Telefone"),
							rs.getString("Email"),
							rs.getString("CEP"),
							rs.getString("Estado"),
							rs.getString("Cidade"),
							rs.getString("Rua"),
							rs.getString("Bairro"),
							rs.getInt("NumCasa")
							);
					fornecedores.add(fornecedor);
				}
			}
		}
		return fornecedores;
	}
}