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
        String sql = "INSERT INTO Fornecedor (id, nome, cnpj, telefone, email, cep, endereco, num_casa, bairro, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, fornecedor.getId());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getRg());
			stmt.setString(4, fornecedor.getCpf());
			stmt.setString(5, fornecedor.getTelefone());
			stmt.setString(6, fornecedor.getEmail());
			stmt.setString(7, fornecedor.getCep());
			stmt.setString(8, fornecedor.getEstado());
			stmt.setString(9, fornecedor.getCidade());
			stmt.setString(10, fornecedor.getRua());
			stmt.setString(11, fornecedor.getBairro()); 
			stmt.setInt(12, fornecedor.getNumCasa());
        }
    }

    public Fornecedores buscarFornecedor(int id) throws SQLException {
        String sql = "SELECT * FROM Fornecedor WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Fornecedores(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getInt("num_casa"),
                        rs.getString("bairro"),
                        rs.getString("estado"),
                        rs.getString("cidade")
                    );
                }
            }
        }
        return null;
    }

    public void atualizarFornecedor(Fornecedores fornecedor) throws SQLException {
        String sql = "UPDATE Fornecedor SET nome = ?, cnpj = ?, telefone = ?, email = ?, cep = ?, endereco = ?, num_casa = ?, bairro = ?, estado = ?, cidade = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getCelular());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getEndereco());
            stmt.setInt(7, fornecedor.getNum_casa());
            stmt.setString(8, fornecedor.getBairro());
            stmt.setString(9, fornecedor.getEstado());
            stmt.setString(10, fornecedor.getCidade());
            stmt.setInt(11, fornecedor.getId());
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
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getInt("num_casa"),
                        rs.getString("bairro"),
                        rs.getString("estado"),
                        rs.getString("cidade")
                    );
                    fornecedores.add(fornecedor);
                }
            }
        }
        return fornecedores;
    }
}