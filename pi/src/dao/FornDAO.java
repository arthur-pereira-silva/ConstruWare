package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Cliente;
import model.Fornecedor;

public class FornDAO {

	private Connection conn;

	public FornDAO() {
		this.conn = new Conn().pegarConexao();
	}

	public void Salvar(Fornecedor obj) {
		try {
			String sql = "INSERT INTO Fornecedores (Nome, CNPJ, Telefone, Email, CEP, Estado, Cidade, Rua, Bairro, NumEstabelecimento) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getCnpj());
			stmt.setString(3, obj.getTelefone());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getCep());
			stmt.setString(6, obj.getEstado());
			stmt.setString(7, obj.getCidade());
			stmt.setString(8, obj.getRua());
			stmt.setString(9, obj.getBairro());
			stmt.setInt(10, obj.getNum());
			stmt.executeUpdate();

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Fornecedor salvo");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar Fornecedor: " + e.getMessage());
		}
	}

	public void Editar(Fornecedor obj) {
		try {
			String sql = "UPDATE Fornecedor SET  Nome = ?, Telefone = ?, Email = ?, CEP = ?, Estado = ?,Cidade = ?, Rua = ?, Bairro = ?  NumEstabelecimento = ?  WHERE IdForncedor = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getCnpj());
			stmt.setString(3, obj.getTelefone());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getCep());
			stmt.setString(6, obj.getEstado());
			stmt.setString(7, obj.getCidade());
			stmt.setString(8, obj.getRua());
			stmt.setString(9, obj.getBairro());
			stmt.setInt(10, obj.getNum());
			stmt.executeUpdate();


			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Fornecedores editados");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar fornecedores: " + e.getMessage());
		}
	}

	public void Excluir(Fornecedor obj) {
		try {
			String sql = "delete from Fornecedores where IdForncedor=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "fornecedor excluido");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir");
		}
	}

	public Fornecedor Pesquisar(String nome) {
		try {
			String sql = "SELECT * FROM Fornecedores WHERE Nome =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Fornecedor obj = new Fornecedor();
			if (rs.next()) {
				stmt.setInt(1, obj.getId());
				stmt.setString(2, obj.getNome());
				stmt.setString(3, obj.getCnpj());
				stmt.setString(3, obj.getTelefone());
				stmt.setString(4, obj.getEmail());
				stmt.setString(5, obj.getCep());
				stmt.setString(6, obj.getEstado());
				stmt.setString(7, obj.getCidade());
				stmt.setString(8, obj.getRua());
				stmt.setString(9, obj.getBairro());
				stmt.setInt(10, obj.getNum());
				stmt.executeUpdate();

			}
			return obj;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
		}
		return null;
	}

	public List<Fornecedor> Listar() {
		List<Fornecedor> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Fornecedor";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor obj = new Fornecedor();
	  			obj.setId(rs.getInt("IdFornecedor"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setCnpj(rs.getString("CNPJ"));
   			 	obj.setTelefone(rs.getString("Telefone"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setCep(rs.getString("CEP"));
 			 	obj.setEstado(rs.getString("Estado"));
   			 	obj.setCidade(rs.getString("Cidade"));
   			 	obj.setRua(rs.getString("Rua"));
   			 	obj.setBairro(rs.getString("Bairro"));
   			 	obj.setNum(rs.getInt("NumEstabelecimento"));
				lista.add(obj);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista: " + e);
		}
		return lista;
	}


	public List<Fornecedor>Filtrar(String nome) {
		List<Fornecedor> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Fornecedores WHERE Nome LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor obj = new Fornecedor();
				obj.setId(rs.getInt("IdFornecedor"));
				obj.setNome(rs.getString("Nome"));
				obj.setCnpj(rs.getString("CNPJ"));
				obj.setTelefone(rs.getString("Telefone"));
				obj.setEmail(rs.getString("Email"));
				obj.setCep(rs.getString("CEP"));
				obj.setEstado(rs.getString("Estado"));
				obj.setCidade(rs.getString("Cidade"));
				obj.setRua(rs.getString("Rua"));
				obj.setBairro(rs.getString("Bairro"));
				obj.setNum(rs.getInt("numCasa"));



				lista.add(obj);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista: " + e);
		}
		return lista;
	}

}