package model;

public class Cliente extends Pessoa {
	String rg;
	String cpf;


	public Cliente() {
		super();
	}
	public Cliente(int id, String nome, String rg,String cpf, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);

		this.rg = rg;
		this.cpf = cpf;
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
	
	@Override
	public String toString() {
		return "Cliente [rg=" + rg + ", cpf=" + cpf + "]";
	}
	
	

}



