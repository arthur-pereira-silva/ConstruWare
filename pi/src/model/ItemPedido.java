package model;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPedido.
 */
public class ItemPedido {
	
	/** The id. */
	private  int id;
	
	/** The produto. */
	private Produto produto;
	
	/** The pedido. */
	private Pedido pedido;
	
	/** The subtotal. */
	private double subtotal;
	
	/** The qtd. */
	private int qtd;
	
	
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
	 * Gets the produto.
	 *
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}
	
	/**
	 * Sets the produto.
	 *
	 * @param produto the new produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	/**
	 * Gets the pedido.
	 *
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * Sets the pedido.
	 *
	 * @param pedido the new pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	/**
	 * Gets the subtotal.
	 *
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	
	/**
	 * Sets the subtotal.
	 *
	 * @param subtotal the new subtotal
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	/**
	 * Gets the qtd.
	 *
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}
	
	/**
	 * Sets the qtd.
	 *
	 * @param qtd the new qtd
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}
