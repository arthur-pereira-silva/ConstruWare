package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Fornecedor;
import model.Produto;

public class ProdutoDAO {

	private Connection conn;

	public ProdutoDAO() {
		this.conn = new Conn().pegarConexao();
	}

	public void Salvar(Produto obj) {
		try {
			String sql = "INSERT INTO Produto (IdFornecedor, Nome, Preco, QuantidadeEstoque) VALUES ( ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getFornecedores().getId());
			stmt.setString(2, obj.getNome());
			stmt.setDouble(3, obj.getPreco());
			stmt.setDouble(4, obj.getQtd());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar produto: " + e.getMessage());
		}
	}

	public void Editar(Produto obj) {
		try {
			String sql = "UPDATE Produto SET IdFornecedor=?, Nome=?, Preco=?, QuantidadeEstoque=? WHERE IdProduto=?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, obj.getFornecedores().getId());
			stmt.setString(2, obj.getNome());
			stmt.setDouble(3, obj.getPreco());
			stmt.setDouble(4, obj.getQtd());
			stmt.setInt(5, obj.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Produto editado");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getMessage());
		}
	}

	public void Excluir(Produto obj) {
		try {
			String sql = "delete from Produto where IdProduto =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "produto excluido");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir");
		}
	}

	public Produto Pesquisar(String nome) {
		try {
			String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome as FornecedorNome "
					+ "FROM Produto AS p "
					+ "INNER JOIN Fornecedor AS f ON p.IdFornecedor = f.IdFornecedor "
					+ "WHERE p.Nome = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Produto obj = null;
			if (rs.next()) {
				obj = new Produto();
				obj.setId(rs.getInt("IdProduto"));
				obj.setNome(rs.getString("Nome"));
				obj.setPreco(rs.getDouble("Preco"));
				obj.setQtd(rs.getDouble("QuantidadeEstoque"));

				Fornecedor f = new Fornecedor();
				f.setNome(rs.getString("FornecedorNome"));
				obj.setFornecedores(f);
			}
			rs.close();
			stmt.close();
			return obj;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + erro.getMessage());
			return null;
		}
	}

	public Produto PesquisarCod(int id) {
		try {
			String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome as FornecedorNome "
					+ "FROM Produto AS p "
					+ "INNER JOIN Fornecedor AS f ON p.IdFornecedor = f.IdFornecedor "
					+ "WHERE p.IdProduto = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Produto obj = null;
			if (rs.next()) {
				obj = new Produto();
				obj.setId(rs.getInt("IdProduto"));
				obj.setNome(rs.getString("Nome"));
				obj.setPreco(rs.getDouble("Preco"));
				obj.setQtd(rs.getDouble("QuantidadeEstoque"));

				Fornecedor f = new Fornecedor();
				f.setNome(rs.getString("FornecedorNome"));
				obj.setFornecedores(f);
			}
			rs.close();
			stmt.close();
			return obj;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + erro.getMessage());
			return null;
		}
	}


	//		public Cliente pesquisarCPF(String cpf) {
	//			try {
	//				String sql = "select * from Cliente where CPF = ?";
	//				PreparedStatement stmt = conn.prepareStatement(sql);
	//				stmt.setString(1, cpf);
	//				ResultSet rs = stmt.executeQuery();
	//				Cliente obj = new Cliente();
	//				if (rs.next()) {
	//		  			obj.setId(rs.getInt("IdCliente"));
	//	   			 	obj.setNome(rs.getString("Nome"));
	//	   			 	obj.setRg(rs.getString("RG"));
	//	   			 	obj.setCpf(rs.getString("CPF"));
	//	   			 	obj.setTelefone(rs.getString("Telefone"));
	//	   			 	obj.setEmail(rs.getString("Email"));
	//	   			 	obj.setCep(rs.getString("CEP"));
	//	 			 	obj.setEstado(rs.getString("Estado"));
	//	   			 	obj.setCidade(rs.getString("Cidade"));
	//	   			 	obj.setRua(rs.getString("Rua"));
	//	   			 	obj.setBairro(rs.getString("Bairro"));
	//	   			 	obj.setNum(rs.getInt("numCasa"));
	//				}
	//				return obj;
	//	
	//			} catch (SQLException erro) {
	//				JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
	//			}
	//			return null;
	//		}
	public List<Produto> listarProdutos() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome as FornecedorNome FROM Produto p INNER JOIN Fornecedor f ON p.IdFornecedor = f.IdFornecedor";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Produto obj = new Produto();
				Fornecedor f = new Fornecedor();
				obj.setId(rs.getInt("IdProduto"));
				obj.setNome(rs.getString("Nome"));
				obj.setPreco(rs.getDouble("Preco"));
				obj.setQtd(rs.getDouble("QuantidadeEstoque"));
				f.setNome(rs.getString("FornecedorNome"));
				obj.setFornecedores(f);
				lista.add(obj);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista: " + e.getMessage());
		}
		return lista;
	}

	public List<Produto> Filtrar(String nome) {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome as FornecedorNome FROM Produto p INNER JOIN Fornecedor f ON p.IdFornecedor = f.IdFornecedor WHERE p.Nome LIKE ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%" + nome + "%");
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Produto obj = new Produto();
					Fornecedor f = new Fornecedor();
					obj.setId(rs.getInt("IdProduto"));
					obj.setNome(rs.getString("Nome"));
					obj.setPreco(rs.getDouble("Preco"));
					obj.setQtd(rs.getDouble("QuantidadeEstoque"));
					f.setNome(rs.getString("FornecedorNome"));
					obj.setFornecedores(f);
					lista.add(obj);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista: " + e.getMessage());
		}
		return lista;
	}
	public void adicionarEstoque( int id, int qtd_nova) {
		String sql= "Update Produto set QuantidadeEstoque = ? where IdProduto =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, qtd_nova);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Adicionado com sucesso ao Estoque!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar ao Estoque!"+e);			}

	}

	public void baixaEstoque(int id, int qtd_nova) {
		String sql= "Update Produto set QuantidadeEstoque = ? where IdProduto =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, qtd_nova);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Baixa no Estoque efetuada com Sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao dar baixa no Estoque!"+e);			
		}

	}
}