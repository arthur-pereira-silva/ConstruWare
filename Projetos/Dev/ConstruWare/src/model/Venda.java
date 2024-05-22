package model;


/**
 * 
 */
public class Venda {

    public Venda() {
    }

    private int cod_venda;
    private Double qtd_prod;
    private Double valor_unitario;
    private Double subtotal_prod;
       
    @Override
	public String toString() {
		return "Venda [cod_venda=" + cod_venda + ", qtd_prod=" + qtd_prod + ", valor_unitario=" + valor_unitario
				+ ", subtotal_prod=" + subtotal_prod + "]";
	}

	public void imprimir() {
    }

    public void atualizarProduto() {
    }

    public void totalValor() {
    }
    
}