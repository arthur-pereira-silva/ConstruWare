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
import model.Produto;

public class ProdDAO {

    private Connection conn;

    public ProdDAO() {
        this.conn = new Conn().pegarConexao();
    }

    public void Salvar(Produto obj) {
        String sql = "INSERT INTO Produto (Nome, Preco, QuantidadeEstoque, Fornecedores) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getPreco());
            stmt.setDouble(3, obj.getQtd());
            stmt.setInt(4, obj.getFornecedores().getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto salvo");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar produto: " + e.getMessage());
        }
    }

    public void Editar(Produto obj) {
        String sql = "UPDATE Produto SET Nome=?, Preco=?, QuantidadeEstoque=?, Fornecedores=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getPreco());
            stmt.setDouble(3, obj.getQtd());
            stmt.setInt(4, obj.getFornecedores().getId());
            stmt.setInt(5, obj.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto editado");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getMessage());
        }
    }

    // Method to delete a product from the database
    public void Excluir(Produto obj) {
        String sql = "DELETE FROM Produto WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluido");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage());
        }
    }

    public Produto PesquisarProd(String nome) {
        String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome FROM Produto p INNER JOIN Fornecedores f ON p.for_id = f.id WHERE p.Nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Produto obj = new Produto();
            Fornecedores f = new Fornecedores();
            if (rs.next()) {
                obj.setId(rs.getInt("p.IdProduto"));
                obj.setNome(rs.getString("p.Nome"));
                obj.setPreco(rs.getDouble("p.Preco"));
                obj.setQtd(rs.getDouble("p.QuantidadeEstoque"));
                f.setNome(rs.getString("f.Nome"));
                obj.setFornecedores(f);
            }
            rs.close();
            return obj;
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto: " + erro.getMessage());
        }
        return null;
    }

    public List<Produto> Listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome FROM Produto p INNER JOIN Fornecedores f ON p.for_id = f.id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.IdProduto"));
                obj.setNome(rs.getString("p.Nome"));
                obj.setPreco(rs.getDouble("p.Preco"));
                obj.setQtd(rs.getDouble("p.QuantidadeEstoque"));
                f.setNome(rs.getString("f.Nome"));
                obj.setFornecedores(f);
                lista.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }

    public List<Produto> Filtrar(String nome) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.IdProduto, p.Nome, p.Preco, p.QuantidadeEstoque, f.Nome FROM Produto p INNER JOIN Fornecedores f ON p.for_id = f.id WHERE p.Nome LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.IdProduto"));
                obj.setNome(rs.getString("p.Nome"));
                obj.setPreco(rs.getDouble("p.Preco"));
                obj.setQtd(rs.getDouble("p.QuantidadeEstoque"));
                f.setNome(rs.getString("f.Nome"));
                obj.setFornecedores(f);
                lista.add(obj);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao filtrar produtos: " + e.getMessage());
        }
        return lista;
    }
}
