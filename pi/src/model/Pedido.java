package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Pedido.
 */
public class Pedido {

    /** The id. */
    private int id	;
    
    /** The data. */
    private String data;
    
    /** The total. */
    private Double total;
    
    /** The cliente. */
    private Cliente cliente;
    
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	
	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	
	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    
}
