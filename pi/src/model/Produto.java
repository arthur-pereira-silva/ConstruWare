package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Produto.
 */
public class Produto {
	
    /** The id. */
    private int id;
    
    /** The nome. */
    private String nome;
    
    /** The qtd. */
    private Double qtd;
    
    /** The preco. */
    private Double preco;
    
    /** The fornecedor. */
    private Fornecedor fornecedor;
    
    
	/**
	 * Instantiates a new produto.
	 */
	public Produto() {
		super();
	}

	/**
	 * Instantiates a new produto.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param qtd the qtd
	 * @param preco the preco
	 */
	public Produto(int id, String nome, Double qtd, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;

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
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the qtd.
	 *
	 * @return the qtd
	 */
	public Double getQtd() {
		return qtd;
	}

	/**
	 * Sets the qtd.
	 *
	 * @param qtd the new qtd
	 */
	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", preco=" + preco + "]";
	}
	
	/**
	 * Gets the fornecedores.
	 *
	 * @return the fornecedores
	 */
	public Fornecedor getFornecedores() {
        return fornecedor;
    }
    
    /**
     * Sets the fornecedores.
     *
     * @param fornecedor the new fornecedores
     */
    public void setFornecedores(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
