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
            String sql = "INSERT INTO Funcionario (Nome, RG, CPF, Cargo, Salario, CNH, Telefone, Email, CEP, Estado, Cidade, Rua, Bairro, NumCasa, Senha) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getCargo());
            stmt.setDouble(5, obj.getSalario());
            stmt.setString(6, obj.getCnh());
            stmt.setString(7, obj.getTelefone());
            stmt.setString(8, obj.getEmail());
            stmt.setString(9, obj.getCep());
            stmt.setString(10, obj.getEstado());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getRua());
            stmt.setString(13, obj.getBairro());
            stmt.setInt(14, obj.getNum());
            stmt.setString(15, obj.getSenha());

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
            String sql = "UPDATE Funcionario SET Nome=?, RG=?, CPF=?, Cargo=?, Salario=?, CNH=?, Telefone=?, Email=?, CEP=?, Estado=?, Cidade=?, Rua=?, Bairro=?, NumCasa=?, Senha=? WHERE IdFuncioanrio=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getCargo());
            stmt.setDouble(5, obj.getSalario());
            stmt.setString(6, obj.getCnh());
            stmt.setString(7, obj.getTelefone());
            stmt.setString(8, obj.getEmail());
            stmt.setString(9, obj.getCep());
            stmt.setString(10, obj.getEstado());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getBairro());
            stmt.setString(13, obj.getRua());
            stmt.setInt(14, obj.getNum());
            stmt.setString(15, obj.getSenha());
            stmt.setInt(16, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario Editado!");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionario: " + e.getMessage());
        }
    }
    
    public void Excluir(Funcionario obj) {
    	try {
    		String sql = "delete from Funcionario where id=?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, obj.getId());
    		stmt.execute();
    		stmt.close();
    		JOptionPane.showMessageDialog(null, "Funcionario Excluido");
    	}catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "Erro ao Excluir");
    	}
    }
    
    public Funcionario PesquisarFunc(String nome) {
    	try {
    		String sql = "select * from Funcionario where nome = ?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, nome);
    		ResultSet rs = stmt.executeQuery();
    		Funcionario obj = new Funcionario();
    		if (rs.next()) {
    			obj.setId(rs.getInt("IdFuncionario"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setRg(rs.getString("RG"));
   			 	obj.setCpf(rs.getString("CPF"));
   			 	obj.setCargo(rs.getString("Cargo"));
   			 	obj.setSalario(rs.getDouble("Salario"));
   			 	obj.setCnh(rs.getString("CNH"));
   			 	obj.setTelefone(rs.getString("Telefone"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setCep(rs.getString("CEP"));
   			 	obj.setEstado(rs.getString("Estado"));
   			 	obj.setCidade(rs.getString("Cidade"));
   			 	obj.setBairro(rs.getString("Bairro"));
   			 	obj.setRua(rs.getString("Rua"));
   			 	obj.setNum(rs.getInt("numCasa"));
   			 	obj.setSenha(rs.getString("Senha"));


    		}
    		return obj;
    		
    	} catch (SQLException erro) {
    		JOptionPane.showMessageDialog(null, "erro ao pesquisar"+ erro);
    	}
		return null;
    }
    public Funcionario PesquisarFuncionario(int id) {
    	try {
    		String sql = "select * from Funcionario where IdFuncionario =?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, id);
    		ResultSet rs = stmt.executeQuery();
    		Funcionario obj = new Funcionario();
    		if (rs.next()) {
    			obj.setId(rs.getInt("IdFuncionario"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setRg(rs.getString("RG"));
   			 	obj.setCpf(rs.getString("CPF"));
   			 	obj.setCargo(rs.getString("Cargo"));
   			 	obj.setSalario(rs.getDouble("Salario"));
   			 	obj.setCnh(rs.getString("CNH"));
   			 	obj.setTelefone(rs.getString("Telefone"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setCep(rs.getString("CEP"));
   			 	obj.setEstado(rs.getString("Estado"));
   			 	obj.setCidade(rs.getString("Cidade"));
   			 	obj.setBairro(rs.getString("Bairro"));
   			 	obj.setRua(rs.getString("Rua"));
   			 	obj.setNum(rs.getInt("numCasa"));
   			 	obj.setSenha(rs.getString("Senha"));

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
    			obj.setId(rs.getInt("IdFuncionario"));
   			 	obj.setNome(rs.getString("Nome"));
   			 	obj.setRg(rs.getString("RG"));
   			 	obj.setCpf(rs.getString("CPF"));
   			 	obj.setCargo(rs.getString("Cargo"));
   			 	obj.setSalario(rs.getDouble("Salario"));
   			 	obj.setCnh(rs.getString("CNH"));
   			 	obj.setTelefone(rs.getString("Telefone"));
   			 	obj.setEmail(rs.getString("Email"));
   			 	obj.setCep(rs.getString("CEP"));
   			 	obj.setEstado(rs.getString("Estado"));
   			 	obj.setCidade(rs.getString("Cidade"));
   			 	obj.setBairro(rs.getString("Bairro"));
   			 	obj.setRua(rs.getString("Rua"));
   			 	obj.setNum(rs.getInt("numCasa"));
   			 	obj.setSenha(rs.getString("Senha"));

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
        			obj.setId(rs.getInt("IdFuncionario"));
       			 	obj.setNome(rs.getString("Nome"));
       			 	obj.setRg(rs.getString("RG"));
       			 	obj.setCpf(rs.getString("CPF"));
       			 	obj.setCargo(rs.getString("Cargo"));
       			 	obj.setSalario(rs.getDouble("Salario"));
       			 	obj.setCnh(rs.getString("CNH"));
       			 	obj.setTelefone(rs.getString("Telefone"));
       			 	obj.setEmail(rs.getString("Email"));
       			 	obj.setCep(rs.getString("CEP"));
       			 	obj.setEstado(rs.getString("Estado"));
       			 	obj.setCidade(rs.getString("Cidade"));
       			 	obj.setBairro(rs.getString("Bairro"));
       			 	obj.setRua(rs.getString("Rua"));
       			 	obj.setNum(rs.getInt("numCasa"));
       			 	obj.setSenha(rs.getString("Senha"));

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