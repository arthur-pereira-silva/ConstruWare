package model;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class Pagamento.
 */
public class Pagamento {
	
    /** The id. */
    private int id;
    
    /** The metodo. */
    private String metodo;
    
    /** The valor. */
    private Double valor;
    
    /** The data. */
    private Date data;
    
	/**
	 * Instantiates a new pagamento.
	 */
	public Pagamento() {
		super();
	}


	/**
	 * Instantiates a new pagamento.
	 *
	 * @param id the id
	 * @param metodo the metodo
	 * @param valor the valor
	 * @param data the data
	 */
	public Pagamento(int id, String metodo, Double valor, Date data) {
		super();
		
		this.id = id;
		this.metodo = metodo;
		this.valor = valor;
		this.data = data;
	}


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
	 * Gets the metodo.
	 *
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}


	/**
	 * Sets the metodo.
	 *
	 * @param metodo the new metodo
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}


	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}


	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}


	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Date data) {
		this.data = data;
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", metodo=" + metodo + ", valor=" + valor + ", data=" + data
				+ "]";
	}
    

}
