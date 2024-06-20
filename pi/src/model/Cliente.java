package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
public class Cliente extends Pessoa {
	
	/** The rg. */
	private String rg;
	
	/** The cpf. */
	private String cpf;


	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
		super();
	}
	
	/**
	 * Instantiates a new cliente.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param rg the rg
	 * @param cpf the cpf
	 * @param telefone the telefone
	 * @param email the email
	 * @param cep the cep
	 * @param estado the estado
	 * @param cidade the cidade
	 * @param rua the rua
	 * @param bairro the bairro
	 * @param num the num
	 */
	public Cliente(int id, String nome, String rg,String cpf, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);

		this.rg = rg;
		this.cpf = cpf;
	}
	
	/**
	 * Gets the rg.
	 *
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	
	/**
	 * Sets the rg.
	 *
	 * @param rg the new rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Cliente [rg=" + rg + ", cpf=" + cpf + "]";
	}
	
	

}



