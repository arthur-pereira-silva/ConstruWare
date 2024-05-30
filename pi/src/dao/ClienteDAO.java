package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conn;
import model.Cliente;

public class ClienteDAO {
	private Connection conn;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}


    // Método para inserir um cliente
    public void inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (IdCliente, Nome, RG, CPF, Telefone, Email, CEP, Estado, Cidade, Rua, Bairro, NumCasa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getEstado());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getRua());
            stmt.setString(11, cliente.getBairro());
            stmt.setInt(12, cliente.getNum());
            stmt.executeUpdate();
        }
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarCliente(int id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE IdCliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("IdCliente"),
                    rs.getString("Nome"),
                    rs.getString("RG"),
                    rs.getString("CPF"),
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
        return null;
    }

    // Método para atualizar um cliente
    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET IdCliente = ? Nome = ?, RG = ?, Telefone = ?, Email = ?, CEP = ?, Estado = ?, Cidade = ?, Rua = ?, Bairro = ?, NumCasa = ? WHERE CPF = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getEstado());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getRua());
            stmt.setString(11, cliente.getBairro());
            stmt.setInt(12, cliente.getNum());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um cliente
    public void deletarCliente(int cpf) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE CPF = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cpf);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("IdCliente"),
                    rs.getString("Nome"),
                    rs.getString("RG"),
                    rs.getString("CPF"),
                    rs.getString("Telefone"),
                    rs.getString("Email"),
                    rs.getString("CEP"),
                    rs.getString("Estado"),
                    rs.getString("Cidade"),
                    rs.getString("Rua"),
                    rs.getString("Bairro"),
                    rs.getInt("NumCasa")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}