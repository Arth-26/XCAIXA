
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    String url = "jdbc:postgresql://localhost:5432/Xcaixa";
    String username = "postgres";
    String password = "admadm";
    Connection conn = null;

    public Connection conectarBancoDeDados() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException var2) {
            System.out.println("Falha ao estabelecer a conexão.");
            System.out.println("Driver JDBC não encontrado.");
            var2.printStackTrace();
        } catch (SQLException var3) {
            System.out.println("Falha ao estabelecer a conexão.");
            System.out.println("Erro na conexão com o banco de dados.");
            var3.printStackTrace();
        }
        return this.conn;
    }

    public void fecharConexao() {
        if (this.conn != null) {
            try {
                this.conn.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException var2) {
                System.out.println("Erro ao fechar a conexão.");
                var2.printStackTrace();
            }
        }

    }
}










