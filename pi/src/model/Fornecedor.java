package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Fornecedor.
 */
public class Fornecedor extends Pessoa {
	
	/** The cnpj. */
	private String cnpj;

	/**
	 * Instantiates a new fornecedor.
	 */
	public Fornecedor() {
		super();
	}

	/**
	 * Instantiates a new fornecedor.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cnpj the cnpj
	 * @param telefone the telefone
	 * @param email the email
	 * @param cep the cep
	 * @param estado the estado
	 * @param cidade the cidade
	 * @param rua the rua
	 * @param bairro the bairro
	 * @param num the num
	 */
	public Fornecedor(int id, String nome, String cnpj, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
		
		this.cnpj = cnpj;
	}

	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getNome();
	}
	
	
}
