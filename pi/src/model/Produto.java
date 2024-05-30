package model;

public class Produto {
	
    private int id;
    private String nome;
    private Double qtd;
    private Double preco;
    
    
	public Produto() {
		super();
	}

	public Produto(int id, String nome, Double qtd, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
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

	private Double getQtd() {
		return qtd;
	}

	private void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	private Double getPreco() {
		return preco;
	}

	private void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", preco=" + preco + "]";
	}
}