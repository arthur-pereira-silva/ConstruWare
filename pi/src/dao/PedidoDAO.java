package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conn;
import model.Cliente;
import model.Pedido;

// TODO: Auto-generated Javadoc
/**
 * The Class PedidoDAO.
 */
public class PedidoDAO {
	
	/** The conn. */
	private Connection conn;

	/**
	 * Instantiates a new pedido DAO.
	 */
	public PedidoDAO() {
		this.conn = new Conn().pegarConexao();
	}
	
	/**
	 * Salvar.
	 *
	 * @param pedido the pedido
	 */
	public void salvar(Pedido pedido) {
		try {
			String sql = "INSERT INTO pedido (IdCliente, DataPedido, Total) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Exemplo de formatação da data
			Date agora = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataFormatada = formatador.format(agora);
			stmt.setInt(1, pedido.getCliente().getId());
			stmt.setString(2, dataFormatada);
			stmt.setDouble(3, pedido.getTotal());
			stmt.executeUpdate();

			stmt.close();
			JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar pedido: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Retorna ultimo id venda.
	 *
	 * @return the int
	 */
	public int retornaUltimoIdVenda() {
		int ultimoId = 0;
		String sql = "SELECT MAX(IdPedido) IdPedido from Pedido";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pedido v =new Pedido();
				v.setId(rs.getInt("IdPedido"));
				ultimoId = v.getId();
			}
			return ultimoId;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao retornar último Id da Venda!"+e);
		}

	}

	/**
	 * Historico pedido.
	 *
	 * @param data_inicio the data inicio
	 * @param data_final the data final
	 * @return the list
	 */
	public List<Pedido> historicoPedido(LocalDate data_inicio, LocalDate data_final) {
		List<Pedido> lista = new ArrayList<>();
		String sql = "SELECT p.IdPedido, c.Nome, CONVERT(varchar, p.DataPedido, 103) AS data_formatada, p.Total " +
	             "FROM Pedido AS p INNER JOIN Cliente AS c ON p.IdCliente = c.IdCliente " +
	             "WHERE p.DataPedido BETWEEN ? AND ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setObject(1, data_inicio);
			stmt.setObject(2, data_final);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pedido p = new Pedido();
				Cliente c = new Cliente();
				p.setId(rs.getInt("IdPedido"));
				c.setNome(rs.getString("Nome"));
				p.setCliente(c);
				p.setData(rs.getString("data_formatada"));
				p.setTotal(rs.getDouble("Total"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar Histórico de Venda", e);
		}
	}
	
	/**
	 * Posicao do dia.
	 *
	 * @param data_venda the data venda
	 * @return the double
	 */
	public double posicaoDoDia(LocalDate data_venda) {
	    double total_dia = 0;
	    
	    try {
	        String sql = "SELECT SUM(Total) AS total FROM Pedido WHERE DataPedido = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setDate(1, java.sql.Date.valueOf(data_venda));
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            total_dia = rs.getDouble("total");
	        }
	        
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao retornar a Posição do Dia!", e);
	    }
	    
	    return total_dia;
	}

}

