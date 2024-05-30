package model;

public class Pessoa {
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String cep;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private int num;
	
	
	
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

	public Pessoa() {
	}
	
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	private String getTelefone() {
		return telefone;
	}

	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getCep() {
		return cep;
	}

	private void setCep(String cep) {
		this.cep = cep;
	}

	private String getEstado() {
		return estado;
	}

	private void setEstado(String estado) {
		this.estado = estado;
	}

	private String getCidade() {
		return cidade;
	}

	private void setCidade(String cidade) {
		this.cidade = cidade;
	}

	private String getRua() {
		return rua;
	}

	private void setRua(String rua) {
		this.rua = rua;
	}

	private String getBairro() {
		return bairro;
	}

	private void setBairro(String bairro) {
		this.bairro = bairro;
	}

	private int getNum() {
		return num;
	}

	private void setNumCasa(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cep=" + cep
				+ ", estado=" + estado + ", cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + ", num=" + num
				+ "]";
	}
	
	
}