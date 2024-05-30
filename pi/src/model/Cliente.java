package model;

public class Cliente extends Pessoa {
	private String rg;
	private String cpf;


	public Cliente() {
		super();
	}
	public Cliente(int id, String nome, String rg,String cpf, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);

		this.rg = rg;
		this.cpf = cpf;
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
	
	@Override
	public String toString() {
		return "Cliente [rg=" + rg + ", cpf=" + cpf + "]";
	}
	
	

}



