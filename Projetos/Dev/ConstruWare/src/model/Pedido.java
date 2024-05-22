package model;

import java.util.Date;

/**
 * 
 * 
 */

public class Pedido {

    public Pedido() {
    }

    private int cod_pedido;
    private Date data_pedido;
    private String status_pedido;
    private Double total_pedido;
    
    @Override
	public String toString() {
		return "Pedido [cod_pedido=" + cod_pedido + ", data_pedido=" + data_pedido + ", status_pedido=" + status_pedido
				+ ", total_pedido=" + total_pedido + "]";
	}

	public void adicionarProduto() {
    }

    public void retiraProduto() {
    }

    public void concluiPedido() {
    }

    public void pagamentoStatus() {
    }

    public void calcTotal() {
    }

}