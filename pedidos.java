public class pedidos {

    private String tipo_de_pagamento;
    private double preco_de_venda;
    private produtos produto;
    private cliente comprador;
    private String data;

    //SETTERS AND GETTERS

    public void setTipo_de_pagamento(String tipo_de_pagamento) {
        this.tipo_de_pagamento = tipo_de_pagamento;
    }

    public String getTipo_de_pagamento() {
        return tipo_de_pagamento;
    }
    
    public void setPreco_de_venda(double preco_de_venda) {
        this.preco_de_venda = preco_de_venda;
    }

    public double getPreco_de_venda() {
        return preco_de_venda;
    }

    public void setProduto(produtos produto) {
        this.produto = produto;
    }

    public produtos getProduto() {
        return produto;
    }

    public void setComprador(cliente comprador) {
        this.comprador = comprador;
    }

    public cliente getComprador() {
        return comprador;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
