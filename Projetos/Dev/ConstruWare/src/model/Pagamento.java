package model;

import java.util.Date;

/**
 * 
 * 
 */

public class Pagamento {


    public Pagamento() {
    }

    private int cod_pag;
    private String metodo_pag;
    private Double valor_pag;
    private Date data_pag;
    private Date hora_paga;
    
    @Override
	public String toString() {
		return "Pagamento [cod_pag=" + cod_pag + ", metodo_pag=" + metodo_pag + ", valor_pag=" + valor_pag
				+ ", data_pag=" + data_pag + ", hora_paga=" + hora_paga + "]";
	}

	public void escolheFormaPgto() {
    }
    
    public void insereFormaPgto() {
    }

    public void calcPedido() {
    }

}