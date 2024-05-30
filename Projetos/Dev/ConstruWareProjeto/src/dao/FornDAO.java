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

    public FornDAO() {
        this.conn = new Conn().pegarConexao();
    }

    public void Salvar(Fornecedores obj) {
        try {
            String sql = "INSERT INTO Fornecedores (Nome, CNPJ, Telefone, CEP, Rua, numCasa, Bairro, Estado, Cidade, Email, Senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
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
            JOptionPane.showMessageDialog(null, "Fornecedor salvo");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar Fornecedor: " + e.getMessage());
        }
    }
    
    public void Editar(Fornecedores obj) {
        try {
            String sql = "UPDATE Fornecedores SET Nome=?, CNPJ=?, Telefone=?, CEP=?, Rua=?, numCasa=?, Bairro=?, Estado=?, Cidade=?, Email=?, Senha=?, Cargo=? WHERE IdFornecedor=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getCelular());
            stmt.setString(4, obj.getCep());
            stmt.setString(5, obj.getEndereco());
            stmt.setInt(6, obj.getNum_end());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getEstado());
            stmt.setString(9, obj.getCidade());
            stmt.setString(10, obj.getEmail());
            stmt.setInt(11, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedores editados");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar fornecedores: " + e.getMessage());
        }
    }
    
    public void Excluir(Fornecedores obj) {
    	try {
    		String sql = "delete from Fornecedores where id=?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, obj.getId());
    		stmt.execute();
    		stmt.close();
    		JOptionPane.showMessageDialog(null, "fornecedor excluido");
    	}catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "erro ao excluir");
    	}
    }
    
    public Fornecedores PesquisarForn(String nome) {
    	try {
    		String sql = "select * from Fornecedores where nome =?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, nome);
    		ResultSet rs = stmt.executeQuery();
    		Fornecedores obj = new Fornecedores();
    		if (rs.next()) {
    			   stmt.setString(1, obj.getNome());
    	            stmt.setString(2, obj.getCnpj());
    	            stmt.setString(3, obj.getCelular());
    	            stmt.setString(4, obj.getCep());
    	            stmt.setString(5, obj.getEndereco());
    	            stmt.setInt(6, obj.getNum_end());
    	            stmt.setString(7, obj.getBairro());
    	            stmt.setString(8, obj.getEstado());
    	            stmt.setString(9, obj.getCidade());
    	            stmt.setString(10, obj.getEmail());
    	            stmt.setInt(11, obj.getId());
    		}
    		return obj;
    		
    	} catch (SQLException erro) {
    		JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
    	}
		return null;
    }
    
    	public List<Fornecedores>Listar() {
        List<Fornecedores> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Fornecedores";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                obj.setId(rs.getInt("IdFornecedor"));
                obj.setNome(rs.getString("Nome"));
                obj.setCnpj(rs.getString("CNPJ"));
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
    	
   public List<Fornecedores>Filtrar(String nome) {
            List<Fornecedores> lista = new ArrayList<>();
            try {
                String sql = "SELECT * FROM Fornecedores where nome like ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Fornecedores obj = new Fornecedores();
                    obj.setId(rs.getInt("IdFornecedor"));
                    obj.setNome(rs.getString("Nome"));
                    obj.setCnpj(rs.getString("CNPJ"));
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