package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conn {
	
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_PI;integratedSecurity=true;encrypt=true;trustServerCertificate=true";	
    private static String user = "sa"; // Substitua pelo seu usuário do banco de dados
    private static String password = "03052004"; // Substitua pela sua senha do banco de dados
    private static Connection connection;

    public static Connection pegarConexao() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Banco de Dados Conectado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}