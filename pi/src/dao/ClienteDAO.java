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

	public void inserirCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO Cliente (IdCliente, Nome, Rg, Cpf, Telefone, Email, Cep, Estado, Cidade, Rua, Bairro, NumCasa,) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			stmt.setInt(12, cliente.getNumCasa());

			stmt.executeUpdate();
		}
	}
	public List<Cliente> listarClientes() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM Cliente";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("IdCliente"),
						rs.getString("Nome"),
						rs.getString("Rg"),
						rs.getString("Cpf"),
						rs.getString("Telefone"),
						rs.getString("Email"),
						rs.getString("Cep"),
						rs.getString("Estado"),
						rs.getString("Cidade"),
						rs.getString("Rua"),
						rs.getString("Bairro"),
						rs.getInt("NumCasa")
						);
				
				clientes.add(cliente);
			}

			return clientes;
		}

	}
	private Cliente criarCliente(ResultSet rs) throws SQLException {
        int id = rs.getInt("IdCliente");
        String nome = rs.getString("Nome");
        String rg = rs.getString("Rg");
        String cpf = rs.getString("Cpf");
        String telefone = rs.getString("Telefone");
        String email = rs.getString("Email");
        String cep = rs.getString("Cep");
        String estado = rs.getString("Estado");
        String cidade = rs.getString("Cidade");
        String rua = rs.getString("Rua");
        String bairro = rs.getString("Bairro");
        int numCasa = rs.getInt("NumCasa");

        return new Cliente(id, nome, rg, cpf, telefone, email, cep, estado, cidade, rua, bairro, numCasa);
    }

	public Cliente buscarClientePorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE Cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarCliente(rs);
            }
        }
        return null;
    }
	public void excluirCliente() {
		        String sql = "DELETE FROM Cliente WHERE IdCliente = ?";
		        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		            stmt.setInt(1, id);
		            int rowsAffected = stmt.executeUpdate();
		        }
	}
}
