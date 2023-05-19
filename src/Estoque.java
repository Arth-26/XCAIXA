
public class Estoque {

    private String id;
    private Produtos produto;
    private int quantidade;

    //SETTERS AND GETTERS

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
