import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) {
        Database db = new Database();

        db.conectarBancoDeDados();
        db.criarTabelas();
    }
}
