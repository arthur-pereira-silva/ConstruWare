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
	private String getRg() {
		return rg;
	}
	private void setRg(String rg) {
		this.rg = rg;
	}
	private String getCpf() {
		return cpf;
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private String getCnh() {
		return cnh;
	}
	private void setCnh(String cnh) {
		this.cnh = cnh;
	}
	private String getCargo() {
		return cargo;
	}
	private void setCargo(String cargo) {
		this.cargo = cargo;
	}
	private float getSalario() {
		return salario;
	}
	private void setSalario(float salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [rg=" + rg + ", cpf=" + cpf + ", cnh=" + cnh + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
	
}

	