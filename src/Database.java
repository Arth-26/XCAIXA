import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) {
        // Configurações de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/Xcaixa";
        String username = "postgres";
        String password = "admadm";

        // Objeto de conexão com o banco de dados
        Connection conn = null;

        try {
            // Registrar o driver JDBC (O driver PostgreSQL já vem com o JDBC)
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");

            // Cria um Statement para executar consultas SQL
            Statement stmt = conn.createStatement();


            String sqlclientes = "CREATE TABLE clientes (nome VARCHAR(50) PRIMARY KEY, estado TEXT, cidade TEXT, rua TEXT, numero_de_telefone TEXT, cpf TEXT, devedor BOOLEAN)";
            // Estabelecer a conexão com o banco de dados
            

            stmt.executeUpdate(sqlclientes);

        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não seja encontrado
            System.out.println("Falha ao estabelecer a conexão.");
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro caso ocorra um problema na conexão com o banco de dados
            System.out.println("Falha ao estabelecer a conexão.");
            System.out.println("Erro na conexão com o banco de dados.");
            e.printStackTrace();
        } finally {
            // Fechar a conexão com o banco de dados, caso tenha sido aberta
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexão fechada com sucesso.");
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão.");
                    e.printStackTrace();
                }
            }
        }
    }
}










