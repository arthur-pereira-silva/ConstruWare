package model;

import java.util.Date;

public class Pedido {

    private int id;
    private Date data;
    private Double total;
    private Cliente cliente;
    private Funcionario funcionario;
    
	public Pedido() {
		super();
	}

	public Pedido(int id, Date data, Double total, Cliente cliente, Funcionario funcionario) {
		super();
		this.id = id;
		this.data = data;
		this.total = total;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private Date getData() {
		return data;
	}

	private void setData(Date data) {
		this.data = data;
	}

	private Double getTotal() {
		return total;
	}

	private void setTotal(Double total) {
		this.total = total;
	}

	private Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private Funcionario getFuncionario() {
		return funcionario;
	}

	private void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", total=" + total + ", cliente=" + cliente + ", funcionario="
				+ funcionario + "]";
	}
	
}