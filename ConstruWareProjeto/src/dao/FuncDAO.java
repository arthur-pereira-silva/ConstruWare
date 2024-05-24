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
import model.Funcionario;

public class FuncDAO {

    private Connection conn;

    public FuncDAO() {
        this.conn = new Conn().pegarConexao();
    }

    public void Salvar(Funcionario obj) {
        try {
            String sql = "INSERT INTO Funcionario (Nome, CPF, RG, Telefone, CEP, Rua, numCasa, Bairro, Estado, Cidade, Email, Senha, Cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
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
            stmt.setString(12, obj.getSenha());
            stmt.setString(13, obj.getCargo());


            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario salvo");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar funcionario: " + e.getMessage());
        }
    }
    
    public void Editar(Funcionario obj) {
        try {
            String sql = "UPDATE Funcionario SET Nome=?, CPF=?, RG=?, Telefone=?, CEP=?, Rua=?, numCasa=?, Bairro=?, Estado=?, Cidade=?, Email=?, Senha=?, Cargo=? WHERE IdCliente=?";
            
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
            stmt.setString(12, obj.getSenha());
            stmt.setString(13, obj.getCargo());
            stmt.setInt(15, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario editado");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionariio: " + e.getMessage());
        }
    }
    
    public void Excluir(Funcionario obj) {
    	try {
    		String sql = "delete from Funcionario where id=?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, obj.getId());
    		stmt.execute();
    		stmt.close();
    		JOptionPane.showMessageDialog(null, "funcionario excluido");
    	}catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "erro ao excluir");
    	}
    }
    
    public Cliente PesquisarFunc(String nome) {
    	try {
    		String sql = "select * from Funcionario where nome =?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, nome);
    		ResultSet rs = stmt.executeQuery();
    		Funcionario obj = new Funcionario();
    		if (rs.next()) {
    			obj.setId(rs.getInt("IdCliente"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setCpf(rs.getString("CPF"));
   			 	obj.setRg(rs.getString("RG"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setSenha(rs.getString("Semha"));
   			 	obj.setCargo(rs.getString("Cargo"));
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
    
    	public List<Funcionario>Listar() {
        List<Funcionario> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Funcionario";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("IdCliente"));
                obj.setNome(rs.getString("Nome"));
                obj.setCpf(rs.getString("CPF"));
                obj.setRg(rs.getString("RG"));
                obj.setEmail(rs.getString("Email"));
                obj.setSenha(rs.getString("Senha"));
                obj.setCargo(rs.getString("Cargo"));
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
    	
   public List<Funcionario>Filtrar(String nome) {
            List<Funcionario> lista = new ArrayList<>();
            try {
                String sql = "SELECT * FROM Funcionario where nome like ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Funcionario obj = new Funcionario();
                    obj.setId(rs.getInt("IdCliente"));
                    obj.setNome(rs.getString("Nome"));
                    obj.setCpf(rs.getString("CPF"));
                    obj.setRg(rs.getString("RG"));
                    obj.setEmail(rs.getString("Email"));
                    obj.setSenha(rs.getString("Senha"));
                    obj.setCargo(rs.getString("Cargo"));
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