package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conn {
    final private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BD_PI;encrypt=true;trustServerCertificate=true;"
;
    final private String usuario = "sa";
    final private String senha = "Cavalo1@";

    public Connection pegarConexao() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }
}