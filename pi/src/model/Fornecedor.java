package model;

public class Fornecedor extends Pessoa {
	
	private String cnpj;

	public Fornecedor() {
		super();
	}

	public Fornecedor(int id, String nome, String cnpj, String telefone, String email, String cep, String estado, String cidade,
			String rua, String bairro, int num) {
		super(id, nome, telefone, email, cep, estado, cidade, rua, bairro, num);
		
		this.cnpj = cnpj;
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
