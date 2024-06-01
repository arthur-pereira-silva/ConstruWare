package model;

public class Produto {
	
    private int id;
    private String nome;
    private Double qtd;
    private Double preco;
    private Fornecedores fornecedor;
    
    
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", preco=" + preco + "]";
	}
	public Fornecedores getFornecedores() {
        return fornecedores;
    }
    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

    private Fornecedores fornecedores;
}