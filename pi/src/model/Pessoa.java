package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Pessoa.
 */
public class Pessoa {
	
	/** The id. */
	private int id;
	
	/** The nome. */
	private String nome;
	
	/** The telefone. */
	private String telefone;
	
	/** The email. */
	private String email;
	
	/** The cep. */
	private String cep;
	
	/** The estado. */
	private String estado;
	
	/** The cidade. */
	private String cidade;
	
	/** The rua. */
	private String rua;
	
	/** The bairro. */
	private String bairro;
	
	/** The num. */
	private int num;
	
	
	
	/**
	 * Instantiates a new pessoa.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param telefone the telefone
	 * @param email the email
	 * @param cep the cep
	 * @param estado the estado
	 * @param cidade the cidade
	 * @param rua the rua
	 * @param bairro the bairro
	 * @param num the num
	 */
	public Pessoa(int id, String nome, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.num = num;
	}

	/**
	 * Instantiates a new pessoa.
	 */
	public Pessoa() {
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
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Gets the rua.
	 *
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Sets the rua.
	 *
	 * @param rua the new rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the num.
	 *
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Sets the num.
	 *
	 * @param num the new num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cep=" + cep
				+ ", estado=" + estado + ", cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + ", num=" + num
				+ "]";
	}
	
	
}
