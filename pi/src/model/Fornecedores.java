package model;

public class Fornecedores extends Pessoa {
	
	private String cnpj;

	public Fornecedores() {
		super();
	}

	public Fornecedores(int id, String nome, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Fornecedores [cnpj=" + cnpj + "]";
	}
	
}
