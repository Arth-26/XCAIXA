import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // Configurações de conexão com o banco de dados
    String url = "jdbc:postgresql://localhost:8080/xcaixadb";
    String username = "postgres";
    String password = "12345";

    // Objeto de conexão com o banco de dados
    Connection conn = null;

    public void conectarBancoDeDados() {

        try{
            // Registrar o driver JDBC (O driver PostgreSQL já vem com o JDBC)
            Class.forName("org.postgresql.Driver");
            // Estabelecer a conexão com o banco de dados
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com sucesso!");
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
        }
    }

    public void fecharConexao(){
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

    public void criarTabelas(){

        try{
            // Cria um Statement para executar consultas SQL
            Statement stmt = conn.createStatement();

            //CRIAÇÃO DE TABELAS
            String sqlclientes = "CREATE TABLE clientes (nome VARCHAR(50) PRIMARY KEY, estado TEXT, cidade TEXT, rua TEXT, numero_de_telefone TEXT, cpf TEXT, devedor BOOLEAN)";

            String sqlEstoque = "CREATE TABLE estoque (id SERIAL PRIMARY KEY, )";

            String sqlProdutos = "CREATE TABLE produtos (codigo SERIAL PRIMARY KEY, marca TEXT, tamanho TEXT, categoria TEXT, preco NUMERIC(10,2)";

            String sqlPedidos = "CREATE TABLE pedidos ()";

            String sqlCaderneta = "CREATE TABLE caderneta ()";

            String sqlAdmin = "CREATE TABLE administrador (nome VARCHAR(50) PRIMARY KEY, email TEXT, senha VAR(16)";

            String sqlCaixa = "CREATE TABLE caixa (data DATE PRIMARY KEY, saldo_inicial NUMERIC(10,2), saldo_final NUMERIC(10,2), saida_capital(10,2)";

            String sqlLoja = "CREATE TABLE loja ()";


            stmt.executeUpdate(sqlProdutos);
            stmt.executeUpdate(sqlAdmin);
            stmt.executeUpdate(sqlCaixa);

            System.out.println("TABELAS CRIADAS COM SUCESSO");

            fecharConexao();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}












