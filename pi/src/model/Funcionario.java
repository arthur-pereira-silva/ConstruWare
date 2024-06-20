package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Funcionario.
 */
public class Funcionario extends Pessoa {
	
	/** The rg. */
	private String rg;
	
	/** The cpf. */
	private String cpf;
	
	/** The cnh. */
	private String cnh;
	
	/** The cargo. */
	private String cargo;
	
	/** The salario. */
	private double salario;
	
	/** The senha. */
	private String senha;
	

	/**
	 * Instantiates a new funcionario.
	 */
	public Funcionario() {
		super();
	}
	
	/**
	 * Instantiates a new funcionario.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param rg the rg
	 * @param cpf the cpf
	 * @param cargo the cargo
	 * @param salario the salario
	 * @param cnh the cnh
	 * @param telefone the telefone
	 * @param email the email
	 * @param cep the cep
	 * @param estado the estado
	 * @param cidade the cidade
	 * @param rua the rua
	 * @param bairro the bairro
	 * @param num the num
	 */
	public Funcionario(int id, String nome, String rg,String cpf,String cargo,double salario, String cnh, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
		
		this.rg = rg;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.cnh = cnh;
		
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
	 * Gets the cnh.
	 *
	 * @return the cnh
	 */
	public String getCnh() {
		return cnh;
	}
	
	/**
	 * Sets the cnh.
	 *
	 * @param cnh the new cnh
	 */
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	/**
	 * Gets the cargo.
	 *
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	
	/**
	 * Sets the cargo.
	 *
	 * @param cargo the new cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Gets the salario.
	 *
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}
	
	/**
	 * Sets the salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Sets the senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Funcionario [rg=" + rg + ", cpf=" + cpf + ", cnh=" + cnh + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
	
}

	