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
	
	// TODO: Auto-generated Javadoc
/**
	 * The Class ClienteDAO.
	 */
	public class ClienteDAO {
	
		/** The conn. */
		private Connection conn;
	
		/**
		 * Instantiates a new cliente DAO.
		 */
		public ClienteDAO() {
			this.conn = new Conn().pegarConexao();
		}
	
		/**
		 * Salvar.
		 *
		 * @param obj the obj
		 */
		public void Salvar(Cliente obj) {
			try {
				String sql = "INSERT INTO Cliente (Nome, RG, CPF, Telefone, Email, CEP, Estado, Cidade, Rua, Bairro, NumCasa) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, obj.getNome());
				stmt.setString(2, obj.getRg());
				stmt.setString(3, obj.getCpf());
				stmt.setString(4, obj.getTelefone());
				stmt.setString(5, obj.getEmail());
				stmt.setString(6, obj.getCep());
				stmt.setString(7, obj.getEstado());
				stmt.setString(8, obj.getCidade());
				stmt.setString(9, obj.getRua());
				stmt.setString(10, obj.getBairro());
				stmt.setInt(11 , obj.getNum());
	
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
	
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + e.getMessage());
			}
		}
	
		/**
		 * Editar.
		 *
		 * @param obj the obj
		 */
		public void Editar(Cliente obj) {
			try {
				String sql = "UPDATE Cliente SET Nome=?, RG=?, CPF=?, Telefone=?, Email=?, CEP=?, Estado=?, Cidade=?, Rua=?, Bairro=?, NumCasa=?  WHERE IdCliente=?";
	
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, obj.getNome());
				stmt.setString(2, obj.getRg());
				stmt.setString(3, obj.getCpf());
				stmt.setString(4, obj.getTelefone());
				stmt.setString(5, obj.getEmail());
				stmt.setString(6, obj.getCep());
				stmt.setString(7, obj.getEstado());
				stmt.setString(8, obj.getCidade());
				stmt.setString(9, obj.getRua());
				stmt.setString(10, obj.getBairro());
				stmt.setInt(11, obj.getNum());
				stmt.setInt(12,obj.getId());
	
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "Cliente editado");
	
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao editar cliente: " + e.getMessage());
			}
		}
	
		/**
		 * Excluir.
		 *
		 * @param obj the obj
		 */
		public void Excluir(Cliente obj) {
			try {
				String sql = "delete from Cliente where IdCliente =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, obj.getId());
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "cliente excluido");
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "erro ao excluir");
			}
		}
	
		/**
		 * Pesquisar.
		 *
		 * @param nome the nome
		 * @return the cliente
		 */
		public Cliente Pesquisar(String nome) {
			try {
				String sql = "select * from Cliente where Nome = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				Cliente obj = new Cliente();
				if (rs.next()) {
		  			obj.setId(rs.getInt("IdCliente"));
	   			 	obj.setNome(rs.getString("Nome"));
	   			 	obj.setRg(rs.getString("RG"));
	   			 	obj.setCpf(rs.getString("CPF"));
	   			 	obj.setTelefone(rs.getString("Telefone"));
	   			 	obj.setEmail(rs.getString("Email"));
	   			 	obj.setCep(rs.getString("CEP"));
	 			 	obj.setEstado(rs.getString("Estado"));
	   			 	obj.setCidade(rs.getString("Cidade"));
	   			 	obj.setRua(rs.getString("Rua"));
	   			 	obj.setBairro(rs.getString("Bairro"));
	   			 	obj.setNum(rs.getInt("numCasa"));
				}
				return obj;
	
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
			}
			return null;
		}
		
		/**
		 * Pesquisar CPF.
		 *
		 * @param cpf the cpf
		 * @return the cliente
		 */
		public Cliente PesquisarCPF(String cpf) {
			try {
				String sql = "select * from Cliente where CPF = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery();
				Cliente obj = new Cliente();
				if (rs.next()) {
		  			obj.setId(rs.getInt("IdCliente"));
	   			 	obj.setNome(rs.getString("Nome"));
	   			 	obj.setRg(rs.getString("RG"));
	   			 	obj.setCpf(rs.getString("CPF"));
	   			 	obj.setTelefone(rs.getString("Telefone"));
	   			 	obj.setEmail(rs.getString("Email"));
	   			 	obj.setCep(rs.getString("CEP"));
	 			 	obj.setEstado(rs.getString("Estado"));
	   			 	obj.setCidade(rs.getString("Cidade"));
	   			 	obj.setRua(rs.getString("Rua"));
	   			 	obj.setBairro(rs.getString("Bairro"));
	   			 	obj.setNum(rs.getInt("numCasa"));
				}
				return obj;
	
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
			}
			return null;
		}
		
		/**
		 * Listar.
		 *
		 * @return the list
		 */
		public List<Cliente>Listar() {
			List<Cliente> lista = new ArrayList<>();
			try {
				String sql = "SELECT * FROM Cliente";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Cliente obj = new Cliente();
		  			obj.setId(rs.getInt("IdCliente"));
	   			 	obj.setNome(rs.getString("Nome"));
	   			 	obj.setRg(rs.getString("RG"));
	   			 	obj.setCpf(rs.getString("CPF"));
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
	
		/**
		 * Filtrar.
		 *
		 * @param nome the nome
		 * @return the list
		 */
		public List<Cliente>Filtrar(String nome) {
			List<Cliente> lista = new ArrayList<>();
			try {
				String sql = "SELECT * FROM Cliente where nome like ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Cliente obj = new Cliente();
		  			obj.setId(rs.getInt("IdCliente"));
	   			 	obj.setNome(rs.getString("Nome"));
	   			 	obj.setRg(rs.getString("RG"));
	   			 	obj.setCpf(rs.getString("CPF"));
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
		
		/**
		 * Filtrar CPF.
		 *
		 * @param cpf the cpf
		 * @return the list
		 */
		public List<Cliente>FiltrarCPF(String cpf) {
			List<Cliente> lista = new ArrayList<>();
			try {
				String sql = "SELECT * FROM Cliente where CPF like	 ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Cliente obj = new Cliente();
		  			obj.setId(rs.getInt("IdCliente"));
	   			 	obj.setNome(rs.getString("Nome"));
	   			 	obj.setRg(rs.getString("RG"));
	   			 	obj.setCpf(rs.getString("CPF"));
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
	