package model;

public class Funcionario extends Pessoa {
	
	private String rg;
	private String cpf;
	private String cnh;
	private String cargo;
	private double salario;
	private String senha;
	

	public Funcionario() {
		super();
	}
	public Funcionario(int id, String nome, String rg,String cpf,String cargo,double salario, String cnh, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
		
		this.rg = rg;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.cnh = cnh;
		
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Funcionario [rg=" + rg + ", cpf=" + cpf + ", cnh=" + cnh + ", cargo=" + cargo + ", salario=" + salario
				+ "]";
	}
	
}

	