import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    
    private String nome;
    private String email;
    private String senha;
    private Caderneta caderneta;
    private Estoque estoque;
    private Database connection;

    Scanner input = new Scanner(System.in);

    public Admin(){
        this.connection = new Database();
    }
    //SETTERS AND GETTERS

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //METODS

    public void cadastrarCliente( String nome, String rua, String cidade, String estado, String numero_De_telefone, String cpf, boolean devedor) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setRua(rua);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setNumero_telefone(numero_De_telefone);
        cliente.setCpf(cpf);
        cliente.setDevedor(devedor);

        String sql = "INSERT INTO clientes(nome, rua, cidade, estado, numero_De_telefone, cpf, devedor)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = connection.conectarBancoDeDados();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getRua());
            preparedStatement.setString(3, cliente.getCidade());
            preparedStatement.setString(4, cliente.getEstado());
            preparedStatement.setString(5, cliente.getNumero_telefone());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setBoolean(7, cliente.isDevedor());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void removerCliente(String cpf) throws SQLException {
        String sql = "DELETE FROM clientes WERE cpf = ?";

        Connection conn = connection.conectarBancoDeDados();

        try {
          PreparedStatement preparedStatement = conn.prepareStatement(sql);
          preparedStatement.setString(1,cpf);

          int linhaDeletada = preparedStatement.executeUpdate();
          if (linhaDeletada > 0){
              System.out.println("Cliente Removido com sucesso!");
          } else {
              System.out.println("Cliente não encontrado!");
          }

        }catch (SQLException e){
            throw  new RuntimeException(e);

        }

    }

    public void adicionarEstoque() {
        
    }

    public void removerEstoque() {
        
    }

    public void verEstoque() {
        
    }

    public void atualizarQuantidade() {
        
    }

    public void adicionarCompra() {
        
    }

    public void obterMargemDeLucro() {
        
    }

    public void adicionarDesconto() {
        
    }

    public void valo() {
        
    }



    
}
