package model;

import java.util.Date;


public class Pagamento {
	
    private int id;
    private String metodo;
    private Double valor;
    private Date data;
    private Date hora;
	
	public Pagamento() {
		super();
	}


	public Pagamento(int id, String metodo, Double valor, Date data, Date hora) {
		super();
		
		this.id = id;
		this.metodo = metodo;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
	}


	private int getId() {
		return id;
	}


	private void setId(int id) {
		this.id = id;
	}


	private String getMetodo() {
		return metodo;
	}


	private void setMetodo(String metodo) {
		this.metodo = metodo;
	}


	private Double getValor() {
		return valor;
	}


	private void setValor(Double valor) {
		this.valor = valor;
	}


	private Date getData() {
		return data;
	}


	private void setData(Date data) {
		this.data = data;
	}


	private Date getHora() {
		return hora;
	}


	private void setHora(Date hora) {
		this.hora = hora;
	}


	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", metodo=" + metodo + ", valor=" + valor + ", data=" + data + ", hora=" + hora
				+ "]";
	}
    

}