package model;

public class Funcionario extends Pessoa {
	
	private String rg;
	private String cpf;
	private String cnh;
	private String cargo;
	private float salario;
	
	public Funcionario() {
		super();
	}
	public Funcionario(int id, String nome, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [rg=" + rg + ", cpf=" + cpf + ", cnh=" + cnh + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
	
}

	