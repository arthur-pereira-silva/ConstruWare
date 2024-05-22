package model;

/**
 * 
 * 
 */

public class Produto {

    public Produto() {
    }

    private int cod_prod;
    private String nome_prod;
    private String descricao;
    private Double qtd_prod;
    private Double preco_prod;
    
    @Override
	public String toString() {
		return "Produto [cod_prod=" + cod_prod + ", nome_prod=" + nome_prod + ", descricao=" + descricao + ", qtd_prod="
				+ qtd_prod + ", preco_prod=" + preco_prod + "]";
	}

	public void cadastrarProduto() {
    }

    public void alteraProduto() {
    }

    public void removerProduto() {
        return;
    }

}