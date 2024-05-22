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

public class ClienteDAO {

    private Connection conn;

    public ClienteDAO() {
        this.conn = new Conn().pegarConexao();
    }

    public void Salvar(Cliente obj) {
        try {
            String sql = "INSERT INTO Cliente (IdCliente, Nome, CPF, RG, Telefone, CEP, Rua, numCasa, Bairro, Estado, Cidade, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getEndereco());
            stmt.setInt(7, obj.getNum_end());
            stmt.setString(8, obj.getBairro());
            stmt.setString(9, obj.getEstado());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getEmail());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Sucesso");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + e.getMessage());
        }
    }
    
    public void Editar(Cliente obj) {
        try {
            String sql = "UPDATE Cliente SET Nome=?, CPF=?, RG=?, Telefone=?, CEP=?, Rua=?, numCasa=?, Bairro=?, Estado=?, Cidade=?, Email=? WHERE IdCliente=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getEndereco());
            stmt.setInt(7, obj.getNum_end());
            stmt.setString(8, obj.getBairro());
            stmt.setString(9, obj.getEstado());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getEmail());
            stmt.setInt(12, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente editado");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente: " + e.getMessage());
        }
    }
    
    public void Excluir(Cliente obj) {
    	try {
    		String sql = "delete from Cliente where id=?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, obj.getId());
    		stmt.execute();
    		stmt.close();
    		JOptionPane.showMessageDialog(null, "cliente excluido");
    	}catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "erro ao excluir");
    	}
    }
    
    public Cliente Pesquisar(String nome) {
    	try {
    		String sql = "select * from Cliente where nome =?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, nome);
    		ResultSet rs = stmt.executeQuery();
    		Cliente obj = new Cliente();
    		if (rs.next()) {
    			obj.setId(rs.getInt("IdCliente"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setCpf(rs.getString("CPF"));
   			 	obj.setRg(rs.getString("RG"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setCelular(rs.getString("Telefone"));
   			 	obj.setCep(rs.getString("CEP"));
   			 	obj.setEndereco(rs.getString("Rua"));
   			 	obj.setNum_end(rs.getInt("numCasa"));
   			 	obj.setBairro(rs.getString("Bairro"));
   			 	obj.setCidade(rs.getString("Cidade"));
   			 	obj.setEstado(rs.getString("Estado"));
    		}
    		return obj;
    		
    	} catch (SQLException erro) {
    		JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
    	}
		return null;
    }
    
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
                obj.setCpf(rs.getString("CPF"));
                obj.setRg(rs.getString("RG"));
                obj.setEmail(rs.getString("Email"));
                obj.setCelular(rs.getString("Telefone"));
                obj.setCep(rs.getString("CEP"));
                obj.setEndereco(rs.getString("Rua"));
                obj.setNum_end(rs.getInt("numCasa"));
                obj.setBairro(rs.getString("Bairro"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setEstado(rs.getString("Estado"));
                lista.add(obj);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar lista: " + e);
        }
        return lista;
    }
    	
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
                    obj.setCpf(rs.getString("CPF"));
                    obj.setRg(rs.getString("RG"));
                    obj.setEmail(rs.getString("Email"));
                    obj.setCelular(rs.getString("Telefone"));
                    obj.setCep(rs.getString("CEP"));
                    obj.setEndereco(rs.getString("Rua"));
                    obj.setNum_end(rs.getInt("numCasa"));
                    obj.setBairro(rs.getString("Bairro"));
                    obj.setCidade(rs.getString("Cidade"));
                    obj.setEstado(rs.getString("Estado"));
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