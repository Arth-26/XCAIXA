import java.sql.*;


public class Database {
    public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:8080/xcaixadb";
            String user = "postgres";
            String password = "12345";
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida com sucesso!");

                Statement stmt = conn.createStatement();

                String updates = "CREATE TABLE clientes (nome VARCHAR(50) PRIMARY KEY, estado STRING, cidade STRING, rua STRING, contato STRING, cpf STRING, devedor BOOLEAN)";
                stmt.executeUpdate(updates);
                System.out.println("Tabeça criada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao tentar conectar: " + e.getMessage());
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        System.out.println("Ocorreu um erro ao tentar fechar a conexão: " + e.getMessage());
                    }
                }

    }
}
